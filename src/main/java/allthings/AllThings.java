package allthings;

import allthings.common.registries.ATBlock;
import allthings.common.registries.ATCreativeTab;
import allthings.common.registries.ATItem;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(AllThings.MODID)
public class AllThings {
    public static final String MODID = "allthings";
    public static final String MOD_NAME = "All Things";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    public AllThings(IEventBus modEventBus, ModContainer container) {
        ATItem.DR.register(modEventBus);
        ATCreativeTab.DR.register(modEventBus);
        ATBlock.DR.register(modEventBus);
    }

    @SubscribeEvent
    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    public static ResourceLocation rl(String path) {
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }


}
