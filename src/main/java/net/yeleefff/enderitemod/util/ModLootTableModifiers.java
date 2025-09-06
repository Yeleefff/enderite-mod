package net.yeleefff.enderitemod.util;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.util.Identifier;
import net.yeleefff.enderitemod.item.ModItems;

public class ModLootTableModifiers {
    private static final Identifier END_CITY_CHEST_ID = Identifier.of("minecraft", "chests/end_city_treasure");

    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if (source.isBuiltin() && END_CITY_CHEST_ID.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1.0f))
                        .conditionally(RandomChanceLootCondition.builder(0.07f))
                        .with(ItemEntry.builder(ModItems.ENDERITE_UPGRADE_SMITHING_TEMPLATE));
                tableBuilder.pool(poolBuilder.build());
            }
        });
    }
}
