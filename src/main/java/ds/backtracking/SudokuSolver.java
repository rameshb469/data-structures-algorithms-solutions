package ds.backtracking;

/**
 * 37. Sudoku Solver
 * Hard
 * Topics
 * Companies
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 *
 * A sudoku solution must satisfy all of the following rules:
 *
 * Each of the digits 1-9 must occur exactly once in each row.
 * Each of the digits 1-9 must occur exactly once in each column.
 * Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
 * The '.' character indicates empty cells.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
 * Output: [["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5","2","8","6","1","7","9"]]
 * Explanation: The input board is shown above and the only valid solution is shown below:
 *
 *
 *
 *
 * Constraints:
 *
 * board.length == 9
 * board[i].length == 9
 * board[i][j] is a digit or '.'.
 * It is guaranteed that the input board has only one solution.
 *
 * <a>https://leetcode.com/problems/sudoku-solver/description/</a>
 */
public class SudokuSolver {

    public static void sudokuSolver(int[][] grid){
        sudokuSolver(grid, 0, 0);
        System.out.println();
    }

    private static void sudokuSolver(int[][] grid, int row, int col){
        if (row == grid.length-1 && col == grid.length-1){
            for (int[] rw : grid){
                for (int i = 0; i < rw.length; i++) {
                    System.out.print(rw[i]+" ");
                }
                System.out.println();
            }
            return;
        }

        int newRow = 0;
        int newCol = 0;
        if (col == grid.length-1){
            newRow = row+1;
            newCol = 0;
        } else {
            newRow = row;
            newCol = col+1;
        }
        if (grid[row][col] != 0){
            sudokuSolver(grid, newRow, newCol);
        } else {
            for (int i = 1; i < 10; i++) {
                if (isSafe(grid, row, col, i)){
                    grid[row][col] = i;
                    sudokuSolver(grid, newRow, newCol);
                    grid[row][col] = 0;
                }
            }
        }
    }

    private static boolean isSafe(int[][] grid, int row, int col, int number){
        for (int value : grid[row]){
            if (number == value){
                return false;
            }
        }

        for (int i = 0; i < grid.length; i++) {
            if (grid[i][col] == number){
                return false;
            }
        }

        int sqrt = (int)Math.sqrt(grid.length);
        int startRow = row - row%sqrt;
        int startCol = col - col%sqrt;

        for (int i = startRow; i < startRow+sqrt; i++) {
            for (int j = startCol; j < startCol+sqrt; j++) {
                if (grid[i][j] == number){
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] board = new int[][]{
                {5,3,0,0,7,0,0,0,0},
                {6,0,0,1,9,5,0,0,0},
                {0,9,8,0,0,0,0,6,0},
                {8,0,0,0,6,0,0,0,3},
                {4,0,0,8,0,3,0,0,1},
                {7,0,0,0,2,0,0,0,6},
                {0,6,0,0,0,0,2,8,0},
                {0,0,0,4,1,9,0,0,5},
                {0,0,0,0,8,0,0,7,9}};
        sudokuSolver(board);


    }
}
