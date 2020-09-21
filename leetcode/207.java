class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<LinkedList<Integer>> m=new ArrayList<LinkedList<Integer>>();
        // m.ensureCapacity(numCourses);
        for(int i=0;i<numCourses;++i){
            LinkedList<Integer> l=new LinkedList<Integer>();
            m.add(l);
        }
        int[] cnt=new int[numCourses];
        for(int i=0;i<prerequisites.length;++i){
            int a=prerequisites[i][0],b=prerequisites[i][1];
            m.get(a).add(b);
            cnt[b]++;
        }
        int count=0;
        Queue<Integer> Q=new LinkedList<Integer>();
        for(int i=0;i<numCourses;++i){
            if(cnt[i]==0){
                Q.offer(i);
                count++;
            }
        }
        while(!Q.isEmpty()){
            int x=Q.poll();
            cnt[x]--;
            for(int i=0;i<m.get(x).size();i++){
                cnt[m.get(x).get(i)]--;
                if(cnt[m.get(x).get(i)]==0){
                    Q.offer(m.get(x).get(i));
                    count++;
                }
            }
        }
        if(count<numCourses)return false;
        return true;
    }
    
}