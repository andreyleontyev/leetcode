class Solution {
 public int climbStairs(int n) {
        int[] dp = new int[46];
        if (n == 0) return 0;
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        if (dp[n] == 0) {
            dp[n] = climbStairs_dp(n,dp);
        }

        return dp[n];
    }

    public int climbStairs_dp (int n, int[] dp) {
        int opts1 = dp[n - 1] ;

        if (opts1 == 0) {
            opts1 = climbStairs_dp(n-1, dp);
            dp[n-1] = opts1;
        }

        int opts2 = dp[n - 2] ;

        if (opts2 == 0) {
            opts2 = climbStairs_dp(n-2, dp);
            dp[n-2] = opts2;
        }

        return opts2 + opts1;
    }
}
