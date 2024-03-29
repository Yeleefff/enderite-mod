package net.yeleefff.enderitemod;

import net.fabricmc.api.ModInitializer;
import net.yeleefff.enderitemod.block.ModBlocks;
import net.yeleefff.enderitemod.item.ModItems;
import net.yeleefff.enderitemod.util.ModLootTableModifiers;
import net.yeleefff.enderitemod.world.gen.ModOreGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EnderiteMod implements ModInitializer {
	public static final String MOD_ID = "enderitemod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModOreGeneration.generateOres();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModLootTableModifiers.modifyLootTables();
	}
}