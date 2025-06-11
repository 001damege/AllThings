package allthings.common.registries;

import allthings.AllThings;
import allthings.common.item.ItemAllThings;
import allthings.common.item.ItemChaos;
import allthings.common.item.ItemCreative;
import allthings.common.item.ItemExtreme;
import allthings.common.registry.ItemRegistry;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public final class ATItem {
    public static final DeferredRegister.Items DR = DeferredRegister.createItems(AllThings.MODID);
    private static final List<ItemRegistry<?>> ITEMS = new ArrayList<>();

    public static List<ItemRegistry<?>> getItems() {
        return Collections.unmodifiableList(ITEMS);
    }

    public static final ItemRegistry<Item> ALL_THINGS = item("All Things", "all_things", ItemAllThings::new);
    public static final ItemRegistry<Item> CHAOS_CATALYST = item("Chaos Catalyst", "chaos_catalyst", ItemChaos::new);
    public static final ItemRegistry<Item> CHAOS_INGOT = item("Chaos Ingot", "chaos_ingot", ItemChaos::new);
    public static final ItemRegistry<Item> CHAOS_PROCESSOR = item("Chaos Processor", "chaos_processor", ItemChaos::new);
    public static final ItemRegistry<Item> EXTREME_CATALYST = item("Extreme Catalyst", "extreme_catalyst", ItemExtreme::new);
    public static final ItemRegistry<Item> EXTREME_INGOT = item("Extreme Ingot", "extreme_ingot", ItemExtreme::new);
    public static final ItemRegistry<Item> EXTREME_PROCESSOR = item("Extreme Processor", "extreme_processor", ItemExtreme::new);
    public static final ItemRegistry<Item> ARK_CATALYST = item("Ark Catalyst", "ark_catalyst", ItemArk::new);
    public static final ItemRegistry<Item> ARK_INGOT = item("Ark Ingot", "ark_ingot", ItemArk::new);
    public static final ItemRegistry<Item> ARK_PROCESSOR = item("Ark Processor", "ark_processor", ItemArk::new);
    public static final ItemRegistry<Item> CREATIVE_CATALYST = item("Creative Catalyst", "creative_catalyst", ItemCreative::new);
    public static final ItemRegistry<Item> CREATIVE_INGOT = item("Creative Ingot", "creative_ingot", ItemCreative::new);
    public static final ItemRegistry<Item> CREATIVE_PROCESSOR = item("Creative Processor", "creative_processor", ItemCreative::new);

    private static <T extends Item> ItemRegistry<T> item(String englishName, String id, Function<Item.Properties, T> factory) {
        var registry = new ItemRegistry<>(englishName, DR.registerItem(id, factory));
        ITEMS.add(registry);
        return registry;
    }
}
