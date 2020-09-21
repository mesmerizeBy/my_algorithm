class Solution {
    List<List<Integer>> ans=new LinkedList<List<Integer>>();
    int n;
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> L=new LinkedList<Integer>();
        n=nums.length;
        Arrays.sort(nums);
        dfs(nums,0,0,L);
        return ans;
    }
    private void dfs(int[] nums,int cur,int last,List<Integer> L){
        if(cur>=n){
            ans.add(new LinkedList<Integer>(L));
            return ;
        }
        L.add(nums[cur]);
        dfs(nums,cur+1,nums[cur],L);
        L.remove(L.size()-1);
        if(nums[cur]!=last||L.size()==0)
        dfs(nums,cur+1,last,L);
    }
}