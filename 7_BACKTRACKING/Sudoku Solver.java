class Solution {
    static boolean isSafe(int row, int col, int[][] grid, int value) {
        int n = grid[0].length;
        for (int i = 0; i < n; i++) {
            // CHECK FOR ROW
            if (grid[row][i] == value)
                return false;

            // CHECK FOR COLUMN
            if (grid[i][col] == value)
                return false;

            // CHECK FOR 3x3 MATRIX
            if (grid[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == value)
                return false;
        }
        return true;
    }

    static boolean solve(int[][] grid) {
        int n = grid[0].length;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 0) {
                    for (int val = 1; val <= 9; val++) {
                        if (isSafe(row, col, grid, val)) {
                            grid[row][col] = val;
                            // Recursive Call
                            boolean possible = solve(grid);
                            if (possible) {
                                return true;
                            } else {
                                grid[row][col] = 0; // Backtrack
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true; 
    }

    static boolean SolveSudoku(int[][] grid) {
        return solve(grid);
    }

    // Function to print grids of the Sudoku.
    static void printGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j]+ " ");
            }
        }
    }
}