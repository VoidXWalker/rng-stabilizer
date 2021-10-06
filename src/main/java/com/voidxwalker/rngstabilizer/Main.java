//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.voidxwalker.rngstabilizer;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

public class Main implements ModInitializer {
    public static final Logger LOGGER = LogManager.getLogger();
    private static final ModContainer mod = FabricLoader.getInstance().getModContainer("rngstabilizer").orElseThrow(NullPointerException::new);
    public static String MOD_VERSION = mod.getMetadata().getVersion().getFriendlyString();
    public static boolean ready;
    public static Random randomPiglin = new Random();
    public static Random randomBlaze = new Random();
    public static Random randomBlaze2 = new Random();
    public static Random randomSheep = new Random();
    public static boolean wasClose = false;
    public static int pearlRange;
    public static int stringRange;
    public static int fireResRange;
    public static int fireChargeRange;
    public static int gravelRange;
    public static int obsidianRange;
    public static int soulSandRange;
    public static int cryingObsidianRange;
    public Main() {
    }
    public static void initializeBarterRates(){
        pearlRange=13;
        fireResRange=9;
        fireChargeRange=8;
        gravelRange=5;
        stringRange=11;
        obsidianRange=8;
        soulSandRange=5;
        cryingObsidianRange=8;
    }
    public void onInitialize() {
        Main.initializeBarterRates();
        LOGGER.info("Using Official SetSpeed NoRNG Mod "+MOD_VERSION);
    }
}
