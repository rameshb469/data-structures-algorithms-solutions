package ds.dynamic;

public class Fibonacci {

    /**
     * 0,1,2,3,5
     * @param n
     * @return
     */
    public static int fibonacci(int n){
        if (n == 0) return 0;
        if (n == 1) return 1;

        return fibonacci(n-1)+fibonacci(n-2);
    }

    public static int fibonacciMemoization(int n, int[] dp){

        if (n == 0) return 0;
        if (n == 1) return 1;

        if (dp[n] == 0){
            dp[n] = fibonacciMemoization(n-1, dp)+fibonacciMemoization(n-2, dp);
        }

        return dp[n];
    }

    public static int fibonacciDp(int n){
        if (n == 0) return 0;
        int a = 0;
        int b = 1;

        for (int i = 2; i < n; i++) {
            int c = a+b;
            a = b;
            b = c;
        }

        return a +b;
    }

    public static void main(String[] args) {
        int[] dp = new int[11];
        System.out.println(fibonacciMemoization(10, dp));
    }
}
