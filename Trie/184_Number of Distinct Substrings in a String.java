 class Node
    {
        Node child[] = new Node[26];
        boolean end;
        Node()
        {
            
        }
        
        Node get(char ch)
        {
            return child[ch-'a'];
        }
        
        boolean containsKey(char ch)
        {
            return child[ch-'a']!=null;
        }
        
        void setEnd()
        {
            end = true;
        }
        
        boolean getEnd()
        {
            return end;
        }
        
        void put(char ch ,Node node)
        {
            child[ch-'a'] = node;
        }
    }



public class Solution {
   
    public static int distinctSubstring(String word) {
        Node root = new Node();
        int count = 0;
        for(int i=0;i<word.length();i++)
        {
            Node node = root;
            for(int j=i;j<word.length();j++)
            {
                char ch = word.charAt(j);
                if(!node.containsKey(ch))
                {
                    Node node1 = new Node();
                    node.put(ch,node1);
                    count++;
                }
                node = node.get(ch);
            }
        }
        return count;
    }
}