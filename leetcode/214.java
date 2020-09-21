class Solution {
    public String shortestPalindrome(String s) {
        int base=131,mod=(int)1e9+7,n=s.length();
        int max=-1;
        int so=0,sr=0,mul=1;
        for(int i=0;i<n;++i){
            so=(int)(((long)so*base+s.charAt(i)) % mod);
            sr=(int)((sr+s.charAt(i)*(long)mul) % mod);
            if(so==sr){
                max=i;
            }
            mul=(int)((long)mul*base%mod);
        }
        String add = (max == n - 1 ? "" : s.substring(max + 1));
        StringBuffer ans = new StringBuffer(add).reverse();
        return ans.append(s).toString();
    }
}