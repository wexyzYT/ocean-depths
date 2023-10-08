package w3xyz.oceandepths.oceandepths.item;

import net.fabricmc.fabric.impl.itemgroup.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;
import w3xyz.oceandepths.oceandepths.OceanDepths;
import w3xyz.oceandepths.oceandepths.entity.ModEntities;

public class ModItems {
	public static final Item RADAR = registerItem("radar", new Item(new QuiltItemSettings()));
	public static final Item ANCIENT_BLUEPRINTS = registerItem("ancient_blueprints", new Item(new QuiltItemSettings()));
	public static final Item BONKFISH_SPAWN_EGG = registerItem("bonkfish_spawn_egg", new SpawnEggItem(ModEntities.BONKFISH, 0x009BFF, 0xFFDC00,
			new QuiltItemSettings()));
	private static Item registerItem(String name, Item item){
		return Registry.register(Registries.ITEM, new Identifier(OceanDepths.MOD_ID, name), item);
	}

	public static void registerModItems(){
		OceanDepths.LOGGER.info("Registering Mod Items for" + OceanDepths.MOD_ID + "!!!");
	}
}
