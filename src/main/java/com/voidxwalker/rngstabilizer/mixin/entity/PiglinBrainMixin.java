package com.voidxwalker.rngstabilizer.mixin.entity;

import com.voidxwalker.rngstabilizer.Main;
import net.minecraft.entity.mob.PiglinBrain;
import net.minecraft.entity.mob.PiglinEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundTag;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.util.ArrayList;
import java.util.List;

@Mixin(PiglinBrain.class)
public class PiglinBrainMixin {
    /**
     * @author VoidXWalker
     * @reason Dynamic bartering
     */
    @Overwrite
    private static List<ItemStack> getBarteredItem(PiglinEntity piglin) {

        ArrayList list;
        int randomNumber = Main.randomPiglin.nextInt(Main.pearlRange + Main.fireResRange + Main.gravelRange + Main.stringRange+Main.obsidianRange+Main.cryingObsidianRange+Main.soulSandRange);
        int point = -1;
        //pearls
        if (randomNumber >= point + 1 && randomNumber <= Main.pearlRange) {
            list = new ArrayList();
            if (Main.pearlTrades++ != 0) {
                Main.pearlRange = Main.pearlRange/4;
            }
            list.add(new ItemStack(Items.ENDER_PEARL, Main.randomPiglin.nextInt(3)+6));
            return list;
        }
        point = Main.pearlRange;
        //fireRes
        if (randomNumber >= point + 1 && randomNumber <= point + Main.fireResRange) {
            list = new ArrayList();
            Main.fireResRange = Main.fireResRange/4;
            CompoundTag fireRes = new CompoundTag();
            fireRes.putString("Potion", "minecraft:fire_resistance");
            ItemStack stack = new ItemStack(Items.SPLASH_POTION);
            stack.setTag(fireRes);
            list.add(stack);
            return list;
        }
        point = point + Main.fireResRange;
        //gravel
        if (randomNumber >= point + 1 && randomNumber <= point + Main.gravelRange) {
            list = new ArrayList();
            list.add(new ItemStack(Items.GRAVEL, Main.randomPiglin.nextInt(5)+12));
            return list;
        }
        //string
        point = point + Main.gravelRange;
        if (randomNumber >= point + 1 && randomNumber <= point + Main.stringRange) {
            list = new ArrayList();
            list.add(new ItemStack(Items.STRING, Main.randomPiglin.nextInt(9)+16));
            return list;
        }
        //obsidian
        point = point + Main.stringRange;
        if (randomNumber >= point + 1 && randomNumber <= point + Main.obsidianRange) {
            list = new ArrayList();
            list.add(new ItemStack(Items.OBSIDIAN));
            return list;
        }
        //crying obsidian
        point = point + Main.obsidianRange;
        if (randomNumber >= point + 1 && randomNumber <= point + Main.cryingObsidianRange) {
            list = new ArrayList();
            list.add(new ItemStack(Items.CRYING_OBSIDIAN,Main.randomPiglin.nextInt(2)+1));
            return list;
        }
        //soul sand
        else {
            list = new ArrayList();
            list.add(new ItemStack(Items.SOUL_SAND,Main.randomPiglin.nextInt(7)+10));
            return list;
        }
    }
}
