package mod.mresuoh.salishexpeditions.client.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RockfishModel<T extends Entity> extends EntityModel<T> {
    public ModelRenderer Body;
    public ModelRenderer DorsalSpines;
    public ModelRenderer Tail;
    public ModelRenderer DorsalFinRight;
    public ModelRenderer DorsalFinLeft;
    public ModelRenderer UnderSideFins;

    public RockfishModel() {
        this.textureWidth = 32;
        this.textureHeight = 16;
        this.UnderSideFins = new ModelRenderer(this, 0, 8);
        this.UnderSideFins.setRotationPoint(0.0F, 1.5F, 0.0F);
        this.UnderSideFins.addBox(0.0F, 0.0F, -3.0F, 0.0F, 1.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.DorsalSpines = new ModelRenderer(this, 0, 3);
        this.DorsalSpines.setRotationPoint(0.0F, -1.5F, 0.0F);
        this.DorsalSpines.addBox(0.0F, -3.0F, -3.0F, 0.0F, 3.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.DorsalFinLeft = new ModelRenderer(this, 0, 12);
        this.DorsalFinLeft.mirror = true;
        this.DorsalFinLeft.setRotationPoint(-1.5F, 0.5F, -0.5F);
        this.DorsalFinLeft.addBox(-2.0F, -1.0F, 0.0F, 2.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(DorsalFinLeft, 0.0F, 0.7853981633974483F, 0.0F);
        this.Tail = new ModelRenderer(this, 0, 0);
        this.Tail.setRotationPoint(0.0F, 0.0F, 3.0F);
        this.Tail.addBox(0.0F, -1.5F, 0.0F, 0.0F, 3.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.DorsalFinRight = new ModelRenderer(this, 0, 12);
        this.DorsalFinRight.setRotationPoint(1.5F, 0.5F, -0.5F);
        this.DorsalFinRight.addBox(0.0F, -1.0F, 0.0F, 2.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(DorsalFinRight, 0.0F, -0.7853981633974483F, 0.0F);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.0F, 22.5F, 0.0F);
        this.Body.addBox(-1.5F, -1.5F, -3.0F, 3.0F, 3.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.Body.addChild(this.UnderSideFins);
        this.Body.addChild(this.DorsalSpines);
        this.Body.addChild(this.DorsalFinLeft);
        this.Body.addChild(this.Tail);
        this.Body.addChild(this.DorsalFinRight);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Body).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        float f = 1.0F;
        if (!entityIn.isInWater()) {
            f = 1.5F;
        }

        this.Tail.rotateAngleY = -f * 0.45F * MathHelper.sin(0.6F * ageInTicks);
    }
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
