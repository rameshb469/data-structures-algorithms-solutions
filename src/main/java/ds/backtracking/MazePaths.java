package ds.backtracking;

import java.util.ArrayList;
import java.util.List;

public class MazePaths {

    public static List<String> fndPaths(int[][] board){
        List<String> paths = new ArrayList<>();
        findPaths(board, 0, 0,"", paths);

        return paths;
    }

    public static void findPaths(int[][] board, int row, int col, String path, List<String> rs){

        if (row == board.length-1 && col == board.length-1){
            rs.add(path);
        }

        
    }
}
