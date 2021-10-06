package com.voidxwalker.rngstabilizer.mixin.entity;

import com.mojang.authlib.GameProfile;
import com.voidxwalker.rngstabilizer.Main;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(ServerPlayerEntity.class)
public abstract class ServerPlayerEntityMixin extends PlayerEntity {
    @Shadow public abstract ServerWorld getServerWorld();

    public ServerPlayerEntityMixin(World world, BlockPos blockPos, GameProfile gameProfile) {
        super(world, blockPos, gameProfile);
    }
    /**
     * @author VoidXWalker
     * @reason initializes Mod
     */
    @Inject(
            method = {"<init>"},
            at = {@At("TAIL")}
    )
    public void init(CallbackInfo ci) {
        Main.randomBlaze = new Random();
        Main.randomBlaze.setSeed(getServerWorld().getSeed());
        Main.randomBlaze2 = new Random();
        Main.randomBlaze2.setSeed(getServerWorld().getSeed());
        Main.randomPiglin = new Random();
        Main.randomPiglin.setSeed(getServerWorld().getSeed());
        Main.randomSheep = new Random();
        Main.randomSheep.setSeed(getServerWorld().getSeed());
        Main.wasClose = false;
        Main.initializeBarterRates();
    }
    @ModifyVariable(
            method = {"moveToSpawn"},
            at = @At("STORE")
    )
    private int eliminateSpawnRng(int i) {
        return 0;
    }
}
