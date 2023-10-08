package w3xyz.oceandepths.oceandepths;



import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;
import w3xyz.oceandepths.oceandepths.entity.ModEntities;
import w3xyz.oceandepths.oceandepths.entity.client.BonkfishRenderer;

public class OceanDepthsClient implements ClientModInitializer {
	@Override
	public void onInitializeClient(ModContainer mod) {
		EntityRendererRegistry.register(ModEntities.BONKFISH, BonkfishRenderer::new);
	}
}
