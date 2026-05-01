class Solution {
    public int subarraySum(int[] nums, int k) {
       HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // prefix sum = 0 occurs once

        int prefix = 0;
        int count = 0;

        for (int num : nums) {
            prefix += num;

            // Check if (prefix - k) was seen before
            if (map.containsKey(prefix - k)) {
                count += map.get(prefix - k);
            }

            // Store/update prefix sum frequency
            map.put(prefix, map.getOrDefault(prefix, 0) + 1);
        }

        return count;  
    }
}