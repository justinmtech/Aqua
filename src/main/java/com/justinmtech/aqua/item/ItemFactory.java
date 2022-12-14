package com.justinmtech.aqua.item;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Build custom ItemStack with one-liners. Return AIR if there's an error or null object.
 * Materials passed can be either Bukkit Materials or Material ID strings
 */
public class ItemFactory {

    /**
     * @param material Bukkit Material or material String ID
     * @param display Display name
     * @return ItemStack (AIR if error)
     */
    public static ItemStack build(Object material, String display) {
        return buildItem(material, 1, display, null, null);
    }


    /**
     * @param material Bukkit Material or material String ID
     * @param amount Item amount
     * @param display Display name
     * @return ItemStack (AIR if error)
     */
    public static ItemStack build(Object material, int amount, String display) {
        return buildItem(material, amount, display, null, null);
    }

    /**
     * @param material Bukkit Material or material String ID
     * @param display Display name
     * @param lore Add multiple String parameters for multiple lines
     * @return ItemStack (AIR if error)
     */
    public static ItemStack build(Object material, String display, String... lore) {
        return buildItem(material, 1, display, lore);
    }

    /**
     * @param material Bukkit Material or material String ID
     * @param amount Item amount
     * @param display Display name
     * @param lore Add multiple String parameters for multiple lines
     * @return ItemStack (AIR if error)
     */
    public static ItemStack build(Object material, int amount, String display, String... lore) {
        return buildItem(material, amount, display, lore);
    }

    private static ItemStack buildItem(Object material, int amount, String display, String... lore) {
        material = MaterialParser.parse(material);
        if (display == null) display = "";
        ItemStack item = new ItemStack((Material) material);
        item.setAmount(amount);
        ItemMeta im = item.getItemMeta();
        if (im == null) return new ItemStack(Material.BARRIER);
        im.setDisplayName(display);
        im.setLore(new ArrayList<>(Arrays.asList(lore)));
        item.setItemMeta(im);
        return item;
    }
}
