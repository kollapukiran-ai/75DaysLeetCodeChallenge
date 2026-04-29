class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Using 3 sets for each row, column, and box
        HashSet<String> seen = new HashSet<>();

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char val = board[r][c];

                if (val == '.') continue;

                // Build unique keys
                String rowKey = val + " in row " + r;
                String colKey = val + " in col " + c;
                String boxKey = val + " in box " + (r/3) + "-" + (c/3);

                // If any key already exists → invalid
                if (!seen.add(rowKey) || !seen.add(colKey) || !seen.add(boxKey)) {
                    return false;
                }
            }
        }
        return true;
    }
}
