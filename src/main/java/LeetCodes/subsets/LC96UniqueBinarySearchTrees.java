package LeetCodes.subsets;

public class LC96UniqueBinarySearchTrees {
    public static int numTrees(int n) {

        int[] dp = new int[n+1];

        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= n; i++){
            for(int j = 0; j < i; j++){

                dp[i] += dp[j] * dp[i - j -1];
                System.out.println(dp[i]);

            }
        }

        return dp[n];

    }


    public static void main(String[] args) {
        numTrees(3);
    }
}
