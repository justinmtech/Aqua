package com.justinmtech.aqua.server;

import java.lang.management.ManagementFactory;

/**
 * Helper methods for common server tasks.
 */
public class ServerUtils {

    /**
     * @return Uptime in seconds as an integer
     */
    public static int getUptimeInSeconds() {
        return (int) ManagementFactory.getRuntimeMXBean().getUptime() / 1000;
    }

    /**
     * @return Uptime in minutes as an integer
     */
    public static int getUptimeInMinutes() {
        return getUptimeInSeconds() * 60;
    }

    /**
     * @param ticks Amount of server ticks
     * @return Ticks converted to hours as a long
     */
    public static long ticksToHours(long ticks) {
        long ticksPerSecond = ticks / 20;
        long ticksPerMinute = ticksPerSecond * 60;
        return ticksPerMinute * 60;
    }

    /**
     * @param minutes Time in minutes
     * @return Minutes converted to ticks as a long
     */
    public static long minutesToTicks(long minutes) {
        long seconds = minutes / 60;
        return seconds * 20;
    }

    /**
     * @return Uptime in seconds as an integer
     */
    public static int getUptimeInHours() {
        return getUptimeInSeconds() * 60;
    }
}
