package net.james.radioflyermod.item.custom;

import net.james.radioflyermod.item.ModItems;
import net.minecraft.ChatFormatting;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.FlintAndSteelItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.CandleBlock;
import net.minecraft.world.level.block.CandleCakeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BlowtorchItem extends Item {
    public BlowtorchItem(Item.Properties properties) {
        super(properties.durability(200)); // Set durability as needed
    }


    public boolean isValidRepairItem(ItemStack p_41134_, ItemStack p_41135_) {
        return p_41135_.is(ModItems.BUTANE_PRESSUREIZED_CONTAINER.get());
    }




    @Override
    public InteractionResult useOn(UseOnContext p_41297_) {
        Player player = p_41297_.getPlayer();
        Level level = p_41297_.getLevel();
        Vec3 vec3 = p_41297_.getClickLocation();
        BlockPos blockpos = p_41297_.getClickedPos();
        ItemStack itemstack = p_41297_.getItemInHand();
        int currentDurability = itemstack.getMaxDamage() - itemstack.getDamageValue();

        if (currentDurability <= 1) {
            return InteractionResult.FAIL;
        }

        // Iterate through the 3x3 area centered around the clicked block
        for (int xOffset = -1; xOffset <= 1; xOffset++) {
            for (int yOffset = -1; yOffset <= 1; yOffset++)
                for (int zOffset = -1; zOffset <= 1; zOffset++) {
                    BlockPos targetPos = new BlockPos(vec3.x() + xOffset, vec3.y(), vec3.z() + zOffset);
                    BlockState targetState = level.getBlockState(targetPos);

                    if (!CampfireBlock.canLight(targetState) && !CandleBlock.canLight(targetState) && !CandleCakeBlock.canLight(targetState)) {
                        if (BaseFireBlock.canBePlacedAt(level, targetPos, p_41297_.getHorizontalDirection())) {
                            level.playSound(player, targetPos, SoundEvents.FLINTANDSTEEL_USE, SoundSource.BLOCKS, 1.0F, level.random.nextFloat() * 0.4F + 0.8F);
                            BlockState fireState = BaseFireBlock.getState(level, targetPos);
                            level.setBlock(targetPos, fireState, 11);
                            level.gameEvent(player, GameEvent.BLOCK_PLACE, targetPos);
                        }
                    }
                }
        }

        if (player instanceof ServerPlayer) {
            CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayer) player, blockpos, itemstack);
            itemstack.hurtAndBreak(1, player, (p_41300_) -> {
                p_41300_.broadcastBreakEvent(p_41297_.getHand());
            });
        }

        return InteractionResult.SUCCESS;
    }


    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
        int durability = itemStack.getMaxDamage() - itemStack.getDamageValue();

        components.add(Component.nullToEmpty("Fuel: " + durability + " / " + itemStack.getMaxDamage()));


        // Add other tooltip information as needed
        if(Screen.hasShiftDown()) {
            components.add(Component.literal("The Blowtorch is a powerful fire starter providing a 3x3 of flames per click!").withStyle(ChatFormatting.WHITE));

        } else {
            components.add(Component.literal("Press SHIFT for more info").withStyle(ChatFormatting.GREEN));
        }



        super.appendHoverText(itemStack, level, components, flag);
    }

}