class Solution {
    public int minPathSum(int[][] grid) {
        int[] dp=new int [grid[0].length];
        for(int i=0;i<grid.length;++i){
            dp[0]+=grid[i][0];
            for(int j=1;j<grid[i].length;++j){
                if(i==0){
                    dp[j]+=dp[j-1]+grid[i][j];
                }else{
                    dp[j]=Math.min(dp[j-1],dp[j])+grid[i][j];
                }
                
            }
        }
        return dp[grid[0].length-1];
    }
}