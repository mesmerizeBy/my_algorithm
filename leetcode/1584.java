class Solution {
    int[] pre;
    public int minCostConnectPoints(int[][] points) {
        int ans=0;
        if(points.length==1) return ans;
        PriorityQueue<int[]> pq=new PriorityQueue<int[]>((e1,e2)->{
                return e1[1] - e2[1];
        });
        Set<Integer> vis=new HashSet<Integer>();
        pq.add(new int[2]);
        while(vis.size()<points.length){
            int[] head=pq.poll();
            if(!vis.contains(head[0])){
                vis.add(head[0]);
                ans+=head[1];
                for(int i=0;i<points.length;++i){
                    if(!vis.contains(i)){
                        pq.add(new int[]{i,Math.abs(points[i][0]-points[head[0]][0])+Math.abs(points[i][1]-points[head[0]][1])});
                    }
                }
            }
        }
        return ans;
    }
}