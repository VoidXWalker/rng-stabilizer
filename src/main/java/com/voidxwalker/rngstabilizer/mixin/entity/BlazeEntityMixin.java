package com.voidxwalker.rngstabilizer.mixin.entity;

import com.voidxwalker.rngstabilizer.Main;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.BlazeEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(BlazeEntity.class)
public class BlazeEntityMixin extends HostileEntity {


    protected BlazeEntityMixin(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }
    protected void dropItem(DamageSource source, boolean causedByPlayer){
        LootTable table = this.world.getServer().getLootManager().getTable(this.getLootTable());
        LootContext.Builder builder = this.getLootContextBuilder(causedByPlayer, source).random(Main.randomBlaze);
        table.generateLoot(builder.build(LootContextTypes.ENTITY),this::dropStack);
    }
}
