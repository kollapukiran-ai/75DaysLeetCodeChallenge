import java.util.*;

class Solution {
    public int minimumLines(int[][] stockPrices) {
        int n = stockPrices.length;
        if (n <= 1) return 0;

        // Sort by day
        Arrays.sort(stockPrices, (a, b) -> a[0] - b[0]);

        int lines = 1;

        for (int i = 2; i < n; i++) {
            long x1 = stockPrices[i - 2][0], y1 = stockPrices[i - 2][1];
            long x2 = stockPrices[i - 1][0], y2 = stockPrices[i - 1][1];
            long x3 = stockPrices[i][0], y3 = stockPrices[i][1];

            // Compare slopes using cross multiplication
            long slope1 = (y2 - y1) * (x3 - x2);
            long slope2 = (y3 - y2) * (x2 - x1);

            if (slope1 != slope2) {
                lines++;
            }
        }

        return lines;
    }
}
