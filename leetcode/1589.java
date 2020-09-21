class Solution {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int n=nums.length;
        int m=requests.length;
        int[] fix=new int[n+5];
        int mod=(int)(1e9+7);
        for(int i=0;i<m;++i){
            int start=requests[i][0];
            int end=requests[i][1];
            fix[start]+=1;
            fix[end+1]-=1;
        }
        int x=0;
        List<Integer> L=new ArrayList<Integer>();
        for(int i=0;i<n;++i){
            x+=fix[i];
            L.add(x);
        }
        Collections.sort(L,(a,b)->{
            return b-a;
        });
        Arrays.sort(nums);
        int ans=0;
        for(int i=0;i<L.size();++i){
            ans=ans%mod+(L.get(i)*nums[n-1-i])%mod;
        }
        return ans;
        
    }
}