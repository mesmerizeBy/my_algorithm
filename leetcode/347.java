class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> M=new HashMap<Integer,Integer>();
        for(int i : nums){
            M.put(i,M.getOrDefault(i,0)+1);
        }
        List<int[]> L=new ArrayList<int[]>();
        for(Map.Entry<Integer, Integer> entry : M.entrySet()){
            L.add(new int[]{entry.getKey(),entry.getValue()});
        }
        int[] ans=new int[k];
        qsort(L,0,L.size()-1,k);
        for(int i=0;i<k;++i){
            ans[i]=L.get(i)[0];
        }
        return ans;
    }
    private void qsort(List<int[]> L,int low,int high,int k){
        if(low>high){
            return;
        }
        int p=partition(L,low,high);
        if(p==k) return;
        qsort(L,low,p-1,k);
        qsort(L,p+1,high,k);
    }
    private int partition(List<int[]> L,int low,int high){
        int x=high;
        int i=low-1;
        for (int j = low; j < high; ++j){
            if(L.get(j)[1]>L.get(x)[1]){
                i++;
                Collections.swap(L,i,j);
            }
        }
        Collections.swap(L,i+1,x);
        return i+1;
    }
}