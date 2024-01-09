package ds.greedy;

public class CoinChangeProblem {

    static final int[] denominations = new int[]{1,2,5,10,20,50,100,200,500};

    /**
     * Find minimum denominations for given amount
     *
     * For ex : denominations [1,2,5,10,20,50,100,200,500]
     *          amount = 144
     * minimum denominations required is 100+2*20+2 = 5
     * @param amount
     * @param denominations
     * @return
     */
    public static int minCountForAmount(int amount, int[] denominations){

        int count = 0;
        int index = denominations.length-1;

        while (amount != 0){
            if(amount >= denominations[index]){
                count++;
                amount-=+denominations[index];
                index = denominations.length-1;
            } else {
                index--;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(minCountForAmount(144, denominations));
        System.out.println(minCountForAmount(201, denominations));
    }
}
