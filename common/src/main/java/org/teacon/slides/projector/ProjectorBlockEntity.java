package org.teacon.slides.projector;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.state.BlockState;
import org.teacon.slides.Registries;
import org.teacon.slides.config.Config;
import org.teacon.slides.mappings.BlockEntityClientSerializableMapper;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("ConstantConditions")
@ParametersAreNonnullByDefault
public final class ProjectorBlockEntity extends BlockEntityClientSerializableMapper {

	public String mLocation = "";
	public int mColor = ~0;
	public float mWidth = 1;
	public float mHeight = 1;
	public float mOffsetX = 0;
	public float mOffsetY = 0;
	public float mOffsetZ = 0;
	public float mRotateX = 0;
	public float mRotateY = 0;
	public float mRotateZ = 0;
	public boolean mDisableLod = false;
	public boolean mDoubleSided = true;

	public ProjectorBlockEntity(BlockPos blockPos, BlockState blockState) {
		super(Registries.BLOCK_ENTITY.get(), blockPos, blockState);
	}

	@Override
	public void writeCompoundTag(CompoundTag compoundTag) {
		super.writeCompoundTag(compoundTag);
		compoundTag.putString("ImageLocation", mLocation);
		compoundTag.putInt("Color", mColor);
		compoundTag.putFloat("Width", mWidth);
		compoundTag.putFloat("Height", mHeight);
		compoundTag.putFloat("OffsetX", mOffsetX);
		compoundTag.putFloat("OffsetY", mOffsetY);
		compoundTag.putFloat("OffsetZ", mOffsetZ);
		compoundTag.putFloat("RotateX", mRotateX);
		compoundTag.putFloat("RotateY", mRotateY);
		compoundTag.putFloat("RotateZ", mRotateZ);
		compoundTag.putBoolean("DoubleSided", mDoubleSided);
		compoundTag.putBoolean("DisableLod", mDisableLod);
	}

	@Override
	public void readCompoundTag(CompoundTag compoundTag) {
		super.readCompoundTag(compoundTag);
		mLocation = compoundTag.getString("ImageLocation");
		mColor = compoundTag.getInt("Color");
		mWidth = compoundTag.getFloat("Width");
		mHeight = compoundTag.getFloat("Height");
		mOffsetX = compoundTag.getFloat("OffsetX");
		mOffsetY = compoundTag.getFloat("OffsetY");
		mOffsetZ = compoundTag.getFloat("OffsetZ");
		mRotateX = compoundTag.getFloat("RotateX");
		mRotateY = compoundTag.getFloat("RotateY");
		mRotateZ = compoundTag.getFloat("RotateZ");

		mDoubleSided = compoundTag.getBoolean("DoubleSided");
		mDisableLod = compoundTag.getBoolean("DisableLod");
	}

	@Environment(EnvType.CLIENT)
	public double getViewDistance(){
		return Config.getViewDistance();
	}
}