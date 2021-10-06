package com.voidxwalker.rngstabilizer.mixin.enderdragon.fight;

import net.minecraft.entity.boss.dragon.phase.HoldingPatternPhase;
import net.minecraft.entity.boss.dragon.phase.PhaseManager;
import net.minecraft.entity.boss.dragon.phase.PhaseType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(HoldingPatternPhase.class)
public class HoldingPatternPhaseMixin {
    @Redirect(
            method = {"method_6841"},
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/boss/dragon/phase/PhaseManager;setPhase(Lnet/minecraft/entity/boss/dragon/phase/PhaseType;)V"
            )
    )
    public void nothing(PhaseManager phaseManager, PhaseType<?> type){
    }
}
