class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int insertPos = 0;  // Position to place the next non-zero element
        
        // First pass: move all non-zero elements to the front
        for (int num : nums) {
            if (num != 0) {
                nums[insertPos++] = num;
            }
        }
        
        // Second pass: fill the rest with zeros
        while (insertPos < nums.size()) {
            nums[insertPos++] = 0;
        }
    }
};