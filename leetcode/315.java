class Solution {
    private int[] c;
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> v = new ArrayList<Integer>();
        List<Integer> resultList = new ArrayList<Integer>();
        c = new int[nums.length+5];
        Arrays.fill(c, 0);
        for(int i=0;i<nums.length;i++){
            if (!v.contains(nums[i])) {
        		v.add(nums[i]);
        	}
        }
        // int[] m=new int[nums.length];
        Collections.sort(v);
        int[]m=new int[v.size()];
        for(int i=0;i<v.size();i++){
            m[i]=v.get(i);
        }
        
        for(int i=nums.length-1;i>=0;i--){
            int id = Arrays.binarySearch(m, nums[i]) + 1;
            resultList.add(getsum(id - 1));
            update(id,1);
        }
        Collections.reverse(resultList);
        return resultList;
    }
    public int lowbit(int x){
        return x&(-x);
    }
    //在i的位置加上k
    public void update(int i,int k){
        while(i < c.length){
            c[i] += k;
            i += lowbit(i);
        }
    }
    //获取从1到i的和
    public int getsum(int i){
        int res = 0;
        while(i > 0){
            res += c[i];
            i -= lowbit(i);
        }
        return res;
    }

}