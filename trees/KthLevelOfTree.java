package trees;

public class KthLevelOfTree {

  static void kLevel(Node root , int level,int k){
    if(root ==null){
      return;
    }

    if(level == k){
      System.out.print(root.data + " ");
      return;
    }

    kLevel(root.left, level+1, k);
    kLevel(root.right, level+1, k);

  }
  public static void main(String[] args) {

//         1
//       /   \
//      2     3
//     / \   / \
//    4  10 20  5
//   / \         \
//  4   7         7

     Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(10);
        root.right.left = new Node(20);
        root.right.right = new Node(5);
        root.left.left.left = new Node(4);
        root.left.left.right = new Node(7);

        root.right.right.right = new Node(7);

        int k = 3;
        kLevel(root, 1, k);
  }
  
}
