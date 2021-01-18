package com.hujingli.algorithm.tree;

public class AVLTree {

    public  AVLNode insert(AVLNode node, AVLNode t){
        // 没有头，新建头
        if (t == null) {
            return new AVLNode(null, null, node.data);
        }
        if (node.compareTo(t) < 0) {
            // 如果加入的小于t
            t.left = insert(node, t.left);
            if (height(t.left) - height(t.right) > 1) {
                // 左右子树的高度差2
                // 加左子树 右旋  加右子树 先左后右

            }

        } else {
            t.right = insert(node, t.right);
            if (height(t.right) - height(t.left) > 1) {
                // 右子树高度比左子树大2
                // TODO: 2020/12/22 旋转
            }
        }
        t.height = Math.max(height(t.left), height(t.right)) + 1;
        return t;
    }

    public int height(AVLNode node){
        return node == null ? -1 : node.height;
    }

    /**
     * 右旋
     * @param node 旋转节点
     * @return 新的树
     */
    public AVLNode rightRotate(AVLNode node) {

        AVLNode newNode = node.left;
        // node的左子树的右子树节点比node小  因为node要右旋到左子树的右子树，则原右子树编程node的左子树
        node.left = newNode.right;
        newNode.right = node;

        // 重新计算高度
        node.height = Math.max(height(node.left), height(node.right))+1;
        newNode.height = Math.max(height(newNode.left), height(newNode.right)) + 1;

        return newNode;
    }

    /**
     * 左旋
     * @param node 旋转节点
     * @return 新的树
     */
    public AVLNode leftRotate(AVLNode node) {
        return null;
    }

}

class AVLNode implements Comparable<AVLNode>{
    AVLNode left;
    AVLNode right;
    int data;
    int height;

    public AVLNode(AVLNode left, AVLNode right, int data) {
        this.left = left;
        this.right = right;
        this.data = data;
        height = 0;
    }
    

    @Override
    public int compareTo(AVLNode o) {
        return data - o.data;
    }
}
