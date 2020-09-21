class Solution {
    public int paintingPlan(int n, int k) {
        if(n==1)
        {
            if(k==0||k==1)
                return 1;
            else
                return 0;
        }
        if(k/n==n)return 1;
        
        int[] set=new int[(1<<12)+5];
        int ans=0;
        for(int i=0;i<(1<<n);++i){
            int cnt1=0,t=i;
            while(t>0){
                if((t&1)==1)
                cnt1++;
                t=t>>1;
            }
            for(int j=0;j<(1<<n);++j){
                int cnt2=0,l=j;
                while(l>0){
                    if((l&1)==1)
                    cnt2++;
                    l=l>>1;
                }
                if((cnt1*n+cnt2*(n-cnt1))==k&&set[i*(1<<6)+j]==0){
                    set[i*(1<<6)+j]=1;
                    ans++;
                }
            }
        }
        return ans;
        
    }
}