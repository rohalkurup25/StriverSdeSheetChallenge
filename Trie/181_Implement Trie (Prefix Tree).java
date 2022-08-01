public class Trie {

    static class Node
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

    private static Node root;
    Trie() {
        root = new Node();
        }


    public static void insert(String word) {
        Node node = root;
        for(int i=0;i<word.length();i++)
        {
            char ch = word.charAt(i);
            if(!node.containsKey(ch))
            {
                Node node1 = new Node();
                node.put(ch, node1);
            }
            node = node.get(ch);
        }
        node.setEnd();
    }


    //Returns if the word is in the trie

    public static boolean search(String word) {
        Node node = root;
        for(int i=0;i<word.length();i++)
        {
            char ch = word.charAt(i);
            if(!node.containsKey(ch))
            {
                return false;
            }
            node = node.get(ch);
        }
        return node.getEnd();
        
    }

    
    //Returns if there is any word in the trie that starts with the given prefix

    public static boolean startsWith(String prefix) {
        Node node = root;
        for(int i=0;i<prefix.length();i++)
        {
            char ch = prefix.charAt(i);
            if(!node.containsKey(ch))
            {
                return false;
            }
            node = node.get(ch);
        }
        return true;
    }
}