package com.justinmtech.aqua.item;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;

public class ItemFactory {

    public static ItemStack build(Material material, String display) {
        return buildItem(material, 1, display, 0, null, null);
    }

    public static ItemStack build(Material material, int amount, String display) {
        return buildItem(material, amount, display, 0, null, null);
    }

    public static ItemStack build(Material material, String display, String... lore) {
        return buildItem(material, 1, display, 0, lore);
    }

    public static ItemStack build(Material material, int amount, String display, int customModelData) {
        return buildItem(material, amount, display, customModelData, null, null);
    }

    public static ItemStack build(Material material, int amount, String display, String... lore) {
        return buildItem(material, amount, display, 0, lore);
    }

    public static ItemStack build(Material material, int amount, String display, int customModelData, String... lore) {
        return buildItem(material, amount, display, customModelData, lore);
    }

    private static ItemStack buildItem(Material material, int amount, String display, int customModelData, String... lore) {
        if (display == null) display = "";
        ItemStack item = new ItemStack(material);
        item.setAmount(amount);
        ItemMeta im = item.getItemMeta();
        if (im == null) return new ItemStack(Material.BARRIER);
        im.setDisplayName(display);
        im.setLore(new ArrayList<>(Arrays.asList(lore)));
        if (customModelData > 0) im.setCustomModelData(customModelData);
        item.setItemMeta(im);
        return item;
    }
}
