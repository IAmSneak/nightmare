// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.12.2 or 1.15.2 (same format for both) for entity models animated with GeckoLib
// Paste this class into your mod and follow the documentation for GeckoLib to use animations. You can find the documentation here: https://github.com/bernie-g/geckolib
// Blockbench plugin created by Gecko
package io.dandin87.monstermash.client.models;

import io.dandin87.monstermash.entity.LittleGremlinEntity;
import io.dandin87.monstermash.Nightmares;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.animation.model.AnimatedEntityModel;
import software.bernie.geckolib.animation.render.AnimatedModelRenderer;

public class LittleGremlinModel extends AnimatedEntityModel<LittleGremlinEntity> {

	private final AnimatedModelRenderer Pumpkin;
	private final AnimatedModelRenderer head;
	private final AnimatedModelRenderer jaw;
	private final AnimatedModelRenderer body;
	private final AnimatedModelRenderer leftArm;
	private final AnimatedModelRenderer rightArm;
	private final AnimatedModelRenderer leftLeg;
	private final AnimatedModelRenderer rightLeg;

    public LittleGremlinModel()
	{
		textureWidth = 64;
		textureHeight = 64;
		Pumpkin = new AnimatedModelRenderer(this);
		Pumpkin.setRotationPoint(0.0F, 24.0F, 0.0F);
		setRotationAngle(Pumpkin, -3.1416F, 0.0F, 3.1416F);

		Pumpkin.setModelRendererName("Pumpkin");
		this.registerModelRenderer(Pumpkin);

		head = new AnimatedModelRenderer(this);
		head.setRotationPoint(0.5F, -9.25F, 0.0F);
		Pumpkin.addChild(head);
		setRotationAngle(head, 0.0873F, 0.0F, 0.0F);
		head.setTextureOffset(0, 7).addBox(-3.5F, -5.75F, -2.0F, 6.0F, 5.0F, 4.0F, 0.0F, false);
		head.setModelRendererName("head");
		this.registerModelRenderer(head);

		jaw = new AnimatedModelRenderer(this);
		jaw.setRotationPoint(-0.5F, -1.25F, 0.0F);
		head.addChild(jaw);
		setRotationAngle(jaw, -0.1745F, 0.0F, 0.0F);
		jaw.setTextureOffset(16, 12).addBox(-3.0F, 0.5F, -2.0F, 6.0F, 1.0F, 4.0F, 0.0F, false);
		jaw.setModelRendererName("jaw");
		this.registerModelRenderer(jaw);

		body = new AnimatedModelRenderer(this);
		body.setRotationPoint(0.0F, -6.375F, -0.5F);
		Pumpkin.addChild(body);
		body.setTextureOffset(0, 16).addBox(-3.0F, -2.375F, -1.5F, 6.0F, 6.0F, 3.0F, 0.0F, false);
		body.setTextureOffset(0, 0).addBox(-4.0F, -2.625F, -1.5F, 8.0F, 4.0F, 3.0F, 0.0F, false);
		body.setModelRendererName("body");
		this.registerModelRenderer(body);

		leftArm = new AnimatedModelRenderer(this);
		leftArm.setRotationPoint(-5.0F, -8.0F, -0.5F);
		Pumpkin.addChild(leftArm);
		leftArm.setTextureOffset(22, 0).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);
		leftArm.setTextureOffset(15, 13).addBox(0.0F, 3.5F, -0.25F, 0.0F, 1.0F, 4.0F, 0.0F, false);
		leftArm.setModelRendererName("leftArm");
		this.registerModelRenderer(leftArm);

		rightArm = new AnimatedModelRenderer(this);
		rightArm.setRotationPoint(5.0F, -8.0F, -0.5F);
		Pumpkin.addChild(rightArm);
		rightArm.setTextureOffset(18, 18).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);
		rightArm.setTextureOffset(16, 4).addBox(0.0F, 3.5F, 0.0F, 0.0F, 1.0F, 4.0F, 0.0F, false);
		rightArm.setModelRendererName("rightArm");
		this.registerModelRenderer(rightArm);

		leftLeg = new AnimatedModelRenderer(this);
		leftLeg.setRotationPoint(-1.5F, -1.5F, -0.5F);
		Pumpkin.addChild(leftLeg);
		leftLeg.setTextureOffset(0, 25).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);
		leftLeg.setModelRendererName("leftLeg");
		this.registerModelRenderer(leftLeg);

		rightLeg = new AnimatedModelRenderer(this);
		rightLeg.setRotationPoint(1.5F, -1.5F, -0.5F);
		Pumpkin.addChild(rightLeg);
		rightLeg.setTextureOffset(24, 24).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);
		rightLeg.setModelRendererName("rightLeg");
		this.registerModelRenderer(rightLeg);

		this.rootBones.add(Pumpkin);
	}

	@Override
	public Identifier getAnimationFileLocation()
    {
		return new Identifier(Nightmares.MODID, "animations/pumpkin_carves_you_walking.json");
    }
}