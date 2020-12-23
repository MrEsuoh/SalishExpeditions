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
 * GruntSculpin - Riguy1
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class GruntSculpinModel<T extends Entity> extends EntityModel<T> {
    public ModelRenderer Body;
    public ModelRenderer Tail;
    public ModelRenderer Mouth;
    public ModelRenderer DorsalSpines;
    public ModelRenderer PectoralFinRight;
    public ModelRenderer PectoralFinLeft;
    public ModelRenderer UndersideSpines;

    public GruntSculpinModel() {
        this.textureWidth = 16;
        this.textureHeight = 16;
        this.DorsalSpines = new ModelRenderer(this, 0, 6);
        this.DorsalSpines.setRotationPoint(0.0F, -1.5F, 0.0F);
        this.DorsalSpines.addBox(0.0F, -1.0F, -2.0F, 0.0F, 1.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.Tail = new ModelRenderer(this, 0, 4);
        this.Tail.setRotationPoint(0.0F, 0.0F, 2.0F);
        this.Tail.addBox(0.0F, -1.5F, 0.0F, 0.0F, 3.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.0F, 22.5F, 0.0F);
        this.Body.addBox(-1.5F, -1.5F, -2.0F, 3.0F, 3.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.PectoralFinRight = new ModelRenderer(this, 6, 7);
        this.PectoralFinRight.setRotationPoint(1.5F, 0.5F, 0.0F);
        this.PectoralFinRight.addBox(0.0F, -1.0F, 0.0F, 2.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(PectoralFinRight, 0.0F, -0.7853981633974483F, 0.0F);
        this.UndersideSpines = new ModelRenderer(this, 0, 8);
        this.UndersideSpines.setRotationPoint(0.0F, 1.5F, 0.5F);
        this.UndersideSpines.addBox(0.0F, 0.0F, -1.5F, 0.0F, 1.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.Mouth = new ModelRenderer(this, 0, 0);
        this.Mouth.setRotationPoint(0.0F, 1.0F, -2.0F);
        this.Mouth.addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.PectoralFinLeft = new ModelRenderer(this, 6, 7);
        this.PectoralFinLeft.mirror = true;
        this.PectoralFinLeft.setRotationPoint(-1.5F, 0.5F, 0.0F);
        this.PectoralFinLeft.addBox(-2.0F, -1.0F, 0.0F, 2.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(PectoralFinLeft, 0.0F, 0.7853981633974483F, 0.0F);
        this.Body.addChild(this.DorsalSpines);
        this.Body.addChild(this.Tail);
        this.Body.addChild(this.PectoralFinRight);
        this.Body.addChild(this.UndersideSpines);
        this.Body.addChild(this.Mouth);
        this.Body.addChild(this.PectoralFinLeft);
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
