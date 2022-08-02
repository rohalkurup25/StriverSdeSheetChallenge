import java.util.*;
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
    public static ArrayList<Integer> maxXorQueries(ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> queries) {
        ArrayList<Integer> ans = new ArrayList();
        int q = queries.size();
        for(int i=0;i<q;i++)
            ans.add(-1);
        ArrayList<ArrayList<Integer>> oq = new ArrayList();

        for(int i=0;i<q;i++)
        {
            ArrayList<Integer> temp = new ArrayList();
            temp.add(queries.get(i).get(0));
            temp.add(queries.get(i).get(1));
            temp.add(i);
            oq.add(temp);
        }
        Collections.sort(oq, (ArrayList<Integer> l1,ArrayList<Integer> l2)->l1.get(1)-l2.get(1));
        Collections.sort(arr);
        Trie trie = new Trie();
        int ind = 0;
        int n = arr.size();
        for(ArrayList<Integer> query : oq){
            while(ind<n &&  query.get(1)>=arr.get(ind)){
                trie.insert(arr.get(ind));
                ind++;
            }
       //     System.out.println("index "+ind);
            int qIndex = query.get(2);
            if(ind!=0)
            ans.set(qIndex,trie.getMaxXor(query.get(0)));
            }           
return ans;
}
}