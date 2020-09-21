class Solution {
    List<String> L=new LinkedList<String>();
    int n,ans=0;
    boolean flag=false;
    public int maxUniqueSplit(String s) {
        n=s.length();
        dfs(s,0,1);
        return ans;
    }
    private void dfs(String s,int pre,int cur){
        if(n-cur+1+L.size()<ans) return;//剪支
        if(cur>n){
            if(L.size()>ans){
                ans=L.size();
            }
            return;
        }
        if(!L.contains(s.substring(pre,cur))){
            L.add(s.substring(pre,cur));
            dfs(s,cur,cur+1);
            L.remove(L.size()-1);
        }
        dfs(s,pre,cur+1);
        
    }
}