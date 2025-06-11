package allthings.common.item;

import net.minecraft.world.item.Item;

public class ItemExtreme extends Item {
    public ItemExtreme(Properties properties) {
        super(properties.fireResistant());
    }
}
