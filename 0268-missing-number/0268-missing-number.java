class Solution {
    public int missingNumber(int[] nums) {
        int xor = 0;
        int n = nums.length;

        // XOR all numbers from 0 to n
        for (int i = 0; i <= n; i++) {
            xor ^= i;
        }

        // XOR all elements in nums
        for (int num : nums) {
            xor ^= num;
        }

        return xor; // remaining value is the missing number
    }
}
