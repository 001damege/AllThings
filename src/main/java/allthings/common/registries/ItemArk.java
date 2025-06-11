package allthings.common.registries;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class ItemArk extends Item {
    public ItemArk(Properties properties) {
        super(properties.rarity(Rarity.RARE));
    }
}
