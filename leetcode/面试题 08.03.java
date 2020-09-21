class Solution {
    public int findMagicIndex(int[] nums) {
        int ans=0;
        while(ans<nums.length){
            if(nums[ans]>ans){
                ans=nums[ans];
            }else if(nums[ans]<ans){
                ans++;
            }else{
                return ans;
            }
        }
        return -1;
    }
}