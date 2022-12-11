package com.justinmtech.aqua.block;

import org.bukkit.Location;
import org.bukkit.Material;

public class BlockUtils {

    //Set block at location to material. Accepts Material object or String
    public static boolean set(Location location, Object material) {
        if (location == null) return false;
        if (material == null) return false;
        if (material instanceof Material) {
            location.getBlock().setType((Material)material);
        } else if (material instanceof String) {
            Material materialFromString = Material.valueOf((String) material);
            location.getBlock().setType(materialFromString);
        }
        return true;
    }

    public static boolean move(Location from, Location to) {
        if (from == null) return false;
        if (to == null) return false;
        Material material = from.getBlock().getType();
        to.getBlock().setType(material);
        from.getBlock().setType(Material.AIR);
        return true;
    }

}
