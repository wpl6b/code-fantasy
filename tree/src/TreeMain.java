
import java.lang.annotation.Target;
import java.util.*;

public class TreeMain {


    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();

        Deque<TreeNode> st = new LinkedList<>();

        st.push(root);
        while (!st.isEmpty()) {
            TreeNode node = st.pop();
            res.add(node.val);
            if (node.right != null) st.push(node.right);
            if (node.left != null) st.push(node.left);
        }

        return res;

    }

    public List<Integer> preorderTraversal1(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();

        Deque<TreeNode> st = new LinkedList<>();
        TreeNode ptr = root;

        while (ptr != null || !st.isEmpty()) {
            if (ptr != null) {
                res.add(ptr.val);
                st.push(ptr);
                ptr = ptr.left;
            } else {
                ptr = st.pop();
                ptr = ptr.right;
            }
        }

        return res;
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();

        Deque<TreeNode> st = new LinkedList<>();


        TreeNode ptr = root;
        while (ptr != null || !st.isEmpty()) {
            if (ptr != null) {
                st.push(ptr);
                ptr = ptr.left;
            } else {
                ptr = st.pop();
                res.add(ptr.val);
                ptr = ptr.right;
            }
        }

        return res;
    }

    public List<Integer> postorderTraversal1(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> st = new LinkedList<>();
        TreeNode ptr = root;
        TreeNode pre = null;

        while (ptr != null || !st.isEmpty()) {
            if (ptr != null) {
                st.push(ptr);
                ptr = ptr.left;
            } else {
                ptr = st.pop();

                if (ptr.right != null && ptr.right != pre) {
                    st.push(ptr);
                    ptr = ptr.right;
                } else {
                    res.add(ptr.val);
                    pre = ptr;
                    ptr = null;
                }
            }
        }

        return res;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> st = new LinkedList<>();
        st.push(root);
        while (!st.isEmpty()) {
            TreeNode node = st.pop();
            res.add(node.val);
            if (node.left != null) st.push(node.left);
            if (node.right != null) st.push(node.right);
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
        if (root == null) return null;
        Deque<TreeNode> st = new LinkedList<>();
        TreeNode node = root;
        st.push(node);
        while (!st.isEmpty()) {
            node = st.pop();
            swap(node);
            if (node.right != null) st.push(node.right);
            if (node.left != null) st.push(node.left);
        }

        return root;
    }

    public TreeNode swap(TreeNode root) {
        TreeNode left = root.right;
        TreeNode right = root.left;
        root.left = left;
        root.right = right;
        return root;
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return check(root.left, root.right);
    }

    public boolean check(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null && node2 != null || node1 != null && node2 == null) return false;

        return node1.val == node2.val && check(node1.right, node2.left) && check(node1.left, node2.right);
    }

    public boolean isSymmetric1(TreeNode root) {
        Deque<TreeNode> qu = new LinkedList<>();
        qu.offer(root);
        qu.offer(root);
        while (!qu.isEmpty()) {
            TreeNode node1 = qu.poll();
            TreeNode node2 = qu.poll();
            if (node1 == null && node2 == null) continue;
            if (node1 == null || node2 == null) return false;
            if (node1.val != node2.val) return false;

            qu.offer(node1.left);
            qu.offer(node2.right);
            qu.offer(node1.right);
            qu.offer(node2.left);
        }

        return true;
    }

    public int maxDepth(TreeNode root) {
        LinkedList<TreeNode> qu = new LinkedList<>();
        int depth = 0;
        if (root == null) return depth;

        qu.offer(root);
        while (!qu.isEmpty()) {
            int size = qu.size();
            while (size > 0) {
                TreeNode node = qu.poll();
                if (node.left != null) qu.offer(node.left);
                if (node.right != null) qu.offer(node.right);
                size--;
            }
            depth++;
        }

        return depth;
    }

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (left == 0 && right == 0) return 1;
        if (left != 0 && right != 0) return Math.min(left, right) + 1;
        return left + right + 1;

    }


    public int minDepth1(TreeNode root) {
        LinkedList<TreeNode> qu = new LinkedList<>();
        int depth = 0;
        if (root == null) return depth;

        qu.offer(root);
        while (!qu.isEmpty()) {
            int size = qu.size();
            while (size > 0) {
                TreeNode node = qu.poll();
                if (node.left == null && node.right == null) return depth + 1;
                if (node.left != null) qu.offer(node.left);
                if (node.right != null) qu.offer(node.right);
                size--;
            }
            depth++;
        }

        return depth;
    }

