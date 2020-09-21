class Solution {
    public int maxCoins(int[] nums) {
        int n=nums.length;
        nums = Arrays.copyOf(nums,nums.length+2);
        for(int i=nums.length-2;i>0;--i){
            nums[i]=nums[i-1];
        }
        nums[0]=nums[nums.length-1]=1;
        int [][] dp=new int[nums.length][nums.length];
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 2; j <= n + 1; ++j) {
                for (int k = i + 1; k < j; ++k) {
                    int sum = nums[i] * nums[k] * nums[j];
                    sum += dp[i][k] + dp[k][j];
                    dp[i][j] = Math.max(dp[i][j], sum);
                }
            }
        }
        return dp[0][n + 1];
    }
}