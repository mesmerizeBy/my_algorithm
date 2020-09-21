class Solution {
    public int minSubarray(int[] nums, int p) {
        int n=nums.length;
        Map<Integer,Integer> M=new HashMap<Integer,Integer>();
        int[] sum=new int[n+1];
        int x=0;
        for(int i=0;i<n;++i){
            x=x%p+nums[i]%p;
            sum[i+1]=x;
        }
        int mod=x%p;
        if(mod==0)return 0; 
        M.put(0,-1);//表示前缀和为0的，索引为-1
        int ans = nums.length;
        for(int i=0;i<n;++i){
            int curmod=sum[i+1]%p;
            M.put(curmod,i);
            int targetmod = curmod >= mod ? (curmod - mod) : (curmod - mod + p);
            if(M.containsKey(targetmod))
                ans = Math.min(ans, i - M.get(targetmod));
        }
         return ans == nums.length ? -1 : ans;
    }
}