class Solution {
    public int maxArea(int[] height) {
        int left=0,right=height.length-1;
        int max=-1;
        while(left<right){
            int x=Math.min(height[right],height[left])*(right-left);
            if(x>max){
                max=x;
            }
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return max;
    }
}