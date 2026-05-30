import java.util.*;

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // DFS from Pacific (top row + left column)
        for (int c = 0; c < n; c++) {
            dfs(0, c, heights, pacific, heights[0][c]);
        }
        for (int r = 0; r < m; r++) {
            dfs(r, 0, heights, pacific, heights[r][0]);
        }

        // DFS from Atlantic (bottom row + right column)
        for (int c = 0; c < n; c++) {
            dfs(m - 1, c, heights, atlantic, heights[m - 1][c]);
        }
        for (int r = 0; r < m; r++) {
            dfs(r, n - 1, heights, atlantic, heights[r][n - 1]);
        }

        // Collect cells reachable by both oceans
        List<List<Integer>> result = new ArrayList<>();
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }

        return result;
    }

    private void dfs(int r, int c, int[][] heights, boolean[][] visited, int prevHeight) {
        int m = heights.length;
        int n = heights[0].length;

        // Out of bounds or already visited or height is lower (can't flow backwards)
        if (r < 0 || c < 0 || r >= m || c >= n ||
            visited[r][c] || heights[r][c] < prevHeight) {
            return;
        }

        visited[r][c] = true;

        dfs(r + 1, c, heights, visited, heights[r][c]);
        dfs(r - 1, c, heights, visited, heights[r][c]);
        dfs(r, c + 1, heights, visited, heights[r][c]);
        dfs(r, c - 1, heights, visited, heights[r][c]);
    }
}
