package trees;

public class SumOfNodes {

    static int sum(Node root){
        if(root==null){
            return 0;
        }
        
        int leftSum = sum(root.left);
        int rightsum = sum(root.right);

        int treeSum =  leftSum + rightsum + root.data;
        return treeSum;
    }
    public static void main(String[] args) {
        
        Node root = new Node(1);
        root.left = new Node(2);                                 
        root.right= new Node(3);
        root.left.left = new Node(4);
        root.right.right = new Node(5);
        root.left.left.left = new Node(6);
        root.right.right.right = new Node(7);

        System.out.println(sum(root));
    }
}
