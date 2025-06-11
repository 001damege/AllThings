package allthings.common.registry;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.Objects;

public class BlockRegistry<T extends Block> implements ItemLike {
    private final String englishName;
    private final ItemRegistry<BlockItem> item;
    private final DeferredBlock<T> block;

    public BlockRegistry(String englishName, DeferredBlock<T> block, ItemRegistry<BlockItem> item) {
        this.englishName = englishName;
        this.item = Objects.requireNonNull(item, "item");
        this.block = Objects.requireNonNull(block, "block");
    }

    public String getEnglishName() {
        return englishName;
    }

    public ResourceLocation id() {
        return block.getId();
    }

    public final T block() {
        return this.block.get();
    }

    public ItemStack stack() {
        return item.stack();
    }

    public ItemStack stack(int stackSize) {
        return item.stack(stackSize);
    }

    public ItemRegistry<BlockItem> item() {
        return item;
    }

    @Override
    public Item asItem() {
        return item.asItem();
    }
}
