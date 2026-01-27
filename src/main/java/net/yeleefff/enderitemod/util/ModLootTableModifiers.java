package net.yeleefff.enderitemod.util;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.yeleefff.enderitemod.item.ModItems;

public class ModLootTableModifiers {
    private static final Identifier END_CITY_CHEST_ID = Identifier.fromNamespaceAndPath("minecraft", "chests/end_city_treasure");

    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if (source.isBuiltin() && END_CITY_CHEST_ID.equals(key.identifier())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0f))
                        .when(LootItemRandomChanceCondition.randomChance(0.07f))
                        .add(LootItem.lootTableItem(ModItems.ENDERITE_UPGRADE_SMITHING_TEMPLATE));
                tableBuilder.pool(poolBuilder.build());
            }
        });
    }
}
