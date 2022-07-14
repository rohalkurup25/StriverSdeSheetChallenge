import java.util.*;
public class Solution {
    public static List<List<Integer>> getTreeTraversal(BinaryTreeNode<Integer> root) {
        // Write your code here.
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> pre = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        
        Stack<BinaryTreeNode<Integer>> st = new Stack<>();
        BinaryTreeNode<Integer> curr = root;
        BinaryTreeNode<Integer> last = root;
        if(root!=null){
            st.push(curr);
        }
        while(!st.isEmpty()){
            curr = st.peek();
            if(last==curr.left){
                // left subtree traversed
                in.add(curr.data);
                if(curr.right!=null){
                    st.push(curr.right);
                }else{
                    st.pop();
                    post.add(curr.data);
                }
            }else if(last==curr.right){
                // right subtree traversed
                post.add(curr.data);
                st.pop();
            }else{
                // both its subtrees are yet to be traversed
                pre.add(curr.data);
                if(curr.left!=null){
                    st.push(curr.left);
                }else{
                    in.add(curr.data);
                    if(curr.right!=null){
                        st.push(curr.right);
                    }else{
                        st.pop();
                        post.add(curr.data);
                    }
                }
            }
            last = curr;
        }
        
        
        ans.add(in);
        ans.add(pre);
        ans.add(post);
        return ans;
    }
}