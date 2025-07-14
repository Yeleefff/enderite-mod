package net.yeleefff.enderitemod.mixin;


import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static net.yeleefff.enderitemod.item.ModItems.ENDERITE_TOOLS_AND_ARMOR_LIST;


@Mixin(ItemEntity.class)
public abstract class ItemEntityVoidFloatingMixin extends Entity {
    @Unique
    private boolean triggered = false;

    @Shadow
    public abstract ItemStack getStack();

    private ItemEntityVoidFloatingMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Inject(method = "tick()V", at = @At("HEAD"))
    private void floatOverVoid(CallbackInfo ci) {
        if (this.getY() < this.getWorld().getBottomY() || triggered) {
            if (ENDERITE_TOOLS_AND_ARMOR_LIST.contains(getStack().getItem())) {
                if (this.getY() < 40) {
                    triggered = true;
                } else {
                    triggered = false;
                }

                this.setVelocity(0, 0.1, 0);
                this.setNoGravity(true);
            }
        }
    }
}