package net.james.radioflyermod.item.custom;

import net.james.radioflyermod.item.ModItems;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.FireworkRocketEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.checkerframework.common.returnsreceiver.qual.This;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.util.IConsumer;

import java.awt.*;
import java.time.Duration;
import java.util.List;

public class RocketPackItem extends FireworkRocketItem {
    public RocketPackItem(Properties properties) {
        super(properties.durability(64));
    }

    public boolean isValidRepairItem(ItemStack p_41134_, ItemStack p_41135_) {
        return p_41135_.is(ModItems.ETHANOL.get());
    }


    public InteractionResult useOn(UseOnContext p_41216_) {
        Level level = p_41216_.getLevel();
        if (!level.isClientSide) {
            ItemStack itemstack = p_41216_.getItemInHand();
            Vec3 vec3 = p_41216_.getClickLocation();
            Direction direction = p_41216_.getClickedFace();
        }

        return InteractionResult.sidedSuccess(level.isClientSide);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        int currentDurability = itemstack.getDamageValue();

        if (currentDurability >= itemstack.getMaxDamage()) {
            // Durability is zero or less, so the item can't be used
            return InteractionResultHolder.fail(player.getItemInHand(hand));
        }

        if (player.isFallFlying()) {
            if (!level.isClientSide) {
                player.getCooldowns().addCooldown(this, 200);
                itemstack.setDamageValue(currentDurability + 1);
                FireworkRocketEntity fireworkrocketentity = new FireworkRocketEntity(level, itemstack, player);
                level.addFreshEntity(fireworkrocketentity);
                if (!player.getAbilities().instabuild) {
                    // ... do something related to using the item
                }

                player.awardStat(Stats.ITEM_USED.get(this));
            }

            return InteractionResultHolder.sidedSuccess(player.getItemInHand(hand), level.isClientSide());
        } else {
            return InteractionResultHolder.pass(player.getItemInHand(hand));
        }
    }


    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
        int durability = itemStack.getMaxDamage() - itemStack.getDamageValue();

        components.add(Component.nullToEmpty("Fuel: " + durability + " / " + itemStack.getMaxDamage()));


        // Add other tooltip information as needed
        if(Screen.hasShiftDown()) {
            components.add(Component.literal("The Rocket Pack is a device designed for quick efficient travel with the Eyltra!").withStyle(ChatFormatting.WHITE));

        } else {
            components.add(Component.literal("Press SHIFT for more info").withStyle(ChatFormatting.GREEN));
        }



        super.appendHoverText(itemStack, level, components, flag);
    }

}