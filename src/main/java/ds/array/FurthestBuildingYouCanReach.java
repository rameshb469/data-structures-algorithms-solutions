package ds.array;

public class FurthestBuildingYouCanReach {

    public static int furthestBuilding(int[] heights, int bricks, int ladders){
        return furthestBuilding(heights, bricks, ladders, 0);
    }

    public static int furthestBuilding(int[] heights, int bricks, int ladders, int i){

        // base condition
        if (i >= heights.length-1 || bricks < 0 || ladders < 0) return i;

        if (heights[i] >= heights[i+1]) {
            return furthestBuilding(heights, bricks, ladders, i+1);
        } else {
            int diff = heights[i+1]-heights[i];
            int cb = furthestBuilding(heights, bricks-diff, ladders, i+1);
            int lb = furthestBuilding(heights, bricks, ladders-1, i+1);

            return Math.max(cb, lb);
        }
    }

    public static void main(String[] args) {
        System.out.println(furthestBuilding(new int[]{14,3,19,3}, 17 , 0));
    }
}
