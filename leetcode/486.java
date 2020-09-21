class Solution {
    public boolean PredictTheWinner(int[] nums) {
        return dfs(0,nums.length-1,1,nums)>=0;
    }
    private int dfs(int l,int r,int is,int[] nums){
        if(l==r) return nums[l]*is;
        int left=nums[l]*is+dfs(l+1,r,-is,nums);
        int right=nums[r]*is+dfs(l,r-1,-is,nums);
        return Math.max(left*is,right*is)*is;
    }
}