//    public int countNodes(TreeNode root) {
//        if(root == null)    return 0;
//    }


    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return Math.abs(maxDepth1(root.right) - maxDepth1(root.left)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int maxDepth1(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth1(root.left), maxDepth1(root.right)) + 1;
    }

    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> res = new ArrayList<>();
        LinkedList<TreeNode> st = new LinkedList<>();
        if (root == null) return res;
        TreeNode node = root;
        while (!st.isEmpty() || node != null) {
            if (node != null) {
                st.push(node);
                node = node.left;
            } else {
                node = st.pop();
                res.add(String.valueOf(node.val));
                node = node.right;
            }

        }

        return res;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p != null && q != null) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right) && p.val == q.val;
        }
        return false;
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
//        if(subRoot == null) return true;
//        if(root == null)    return false;
//
//        if( isSameTree(root, subRoot) || isSameTree(root.right, subRoot) || isSameTree(root.left, subRoot)) return true;
//        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);


//        if(isSameTree(root, subRoot))   return true;
//        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);

        if (root == null) return false;

        return isSameTree(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }


    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;

        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) return root.left.val + sumOfLeftLeaves(root.right);
            else return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
        } else {
            return sumOfLeftLeaves(root.right);
        }
    }

    public int findBottomLeftValue(TreeNode root) {
        if (root == null) return 0;
        Deque<TreeNode> qu = new LinkedList<>();
        TreeNode ptr = root;
        qu.offer(ptr);

        int val = 0;
        while (!qu.isEmpty()) {
            int size = qu.size();
            if (qu.peek().left == null && qu.peek().right == null) val = qu.peek().val;
            while (size > 0) {
                ptr = qu.poll();
                if (ptr.left != null) qu.offer(ptr.left);
                if (ptr.right != null) qu.offer(ptr.right);
                size--;
            }

        }

        return val;
    }


    //depth 表示当前节点所在的层   deepest表示最深叶子节点所在的层
    //以前序遍历的方式搜索 可以保证val只记录最深最左的叶子节点，因为遍历到同层次的其他叶子节点时不满足depth > deepest,所以不会被记录
    static int val = 0;
    static int deepest = 0;

    public static int findBottomLeftValue1(TreeNode root) {
        val = root.val;
        dfs(root, 1);
//        dfs(root, 0, -1, 0);
        return val;
    }

    public static void dfs(TreeNode root, int depth) {
        if (root == null) return;

        if (root.left == null && root.right == null && depth > deepest) {
            val = root.val;
            deepest = depth;
        }
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }

    public static void main(String[] args) {
        TreeMain treeMain = new TreeMain();
//        treeMain.buildTree1(new int[]{1,2}, new int[]{1,2});

//        treeMain.constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});

//        Integer[] arr = {3, 1, 2};
//        Arrays.sort(arr, Collections.reverseOrder());
//        List<Integer> list = Arrays.asList(arr);
//        Collections.sort(list, Collections.reverseOrder());
//        list.forEach(System.out::println);

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
//        root.right.left = new TreeNode(2);
        treeMain.findMode1(root);

    }


    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, targetSum, 0);
    }

    public boolean dfs(TreeNode root, int targetSum, int preSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return root.val + preSum == targetSum;

        return dfs(root.left, targetSum, preSum + root.val) || dfs(root.right, targetSum, preSum + root.val);
    }


    ArrayList<List<Integer>> res;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new ArrayList<>();
        dfs(root, 0, targetSum, new ArrayList<Integer>());
        return res;
    }


    public void dfs(TreeNode root, int preSum, int targetSum, List<Integer> path) {
        if (root == null) return;


        path.add(root.val);
        if (root.left == null && root.right == null) {
            if (root.val + preSum == targetSum) {
                res.add(new ArrayList<Integer>(path));
                return;
            }
        }

        if (root.left != null) {
            dfs(root.left, preSum + root.val, targetSum, path);
            path.remove(path.size() - 1);
        }

        if (root.right != null) {
            dfs(root.right, preSum + root.val, targetSum, path);
            path.remove(path.size() - 1);
        }

    }


    HashMap<Integer, Integer> imap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        imap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            imap.put(inorder[i], i);
        }
        return dfsBuild(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode dfsBuild(int[] inorder, int is, int ie, int[] postorder, int ps, int pe) {
        if (is < 0 || ps < 0 || ie >= inorder.length || pe >= postorder.length || is > ie || ps > pe) return null;
        TreeNode root = new TreeNode(postorder[pe]);


        int lis, lie, lps, lpe;
        lis = is;
        lie = imap.get(root.val) - 1;
        lps = ps;
        lpe = ps + lie - lis;   //len = lie - lis + 1
        root.left = dfsBuild(inorder, lis, lie, postorder, lps, lpe);

        int ris, rie, rps, rpe;
        ris = lie + 2;
        rie = ie;
        rps = lpe + 1;
        rpe = pe - 1;
        root.right = dfsBuild(postorder, ris, rie, postorder, rps, rpe);

        return root;
    }


    //    HashMap<Integer, Integer> imap;  提交时需要
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        imap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            imap.put(inorder[i], i);
        }
        return dfsbuild1(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode dfsbuild1(int[] preOrder, int ps, int pe, int[] inOrder, int is, int ie) {
        if (is < 0 || ps < 0 || ie >= inOrder.length || pe >= preOrder.length || is > ie || ps > pe) return null;
        TreeNode root = new TreeNode(preOrder[ps]);

        int lps, lpe, lis, lie;
        lis = is;
        lie = imap.get(root.val) - 1;
        lps = ps + 1;
        lpe = ps + lie - lis + 1;

        root.left = dfsbuild1(preOrder, lps, lpe, inOrder, lis, lie);
        int rps, rpe, ris, rie;
        ris = lie + 2;
        rie = ie;
        rps = lpe + 1;
        rpe = pe;
        root.right = dfsbuild1(preOrder, rps, rpe, inOrder, ris, rie);

        return root;
    }


    public TreeNode constructMaximumBinaryTree(int[] nums) {

        return dfsBuild(nums, 0, nums.length - 1);
    }

    public TreeNode dfsBuild(int[] nums, int s, int e) {
        if (s > e) return null;
        int maxIndex = s;       //傻吊
        for (int i = s; i < e + 1; i++) {
            maxIndex = nums[i] >= nums[maxIndex] ? i : maxIndex;
        }

        TreeNode root = new TreeNode(nums[maxIndex]);

        root.left = dfsBuild(nums, s, maxIndex - 1);
        root.right = dfsBuild(nums, maxIndex + 1, e);
        return root;
    }


    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return null;
        TreeNode node;
        if (root1 != null && root2 != null) {
            node = new TreeNode(root1.val + root2.val);
            node.left = mergeTrees(root1.left, root2.left);
            node.right = mergeTrees(root1.right, root2.right);
        } else if (root1 == null) {
            node = new TreeNode(root2.val);
            node.left = root2.left;
            node.right = root2.right;
        } else {
            node = new TreeNode(root1.val);
            node.left = root1.left;
            node.right = root1.right;
        }

        return node;

    }


    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        else if (root.val < val) return searchBST(root.right, val);
        else return searchBST(root.left, val);
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        boolean left = isValidBST(root.left);
        boolean right = isValidBST(root.right);

        TreeNode lChildMax = root.left;
        while (lChildMax != null && lChildMax.right != null) lChildMax = lChildMax.right;

        TreeNode rChildMin = root.right;
        while (rChildMin != null && rChildMin.left != null) rChildMin = rChildMin.left;

        if (lChildMax == null && rChildMin == null) return true;
        else if (lChildMax == null) return right && rChildMin.val > root.val;
        else if (rChildMin == null) return left && lChildMax.val < root.val;
        else return left && right && rChildMin.val > root.val && lChildMax.val < root.val;
    }

    long pre = Long.MIN_VALUE; // 记录上一个节点的值，初始值为Long的最小值

    public boolean isValidBST1(TreeNode root) {
        return inorder1(root);
    }

    // 中序遍历
    private boolean inorder1(TreeNode node) {
        if (node == null) return true;
        boolean l = inorder1(node.left);
        if (node.val <= pre) return false;
        pre = node.val;
        boolean r = inorder1(node.right);
        return l && r;
    }


    public int getMinimumDifference(TreeNode root) {
        if (root.left == null && root.right == null) return Integer.MAX_VALUE;

        else if(root.left != null && root.right != null){

            TreeNode leftMax = root.left;
            while (leftMax.right != null) leftMax = leftMax.right;

            TreeNode rightMin = root.right;
            while (rightMin.left != null) rightMin = rightMin.left;

            int left = getMinimumDifference(root.left);
            int right = getMinimumDifference(root.right);
            return Math.min(Math.min(left, right), Math.min(root.val - leftMax.val, rightMin.val - root.val));
        }

        else if(root.left != null){
            TreeNode leftMax = root.left;
            while (leftMax.right != null) leftMax = leftMax.right;
            int left = getMinimumDifference(root.left);
            return Math.min(root.val - leftMax.val, left);
        }

        else {
            int right = getMinimumDifference(root.right);
            TreeNode rightMin = root.right;
            while (rightMin.left != null) rightMin = rightMin.left;
            return Math.min(rightMin.val - root.val, right);
        }


    }

    int min = Integer.MAX_VALUE;
    TreeNode preNode = null;
    public int getMinimumDifference1(TreeNode root) {
        dfs(root);
        return min;
    }

    public void dfs(TreeNode root){
        if(root == null)    return;
        dfs(root.left);
        if(preNode != null) min = Math.min(root.val - preNode.val, min);
        preNode = root;
        dfs(root.right);
    }

    public int getMinimumDifference2(TreeNode root) {
        int min = Integer.MAX_VALUE;
        Deque<TreeNode> st = new LinkedList<>();
        TreeNode ptr = root;
        TreeNode pre = null;
        while (ptr != null|| !st.isEmpty()){
            if(ptr != null){
                st.push(ptr);
                ptr = ptr.left;
            }else {
                ptr = st.pop();
                if(pre != null) min = Math.min(min, ptr.val - pre.val);
                pre = ptr;
                ptr = ptr.right;
            }
        }

        return min;
    }


    HashMap<Integer, Integer>   map = new HashMap<>();
    public int[] findMode(TreeNode root) {
        dfs1(root);
//        List<Set<Map.Entry<Integer, Integer>>> list = Arrays.asList(map.entrySet());
        ArrayList<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());
        entries.sort((entry1, entry2) -> entry2.getValue() - entry1.getValue());

        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < entries.size(); i++) {
            res.add(entries.get(i).getKey());
            if(i+1 < entries.size() && entries.get(i).getValue() != entries.get(i+1).getValue())  break;
        }

        return res.stream().mapToInt(Integer::intValue).toArray();

    }

    public void dfs1(TreeNode root){
        if(root == null)    return;
        dfs1(root.left);
        if(map.containsKey(root.val))   map.put(root.val, map.get(root.val) + 1);
        else map.put(root.val, 1);
        dfs1(root.right);
    }

    ArrayList<Integer> inorder = new ArrayList<Integer>();
    public int[] findMode1(TreeNode root) {
        dfs2(root);
        ArrayList<Integer> res = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < inorder.size(); i++) {
            int cnt = 1;
            int base = inorder.get(i);
            int j = i + 1;
            while (j < inorder.size() && inorder.get(j) == base){
                cnt ++;
                j++;
            }
            if(cnt > max){
                max = cnt;
                res.clear();
                res.add(base);
            }
            else if(cnt == max) res.add(base);

        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public void dfs2(TreeNode root){
        if(root == null)    return;
        dfs2(root.left);
        inorder.add(root.val);
        dfs2(root.right);
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)    return null;
        if(root.val == p.val || root.val == q.val)  return root;
        if(hasNode(root.left, p.val) && hasNode(root.right, q.val) || hasNode(root.left, q.val) && hasNode(root.right, p.val))  return root;
        if(hasNode(root.left, p.val) && hasNode(root.left, q.val))  return lowestCommonAncestor(root.left, p, q);
        if(hasNode(root.right, p.val) && hasNode(root.right, q.val))  return lowestCommonAncestor(root.right, p, q);
        return null;
    }

    public boolean hasNode(TreeNode root, int val){
        if(root == null)    return false;
        if(root.val == val) return true;
        return hasNode(root.left, val) || hasNode(root.right, val);
    }

    TreeNode resNode;
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q){
        dfs(root, p, q);
        return resNode;
    }

    public boolean dfs(TreeNode root, TreeNode p, TreeNode q){
        if(root == null)    return false;
        boolean left = dfs(root.left, p, q);
        boolean right = dfs(root.right, p, q);
        if((root.val == p.val || root.val == q.val) && (left ||  right) || left && right)   resNode = root;
        return left || right || root.val == p.val || root.val == q.val;
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null)    return new TreeNode(val);
        TreeNode pre = null;
        TreeNode ptr = root;
        while (ptr != null){
            pre = ptr;
            if(ptr.val < val){
                ptr = ptr.right;
            }
            else {
                ptr = ptr.left;
            }
        }

        if(pre.val < val)   pre.right = new TreeNode(val);
        else pre.left = new TreeNode(val);

        return root;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)    return null;
        if(root.val < key)  root.right = deleteNode(root.right, key);
        else if(root.val > key)  root.left = deleteNode(root.left, key);
        else {
            if(root.left == null)   return root.right;
            if(root.right == null)  return root.left;

            TreeNode rChildMin = min(root.right);
            rChildMin.right = deleteMin(root.right);        //先动右边！！！！！ 再动左边
            rChildMin.left = root.left;
            root = rChildMin;

//            TreeNode t = root;
//            root = min(root.right);
//            root.right = deleteMin(t.right);
//            root.left = t.left;
        }

        return root;
    }

