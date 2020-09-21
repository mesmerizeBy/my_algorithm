class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int n=arr.length;
        int[] sum=new int[n+5];
        int x=0;
        for(int i=0;i<n;++i){
            x+=arr[i];
            sum[i+1]=x;
        }
        int ans=0;
        for(int i=0;i<n;++i){
            for(int j=1;j<=n;j+=2){
                if(i+j<=n){
                    ans+=sum[i+j]-sum[i];
                }
            }
        }
        return ans;
    }
}