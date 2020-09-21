class Solution {
    private int[][] dd={{0,1},{1,0},{0,-1},{-1,0},{1,1},{-1,1},{1,-1},{-1,-1}};
    private int[][] vis;
    public char[][] updateBoard(char[][] board, int[] click) {
        if(board.length==0) return board;
        if(board[click[0]][click[1]]=='M'){
            board[click[0]][click[1]]='X';
            return board;
        }
        vis=new int[board.length][board[0].length];
        vis[click[0]][click[1]]=1;
        dfs(board,click[0],click[1]);
        return board;
    }
    private void dfs(char[][] board,int x,int y){
        if(board[x][y]=='M'){
            return ;
        }
        int M=0;
        for(int i=0;i<dd.length;i++){
            int xx=x+dd[i][0];
            int yy=y+dd[i][1];
            if(xx>=0&&xx<board.length&&yy>=0&&yy<board[0].length){
                if(board[xx][yy]=='M')
                    M++;
            }
        }
        if(M==0){
            board[x][y]='B';
            for(int i=0;i<dd.length;i++){
                int xx=x+dd[i][0];
                int yy=y+dd[i][1];
                if(xx>=0&&xx<board.length&&yy>=0&&yy<board[0].length&&vis[xx][yy]==0){
                    vis[xx][yy]=1;
                    dfs(board,xx,yy);
                }
            }
        }
        else{
            board[x][y]=(char)('0'+M);
        }
        return ;
    }
}