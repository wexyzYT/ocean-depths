package w3xyz.oceandepths.oceandepths.entity;

import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.quiltmc.qsl.entity.api.QuiltEntityTypeBuilder;
import org.quiltmc.qsl.entity.impl.QuiltEntityType;
import w3xyz.oceandepths.oceandepths.OceanDepths;
import w3xyz.oceandepths.oceandepths.entity.custom.BonkfishEntity;

public class ModEntities {
	public static final EntityType<BonkfishEntity> BONKFISH = Registry.register(Registries.ENTITY_TYPE, new Identifier(OceanDepths.MOD_ID, "bonkfish"),
			QuiltEntityTypeBuilder.create(SpawnGroup.WATER_CREATURE, BonkfishEntity::new)
					.setDimensions(EntityDimensions.fixed(0.5f, 0.3f)).build());
}
