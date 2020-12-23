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

/**
 * SXSailfin - Riguy1
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class SailfinSculpinModel<T extends Entity> extends EntityModel<T> {
    public ModelRenderer Body;
    public ModelRenderer Tail;
    public ModelRenderer DorsalFins;
    public ModelRenderer FlipperRight;
    public ModelRenderer FlipperRight_1;
    public ModelRenderer UndersideFins;

    public SailfinSculpinModel() {
        this.textureWidth = 24;
        this.textureHeight = 16;
        this.Tail = new ModelRenderer(this, 0, 0);
        this.Tail.setRotationPoint(0.0F, 0.0F, 3.0F);
        this.Tail.addBox(0.0F, -1.5F, 0.0F, 0.0F, 3.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.FlipperRight = new ModelRenderer(this, 0, 12);
        this.FlipperRight.setRotationPoint(1.5F, 0.5F, 0.0F);
        this.FlipperRight.addBox(0.0F, -1.0F, 0.0F, 2.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(FlipperRight, 0.0F, -0.7853981633974483F, 0.0F);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.0F, 22.5F, 0.0F);
        this.Body.addBox(-1.5F, -1.5F, -3.0F, 3.0F, 3.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.FlipperRight_1 = new ModelRenderer(this, 0, 12);
        this.FlipperRight_1.setRotationPoint(-1.5F, 0.5F, 0.0F);
        this.FlipperRight_1.addBox(-2.0F, -1.0F, 0.0F, 2.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(FlipperRight_1, 0.0F, 0.7853981633974483F, 0.0F);
        this.UndersideFins = new ModelRenderer(this, 0, 9);
        this.UndersideFins.setRotationPoint(0.0F, 1.5F, 0.5F);
        this.UndersideFins.addBox(0.0F, 0.0F, -2.5F, 0.0F, 1.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.DorsalFins = new ModelRenderer(this, 0, 2);
        this.DorsalFins.setRotationPoint(0.0F, -1.5F, 0.0F);
        this.DorsalFins.addBox(0.0F, -3.0F, -4.0F, 0.0F, 3.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.Body.addChild(this.Tail);
        this.Body.addChild(this.FlipperRight);
        this.Body.addChild(this.FlipperRight_1);
        this.Body.addChild(this.UndersideFins);
        this.Body.addChild(this.DorsalFins);
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

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
