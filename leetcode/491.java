class Solution {
    List<List<Integer>> ans=new LinkedList<List<Integer>>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<Integer> L=new LinkedList<Integer>();
        dfs(nums,L,0);
        return ans;
    }
    private void dfs(int[] nums,List<Integer> L,int id){
        if(id>=nums.length){
            if(L.size()>1){
                // if(!ans.contains(L))
                ans.add(new LinkedList<Integer>(L));
            }
            return;
        } 
        if(L.size()==0||nums[id]>=L.get(L.size()-1)){
            L.add(nums[id]);
            dfs(nums,L,id+1);
            L.remove(L.size()-1);
        }
        if(L.size()==0||nums[id]!=L.get(L.size()-1))
        dfs(nums,L,id+1);
    }
}