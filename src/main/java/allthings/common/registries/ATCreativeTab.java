package allthings.common.registries;

import allthings.AllThings;
import allthings.common.registry.BlockRegistry;
import allthings.common.registry.ItemRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;

public final class ATCreativeTab {
    public static final DeferredRegister<CreativeModeTab> DR = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AllThings.MODID);

    static {
        DR.register("tab", () -> CreativeModeTab.builder()
                .title(Component.translatable("itemGroup.allthings"))
                .icon(ATItem.ALL_THINGS::stack)
                .displayItems(ATCreativeTab::insertTab)
                .build());
    }

    private static void insertTab(CreativeModeTab.ItemDisplayParameters params, CreativeModeTab.Output output) {
        var registries = new ArrayList<ItemRegistry<?>>();
        registries.addAll(ATItem.getItems());
        registries.addAll(ATBlock.getBlocks().stream().map(BlockRegistry::item).toList());

        for (var registry : registries) {
            var item = registry.asItem();
            output.accept(item);
        }
    }
}
