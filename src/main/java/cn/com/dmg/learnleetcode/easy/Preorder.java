package cn.com.dmg.learnleetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Preorder
 * @Description 589. N 叉树的前序遍历
 * @author zhum
 * @date 2022/8/8 9:38
 */
public class Preorder {
    public static void main(String[] args) {

    }

    public static List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        preorder(root,list);
        return list;
    }

    public static void preorder(Node root,List<Integer> list) {
        //先将当前节点加入
        list.add(root.val);
        //递归子节点
        if(root.children != null){
            for (Node child : root.children) {
                preorder(child,list);
            }
        }
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
