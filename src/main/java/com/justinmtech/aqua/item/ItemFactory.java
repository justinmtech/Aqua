package com.justinmtech.aqua.item;

import com.justinmtech.aqua.persistence.SQLQueries;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;

public class ItemFactory {

    //Build an ItemStack from Material and display
    public static ItemStack build(Object material, String display) {
        return buildItem(material, 1, display, 0, null, null);
    }

    //Build an ItemStack from Material, amount and display
    public static ItemStack build(Object material, int amount, String display) {
        return buildItem(material, amount, display, 0, null, null);
    }

    //Build an ItemStack from Material, display, and lores
    public static ItemStack build(Object material, String display, String... lore) {
        return buildItem(material, 1, display, 0, lore);
    }

    //Build an ItemStack from Material, amount, display and customModelData
    public static ItemStack build(Object material, int amount, String display, int customModelData) {
        return buildItem(material, amount, display, customModelData, null, null);
    }

    //Build an ItemStack from Material, amount, display and lores
    public static ItemStack build(Object material, int amount, String display, String... lore) {
        return buildItem(material, amount, display, 0, lore);
    }

    //Build an ItemStack from Material, amount, display, customModelData and lores
    public static ItemStack build(Object material, int amount, String display, int customModelData, String... lore) {
        return buildItem(material, amount, display, customModelData, lore);
    }

    private static ItemStack buildItem(Object material, int amount, String display, int customModelData, String... lore) {
        material = MaterialParser.parse(material);
        if (display == null) display = "";
        ItemStack item = new ItemStack((Material) material);
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
