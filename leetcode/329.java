class Solution {
    int[][] dis;
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length==0) return 0;
        dis=new int[matrix.length][matrix[0].length];
        int ans=0;
        for(int i=0;i<matrix.length;++i){
            for(int j=0;j<matrix[i].length;++j){
                int x=find(i,j,matrix);
                if(x>ans)
                    ans=x;
            }
        }
        return ans;
    }
    public int find(int x,int y,int[][] map){
        if(dis[x][y]!=0){
            return dis[x][y];
        }else{
            int[] dx=new int[]{1,0,-1,0};
            int[] dy=new int[]{0,1,0,-1};
            int max=0;
            for(int i=0;i<dx.length;++i){
                int xx=x+dx[i];
                int yy=y+dy[i];
                if(xx>=0&&xx<map.length&&yy>=0&&yy<map[0].length&&map[xx][yy]>map[x][y]){
                    int ans=find(xx,yy,map);
                    if(ans>max)
                        max=ans;
                }
            }
            return dis[x][y]=max+1;
        }
        
    }
}