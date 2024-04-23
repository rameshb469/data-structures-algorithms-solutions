package ds.backtracking;

/**
 * You are given an m x n matrix maze (0-indexed) with empty cells (represented as '.') and walls (represented as '+'). You are also given the entrance of the maze, where entrance = [entrancerow, entrancecol] denotes the row and column of the cell you are initially standing at.
 *
 * In one step, you can move one cell up, down, left, or right. You cannot step into a cell with a wall, and you cannot step outside the maze. Your goal is to find the nearest exit from the entrance. An exit is defined as an empty cell that is at the border of the maze. The entrance does not count as an exit.
 *
 * Return the number of steps in the shortest path from the entrance to the nearest exit, or -1 if no such path exists.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: maze = [["+","+",".","+"],[".",".",".","+"],["+","+","+","."]], entrance = [1,2]
 * Output: 1
 * Explanation: There are 3 exits in this maze at [1,0], [0,2], and [2,3].
 * Initially, you are at the entrance cell [1,2].
 * - You can reach [1,0] by moving 2 steps left.
 * - You can reach [0,2] by moving 1 step up.
 * It is impossible to reach [2,3] from the entrance.
 * Thus, the nearest exit is [0,2], which is 1 step away.
 * Example 2:
 *
 *
 * Input: maze = [["+","+","+"],[".",".","."],["+","+","+"]], entrance = [1,0]
 * Output: 2
 * Explanation: There is 1 exit in this maze at [1,2].
 * [1,0] does not count as an exit since it is the entrance cell.
 * Initially, you are at the entrance cell [1,0].
 * - You can reach [1,2] by moving 2 steps right.
 * Thus, the nearest exit is [1,2], which is 2 steps away.
 * Example 3:
 *
 *
 * Input: maze = [[".","+"]], entrance = [0,0]
 * Output: -1
 * Explanation: There are no exits in this maze.
 *
 */
public class NearestExitProblem {

    public static int nearestExit(int[][] maze, int row, int col, int min){

        if (row < 0 || col < 0 || row >= maze.length || col >= maze.length){
            return 0;
        }

        if (maze[row][col] == 0){
            maze[row][col] = 1;
            int c1 = 1+nearestExit(maze, row+1, col, min+1);
            int c2 = 1+nearestExit(maze, row-1, col, min+1);
            int c3 = 1+nearestExit(maze, row, col+1, min+1);
            int c4 = 1+nearestExit(maze, row, col-1, min+1);
            maze[row][col] = 0;
            return Math.min(c1, Math.max(c2, Math.max(c3, c4)));

        }

        return 1;
    }


    private boolean isSafe(int[][] maze, int row, int col){
        if (maze[row][col] != 0){
            return false;
        }

        return (maze[row+1][col] == 0 || maze[row-1][col] == 0
                || maze[row][col-1] == 0 || maze[row][col+1] == 0);
    }



    public static int nearestExit(int[][] maze, int[] entrance) {

        int[][] offset = new int[][]{{-1,0},{1,0},{0, 1},{0, -1}};

        int x = entrance[0];
        int y = entrance[1];

        int globalMin = -1;
        while (x != 0 && y != 0){
            int min = 0;
            boolean found = false;
            for (int[] off : offset){
                int newX = x+off[0];
                int newY = y+off[1];

                if (maze[newX][newY] == 0){
                    x= newX;
                    y = newY;
                    min = min+1;
                    found = true;
                }
            }

            if (found && min > globalMin){
                globalMin = min;
                x = entrance[0];
                y = entrance[1];
            }
        }
        return globalMin;
    }

    public static void main(String[] args) {
        int[][] maze = new int[][]{
            {1,1,0,1},{0,0,0,1},{1,1,1,0}
        };
        int[]entrance = new int[]{1,2};

        System.out.println(nearestExit(maze, 1, 2, 0));;
    }
}
