package w3xyz.oceandepths.oceandepths.block;


import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;
import w3xyz.oceandepths.oceandepths.OceanDepths;

public class ModBlocks {

	public static final Block CRATE = registerBlock("crate",
			new Block(QuiltBlockSettings.copyOf(Blocks.BARREL)));

	private static Block registerBlock(String name, Block block) {
		registerBlockItem(name, block);
		return Registry.register(Registries.BLOCK, new Identifier(OceanDepths.MOD_ID, name), block);
	}

	private static Item registerBlockItem(String name, Block block) {
		return Registry.register(Registries.ITEM, new Identifier(OceanDepths.MOD_ID, name),
				new BlockItem(block, new QuiltItemSettings()));
	}

	public static void registerModBlocks() {
		OceanDepths.LOGGER.info("Registering ModBlocks for " + OceanDepths.MOD_ID);
	}
}
