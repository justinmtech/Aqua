package com.justinmtech.aqua.search;

import org.apache.commons.text.similarity.LevenshteinDistance;
import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * Utility methods for finding similar strings in datasets
 * Useful for getting tab completion recommendations or autocorrecting input
 * Example: Feed findNearMatches a warp name to match and provide it with a list of possible warps
 * Result: It will return a list of similar warps
 */
public class StringSearch {

    /**
     * @param string String
     * @param stringSet Set of strings to compare
     * @return String of the closest match or NULL
     */
    public static String findClosestMatch(@NotNull String string, @NotNull Set<String> stringSet) {
        if (stringSet.contains(string)) return string;

        List<String> nearMatches = findNearMatches(string, stringSet, 1, 4);
        if (!nearMatches.isEmpty()) {
            return nearMatches.get(0);
        }
        return null;
    }

    /**
     * @param string String
     * @param dataSet Set of strings
     * @param limit Max amount of matches to return
     * @param distanceThreshold How close the strings must be in distance
     * @return String List
     */
    public static List<String> findNearMatches(@NotNull String string, @NotNull Set<String> dataSet, int limit, int distanceThreshold) {
        Map<Integer, String> nearMatches = new HashMap<>();

        for (String data : dataSet) {
            int distance = getDistanceBetweenStrings(string, data);
                if (distance > distanceThreshold) continue;
            nearMatches.put(distance, data);
        }
        return orderNearestMatches(nearMatches, limit);
    }

    /**
     * @param nearMatches A map of near match strings and their distances
     * @param limit The amount of ordered matches return
     * @return List of String
     */
    private static List<String> orderNearestMatches(@NotNull Map<Integer, String> nearMatches, int limit) {
        int count = 0;
        List<String> nearMatchesInOrder = new ArrayList<>();
        int previousDistance = 100;
        for (int currentDistance : nearMatches.keySet()) {
            if (count >= limit) break;
            if (currentDistance <= previousDistance) {
                nearMatchesInOrder.add(nearMatches.get(currentDistance));
                count++;
            }
        }
        return nearMatchesInOrder;
    }

    /**
     * @param string1 First string
     * @param string2 Second string
     * @return Levenshtein distance between the two strings
     */
    public static int getDistanceBetweenStrings(@NotNull String string1, @NotNull String string2) {
        CharSequence string1Sequence = new StringBuilder(string1.toLowerCase());
        CharSequence string2Sequence = new StringBuilder(string2.toLowerCase());
        return LevenshteinDistance.getDefaultInstance().apply(string1Sequence, string2Sequence);
    }

}
