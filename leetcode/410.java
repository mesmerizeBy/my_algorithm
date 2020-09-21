class Solution {
    public boolean check(int[] arr,int x,int n){
        int cnt=1,sum=0;
        for(int i=0;i<arr.length;++i){
            if(sum+arr[i]>x){
                sum=arr[i];
                cnt++;
            }else{
                sum+=arr[i];
            }
        }
        return cnt<=n;
    }
    public int splitArray(int[] nums, int m) {
        int l=nums[0],r=0;
        for(int i=0;i<nums.length;++i){
            if(l<nums[i])
                l=nums[i];
            r+=nums[i];
        }
        int mid=0;
        while(l<r){
            mid=(r-l)/2+l;
            if(check(nums,mid,m)){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        return l;
    }
}