package com.voidxwalker.rngstabilizer.mixin.entity;

import com.voidxwalker.rngstabilizer.Main;
import net.minecraft.entity.passive.SheepEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin({SheepEntity.class})
public class SheepEntityMixin {
    public SheepEntityMixin() {
    }
    /**
     * @author VoidXWalker
     * @reason best possible sheep drops
     */
    @ModifyVariable(
            method = {"sheared"},
            at = @At("STORE")
    )
    private int sheared(int x) {
        return Main.randomSheep.nextInt(2)+2;
    }
}