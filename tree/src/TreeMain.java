import javax.crypto.interfaces.PBEKey;
import javax.xml.soap.Node;
import java.util.*;

public class TreeMain {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root){
        ArrayList<Integer> res = new ArrayList<>();

        Deque<TreeNode> st = new LinkedList<>();

        st.push(root);
        while (!st.isEmpty()){
            TreeNode node = st.pop();
            res.add(node.val);
            if(node.right != null)  st.push(node.right);
            if(node.left != null)   st.push(node.left);
        }

        return res;

    }

    public  static List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();

        Deque<TreeNode> st = new LinkedList<>();


        TreeNode ptr = root;
        while (ptr != null || !st.isEmpty()){
            if(ptr != null) {
                st.push(ptr);
                ptr = ptr.left;
            }
            else {
                ptr = st.pop();
                res.add(ptr.val);
                ptr = ptr.right;
            }
        }

        return res;
    }

    public List<Integer> postorderTraversal(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<>();
        if(root == null)    return res;
        Deque<TreeNode> st = new LinkedList<>();
        st.push(root);
        while (!st.isEmpty()){
            TreeNode node = st.pop();
            res.add(node.val);
            if(node.left != null)   st.push(node.left);
            if(node.right != null)   st.push(node.right);
        }

        Collections.reverse(res);
        return res;
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> qu = new LinkedList<>();


        return res;
    }

    public TreeNode invertTree(TreeNode root) {
        if(root == null)    return null;
        Deque<TreeNode> st = new LinkedList<>();
        TreeNode node = root;
        st.push(node);
        while (!st.isEmpty()){
            node = st.pop();
            swap(node);
            if(node.right != null)  st.push(node.right);
            if (node.left != null)  st.push(node.left);
        }

        return root;
    }

    public TreeNode swap(TreeNode root){
        TreeNode left = root.right;
        TreeNode right = root.left;
        root.left = left;
        root.right = right;
        return root;
    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null)    return true;
        return check(root.left, root.right);
    }

    public boolean check(TreeNode node1, TreeNode node2){
        if(node1 == null && node2 == null)  return true;
        if(node1 == null && node2 != null || node1 != null && node2 == null)    return false;

        return node1.val == node2.val && check(node1.right, node2.left) && check(node1.left, node2.right);
    }

    public boolean isSymmetric1(TreeNode root) {
        Deque<TreeNode> qu = new LinkedList<>();
        qu.offer(root);
        qu.offer(root);
        while (!qu.isEmpty()){

        }
        return true;
    }


}

