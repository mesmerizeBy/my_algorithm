class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1) return s;
        String[] ss=new String[numRows];
        for(int i=0;i<numRows;++i){
            ss[i]="";
        }
        int cur=0;
        int symbol=1;
        for(int i=0;i<s.length();++i){
            ss[cur]+=s.substring(i,i+1);
            cur+=symbol;
            if(cur==0||cur==numRows-1)
                symbol=-symbol;
        }
        String ans="";
        for(int i=0;i<numRows;++i){
            ans+=ss[i];
        }
        return ans;
    }
}