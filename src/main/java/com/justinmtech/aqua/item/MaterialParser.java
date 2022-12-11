package com.justinmtech.aqua.item;

import org.bukkit.Material;

/**
 * Obtain Material types from generic types
 */
public class MaterialParser {

    /**
     * @param material Bukkit Material or String ID of material
     * @return ItemStack (AIR if error or null)
     */
    public static Material parse(Object material) {
        if (material == null) {
            return Material.AIR;
        } else if (material instanceof Material) {
            return (Material)material;
        } else if (material instanceof String) {
            return Material.getMaterial((String) material);
        }
        return Material.AIR;
    }
}
