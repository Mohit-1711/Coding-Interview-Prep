
class Pair {
    int i;
    int j;

    Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int n = image.length;
        int m = image[0].length;

        int originalColor = image[sr][sc];

        // If both colors are same, no changes needed
        if (originalColor == color) {
            return image;
        }

        Queue<Pair> q = new ArrayDeque<>();

        q.offer(new Pair(sr, sc));
        image[sr][sc] = color;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int x = 0; x < size; x++) {

                Pair coordinate = q.poll();

                int i = coordinate.i;
                int j = coordinate.j;

                // Up
                if (i-1 >= 0 && image[i-1][j] == originalColor) {
                    image[i-1][j] = color;
                    q.offer(new Pair(i-1, j));
                }

                // Down
                if (i+1 < n && image[i+1][j] == originalColor) {
                    image[i+1][j] = color;
                    q.offer(new Pair(i+1, j));
                }

                // Left
                if (j-1 >= 0 && image[i][j-1] == originalColor) {
                    image[i][j-1] = color;
                    q.offer(new Pair(i, j-1));
                }

                // Right
                if (j+1 < m && image[i][j+1] == originalColor) {
                    image[i][j+1] = color;
                    q.offer(new Pair(i, j+1));
                }
            }
        }

        return image;
    }
}
