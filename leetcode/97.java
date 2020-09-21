class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length())
            return false;
        boolean[] dp=new boolean[s2.length()+5];
        dp[0]=true;
        for(int i=0;i<=s1.length();i++){
            for(int j=0;j<=s2.length();j++){
                int cur=i+j-1;
                if(i>0){
                    dp[j] &= s1.charAt(i-1)==s3.charAt(cur);
                }
                if(j>0){
                    dp[j] |= dp[j-1]&&s2.charAt(j-1)==s3.charAt(cur);
                }
            }
        }
        return dp[s2.length()];
    }
}