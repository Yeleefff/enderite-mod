package net.yeleefff.enderitemod.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.util.List;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.SmithingTemplateItem;

@Mixin(SmithingTemplateItem.class)
public interface NetheriteUpgradeSlotTexturesInvoker {
    @Invoker("createNetheriteUpgradeIconList")
    static List<Identifier> invokeGetNetheriteUpgradeEmptyBaseSlotTextures() {
        throw new AssertionError();
    }

    @Invoker("createNetheriteUpgradeMaterialList")
    static List<Identifier> invokeGetNetheriteUpgradeEmptyAdditionsSlotTextures() {
        throw new AssertionError();
    }
}