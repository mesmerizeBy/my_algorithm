class Solution {
    List<List<Integer>> ans=new LinkedList<List<Integer>>();
    int n;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        n=target;
        List<Integer> L=new LinkedList<Integer>();
        dfs(candidates,0,0,L);
        return ans;
    }
    private void dfs(int[] nums,int sum,int cur,List<Integer> L){
        if(sum>n||cur>=nums.length){
            return;
        }
        if(sum==n){
            ans.add(new LinkedList<Integer>(L));
            return;
        }
        
        L.add(nums[cur]);
        dfs(nums,sum+nums[cur],cur,L);
        L.remove(L.size()-1);

        dfs(nums,sum,cur+1,L);
    }
}