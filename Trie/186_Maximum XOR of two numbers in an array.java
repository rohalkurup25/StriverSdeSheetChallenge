class Node
{
    Node child[] = new Node[2];
    Node()
    {    
    }
    
    Node get(int num)
    {
        return child[num];
    }
    
    boolean contains(int num)
    {
        return child[num]!=null;
    }
    
    void put(int num, Node node)
    {
        child[num] = node;
    }
}

class Trie
{
    Node root = new Node();
    Trie(){
        
    }
    
    public void insert(int num)
    {
        Node node = root;
        for(int i=31;i>=0;i--)
        {
            int bit = (num>>i)&1;
            if(!node.contains(bit))
            {
                Node node1 = new Node();
                node.put(bit,node1);
            }
            node = node.get(bit);
        }
    }
    
    public int getMaxXor(int num)
    {
        int ans = 0;
        Node node =root;
         for(int i=31;i>=0;i--)
        {
            int bit = (num>>i)&1;
            int negBit = bit==1?0:1;
            if(node.contains(negBit))
            {
                ans = (ans | (1<<i));
                node = node.get(negBit);
            }
            else
                node = node.get(bit);
        }  
        return ans;
    }
}

public class Solution {

    public static int maximumXor(int[] A) {
        Trie trie = new Trie();
        for(int element : A)
            trie.insert(element);
        int max = 0;
        for(int element : A)
        {
            max = Math.max(max,trie.getMaxXor(element));
        }
        return max;
    }
    

}