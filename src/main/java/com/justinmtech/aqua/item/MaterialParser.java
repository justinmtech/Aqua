package com.justinmtech.aqua.item;

import org.bukkit.Material;

public class MaterialParser {

    //Parse material object as Material or String. Return AIR if null.
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
