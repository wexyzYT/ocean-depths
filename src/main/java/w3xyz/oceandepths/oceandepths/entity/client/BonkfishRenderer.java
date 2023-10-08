package w3xyz.oceandepths.oceandepths.entity.client;



import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import w3xyz.oceandepths.oceandepths.OceanDepths;
import w3xyz.oceandepths.oceandepths.entity.custom.BonkfishEntity;

public class BonkfishRenderer extends GeoEntityRenderer<BonkfishEntity> {
	public BonkfishRenderer(EntityRendererFactory.Context renderManager) {
		super(renderManager, new BonkfishModel());
	}

	@Override
	public Identifier getTextureLocation(BonkfishEntity animatable) {
		return new Identifier(OceanDepths.MOD_ID, "textures/entity/bonkfish.png");
	}


	@Override
	public void render(BonkfishEntity entity, float entityYaw, float partialTick, MatrixStack poseStack,
					   VertexConsumerProvider bufferSource, int packedLight) {
		if(entity.isBaby()){
			poseStack.scale(0.5f, 0.5f, 0.5f);
		}else{
			poseStack.scale(1.2f, 1.2f, 1.2f);
		}
		super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
	}
}
