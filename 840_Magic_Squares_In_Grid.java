class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        if (rows < 3 || cols < 3) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < rows - 2; i++) {
            for (int j = 0; j < cols - 2; j++) {
                if (isMagicSquare(grid, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    public int findRowSum(int grid[][], int rows, int cols) {
        boolean visited[] = new boolean[10];
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            int rowSum = 0;
            for (int j = 0; j < 3; j++) {
                int val = grid[rows + i][cols + j];
                if (val == 0 || val >= 10 || visited[val]) {
                    return -1;
                }
                visited[val] = true;
                rowSum += val;
            }
            if (i == 0) {
                sum = rowSum;
            } else {
                if (sum != rowSum) {
                    return -1;
                }
            }
        }
        return sum;
    }

    public int findColSum(int grid[][], int rows, int cols) {
        int sum = 0;
        for (int j = 0; j < 3; j++) {
            int colSum = 0;
            for (int i = 0; i < 3; i++) {
                int val = grid[rows + i][cols + j];
                colSum += val;
            }
            if (j == 0) {
                sum = colSum;
            } else {
                if (sum != colSum) {
                    return -1;
                }
            }
        }
        return sum;
    }

    public int diagonalSum(int grid[][], int rows, int cols) {
        int sum1 = grid[rows][cols] + grid[rows + 1][cols + 1] + grid[rows + 2][cols + 2];
        int sum2 = grid[rows][cols + 2] + grid[rows + 1][cols + 1] + grid[rows + 2][cols];
        if (sum1 == sum2) {
            return sum1;
        }
        return -1;
    }

    public boolean isMagicSquare(int grid[][], int rows, int cols) {
        int rowSum = findRowSum(grid, rows, cols);
        if (rowSum == -1)
            return false;
        int colSum = findColSum(grid, rows, cols);
        if (colSum == -1)
            return false;
        int diagonalSum = diagonalSum(grid, rows, cols);
        if (diagonalSum == -1)
            return false;
        if (rowSum == colSum && rowSum == diagonalSum) {
            return true;
        }
        return false;
    }
}
