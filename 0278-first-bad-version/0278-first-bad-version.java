public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (isBadVersion(mid)) {
                right = mid;      // mid might be the first bad version
            } else {
                left = mid + 1;   // first bad must be after mid
            }
        }

        return left; // or right, both are same here
    }
}
