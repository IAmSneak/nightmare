package com.gmail.sneakdevs.nightmares.util.registry;

import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RegistryUtils {

    public static <I extends Item> I registerItem(I item, Identifier name) {
        return Registry.register(Registry.ITEM, name, item);
    }

}