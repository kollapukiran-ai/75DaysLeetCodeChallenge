class Solution {
    public int findPeakElement(int[] nums) {
      int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If mid is rising towards the right, peak must be on the right side
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                // If mid is falling or peak is at mid, go left
                right = mid;
            }
        }

        // left == right → peak index
        return left;  
    }
}