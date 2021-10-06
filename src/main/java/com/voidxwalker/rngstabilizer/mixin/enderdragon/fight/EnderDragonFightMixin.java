//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.voidxwalker.rngstabilizer.mixin.enderdragon.fight;

import com.voidxwalker.rngstabilizer.Main;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.boss.dragon.EnderDragonFight;
import net.minecraft.entity.boss.dragon.phase.PhaseType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({EnderDragonFight.class})
class EnderDragonFightMixin {
    EnderDragonFightMixin() {
    }
    @Shadow
    @Final
    private ServerWorld world;
    /**
     * @author VoidXWalker
     * @reason Implements the custom, faster end fight
     */

    @Inject(
            at = {@At("HEAD")},
            method = {"tick"}
    )
    private void tick(CallbackInfo ci) {

        if (!Main.ready&&!world.getAliveEnderDragons().isEmpty()) {

            PlayerEntity playerEntity = world.getClosestPlayer(0, 0, 0, 2000, false);

            if(playerEntity!=null){

                if ((playerEntity.getZ()>=30 ||playerEntity.getZ()<=-30)&&playerEntity.getX()<=10&&playerEntity.getX()>=-10&&playerEntity.getY()<=70) {
                    world.getAliveEnderDragons().get(0).getPhaseManager().setPhase(PhaseType.LANDING_APPROACH);


                }
            }
        }

    }
}
