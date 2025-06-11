package allthings.common.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class ItemAllThings extends Item {
    public ItemAllThings(Properties properties) {
        super(properties.fireResistant());
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag advancedTooltip) {
        tooltip.add(Component.translatable("tooltip.allthings.all_things").withStyle(ChatFormatting.DARK_GRAY));
        super.appendHoverText(stack, context, tooltip, advancedTooltip);
    }
}
