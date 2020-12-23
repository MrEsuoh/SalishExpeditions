package mod.mresuoh.salishexpeditions.client;


import mod.mresuoh.salishexpeditions.SalishExpeditions;
import mod.mresuoh.salishexpeditions.client.renderer.GruntSculpinRenderer;
import mod.mresuoh.salishexpeditions.client.renderer.RockfishRenderer;
import mod.mresuoh.salishexpeditions.init.SXEntities;

import mod.mresuoh.salishexpeditions.item.SXSpawnEggItem;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = SalishExpeditions.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {
    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(SXEntities.ROCKFISH.get(), RockfishRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(SXEntities.GRUNT_SCULPIN.get(), GruntSculpinRenderer::new);
    }

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void itemColors(ColorHandlerEvent.Item event) {
        ItemColors handler = event.getItemColors();
        IItemColor eggColor = (stack, tintIndex) -> ((SXSpawnEggItem) stack.getItem()).getColor(tintIndex);
        for (SXSpawnEggItem e : SXSpawnEggItem.UNADDED_EGGS) handler.register(eggColor, e);
    }

}
