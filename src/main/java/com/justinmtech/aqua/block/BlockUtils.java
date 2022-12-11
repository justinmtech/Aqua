package com.justinmtech.aqua.block;

import org.bukkit.Location;
import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;

/**
 * Set or move blocks and return success.
 */
public class BlockUtils {

    /**
     * @param location Block location
     * @param material Bukkit Material or String material ID
     */
    //Set block at location to material. Accepts Material object or String
    public static void set(@NotNull Location location, @NotNull Object material) {
        if (material instanceof Material) {
            location.getBlock().setType((Material)material);
        } else if (material instanceof String) {
            Material materialFromString = Material.valueOf((String) material);
            location.getBlock().setType(materialFromString);
        }
    }

    /**
     * @param from Current block location
     * @param to Location to move it to
     */
    public static void move(@NotNull Location from, @NotNull Location to) {
        Material material = from.getBlock().getType();
        to.getBlock().setType(material);
        from.getBlock().setType(Material.AIR);
    }

}
