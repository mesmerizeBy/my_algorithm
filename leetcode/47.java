class Solution {
    List<List<Integer>> ans=new LinkedList<List<Integer>>();
    int[] vis;
    public List<List<Integer>> permuteUnique(int[] nums) {
        // ans.add(new LinkedList(Arrays.stream( nums ).boxed().collect(Collectors.toList())));
        vis=new int[nums.length];
        List<Integer> L=new LinkedList<Integer>();
        //保证相同元素相邻
        Arrays.sort(nums);
        dfs(nums,0,L);
        return ans;
    }
    private void dfs(int[] nums,int cur,List<Integer> L){
        if(cur==nums.length){
            ans.add(new LinkedList<Integer>(L));
            return;
        }
        for(int i=0;i<nums.length;++i){
            //如果前面有相同元素还没被访问则不采取这种选取，因为会重复
            if(vis[i]!=0||(i>0&&nums[i]==nums[i-1]&&vis[i-1]==0))
                continue;
            vis[i]=1;
            L.add(nums[i]);
            dfs(nums,cur+1,L);
            L.remove(L.size()-1);
            vis[i]=0;
        }
    }
    private void swap(int[] nums,int i,int j){
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
        //注意，同一位置不能用这种方法
        // nums[i]=nums[i]-nums[j];
        // nums[j]=nums[j]+nums[i];
        // nums[i]=nums[j]-nums[i];
    }
}