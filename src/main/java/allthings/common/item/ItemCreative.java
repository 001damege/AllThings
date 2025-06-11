package allthings.common.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class ItemCreative extends Item {
    public ItemCreative(Properties properties) {
        super(properties.rarity(Rarity.EPIC).fireResistant());
    }
}
