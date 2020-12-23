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
 * SXRatfish - Undefined
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class RatfishModel<T extends Entity> extends EntityModel<T> {
    public ModelRenderer Body;
    public ModelRenderer Tail;
    public ModelRenderer PectoralFinRight;
    public ModelRenderer PectoralFinLeft;
    public ModelRenderer Dorsal;

    public RatfishModel() {
        this.textureWidth = 16;
        this.textureHeight = 16;
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.0F, 22.5F, 0.0F);
        this.Body.addBox(-1.0F, -1.5F, -2.5F, 2.0F, 3.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.Dorsal = new ModelRenderer(this, 8, 6);
        this.Dorsal.setRotationPoint(0.0F, -1.5F, -1.0F);
        this.Dorsal.addBox(0.0F, -2.0F, -0.5F, 0.0F, 2.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.Tail = new ModelRenderer(this, 0, 4);
        this.Tail.setRotationPoint(0.0F, 0.0F, 2.5F);
        this.Tail.addBox(0.0F, -1.5F, 0.0F, 0.0F, 3.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail, 0.003665191314755389F, 0.0F, 0.0F);
        this.PectoralFinLeft = new ModelRenderer(this, 9, 8);
        this.PectoralFinLeft.mirror = true;
        this.PectoralFinLeft.setRotationPoint(-1.0F, 1.5F, -0.5F);
        this.PectoralFinLeft.addBox(-2.0F, 0.0F, 0.0F, 2.0F, 0.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(PectoralFinLeft, 0.0F, 0.0F, -0.7853981633974483F);
        this.PectoralFinRight = new ModelRenderer(this, 9, 8);
        this.PectoralFinRight.setRotationPoint(1.0F, 1.5F, -0.5F);
        this.PectoralFinRight.addBox(0.0F, 0.0F, 0.0F, 2.0F, 0.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(PectoralFinRight, 0.0F, 0.0F, 0.7853981633974483F);
        this.Body.addChild(this.Dorsal);
        this.Body.addChild(this.Tail);
        this.Body.addChild(this.PectoralFinLeft);
        this.Body.addChild(this.PectoralFinRight);
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
