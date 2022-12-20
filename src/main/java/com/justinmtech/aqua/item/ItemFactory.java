package com.justinmtech.aqua.item;

import com.justinmtech.aqua.chat.ColorUtils;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

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
        return buildItem(material, 1, display, 0, null);
    }

    /**
     * @param material Bukkit Material or material String ID
     * @param amount Item amount
     * @param display Display name
     * @return ItemStack (AIR if error)
     */
    public static ItemStack build(Object material, int amount, String display) {
        return buildItem(material, amount, display, 0, null);
    }

    /**
     * @param material Bukkit Material or material String ID
     * @param display Display name
     * @param lore Add multiple String parameters for multiple lines
     * @return ItemStack (AIR if error)
     */
    public static ItemStack build(Object material, String display, String... lore) {
        return buildItem(material, 1, display, 0, List.of(lore));
    }

    /**
     * @param material Bukkit Material or material String ID
     * @param display Display name
     * @param lore List of Strings
     * @return ItemStack (AIR if error)
     */
    public static ItemStack build(Object material, String display, List<String> lore) {
        return buildItem(material, 1, display, 0, lore);
    }

    /**
     * @param material Bukkit Material or material String ID
     * @param amount Item amount
     * @param display Display name
     * @param customModelData Model data
     * @return ItemStack (AIR if error)
     */
    public static ItemStack build(Object material, int amount, String display, int customModelData) {
        return buildItem(material, amount, display, customModelData, null);
    }

    /**
     * @param material Bukkit Material or material String ID
     * @param amount Item amount
     * @param display Display name
     * @param lore Add multiple String parameters for multiple lines
     * @return ItemStack (AIR if error)
     */
    public static ItemStack build(Object material, int amount, String display, String... lore) {
        return buildItem(material, amount, display, 0, List.of(lore));
    }

    /**
     * @param material Bukkit Material or material String ID
     * @param amount Item amount
     * @param display Display name
     * @param lore List of strings
     * @return ItemStack (AIR if error)
     */
    public static ItemStack build(Object material, int amount, String display, List<String> lore) {
        return buildItem(material, amount, display, 0, lore);
    }

    /**
     * @param material Bukkit Material or material String ID
     * @param amount Item amount
     * @param display Display name
     * @param customModelData Model data
     * @param lore Add multiple String parameters for multiple lines
     * @return ItemStack (AIR if error)
     */
    public static ItemStack build(Object material, int amount, String display, int customModelData, String... lore) {
        return buildItem(material, amount, display, customModelData, List.of(lore));
    }

    private static ItemStack buildItem(Object material, int amount, String display, int customModelData, List<String> lore) {
        material = MaterialParser.parse(material);
        if (display == null) display = "";
        ItemStack item = new ItemStack((Material) material);
        item.setAmount(amount);
        ItemMeta im = item.getItemMeta();
        if (im == null) return new ItemStack(Material.BARRIER);
        im.setDisplayName(ColorUtils.apply(display));
        if (lore != null) {
            List<String> loreLines = new ArrayList<>();
            for (String line : lore) {
                loreLines.add(ColorUtils.apply(line));
            }
            im.setLore(loreLines);
        }
        if (customModelData > 0) im.setCustomModelData(customModelData);
        item.setItemMeta(im);
        return item;
    }
}
