package trees;

import java.util.LinkedList;
import java.util.Queue;


class Node {

    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BinaryTree {

    static int idx = -1;

    Node bulidTree(int[] arr) {
        idx++;
        if (arr[idx] == -1) {
            return null;
        }

        Node newNode = new Node(arr[idx]);
        newNode.left = bulidTree(arr);
        newNode.right = bulidTree(arr);

        return newNode;
    }
}

public class Basics {

    //preorder traversal
    static void preorder(Node root) {
        if (root == null) {
            return;
        }

        System.err.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    //inorder travesal
    static void inorder(Node root) {
        if (root == null) {
            return;
        }

        preorder(root.left);
        System.err.print(root.data + " ");
        preorder(root.right);
    }
// postorder traversal

    static void postorder(Node root) {
        if (root == null) {
            return;
        }

        preorder(root.left);

        preorder(root.right);
        System.err.print(root.data + " ");
    }
//level order traversal

static void levelorder(Node root) {
    if(root == null){
        return;
    }

    Queue<Node> q = new LinkedList<>();
    q.add(root);
    q.add(null);
    
    while(!q.isEmpty()){
        Node currNode = q.remove();
        if(currNode == null){
            System.out.println();
            if(q.isEmpty()){
                break;
            }
            else{
                q.add(null);
            }
        }
        else{
            System.out.print(currNode.data +" ");
            if(currNode.left != null){
                q.add(currNode.left);
            }
            if(currNode.right != null){
                q.add(currNode.right);
            }
        }
    }
    
}
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, -1, -1, 5, -1, -1, 3, -1, 9, -1, -1};

        BinaryTree tree = new BinaryTree();
        Node root = tree.bulidTree(arr);
        System.out.println(root.data);
        preorder(root);
        inorder(root);
        postorder(root);
        System.out.println("");
        levelorder(root);

    }
}
