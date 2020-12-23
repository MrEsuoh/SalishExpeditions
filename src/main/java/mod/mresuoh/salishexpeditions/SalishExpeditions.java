package mod.mresuoh.salishexpeditions;

import mod.mresuoh.salishexpeditions.entity.RockfishEntity;
import mod.mresuoh.salishexpeditions.init.SXEntities;
import mod.mresuoh.salishexpeditions.init.SXItems;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(SalishExpeditions.MOD_ID)
@Mod.EventBusSubscriber(modid = SalishExpeditions.MOD_ID)
public class SalishExpeditions {
    public static final String MOD_ID = "salishexpeditions";
    public static SalishExpeditions instance;

    public SalishExpeditions() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::registerCommon);

        SXItems.REGISTRY.register(bus);
        SXEntities.REGISTRY.register(bus);

        instance = this;
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void registerBiomes(BiomeLoadingEvent event) {
        if (event.getName().equals(new ResourceLocation("minecraft", "cold_ocean"))) {
            event.getSpawns().getSpawner(EntityClassification.WATER_CREATURE).add(new MobSpawnInfo.Spawners(SXEntities.ROCKFISH.get(), 30, 3, 3));
            event.getSpawns().getSpawner(EntityClassification.WATER_CREATURE).add(new MobSpawnInfo.Spawners(SXEntities.GRUNT_SCULPIN.get(), 30, 3, 3));
        }

        if (event.getName().equals(new ResourceLocation("minecraft", "deep_cold_ocean"))) {
            event.getSpawns().getSpawner(EntityClassification.WATER_CREATURE).add(new MobSpawnInfo.Spawners(SXEntities.ROCKFISH.get(), 30, 3, 3));
            event.getSpawns().getSpawner(EntityClassification.WATER_CREATURE).add(new MobSpawnInfo.Spawners(SXEntities.GRUNT_SCULPIN.get(), 30, 3, 3));
        }

    }

    private void registerCommon(FMLCommonSetupEvent event) {
        registerEntityAttributes();
        EntitySpawnPlacementRegistry.register(SXEntities.ROCKFISH.get(), EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AbstractFishEntity::func_223363_b);
        EntitySpawnPlacementRegistry.register(SXEntities.GRUNT_SCULPIN.get(), EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AbstractFishEntity::func_223363_b);
    }

    private void registerEntityAttributes() {
        GlobalEntityTypeAttributes.put(SXEntities.ROCKFISH.get(), RockfishEntity.func_234176_m_().create());
        GlobalEntityTypeAttributes.put(SXEntities.GRUNT_SCULPIN.get(), RockfishEntity.func_234176_m_().create());
    }
}
