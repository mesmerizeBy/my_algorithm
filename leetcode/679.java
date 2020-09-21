class Solution {
    private int[] vis;
    public boolean judgePoint24(int[] nums) {
        vis=new int[nums.length];
        double[] db=new double[nums.length];
        for(int i=0;i<nums.length;++i){
            db[i]=nums[i];
        }
        return dfs(db,0,0);
    }
    private boolean dfs(double[] db,double ans,int n){
        if(n==db.length-1&&Math.abs(24-ans)<0.00001) return true;
        for(int i=0;i<db.length;++i){
            if(vis[i]==0){
                if(db[i]==0)continue;
                vis[i]=1;
                for(int j=0;j<db.length;j++){
                    if(vis[j]==0){
                        double x=db[j];
                        db[j]=x*db[i];
                        if(dfs(db,db[j],n+1))
                            return true;
                        db[j]=x/db[i];
                        if(dfs(db,db[j],n+1))
                            return true;
                        db[j]=x+db[i];
                        if(dfs(db,db[j],n+1))
                            return true;
                        db[j]=x-db[i];
                        if(dfs(db,db[j],n+1))
                            return true;
                        db[j]=x;
                    }
                }
                vis[i]=0;
            }
        }
        return false;
    }
}