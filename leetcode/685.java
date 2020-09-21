// class Solution {
//     int[] pre=new int[1005];
//     int[] parent=new int[1005];
//     public int[] findRedundantDirectedConnection(int[][] edges) {
//         boolean flag=false;
//         for(int i=0;i<1005;++i){
//             pre[i]=i;
//         }
//         int[] ans=new int[2];
//         for(int i=0;i<edges.length;++i){
//             int x=edges[i][0];
//             int y=edges[i][1];
//             if(parent[y]!=0){
//                 ans[0]=x;
//                 ans[1]=y;
//                 if(flag){
//                     ans[0]=parent[ans[1]];
//                 }
//             }else{
//                 parent[y]=x;
//                 if(find(x)==find(y)){
//                     flag=true;
//                     if(ans[0]!=0){
//                         ans[0]=parent[ans[1]];
//                     }
//                     else{
//                         ans[0]=x;
//                         ans[1]=y;
//                     }
//                 }else{
//                     union(x,y);
//                 }
//             }
//         }
//         return ans;
//     }
//     private int find(int x){
//         int r=x;
//         while(r!=pre[r]){
//             r=pre[r];
//         }
//         int t=x;
//         while(t!=r){
//             t=pre[x];
//             pre[x]=r;
//             x=t;
//         }
//         return r;
//     }
//     private void union(int a,int b){
//         int x=find(a);
//         int y=find(b);
//         if(x!=y){
//             pre[x]=y;
//         }
//     }
// }
class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int nodesCount = edges.length;
        UnionFind uf = new UnionFind(nodesCount + 1);
        int[] parent = new int[nodesCount + 1];
        for (int i = 1; i <= nodesCount; ++i) {
            parent[i] = i;
        }
        int conflict = -1;
        int cycle = -1;
        for (int i = 0; i < nodesCount; ++i) {
            int[] edge = edges[i];
            int node1 = edge[0], node2 = edge[1];
            if (parent[node2] != node2) {
                conflict = i;
            } else {
                parent[node2] = node1;
                if (uf.find(node1) == uf.find(node2)) {
                    cycle = i;
                } else {
                    uf.union(node1, node2);
                }
            }
        }
        if (conflict < 0) {
            int[] redundant = {edges[cycle][0], edges[cycle][1]};
            return redundant;
        } else {
            int[] conflictEdge = edges[conflict];
            if (cycle >= 0) {
                int[] redundant = {parent[conflictEdge[1]], conflictEdge[1]};
                return redundant;
            } else {
                int[] redundant = {conflictEdge[0], conflictEdge[1]};
                return redundant;
            }
        }
    }
}

class UnionFind {
    int[] ancestor;

    public UnionFind(int n) {
        ancestor = new int[n];
        for (int i = 0; i < n; ++i) {
            ancestor[i] = i;
        }
    }

    public void union(int index1, int index2) {
        ancestor[find(index1)] = find(index2);
    }

    public int find(int index) {
        if (ancestor[index] != index) {
            ancestor[index] = find(ancestor[index]);
        }
        return ancestor[index];
    }
}