//    public TreeNode deleteMin(TreeNode root){
//        if(root.left == null)   return root.right;
//        TreeNode node = root;
//        TreeNode pre = node;
//        node = node.left;
//        while (node.left != null){
//            pre = node;
//            node = node.left;
//        }
//        pre.left = node.right;
//
//        return root;
//    }
//
//
//    public TreeNode min(TreeNode root){
//
//        while (root.left != null)   root = root.left;
//        return root;
//    }


    public TreeNode deleteMin(TreeNode node){

        if(node.left == null)   return node.right;
        node.left = deleteMin(node.left);
        return node;
    }


    public TreeNode min(TreeNode root){
        if(root.left != null)   return min(root.left);
        else return root;
    }


//    public TreeNode trimBST(TreeNode root, int low, int high) {
//        dfs1(root, low, high);
//        return root;
//    }
//
//    public void dfs1(TreeNode root, int low, int high){
//        if(root == null)    return;
//        if(root.val > high || root.val < low) deleteNode(root, root.val);
//        dfs1(root.left, low, high);
//        dfs1(root.right, low, high);
//
//    }

//    public TreeNode trimBST(TreeNode root, int low, int high) {
//        if(root == null)    return null;
//
//        root.left = trimBST(root.left, low, high);
//        root.right = trimBST(root.right, low, high);
//        if(root.val < low || root.val > high)   root = deleteHead(root);
//        return root;
//    }
//
//    public TreeNode deleteHead(TreeNode root){
//        if(root.left == null)   return root.right;
//        if(root.right == null)  return root.left;
//
//        TreeNode rChildMin = min(root.right);
//        rChildMin.left = root.left;
//        return root.right;
//    }

    public TreeNode trimBST(TreeNode root, int low, int high) { //其迭代法实现 灰常厉害 再写
        if(root == null)    return null;
        if(root.val < low)  return trimBST(root.right, low, high);
        if(root.val > high) return trimBST(root.left, low, high);
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null)    return null;
        return combineTree(nums, 0, nums.length - 1);
    }

    public TreeNode combineTree(int[] nums, int s, int e){
        if(s > e)   return null;
        int mid = s + e >> 1;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = combineTree(nums, s,mid - 1);
        node.right = combineTree(nums, mid + 1, e);
        return node;
    }

//    public TreeNode convertBST(TreeNode root) {
//        inOrder = new ArrayList<Integer>();
//        dfs3(root);
//        int [] sum = inOrder.stream().mapToInt(Integer::intValue).toArray();
//        for (int i = sum.length - 1; i >= 0; i --) {
//            if(i == sum.length - 1) continue;
//            sum[i] += sum[i+1];
//        }
//        dfs4(root, sum);
//        return root;
//    }
//    ArrayList<Integer>  inOrder;
//    int cnt = 0;
//    public void dfs3(TreeNode root){
//        if(root == null)    return;
//        dfs3(root.left);
//        inOrder.add(root.val);
//        dfs3(root.right);
//    }
//
//    public void dfs4(TreeNode root, int[] sum){
//        if(root == null)    return;
//        dfs4(root.left, sum);
//        root.val = sum[cnt++];
//        dfs4(root.right, sum);
//    }


    public TreeNode convertBST(TreeNode root) {
        if(root == null)    return null;
        dfsConvertBST(root);
        return root;
    }
    int sum = 0;
    public void dfsConvertBST(TreeNode root){
        if(root == null)    return;
        dfsConvertBST(root.right);
        sum += root.val;
        root.val = sum;
        dfsConvertBST(root.left);

    }

}

