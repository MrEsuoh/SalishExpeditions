package mod.mresuoh.salishexpeditions.client.renderer;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.matrix.MatrixStack;
import mod.mresuoh.salishexpeditions.SalishExpeditions;
import mod.mresuoh.salishexpeditions.client.model.RockfishModel;
import mod.mresuoh.salishexpeditions.entity.RockfishEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Util;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Map;

@OnlyIn(Dist.CLIENT)
public class RockfishRenderer extends MobRenderer<RockfishEntity, RockfishModel<RockfishEntity>> {
   public static final Map<Integer, ResourceLocation> TEXTURES = Util.make(Maps.newHashMap(), (hashMap) -> {
      hashMap.put(0, new ResourceLocation(SalishExpeditions.MOD_ID, "textures/entity/rockfish/rockfish_1.png"));
      hashMap.put(1, new ResourceLocation(SalishExpeditions.MOD_ID, "textures/entity/rockfish/rockfish_2.png"));
      hashMap.put(2, new ResourceLocation(SalishExpeditions.MOD_ID, "textures/entity/rockfish/rockfish_3.png"));
   });

   public RockfishRenderer(EntityRendererManager renderManagerIn) {
      super(renderManagerIn, new RockfishModel<>(), 0.2F);
   }

   @Override
   public ResourceLocation getEntityTexture(RockfishEntity entity) {
      return TEXTURES.getOrDefault(entity.getVariant(), TEXTURES.get(0));
   }

   protected void applyRotations(RockfishEntity entityLiving, MatrixStack matrixStackIn, float ageInTicks, float rotationYaw, float partialTicks) {
      super.applyRotations(entityLiving, matrixStackIn, ageInTicks, rotationYaw, partialTicks);
      float f = 4.3F * MathHelper.sin(0.6F * ageInTicks);
      matrixStackIn.rotate(Vector3f.YP.rotationDegrees(f));
      if (!entityLiving.isInWater()) {
         matrixStackIn.translate((double)0.1F, (double)0.1F, (double)-0.1F);
         matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90.0F));
      }

   }
}
