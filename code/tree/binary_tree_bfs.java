package tree;

import utils.TreeNode;

import java.util.*;

/**
 * @author: hunyiha
 * @create-date: 2024-05-14 23:16
 */
public class binary_tree_bfs {

    public static void main(String[] args) {
        // 初始化节点
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        // 构建节点之间的引用（指针）
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;

        List<Integer> integers = levelOrder(n1);
        System.out.println(integers);
    }


    /**
     * 层序遍历
     * @param root
     * @return
     */
    public static List<Integer> levelOrder(TreeNode root){

        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode treeNode = queue.poll();
            list.add(treeNode.val);
            if (treeNode.left != null){
                queue.offer(treeNode.left);
            }
            if (treeNode.right != null){
                queue.offer(treeNode.right);
            }
        }
        return list;
    }

    /**
     * 先序遍历
     * @param root
     * @param list
     */
    public static void preOrder(TreeNode root, List list){
        if (root == null){
            return;
        }
        list.add(root.val);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }


    /**
     * 中序遍历
     * @param root
     * @param list
     */
    public static void inOrder(TreeNode root, List list){
        if (root == null){
            return;
        }
        preOrder(root.left, list);
        list.add(root.val);
        preOrder(root.right, list);
    }

    /**
     * 后序遍历
     * @param root
     * @param list
     */
    public static void postOrder(TreeNode root, List list){
        if (root == null){
            return;
        }
        preOrder(root.left, list);
        preOrder(root.right, list);
        list.add(root.val);
    }
}
