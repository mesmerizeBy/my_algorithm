class Solution {
    List<List<Integer>> ans=new LinkedList<List<Integer>>();
    int n;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        n=target;
        List<Integer> L=new LinkedList<Integer>();
        Arrays.sort(candidates);
        dfs(candidates,0,0,-1,L);
        return ans;
    }
    private void dfs(int[] nums,int sum,int cur,int last,List<Integer> L){
        if(cur==nums.length&&sum==n){
            ans.add(new LinkedList<Integer>(L));
            return;
        }
        if(sum>n||cur>=nums.length) return;
        
        L.add(nums[cur]);
        dfs(nums,sum+nums[cur],cur+1,nums[cur],L);
        L.remove(L.size()-1);
        if(nums[cur]!=last)
        dfs(nums,sum,cur+1,last,L);
    }
}