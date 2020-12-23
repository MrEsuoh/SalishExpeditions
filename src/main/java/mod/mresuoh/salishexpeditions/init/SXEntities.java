package mod.mresuoh.salishexpeditions.init;

import mod.mresuoh.salishexpeditions.SalishExpeditions;
import mod.mresuoh.salishexpeditions.entity.GruntSculpinEntity;
import mod.mresuoh.salishexpeditions.entity.RockfishEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SXEntities {
    public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITIES, SalishExpeditions.MOD_ID);

    public static final RegistryObject<EntityType<RockfishEntity>> ROCKFISH = REGISTRY.register("rockfish", () ->
            EntityType.Builder.<RockfishEntity>create(RockfishEntity::new, EntityClassification.WATER_CREATURE)
                    .size(0.3f, 0.3f).build(new ResourceLocation(SalishExpeditions.MOD_ID, "rockfish").toString()));

    public static final RegistryObject<EntityType<GruntSculpinEntity>> GRUNT_SCULPIN = REGISTRY.register("grunt_sculpin", () ->
            EntityType.Builder.<GruntSculpinEntity>create(GruntSculpinEntity::new, EntityClassification.WATER_CREATURE)
                    .size(0.3f, 0.3f).build(new ResourceLocation(SalishExpeditions.MOD_ID, "grunt_sculpin").toString()));


}
