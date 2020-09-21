class Solution {
    List<String> L=new LinkedList<String>();
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0) return L;
        dfs(0,digits,"");
        return L;
    }
    private void dfs(int cur,String dg,String ans){
        if(cur==dg.length()){
            L.add(ans);
            return ;
        }
        if(dg.charAt(cur)=='7'||dg.charAt(cur)=='9'){
            for(int i=0;i<4;i++){
                int v=dg.charAt(cur)-'0'-2;
                if(v>5){
                    v*=3;
                    v++;
                }
                else
                    v*=3;
                ans+=String.valueOf((char)('a'+(v+i)));
                dfs(cur+1,dg,ans);
                ans=ans.substring(0,ans.length()-1);
            }
        }else{
            for(int i=0;i<3;i++){
                int v=dg.charAt(cur)-'0'-2;
                if(v>5){
                    v*=3;
                    v++;
                }
                else
                    v*=3;
                ans+=String.valueOf((char)('a'+(v+i)));
                dfs(cur+1,dg,ans);
                ans=ans.substring(0,ans.length()-1);
            }
        }
    }
}