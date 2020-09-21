class Solution {
    int [][]d={{1,0},{0,1},{-1,0},{0,-1}};
    int [][]vis;
    int n,m;
    public void solve(char[][] board) {
        if(board.length!=0){
            n=board.length;
            m=board[0].length;
        }
        vis=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if((i==0||j==0||i==n-1||j==m-1)&&board[i][j]=='O'){
                    vis[i][j]=1;
                    dfs(i,j,board);
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if( vis[i][j]==0&&board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
    }
    private void dfs(int x,int y,char[][] board){
        for(int i=0;i<d.length;i++){
            int xx=x+d[i][0];
            int yy=y+d[i][1];
            if(xx>0&&xx<n&&yy>0&&yy<m&&vis[xx][yy]==0&&board[xx][yy]=='O'){
                vis[xx][yy]=1;
                dfs(xx,yy,board);
            }
        }
    }
}