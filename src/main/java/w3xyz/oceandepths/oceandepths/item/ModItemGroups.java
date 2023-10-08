package w3xyz.oceandepths.oceandepths.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import w3xyz.oceandepths.oceandepths.OceanDepths;
import w3xyz.oceandepths.oceandepths.block.ModBlocks;

public class ModItemGroups {
	public static final ItemGroup RUBY_GROUP = Registry.register(Registries.ITEM_GROUP,
			new Identifier(OceanDepths.MOD_ID, "ruby"),
			FabricItemGroup.builder().name(Text.translatable("itemgroup.ruby"))
					.icon(() -> new ItemStack(ModItems.ANCIENT_BLUEPRINTS)).entries((displayContext, entries) -> {
						entries.addItem(ModItems.ANCIENT_BLUEPRINTS);
						entries.addItem(ModItems.RADAR);

						entries.addItem(ModBlocks.CRATE);
						entries.addItem(ModItems.BONKFISH_SPAWN_EGG);

					}).build());


	public static void registerItemGroups() {
		OceanDepths.LOGGER.info("Registering Item Groups for " + OceanDepths.MOD_ID);
	}
}
