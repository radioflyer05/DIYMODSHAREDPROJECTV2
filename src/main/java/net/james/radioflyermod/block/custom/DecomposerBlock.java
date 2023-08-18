package net.james.radioflyermod.block.custom;

import net.james.radioflyermod.block.entity.DecomposerBlockEntity;
import net.james.radioflyermod.block.entity.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.Nullable;

public class DecomposerBlock extends BaseEntityBlock {

    private static final VoxelShape SHAPE = makeShape();
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public DecomposerBlock(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext ctx) {
        return SHAPE;
    }

    public static VoxelShape makeShape(){
        VoxelShape shape = Shapes.empty();
        shape = Shapes.join(shape, Shapes.box(0.3125, 0.0625, 0.0625, 0.6875, 0.5, 0.9375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.0625, 0.0625, 0.3125, 0.9375, 0.5, 0.6875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.1875, 0.0625, 0.1875, 0.8125, 0.5, 0.8125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.25, 0.5, 0.25, 0.75, 0.5625, 0.75), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.125, 0.5, 0.375, 0.875, 0.5625, 0.625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.375, 0.5, 0.125, 0.625, 0.5625, 0.875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.4375, 0.5625, 0.1875, 0.5625, 0.625, 0.8125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.5625, 0.5625, 0.3125, 0.6875, 0.625, 0.6875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.3125, 0.5625, 0.3125, 0.4375, 0.625, 0.6875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.1875, 0.5625, 0.4375, 0.3125, 0.625, 0.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.6875, 0.5625, 0.4375, 0.8125, 0.625, 0.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.25, 0, 0.25, 0.375, 0.0625, 0.375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.625, 0, 0.25, 0.75, 0.0625, 0.375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.625, 0, 0.625, 0.75, 0.0625, 0.75), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.25, 0, 0.625, 0.375, 0.0625, 0.75), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.453125, 0.625, 0.453125, 0.546875, 0.75, 0.546875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.40625, 0.75, 0.40625, 0.59375, 0.78125, 0.59375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.40625, 0.96875, 0.40625, 0.59375, 1, 0.59375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.375, 0.78125, 0.40625, 0.40625, 0.84375, 0.59375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.375, 0.90625, 0.40625, 0.40625, 0.96875, 0.59375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.59375, 0.90625, 0.40625, 0.625, 0.96875, 0.59375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.59375, 0.78125, 0.40625, 0.625, 0.84375, 0.59375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.40625, 0.78125, 0.375, 0.59375, 0.84375, 0.40625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.40625, 0.90625, 0.375, 0.59375, 0.96875, 0.40625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.40625, 0.78125, 0.59375, 0.59375, 0.84375, 0.625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.40625, 0.90625, 0.59375, 0.59375, 0.96875, 0.625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.53125, 0.84375, 0.375, 0.59375, 0.90625, 0.40625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.40625, 0.84375, 0.375, 0.46875, 0.90625, 0.40625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.40625, 0.84375, 0.59375, 0.46875, 0.90625, 0.625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.53125, 0.84375, 0.59375, 0.59375, 0.90625, 0.625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.59375, 0.84375, 0.53125, 0.625, 0.90625, 0.59375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.59375, 0.84375, 0.40625, 0.625, 0.90625, 0.46875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.375, 0.84375, 0.53125, 0.40625, 0.90625, 0.59375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.375, 0.84375, 0.40625, 0.40625, 0.90625, 0.46875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.59375, 0.84375, 0.46875, 0.625, 0.90625, 0.53125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.375, 0.84375, 0.46875, 0.40625, 0.90625, 0.53125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.46875, 0.84375, 0.59375, 0.53125, 0.90625, 0.625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.46875, 0.84375, 0.375, 0.53125, 0.90625, 0.40625), BooleanOp.OR);

        return shape;
    }


    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState pState, Rotation pRotation) {
        return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    /* BLOCK ENTITY */

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pIsMoving) {
        if (pState.getBlock() != pNewState.getBlock()) {
            BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
            if (blockEntity instanceof DecomposerBlockEntity) {
                ((DecomposerBlockEntity) blockEntity).drops();
            }
        }
        super.onRemove(pState, pLevel, pPos, pNewState, pIsMoving);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos,
                                 Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (!pLevel.isClientSide()) {
            BlockEntity entity = pLevel.getBlockEntity(pPos);
            if(entity instanceof DecomposerBlockEntity) {
                NetworkHooks.openScreen(((ServerPlayer)pPlayer), (DecomposerBlockEntity)entity, pPos);
            } else {
                throw new IllegalStateException("Our Container provider is missing!");
            }
        }

        return InteractionResult.sidedSuccess(pLevel.isClientSide());
    }


    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new DecomposerBlockEntity(pos, state);
    }
    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return createTickerHelper(type, ModBlockEntities.DECOMPOSER.get(),
                DecomposerBlockEntity::tick);
    }
}