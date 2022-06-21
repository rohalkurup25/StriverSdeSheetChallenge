class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList();
        List<String> list = new ArrayList();
        solve(ans,list,s,0);
        return ans;
    }
    
    
    public void solve(List<List<String>> ans ,List<String> list,String s,int index)
    {
        if(index ==s.length())
        {
            ans.add(new ArrayList(list));
            return;
        }
        
        
        for(int i=index;i<s.length();i++)
        {
            String sub = s.substring(index,i+1);
            if(isPossible(sub))
            {
                list.add(sub);
                solve(ans,list,s,i+1);
                list.remove(list.size()-1);
            }
        }
    }
    
    public boolean isPossible(String s)
    {
        int i=0;
        int j = s.length()-1;
        while(i<j)
        {
            if(s.charAt(i)!=s.charAt(j))
                return false;
            i++;
            j--;
        }
        
        return true;
    }
}