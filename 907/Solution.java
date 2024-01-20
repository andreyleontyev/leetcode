class Solution {

    public int sumSubarrayMins(int[] arr) {
         int ans = 0;

        int mod = (int) 1e9 + 7;

        for (int i = 0; i < arr.length; i++) {
            int[] dp = new int[arr.length];

            dp[i] = arr[i];
            ans += dp[i];
            for (int j = i+1; j < arr.length; j++) {
                dp[j] = Math.min(arr[j], dp[j-1]);
                ans += dp[j];
                ans %= mod;
            }
        }

        return ans;
    }
}
