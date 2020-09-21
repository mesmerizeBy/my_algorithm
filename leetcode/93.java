class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> L=new LinkedList<String>();
        dfs(L,s,0);
        return L;
    }
    private void dfs(List<String> L,String s,int c){
        int index=s.lastIndexOf(".");
        if(c==3){
            if(s.length()-index-1>3)
                return;
            int n=Integer.parseInt(s.substring(index+1));
            if(s.substring(index+1).length()!=(""+n).length()||n>255)
                return;
            if(L.indexOf(s)==-1)
            L.add(s);
            return;
        }
        for(int i=2;i<=4;++i){
            if(index+i>=s.length())
                return;
            int n=Integer.parseInt(s.substring(index+1,index+i));
            if(n>255||s.substring(index+1,index+i).length()!=(""+n).length())
                return;
            String ss=(new StringBuffer(s)).insert(index+i,".").toString();
            dfs(L,ss,c+1);
        }
    }
}