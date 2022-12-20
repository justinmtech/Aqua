# Aqua
A collection of Bukkit/Spigot utilities to help you stay in flow, save time and improve readability.

# Utility Classes
- Color - Fetch traditional or hex colors without "translateAlternateColorCodes" (assume & char)
- ItemFactory - Build simple or complex items with one liners and generic Material type (String or Material accepted)
- SoundUtils - Broadcast sounds to all online players with or without permissions
- BossBarCache - Bossbar cache for storing and modifying temporary bossbar objects (useful for status updates with progress)
- Message - Send ActionBar messages cleanly
- Credentials - Database credentials wrapped in a class.
= ConnectionManager - Easily setup HikariCP data sources and obtain sql connections efficiently.
- SQLQueries - An enum class with SQL query notes and basic examples. Simply use "SQLQueries." to then show query syntax.
- PlayerUtils - Give ItemStack to player or drop naturally if inv is full with one liner.
- StringSearch - Given an input string and set of other strings, return similar or matching strings.

# Dependency Setup

This repo uses JitPack. To use the utility with Maven, you need the following repository and dependency in your project:

	<repository>
	    <id>jitpack.io</id>
	    <url>https://jitpack.io</url>
	</repository>
    
	<dependency>
	    <groupId>com.github.justinmtech</groupId>
	    <artifactId>Aqua</artifactId>
	    <version>1.1</version>
	</dependency>

For setup with other project management tools:
https://jitpack.io/#justinmtech/Aqua/1.1
