class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string, vector<string>> mp;

        for (string s : strs) {
            string key = s;
            sort(key.begin(), key.end());   // sort characters to form key
            mp[key].push_back(s);           // store original string
        }

        vector<vector<string>> result;
        for (auto &p : mp) {
            result.push_back(p.second);
        }

        return result;

    }
};