class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
        Queue<Integer> Q=new LinkedList<Integer>();
        int[] vis=new int[n];
        Q.offer(0);
        vis[0]++;
        n--;
        while(!Q.isEmpty()){
            int x=Q.poll();
            for(Integer i : rooms.get(x)){
                if(vis[i]==0){
                    Q.offer(i);
                    vis[i]++;
                    n--;
                }
                
            }
        }
        return n==0;
    }
}