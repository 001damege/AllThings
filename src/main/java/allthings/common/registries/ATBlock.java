package allthings.common.registries;

import allthings.AllThings;
import allthings.common.registry.BlockRegistry;
import allthings.common.registry.ItemRegistry;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Supplier;

public final class ATBlock {
    public static final DeferredRegister.Blocks DR = DeferredRegister.createBlocks(AllThings.MODID);
    private static final List<BlockRegistry<?>> BLOCKS = new ArrayList<>();

    public static List<BlockRegistry<?>> getBlocks() {
        return Collections.unmodifiableList(BLOCKS);
    }

    public static final BlockRegistry<Block> CHAOS_BLOCK = block("Chaos Block", "chaos_block", () ->
            new Block(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(10.0f, 1200.0f)), BlockItem::new);
    public static final BlockRegistry<Block> EXTREME_BLOCK = block("Extrene Block", "extreme_block", () ->
            new Block(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(20.0f, 1200.0f)), BlockItem::new);
    public static final BlockRegistry<Block> ARK_BLOCK = block("Ark Block", "ark_block", () ->
            new Block(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(30.0f, 1200.0f)), BlockItem::new);
    public static final BlockRegistry<Block> CREATIVE_BLOCK = block("Creative Block", "creative_block", () ->
            new Block(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(40.0f, 1200.0f)), BlockItem::new);

    private static <T extends Block> BlockRegistry<T> block(String englishName, String id, Supplier<T> blockSupplier, BiFunction<Block, Item.Properties, BlockItem> factory) {
        var block = DR.register(id, blockSupplier);
        var item = ATItem.DR.register(id, () -> factory.apply(block.get(), new Item.Properties()));
        var registry = new BlockRegistry<>(englishName, block, new ItemRegistry<>(englishName, item));
        BLOCKS.add(registry);
        return registry;
    }
}
