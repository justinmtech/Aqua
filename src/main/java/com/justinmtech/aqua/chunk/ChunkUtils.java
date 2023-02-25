package com.justinmtech.aqua.chunk;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.jetbrains.annotations.NotNull;

/**
 * Work with chunks with short one-liners
 */
public class ChunkUtils {

    /**
     * @param worldName Name of the world
     * @param x X coordinate of chunk
     * @param z Z coordinate of chunk
     * @return True if chunk is loaded and false if not.
     */
    public boolean loadChunkAt(@NotNull String worldName, double x, double z) {
        World worldObject = Bukkit.getWorld(worldName);
        if (worldObject == null) return false;
        Chunk chunk = worldObject.getChunkAt((int) x, (int) z);
        if (!chunk.isLoaded()) {
            return chunk.load();
        } else {
            return false;
        }
    }

    /**
     * @param worldName Name of the world
     * @param x X coordinate of chunk
     * @param z Z coordinate of chunk
     * @return True of chunk is loaded and false if not.
     */
    public boolean unloadChunkAt(@NotNull String worldName, double x, double z) {
        World worldObject = Bukkit.getWorld(worldName);
        if (worldObject == null) return false;
        Chunk chunk = worldObject.getChunkAt((int) x, (int) z);
        if (!chunk.isLoaded()) {
            return chunk.load();
        } else {
            return false;
        }
    }
}
