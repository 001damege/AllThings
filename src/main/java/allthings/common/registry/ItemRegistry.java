package allthings.common.registry;

import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.function.Supplier;

public class ItemRegistry<T extends Item> implements ItemLike, Supplier<T> {
    private final String englishName;
    private final DeferredItem<T> item;

    public ItemRegistry(String englishName, DeferredItem<T> item) {
        this.englishName = englishName;
        this.item = item;
    }

    public String getEnglishName() {
        return englishName;
    }

    public ResourceLocation id() {
        return this.item.getId();
    }

    public ItemStack stack() {
        return stack(1);
    }

    public ItemStack stack(int stackSize) {
        return new ItemStack((ItemLike) item, stackSize);
    }

    public Holder<Item> holder() {
        return item;
    }

    @Override
    public T get() {
        return item.get();
    }

    @Override
    public Item asItem() {
        return item.get();
    }
}
