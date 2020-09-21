class Solution {
    List<List<Integer>> ans=new LinkedList<List<Integer>>();
    int N,K;
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> L=new LinkedList<Integer>();
        N=n;
        K=k;
        dfs(1,L);
        return ans;
    }
    private void dfs(int cur,List<Integer> L){
        if (L.size() + (N - cur + 1) < K) {
            return;
        }
        if(L.size()==K){
            ans.add(new LinkedList<Integer>(L));
            return;
        }
        L.add(cur);
        dfs(cur+1,L);
        L.remove(L.size()-1);
        dfs(cur+1,L);
    }
}