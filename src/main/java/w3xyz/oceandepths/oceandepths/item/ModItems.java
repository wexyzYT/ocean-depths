package w3xyz.oceandepths.oceandepths.item;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;
import w3xyz.oceandepths.oceandepths.OceanDepths;

public class ModItems {
	public static final Item RADAR = registerItem("radar", new Item(new QuiltItemSettings()));
	public static final Item ANCIENT_BLUEPRINTS = registerItem("ancient_blueprints", new Item(new QuiltItemSettings()));

	private static Item registerItem(String name, Item item){
		return Registry.register(Registries.ITEM, new Identifier(OceanDepths.MOD_ID, name), item);
	}

	public static void registerModItems(){
		OceanDepths.LOGGER.info("Registering Mod Items for" + OceanDepths.MOD_ID);
	}
}
