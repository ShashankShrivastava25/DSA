package Graph;

public class FloodFillAlgo { // TC O(m*n)
    public static int[][] floodFill(int image[][], int sr, int sc, int color) {
        boolean visited[][] = new boolean[image.length][image[0].length];
        helper(image, sr, sc, color, visited, image[sr][sc]);
        return image;
    }

    public static void helper(int image[][], int sr, int sc, int color, boolean visited[][], int orgColor) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || visited[sr][sc]
                || image[sr][sc] != orgColor) {
            return;
        }
        // Mark visited
        visited[sr][sc] = true;

        // Change color
        image[sr][sc] = color;

        // left
        helper(image, sr, sc - 1, color, visited, orgColor);

        // right
        helper(image, sr, sc + 1, color, visited, orgColor);

        // up
        helper(image, sr - 1, sc, color, visited, orgColor);

        // down
        helper(image, sr + 1, sc, color, visited, orgColor);

        return;
    }

    public static void main(String args[]) {
        int image[][] = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
        int sr = 1, sc = 1, color = 2;
        int ans[][] = floodFill(image, sr, sc, color);
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
