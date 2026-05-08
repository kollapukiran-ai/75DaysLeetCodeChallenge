class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] freq = new int[26];

        // Count characters of s1
        for (char c : s1.toCharArray()) {
            freq[c - 'a']++;
        }

        int left = 0, right = 0, needed = s1.length();

        while (right < s2.length()) {
            char r = s2.charAt(right);

            // If this character is needed, reduce needed count
            if (freq[r - 'a'] > 0) {
                needed--;
            }

            // Reduce frequency (we include this char in window)
            freq[r - 'a']--;
            right++;

            // When window size exceeds s1 length, shrink from left
            if (right - left > s1.length()) {
                char l = s2.charAt(left);
                if (freq[l - 'a'] >= 0) {
                    needed++;
                }
                freq[l - 'a']++;
                left++;
            }

            // If all characters matched
            if (needed == 0) return true;
        }

        return false;
    }
}
