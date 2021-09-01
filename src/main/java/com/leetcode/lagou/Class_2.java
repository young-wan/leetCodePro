package com.leetcode.lagou;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author young
 * @Date 2021/6/16 10:01
 * @Desc
 **/
class TreeNode {
    // 树结点中的元素值
    int val = 0;
    // 二叉树结点的左子结点
    TreeNode left = null;
    // 二叉树结点的右子结点
    TreeNode right = null;

    TreeNode(int x) {
        val = x;
    }
}

class Node {
    int val = 0;
    Node left = null;
    Node right = null;
    Node next = null;
}

class XNode {
    public int val;
    public List<XNode> children;

    public XNode() {
    }

    public XNode(int _val) {
        val = _val;
    }

    public XNode(int _val, List<XNode> _children) {
        val = _val;
        children = _children;
    }
}

public class Class_2 {

    public static void main(String[] args) {

    }


    /**
     * 从上到下按层打印二叉树，同一层结点按从左到右的顺序打印，每一层打印到一行
     */
    static List<List<Integer>> levelOrderByQueue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        List<List<Integer>> ans = new LinkedList<>();
        while (queue.size() > 0) {
            int size = queue.size();
            List<Integer> temp = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                temp.add(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            ans.add(temp);
        }
        return ans;
    }

    static List<List<Integer>> levelOrderByList(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        List<TreeNode> curLevel = new LinkedList<>();
        if (root != null) {
            curLevel.add(root);
        }
        while (curLevel.size() > 0) {
            List<Integer> temp = new LinkedList<>();
            List<TreeNode> nextLevel = new LinkedList<>();
            for (int i = 0; i < curLevel.size(); i++) {
                TreeNode cur = curLevel.get(i);
                temp.add(cur.val);
                if (cur.left != null) {
                    nextLevel.add(cur.left);
                }
                if (cur.right != null) {
                    nextLevel.add(cur.right);
                }
            }
            curLevel = nextLevel;
            ans.add(temp);
        }
        return ans;
    }

    /**
     * 求二叉树每一层的平均值
     *
     * @param root
     * @return
     */
    static List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (queue.size() > 0) {
            int size = queue.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                sum += cur.val;
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            ans.add(sum / size);
        }
        return ans;
    }

    /**
     * N叉树的层次遍历
     * <p>
     * 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
     * <p>
     * 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
     * 示例 1：
     * 输入：root = [1,null,3,2,4,null,5,6]
     * 输出：[[1],[3,2,4],[5,6]]
     * <p>
     * 示例 2：
     * 输入：root =
     * [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
     * 输出：[[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
     */
    static List<List<Integer>> xLevelOrder(XNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        Queue<XNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (queue.size() > 0) {
            List<Integer> temp = new LinkedList<>();
            final int size = queue.size();
            for (int i = 0; i < size; i++) {
                XNode cur = queue.poll();
                temp.add(cur.val);
                for (XNode child : cur.children) {
                    if (child != null) {
                        queue.offer(child);
                    }
                }
            }
            ans.add(temp);
        }
        return ans;
    }

    /**
     * 层数最深叶子节点的和
     * 给你一棵二叉树，请你返回层数最深的叶子节点的和。
     * <p>
     * 示例：
     * 输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
     * 输出：15
     *
     * @return
     */
    static Integer deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        int sum = 0;
        while (queue.size() > 0) {
            sum = 0;
            final int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                sum += cur.val;
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
        return sum;
    }

    /**
     * 给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary
     * tree）结构相同，但一些节点为空。
     * <p>
     * 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
     * <p>
     * 示例 1:
     * <p>
     * <p>
     * 输入:
     * <p>
     * ⁠          1
     * ⁠        /   \
     * ⁠       3     2
     * ⁠      / \     \
     * ⁠     5   3     9
     * <p>
     * 输出: 4
     * 解释: 最大值出现在树的第 3 层，宽度为 4 (5,3,null,9)。
     * <p>
     * <p>
     * 示例 2:
     * <p>
     * <p>
     * 输入:
     * <p>
     * ⁠         1
     * ⁠        /
     * ⁠       3
     * ⁠      / \
     * ⁠     5   3
     * <p>
     * 输出: 2
     * 解释: 最大值出现在树的第 3 层，宽度为 2 (5,3)。
     * <p>
     * <p>
     * 示例 3:
     * <p>
     * <p>
     * 输入:
     * <p>
     * ⁠         1
     * ⁠        / \
     * ⁠       3   2
     * ⁠      /
     * ⁠     5
     * <p>
     * 输出: 2
     * 解释: 最大值出现在树的第 2 层，宽度为 2 (3,2)。
     * <p>
     * <p>
     * 示例 4:
     * <p>
     * <p>
     * 输入:
     * <p>
     * ⁠         1
     * ⁠        / \
     * ⁠       3   2
     * ⁠      /     \
     * ⁠     5       9
     * ⁠    /         \
     * ⁠   6           7
     * 输出: 8
     * 解释: 最大值出现在树的第 4 层，宽度为 8 (6,null,null,null,null,null,null,7)。
     *
     * @param root
     * @return
     */
    static int widthOfBinaryTree(TreeNode root) {
        class Pair {
            private TreeNode node;
            private int id;

            public Pair(TreeNode n, int i) {
                node = n;
                id = i;
            }
        }
        Queue<Pair> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(new Pair(root, 1));
        }
        int ans = 0;
        while (queue.size() > 0) {
            int start = -1, end = -1;
            final int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair cur = queue.poll();
                if (start == -1) {
                    start = cur.id;
                }
                end = cur.id;
                if (cur.node.left != null) {
                    queue.offer(new Pair(cur.node.left, cur.id * 2));
                }
                if (cur.node.right != null) {
                    queue.offer(new Pair(cur.node.right, cur.id * 2 + 1));
                }
            }
            ans = Math.max(ans, end - start + 1);
        }
        return ans;
    }

    /**
     * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
     * <p>
     * 例如：
     * 给定二叉树 [3,9,20,null,null,15,7],
     * <p>
     * <p>
     * ⁠   3
     * ⁠  / \
     * ⁠ 9  20
     * ⁠   /  \
     * ⁠  15   7
     * <p>
     * <p>
     * 返回锯齿形层序遍历如下：
     * <p>
     * <p>
     * [
     * ⁠ [3],
     * ⁠ [20,9],
     * ⁠ [15,7]
     * ]
     *
     * @param root
     * @return
     */
    static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        boolean reverse = false;
        while (queue.size() > 0) {
            List<Integer> temp = new LinkedList<>();
            final int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                temp.add(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
//            List<Integer> finalTemp = new LinkedList<>();
//            finalTemp = temp;
//            if (reverse) {
//                for (int i = temp.size() - 1; i >= 0; i--) {
//                    finalTemp.set(temp.size() -i - 1, temp.get(i));
//                }
//            }
//            ans.add(finalTemp);
            if (reverse) {
                Collections.reverse(temp);
            }
            ans.add(temp);
            reverse = !reverse;
        }
        return ans;
    }
}
