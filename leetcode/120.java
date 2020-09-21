class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp=new int[triangle.size()];
        dp[0]=triangle.get(0).get(0);
        for(int i=1 ;i<triangle.size();i++){
            dp[i]=dp[i-1]+triangle.get(i).get(i);
            for(int j=i-1;j>0;j--){
                dp[j]=Math.min(dp[j],dp[j-1])+triangle.get(i).get(j);
            }
            dp[0]+=triangle.get(i).get(0);
        }
        int ans=dp[0];
        for(int i=0 ;i<triangle.size();i++){
            if(dp[i]<ans) ans=dp[i];
        }
        return ans;
    }
}