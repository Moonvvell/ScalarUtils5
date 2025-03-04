package lemon_juice.scalar_utils.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import static net.minecraft.world.damagesource.DamageTypes.*;

public class AbstractRunedropperBlock extends Block {
    private final float blocks;

    public AbstractRunedropperBlock(Properties properties, float blocks) {
        super(properties);
        this.blocks = blocks;
    }

    //Stops Entities from Taking Fall Damage on Unless they "Suppress the Bounce"
    @Override
    public void fallOn(Level level, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
        if(entity.isSuppressingBounce()){
            super.fallOn(level, state, pos, entity, fallDistance);
        } else {
            entity.causeFallDamage(fallDistance-blocks, 1.0F, entity.damageSources().fall());
        }
    }

}
