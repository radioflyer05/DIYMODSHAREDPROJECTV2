package net.james.radioflyermod.item.custom;

import net.james.radioflyermod.item.ModItems;
import net.minecraft.ChatFormatting;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.checkerframework.common.returnsreceiver.qual.This;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.util.IConsumer;

import java.util.List;

public class EthanolItem extends MilkBucketItem {
    public EthanolItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
            ItemStack itemstack = player.getItemInHand(hand);
            if(!level.isClientSide() && hand == InteractionHand.MAIN_HAND) {
               player.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 600, 1));
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 600, 2));
                player.getCooldowns().addCooldown(this, 2000);
                level.playSound((Player)null, player.getX(), player.getY(), player.getZ(), SoundEvents.PLAYER_BURP , SoundSource.NEUTRAL, 0.9F, 0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F));

            }
        player.awardStat(Stats.ITEM_USED.get(this));
        if (!player.getAbilities().instabuild) {
            itemstack.shrink(1);
            ItemStack glassJarStack = new ItemStack(ModItems.GLASS_JAR.get(), 1);
            // Add the glass jar ItemStack to the player's inventory
            player.addItem(glassJarStack);
        }

        return super.use(level, player, hand);
    }


    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
       if(Screen.hasShiftDown()) {
           components.add(Component.literal("Material used for crafting. Can be drunk to cause certain side effects.").withStyle(ChatFormatting.WHITE));

       } else {
           components.add(Component.literal("Press SHIFT for more info").withStyle(ChatFormatting.GREEN));
       }


        super.appendHoverText(itemStack, level, components, flag);
    }
}
