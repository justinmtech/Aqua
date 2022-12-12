package com.justinmtech.aqua.server;

import java.lang.management.ManagementFactory;

public class ServerUtils {

    public static int getUptimeInSeconds() {
        return (int) ManagementFactory.getRuntimeMXBean().getUptime() / 1000;
    }

    public static int getUptimeInMinutes() {
        return getUptimeInSeconds() * 60;
    }

    public static int getUptimeInHours() {
        return getUptimeInSeconds() * 60;
    }
}
