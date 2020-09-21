class Solution {
    int[] col;
    public boolean isBipartite(int[][] graph) {
        col=new int[graph.length];
        Arrays.fill(col,0);
        Queue<Integer> Q=new LinkedList<Integer>();
        for(int i=0;i<graph.length;i++){
            Q.offer(i);
            if(col[i]==0)
            col[i]=1;
            while(!Q.isEmpty()){
                int y=Q.poll();
                for(int j=0;j<graph[y].length;j++){
                    int x=graph[y][j];
                    if(col[x]==0){
                        col[x]=-col[y];
                        Q.offer(x);
                    }else{
                        if(col[y] == col[x]){    // 如果颜色冲突说明不是二分图
                            return false;
                        }
                    }
                }
            }
        }
        
        
        return true;
    }
}