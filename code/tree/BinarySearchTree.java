package tree;

import utils.TreeNode;

/**
 * @author: hunyiha
 * @create-date: 2024-05-15 0:14
 */
/* 二叉搜索树 */
class BinarySearchTree {
    private TreeNode root;

    /* 构造方法 */
    public BinarySearchTree() {
        // 初始化空树
        root = null;
    }

    /* 获取二叉树根节点 */
    public TreeNode getRoot() {
        return root;
    }

    /* 查找节点 */
    TreeNode search(int num){
        while(root != null){
            if (root.val == num){
                return root;
            } else if (num > root.val) {
                root = root.right;
            }else {
                root = root.left;
            }
        }
        return root;
    }

    /* 插入节点 */
    public void insert(int num) {
        // 若树为空，则初始化根节点
        if (root == null) {
            root = new TreeNode(num);
            return;
        }
        TreeNode cur = root, pre = null;
        // 循环查找，越过叶节点后跳出
        while (cur != null) {
            // 找到重复节点，直接返回
            if (cur.val == num)
                return;
            pre = cur;
            // 插入位置在 cur 的右子树中
            if (cur.val < num)
                cur = cur.right;
                // 插入位置在 cur 的左子树中
            else
                cur = cur.left;
        }
        // 插入节点
        TreeNode node = new TreeNode(num);
        if (pre.val < num)
            pre.right = node;
        else
            pre.left = node;
    }

    /* 删除节点 */
    public void remove(int num) {
        // 若树为空，直接提前返回
        if (root == null)
            return;
        TreeNode cur = root, pre = null;
        // 循环查找，越过叶节点后跳出
        while (cur != null) {
            // 找到待删除节点，跳出循环
            if (cur.val == num)
                break;
            pre = cur;
            // 待删除节点在 cur 的右子树中
            if (cur.val < num)
                cur = cur.right;
                // 待删除节点在 cur 的左子树中
            else
                cur = cur.left;
        }
        // 若无待删除节点，则直接返回
        if (cur == null)
            return;
        // 子节点数量 = 0 or 1
        if (cur.left == null || cur.right == null) {
            // 当子节点数量 = 0 / 1 时， child = null / 该子节点
            TreeNode child = cur.left != null ? cur.left : cur.right;
            // 删除节点 cur
            if (cur != root) {
                if (pre.left == cur)
                    pre.left = child;
                else
                    pre.right = child;
            } else {
                // 若删除节点为根节点，则重新指定根节点
                root = child;
            }
        }
        // 子节点数量 = 2
        else {
            // 获取中序遍历中 cur 的下一个节点
            TreeNode tmp = cur.right;
            while (tmp.left != null) {
                tmp = tmp.left;
            }
            // 递归删除节点 tmp
            remove(tmp.val);
            // 用 tmp 覆盖 cur
            cur.val = tmp.val;
        }
    }
}

class binary_search_tree {
    public static void main(String[] args) {
        /* 初始化二叉搜索树 */
        BinarySearchTree bst = new BinarySearchTree();
        // 请注意，不同的插入顺序会生成不同的二叉树，该序列可以生成一个完美二叉树
        int[] nums = { 8, 4, 12, 2, 6, 10, 14, 1, 3, 5, 7, 9, 11, 13, 15 };
        for (int num : nums) {
            bst.insert(num);
        }

        /* 查找节点 */
        TreeNode node = bst.search(12);
        System.out.println("\n查找到的节点对象为 " + node + "，节点值 = " + node.val);
    }
}


