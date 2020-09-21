class Solution {
    public int maxProductPath(int[][] grid) {
        if(grid.length==0)return 0;
        int n=grid.length;
        int m=grid[0].length;
        long mod=(long)(1e9+7);
        long[][] dp1=new long[n][m];
        long[][] dp2=new long[n][m];
        dp1[0][0]=dp2[0][0]=grid[0][0];
        for(int i=1;i<m;++i){
            dp1[0][i]=dp2[0][i]=dp2[0][i-1]*grid[0][i];
        }
        for(int i=1;i<n;++i){
            dp1[i][0]=dp2[i][0]=dp2[i-1][0]*grid[i][0];
            for(int j=1;j<m;++j){
                dp1[i][j]=Math.max(dp1[i-1][j]*grid[i][j],dp1[i][j-1]*grid[i][j]);
                dp1[i][j]=Math.max(dp1[i][j],dp2[i][j-1]*grid[i][j]);
                dp1[i][j]=Math.max(dp1[i][j],dp2[i-1][j]*grid[i][j]);
                
                dp2[i][j]=Math.min(dp2[i-1][j]*grid[i][j],dp2[i][j-1]*grid[i][j]);
                dp2[i][j]=Math.min(dp2[i][j],dp1[i][j-1]*grid[i][j]);
                dp2[i][j]=Math.min(dp2[i][j],dp1[i-1][j]*grid[i][j]);
            }
        }
        if(dp1[n-1][m-1]<0) return -1;
        return (int)(dp1[n-1][m-1]%mod);
    }
}