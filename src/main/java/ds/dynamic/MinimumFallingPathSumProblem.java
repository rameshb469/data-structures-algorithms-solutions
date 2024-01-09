package ds.dynamic;

/**
 * <h2>931. Minimum Falling Path Sum</h2>
 * <p>Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.</p>
 * <br/>
 * <p>A falling path starts at any element in the first row and chooses the element in the next row
 * that is either directly below or diagonally left/right. Specifically, the next element
 * from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).</p>
 * <br/>
 * <p>Example 1:
 * Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
 * Output: 13
 * Explanation: There are two falling paths with a minimum sum as shown.</p>
 * <br/>
 * <p>Example 2:
 * Input: matrix = [[-19,57],[-40,-5]]
 * Output: -59
 * Explanation: The falling path with a minimum sum is shown. </p>
 *
 */
public class MinimumFallingPathSumProblem {


    public static int minimumFallingSum(int[][] matrix){
        int row  = matrix.length;
        int col = matrix.length;

        int[][] rs = new int[row][col];
        // base conditions
        for (int i = 0; i < col; i++) {
            rs[0][i] = matrix[0][i];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {

                // edge case : If left most colum, so doesn
                if (j == 0){
                    rs[i][j] = matrix[i][j]+
                            Math.min(rs[i-1][j], rs[i-1][j+1]);
                } else if (j+1 == col) {
                    rs[i][j] = matrix[i][j]+
                            Math.min(rs[i-1][j], rs[i-1][j-1]);
                } else {
                    rs[i][j] = matrix[i][j]+
                            Math.min(rs[i-1][j-1], Math.min(rs[i-1][j], rs[i-1][j+1]));
                }
            }
        }

        int min = rs[row-1][0];
        for (int i=0 ; i< col; i++){
            min = Math.min(min, rs[row-1][i]);
        }

        return min;

    }
}
