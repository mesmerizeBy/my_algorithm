class Solution {
    class TreeNode {
        int idx;
        boolean isend;
        TreeNode[] son;
        TreeNode() {
            idx=-1;
            isend=false;
            son=new TreeNode[26];
        }
    }
    private TreeNode root;
    private TreeNode cur;
    private List<List<Integer>> ans;
    // private LinkedList<Integer> id;
    public List<List<Integer>> palindromePairs(String[] words) {
        ans=new LinkedList<List<Integer>>();
        root = new TreeNode();
        // Map<String,Integer> M=new HashMap<String,Integer>();
        // for(int i=0;i<words.length;++i){
        //     M.put(words[i],i);
        // }
        // Arrays.sort(words,(s1, s2)->{
		// 	return s1.length()-s2.length();
		// });
        for(int i=0;i<words.length;++i){
            if(words[i].equals("")){
                for(int j=0;j<words.length;++j){
                    if(ishuiwen(words[j])){
                        ans.add(new LinkedList<Integer>(Arrays.asList(j,i)));
                        ans.add(new LinkedList<Integer>(Arrays.asList(i,j)));
                    }
                }
                continue;
            }
            insert(words[i],i);
        }
        for(int i=0;i<words.length;++i){
            if(words[i].equals("")) continue;
            String str=(new StringBuffer(words[i])).reverse().toString();
            if(search(str,i)){
                int a=cur.idx;
                if(a!=i)
                ans.add(new LinkedList<Integer>(Arrays.asList(a,i)));
                // ans.add(new LinkedList<Integer>(Arrays.asList(i,a)));
            }
        }
        return ans;
    }
    private void insert(String word,int idx) {
		if (word == null)
			return;
		TreeNode node = root;
		char[] words = word.toCharArray();
		int index = 0;
		for (int i = 0; i < words.length; i++) {
			index = words[i] - 'a';
			if (node.son[index] == null) {
				node.son[index] = new TreeNode();
			}
			node = node.son[index];
		}
		node.isend=true;
        node.idx=idx;
	}
    private boolean search(String word,int id) {
        if (word == null)
            return false;
        TreeNode node = root;
        char[] words = word.toCharArray();
        int index = 0;
        for (int i = 0; i < words.length; i++) {
            index = words[i] - 'a';
            if (node.son[index] == null){
                if(ishuiwen(word.substring(i))&&node.isend){
                    ans.add(new LinkedList<Integer>(Arrays.asList(node.idx,id)));
                }
                return false;
            }
            if(ishuiwen(word.substring(i))&&node.isend){
                ans.add(new LinkedList<Integer>(Arrays.asList(node.idx,id)));
            }
            node = node.son[index];
        }
        cur=node;
        dfs(cur,"",id);
        return node.isend;
    }
    private void dfs(TreeNode node,String s,int id){
        if(node==null) return ;
        if(node.isend){
            if(ishuiwen(s)){
                ans.add(new LinkedList<Integer>(Arrays.asList(node.idx,id)));
            }
        }
        for(int i=0;i<26;++i){
            if(node.son[i]!=null){
                String ss=s+Character.toString((char) ('a'+i));
                dfs(node.son[i],ss,id);
            }
        }
        return;
    }
    private boolean ishuiwen(String s){
        if(s==null||s.equals("")) return false;
        for(int i=0;i<(s.length()>>1);++i){
            if(s.charAt(i)!=s.charAt(s.length()-i-1)){
                return false;
            }
        }
        return true;
    }

}