package com.kekecreations.kaleidoscopic.core.mixin;


import com.kekecreations.kaleidoscopic.core.init.KTags;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.block.LadderBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {


    @Inject(method = "trapdoorUsableAsLadder", at = @At(value = "RETURN"), cancellable = true)
    public void kaleidoscopic_trapdoorUsableAsLadder(BlockPos pos, BlockState state, CallbackInfoReturnable<Boolean> cir) {
        LivingEntity $this = (LivingEntity) (Object) this;
        BlockState blockstate = $this.level().getBlockState(pos.below());
        cir.setReturnValue(blockstate.is(KTags.BlockTags.DYED_LADDERS) && blockstate.getValue(LadderBlock.FACING) == state.getValue(TrapDoorBlock.FACING));
    }
}