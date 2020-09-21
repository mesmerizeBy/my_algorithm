class Solution {
    Map<String,List<String>> M=new HashMap<String,List<String>>();
    Map<String,Integer> vis=new HashMap<String,Integer>();
    List<String> ans=new LinkedList<String>();
    int cnt,n;
    public List<String> findItinerary(List<List<String>> tickets) {
        cnt=tickets.size();
        for(int i=0;i<tickets.size();i++){
            String ss=tickets.get(i).get(0)+tickets.get(i).get(1);
            if(M.get(tickets.get(i).get(0))==null){
                M.put(tickets.get(i).get(0),new ArrayList<String>());
            }
            if(vis.get(ss)==null){
                vis.put(ss,0);
            }
            M.get(tickets.get(i).get(0)).add(tickets.get(i).get(1));
            vis.put(ss,vis.get(ss)+1);
        }
        for (Map.Entry<String, List<String>> entry : M.entrySet()) {
            Collections.sort(entry.getValue());
        }
        ans.add("JFK");
        dfs("JFK");
        return ans;
    }
    private void dfs(String s){
        if(n==cnt) return;
        if(M.get(s)!=null)
        for(int i=0;i<M.get(s).size();i++){
            String ss=s+M.get(s).get(i);
            if(n!=cnt&&vis.get(ss)!=0){
                vis.put(ss,vis.get(ss)-1);
                ans.add(M.get(s).get(i));
                n++;
                dfs(M.get(s).get(i));
                if(n<cnt){
                    n--;
                    ans.remove(ans.size()-1);
                    vis.put(ss,vis.get(ss)+1);
                }
            }
        }
    }
}