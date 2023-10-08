package w3xyz.oceandepths.oceandepths;


import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import w3xyz.oceandepths.oceandepths.block.ModBlocks;
import w3xyz.oceandepths.oceandepths.entity.ModEntities;
import w3xyz.oceandepths.oceandepths.entity.custom.BonkfishEntity;
import w3xyz.oceandepths.oceandepths.item.ModItemGroups;
import w3xyz.oceandepths.oceandepths.item.ModItems;

public class OceanDepths implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod name as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "oceandepths";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize(ModContainer mod) {
		LOGGER.info("Hello world from Ocean Depths!");


		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModItemGroups.registerItemGroups();
		FabricDefaultAttributeRegistry.register(ModEntities.BONKFISH, BonkfishEntity.setAttributes());
	}
}
