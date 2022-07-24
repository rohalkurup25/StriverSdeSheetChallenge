/***************************************************************************

  Class for graph node is as follows:

  class graphNode {
      public int data;
      public ArrayList<graphNode> neighbours;

      graphNode() {
          data = 0;
          neighbours = new ArrayList<graphNode>();
      }

      graphNode(int val) {
          data = val;
          neighbours = new ArrayList<graphNode>();
      }

      graphNode(int val, ArrayList<graphNode> neighbours) {
          data = val;
          this.neighbours = neighbours;
      }
    }

******************************************************************************/
import java.util.*;
public class Solution {
    public static graphNode cloneGraph(graphNode node) {
        return solve(node,new HashMap());
    }
    
    public static graphNode solve(graphNode root, HashMap<graphNode,graphNode> map)
                                  
    {
        if(root==null)
            return root;
        if(map.containsKey(root))
            return map.get(root);
        graphNode node = new graphNode(root.data);
        for(graphNode child : root.neighbours)
        {
            node.neighbours.add(solve(child,map));
        }
        return node;
    }
}