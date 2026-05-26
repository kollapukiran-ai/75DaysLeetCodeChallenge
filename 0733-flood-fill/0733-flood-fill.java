class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int original = image[sr][sc];
        
        // If the starting pixel already has the target color, no change needed
        if (original == color) return image;

        dfs(image, sr, sc, original, color);
        return image;
    }

    private void dfs(int[][] image, int r, int c, int original, int color) {
        // Boundary check
        if (r < 0 || c < 0 || r >= image.length || c >= image[0].length) return;

        // Only fill pixels that match the original color
        if (image[r][c] != original) return;

        // Fill the pixel
        image[r][c] = color;

        // Explore 4-directionally
        dfs(image, r + 1, c, original, color); // down
        dfs(image, r - 1, c, original, color); // up
        dfs(image, r, c + 1, original, color); // right
        dfs(image, r, c - 1, original, color); // left
    }
}
