import java.util.*;

public class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        // Count frequencies
        for (char c : tasks) {
            freq[c - 'A']++;
        }

        // Find the maximum frequency
        int maxFreq = 0;
        for (int f : freq) {
            maxFreq = Math.max(maxFreq, f);
        }

        // Count how many tasks have this max frequency
        int maxCount = 0;
        for (int f : freq) {
            if (f == maxFreq) maxCount++;
        }

        // Apply the formula
        int partCount = maxFreq - 1;
        int partLength = n + 1;
        int emptySlots = partCount * partLength + maxCount;

        return Math.max(emptySlots, tasks.length);
    }
}
