class Solution {
public:
    int lengthOfLongestSubstring(string s) {
     vector<int> lastIndex(256, -1);  // stores last seen index of each char
        int maxLen = 0;
        int start = 0; // left pointer of window

        for (int i = 0; i < s.size(); i++) {
            // If character seen before and inside current window
            if (lastIndex[s[i]] >= start) {
                start = lastIndex[s[i]] + 1;
            }

            lastIndex[s[i]] = i; // update last seen index
            maxLen = max(maxLen, i - start + 1);
        }

        return maxLen;     
    }
};