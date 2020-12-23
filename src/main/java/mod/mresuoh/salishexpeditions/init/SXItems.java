package mod.mresuoh.salishexpeditions.init;

import mod.mresuoh.salishexpeditions.SalishExpeditions;
import mod.mresuoh.salishexpeditions.item.SXSpawnEggItem;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SXItems {
    public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, SalishExpeditions.MOD_ID);

    public final static ItemGroup GROUP = new ItemGroup(SalishExpeditions.MOD_ID) {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ROCKFISH.get());
        }
    };

    public static final RegistryObject<SXSpawnEggItem> ROCKFISH_SPAWN_EGG = REGISTRY.register("rockfish_spawn_egg", () ->
            new SXSpawnEggItem(SXEntities.ROCKFISH, 0x1b1b22, 0xedc949 , new Item.Properties().group(GROUP)));

    public static final RegistryObject<SXSpawnEggItem> GRUNT_SCULPIN_SPAWN_EGG = REGISTRY.register("grunt_sculpin_spawn_egg", () ->
            new SXSpawnEggItem(SXEntities.GRUNT_SCULPIN, 0x587753, 0xc8d7c5 , new Item.Properties().group(GROUP)));



    public static final RegistryObject<Item> ROCKFISH = REGISTRY.register("rockfish", () ->
            new Item(new Item.Properties().group(GROUP).food((new Food.Builder()).hunger(2).saturation(0.1F).build())));

    public static final RegistryObject<Item> COOKED_ROCKFISH = REGISTRY.register("cooked_rockfish", () ->
            new Item(new Item.Properties().group(GROUP).food((new Food.Builder()).hunger(5).saturation(0.6F).build())));

    public static final RegistryObject<Item> GRUNT_SCULPIN = REGISTRY.register("grunt_sculpin", () ->
            new Item(new Item.Properties().group(GROUP).food((new Food.Builder()).hunger(2).saturation(0.1F)
                    .effect(new EffectInstance(Effects.POISON, 140, 1), 1.0f).build())));

    public static final RegistryObject<Item> COOKED_GRUNT_SCULPIN = REGISTRY.register("cooked_grunt_sculpin", () ->
            new Item(new Item.Properties().group(GROUP).food((new Food.Builder()).hunger(5).saturation(0.6F).build())));

    public static final RegistryObject<Item> ROCKFISH_BUCKET = REGISTRY.register("rockfish_bucket", () ->
            new FishBucketItem(() -> SXEntities.ROCKFISH.get(), () -> Fluids.WATER, new Item.Properties().group(GROUP)));

    public static final RegistryObject<Item> GRUNT_SCULPIN_BUCKET = REGISTRY.register("grunt_sculpin_bucket", () ->
            new FishBucketItem(() -> SXEntities.GRUNT_SCULPIN.get(), () -> Fluids.WATER, new Item.Properties().group(GROUP)));


}
