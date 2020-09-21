class Solution {
    public boolean isMagic(int[] target) {
        int cur=0,n=target.length;
        int[] val=new int[n+5];
        int[] next=new int[n+5];
        int head=1;
        int fuck=-1;
        for(int i=1;i<=n;++i){
            val[i]=i;
            next[i]=i+1;
        }
        next[n]=0;
        while(cur<n-1){
            int i=next[head];
            int xh=next[next[next[head]]];
            int t=head;
            // if(cur>2)
            // return true;
            // if(cur>3) return fuck==2;
            if(val[i]==target[cur]){
                cur++;
                if(xh!=0){//偶数位置全放在前面
                    int pre=i;
                    while(i!=0&&t!=0){
                        next[t]=next[next[t]];
                        t=next[t];
                        next[i]=next[next[i]];
                        pre=i;
                        i=next[i];
                    }
                    next[pre]=head;
                    head=xh;
                }else{//只剩<3个数
                    next[head]=next[next[head]];
                }
            }else{
                return false;
            }
            i=head;
            int cnt=0;
            if(fuck==-1){
                while(cur<n&&val[i]==target[cur]){
                    cur++;
                    i=next[i];
                    cnt++;
                }
                head=i;
                fuck=cnt;
            }
            else{
                // return true;
                for(int j=0;j<fuck&&cur<n;++j){
                    if(val[i]!=target[cur++]){
                        return false;
                    }
                    i=next[i];
                }
                head=i;
            }
        }
        return true;
    }
}