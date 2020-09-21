class Solution {
    public int integerBreak(int n) {
        int[] dp=new int[n+5];
        dp[0]=1;
        for(int i=1;i<n;++i){
            for(int j=0;j<i;++j){
                int x=Math.max(dp[i-j],i-j);
                dp[i]=Math.max(dp[j]*x,dp[i]);
            }
        }
        for(int j=1;j<n;++j){
            int x=Math.max(dp[n-j],n-j);
            dp[n]=Math.max(dp[j]*x,dp[n]);
        }
        return dp[n];
    }
}