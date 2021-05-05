public class Testing {
    public static void main(String[] args) {

    }

    public int fib(int N){

        if(N==0) return 0;
        if(N==1) return 1;

        int[] dp = new int[N+1];

        for(int i = 2; i < N; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[N];
    }
}
