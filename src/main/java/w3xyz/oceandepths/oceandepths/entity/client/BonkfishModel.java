package w3xyz.oceandepths.oceandepths.entity.client;


import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;
import w3xyz.oceandepths.oceandepths.OceanDepths;
import w3xyz.oceandepths.oceandepths.entity.custom.BonkfishEntity;

public class BonkfishModel extends GeoModel<BonkfishEntity> {
	@Override
	public Identifier getModelResource(BonkfishEntity animatable) {
		return new Identifier(OceanDepths.MOD_ID, "geo/bonkfish.geo.json");
	}

	@Override
	public Identifier getTextureResource(BonkfishEntity animatable) {
		return new Identifier(OceanDepths.MOD_ID, "textures/entity/bonkfish.png");
	}

	@Override
	public Identifier getAnimationResource(BonkfishEntity animatable) {
		return new Identifier(OceanDepths.MOD_ID, "animations/bonkfish.animation.json");
	}


}
