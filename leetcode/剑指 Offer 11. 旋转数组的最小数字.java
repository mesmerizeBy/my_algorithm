class Solution {
    public int minArray(int[] numbers) {
        int low=0,high=numbers.length-1;
        int ans=0;
        for(int i=low+(high-low)/2;low<high;i=low+(high-low)/2){
            if(numbers[i]>numbers[high]){
                low=i+1;
            }else if(numbers[i]<numbers[high]){
                high=i;
            }else{
                high-=1;
            }
        }
        return numbers[low];
    }
}