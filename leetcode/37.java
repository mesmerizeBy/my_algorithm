class Solution {
    List<int[]> L=new LinkedList<int[]>();
    boolean flag=false;
    int[][] row=new int[9][10];
    int[][] col=new int[9][10];
    int[][] block=new int[9][10];
    public void solveSudoku(char[][] board) {
        for(int i=0;i<board.length;++i){
            for(int j=0;j<board[i].length;++j){
                if(board[i][j]!='.'){
                    int x=board[i][j]-'0';
                    col[i][x]=1;
                    row[j][x]=1;
                    block[(i/3)*3+j/3][x]=1;
                }
                else{
                    L.add(new int[]{i,j});
                }
            }
        }
        dfs(board,0);
    }
    private void dfs(char[][] board,int cur){
        if(cur==L.size()){
            flag=true;
            return;
        }
        int x=L.get(cur)[0];
        int y=L.get(cur)[1];
        for(int i=1;i<=9;++i){
            if(col[x][i]==0&&row[y][i]==0&&block[(x/3)*3+y/3][i]==0){
                col[x][i]=1;
                row[y][i]=1;
                block[(x/3)*3+y/3][i]=1;
                board[x][y]=(char)('0'+i);
                dfs(board,cur+1);
                if(!flag){
                    col[x][i]=0;
                    row[y][i]=0;
                    block[(x/3)*3+y/3][i]=0;
                    board[x][y]='.';
                }
            }
        }
    }
}