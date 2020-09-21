class Solution {
    public String getPermutation(int n, int k) {
        int[] fac=new int[n];
        int[] vis=new int[n+1];
        fac[0]=1;
        for(int i=1;i<n;++i){
            fac[i]=fac[i-1]*i;
        }
        String ans="";
        k--;
        for(int i=1;i<=n;++i){
            int t=k/fac[n-i];
            k%=fac[n-i];
            int p=1;
            while(vis[p]!=0||t!=0){
                if(vis[p++]==0)t--;
            }
            ans=ans+String.valueOf((char)('0'+p));
            vis[p]=1;
        }
        return ans;
    }
}