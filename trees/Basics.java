package trees;

class Node{
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data = data;
        this.left=null;
        this.right = null;
    }
}

class BinaryTree{
    static int idx = -1;

     Node bulidTree(int[] arr){
        idx++;
        if(arr[idx] ==-1){
            return null ;
        }

        Node newNode = new Node(arr[idx]);
        newNode.left = bulidTree(arr);
        newNode.right=bulidTree(arr);

        return newNode;
    }
}

public class Basics {

    static void preorder(Node root){
        if(root == null){
            return;
        }

        System.err.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String[] args) {
        int[] arr = { 1,3,4,-1,-1,5,-1,-1,3,-1,9,-1,-1};

        BinaryTree tree  = new BinaryTree();
        Node root = tree.bulidTree(arr);
        System.out.println(root.data);
        preorder(root);
      
    }
}
