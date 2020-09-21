class Solution {
    ;
    int[][] dis=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public boolean exist(char[][] board, String word) {
        if(board.length==0) return false;
        int[][] vis=new int[board.length][board[0].length];
        for(int i=0;i<board.length;++i){
            for(int j=0;j<board[0].length;++j){
                vis[i][j]=1;
                if(dfs(board,i,j,word,vis)){
                    return true;
                }
                vis[i][j]=0;
            }
        }
        return false;
    }
    private boolean dfs(char[][] board,int x,int y,String word,int[][] vis){
        if(word.length()==0){
            return true;
        }
        if(board[x][y]==word.charAt(0)){
            if(word.length()==1) return true;
            for(int i=0;i<dis.length;++i){
                int xx=x+dis[i][0];
                int yy=y+dis[i][1];
                if(xx<0||xx>=board.length||yy<0||yy>=board[0].length||vis[xx][yy]==1)
                    continue;
                vis[xx][yy]=1;
                if(dfs(board,xx,yy,word.substring(1),vis)){
                    return true;
                }
                vis[xx][yy]=0;
            }
        }
        return false;
    }
}