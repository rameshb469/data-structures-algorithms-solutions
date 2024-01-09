package ds.dynamic;

public class MinimumFallingPathSumIIProblem {

    public static int minimumFallingPath(int[][] matrix){

        int row = matrix.length;
        int col = matrix[0].length;

        int[][] rs = new int[row][col];
        rs[row-1][0] = matrix[row-1][0];

        for( int i = 1; i < col; i++){
            rs[row-1][i] = matrix[row-1][i]+rs[row-1][i-1];
        }

        // rs[i][j] = matrix[i][j]+max(rs[i-1][j], rs[i][j-1])

        for (int i = row-2; i >= 0; i--) {
            for (int j = 0; j < col; j++) {

                if(j == 0){
                    rs[i][j] = matrix[i][j]+rs[i+1][j];
                } else if (i+1 == row) {
                    rs[i][j] = matrix[i][j]+rs[i][j-1];
                } else {
                    rs[i][j] = matrix[i][j]+ Math.max(rs[i][j-1], rs[i+1][j]);
                }
            }
        }

        print(rs);

        return rs[0][col-1];
    }

    public static void print(int[][] matrix){
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[4][4];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = (j % 2 == 0) ? 1 : 0;
            }
        }

        print(matrix);
        System.out.println("-------------------------");

        System.out.println(minimumFallingPath(matrix));
    }
}
