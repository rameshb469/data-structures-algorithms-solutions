package ds.dynamic;

public class NumberPathProblem {

    public int numberOfPaths(int[][] grid, int row, int col, int cost){

        if (row < 0 || col < 0 ) return 0;

        if (row == 0 && col == 0 ){
            return grid[row][col]-cost == 0 ? 1  : 0;
        }

        if (row == 0){
            return numberOfPaths(grid, 0, col-1, cost-grid[row][col]);
        }

        if (col == 0){
            return numberOfPaths(grid, row, 0, cost-grid[row][col]);
        }
        int ways1 = numberOfPaths(grid, row-1, col, cost-grid[row][col]);
        int ways2 = numberOfPaths(grid, row, col-1, cost-grid[row][col]);

        return ways1+ways2;
    }
}
