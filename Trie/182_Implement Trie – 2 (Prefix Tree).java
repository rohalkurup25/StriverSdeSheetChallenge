public class Trie {
    static class Node
    {
        Node child[] = new Node[26];
        int end=0;
        int count=1;
        
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
        
        void IncEnd()
        {
            end++;
        }
        
        int getEnd()
        {
            return end;
        }
        
        void put(char ch ,Node node)
        {
            child[ch-'a'] = node;
        }
        
        void IncCnt()
        {
            count++;
        }
        
        void DecCnt()
        {
            count--;
        }
        
        void DecEnd()
        {
            end--;
        }
        
        int getCnt()
        {
            return count;
        }
    }
    private static Node root;
    Trie() {
        root = new Node();
        }

    public void insert(String word) {
        Node node = root;
        for(int i=0;i<word.length();i++)
        {
            char ch = word.charAt(i);
            if(!node.containsKey(ch))
            {
                Node node1 = new Node();
                node.put(ch, node1);
                node = node.get(ch);
            }
            else{
            node = node.get(ch);
            node.IncCnt();
            }
        }
        node.IncEnd();
    }

    public int countWordsEqualTo(String word) {
        Node node = root;
        for(int i=0;i<word.length();i++)
        {
            char ch = word.charAt(i);
            if(!node.containsKey(ch))
            {
                return 0;
            }
            node = node.get(ch);
        }
        return node.getEnd();
    }

    public int countWordsStartingWith(String word) {
        Node node = root;
        for(int i=0;i<word.length();i++)
        {
            char ch = word.charAt(i);
            if(!node.containsKey(ch))
            {
                return 0;
            }
            node = node.get(ch);
        }
           return node.getCnt();

    }

    public void erase(String word) {
        Node node = root;
        for(int i=0;i<word.length();i++)
        {
            char ch = word.charAt(i);
            node = node.get(ch);
            node.DecCnt();
        }
        if(node.end>0)
            node.DecEnd();
    }

}