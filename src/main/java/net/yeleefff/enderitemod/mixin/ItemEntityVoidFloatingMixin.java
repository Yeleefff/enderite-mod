package net.yeleefff.enderitemod.mixin;


import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static net.yeleefff.enderitemod.item.ModItems.ENDERITE_TOOLS_AND_ARMOR_LIST;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;


@Mixin(ItemEntity.class)
public abstract class ItemEntityVoidFloatingMixin extends Entity {
    @Unique
    private boolean triggered = false;

    @Shadow
    public abstract ItemStack getItem();

    private ItemEntityVoidFloatingMixin(EntityType<?> type, Level world) {
        super(type, world);
    }

    @Inject(method = "tick()V", at = @At("HEAD"))
    private void floatOverVoid(CallbackInfo ci) {
        if (this.getY() < this.level().getMinY() || triggered) {
            if (ENDERITE_TOOLS_AND_ARMOR_LIST.contains(getItem().getItem())) {
                if (this.getY() < 40) {
                    triggered = true;
                } else {
                    triggered = false;
                }

                this.setDeltaMovement(0, 0.1, 0);
                this.setNoGravity(true);
            }
        }
    }
}