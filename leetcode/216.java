class Solution {
    List<List<Integer>> ans=new LinkedList<List<Integer>>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> L=new LinkedList<Integer>();
        dfs(k,n,1,L);

        return ans;
    }
    private void dfs(int restc,int rest,int cur,List<Integer> L){
        if(rest==0&&restc==0){
            ans.add(new LinkedList<Integer>(L));
            return;
        }
        if(rest<0||restc<0||cur>9) return;
        
        L.add(cur);
        dfs(restc-1,rest-cur,cur+1,L);
        L.remove(L.size()-1);

        dfs(restc,rest,cur+1,L);
    }
}