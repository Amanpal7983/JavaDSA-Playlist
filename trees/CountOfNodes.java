package trees;
      
    public class CountOfNodes {
        static int count(Node root) {
        if (root == null) {
            return 0;
        }
        int left = count(root.left);
        int right= count(root.right);
        return (left+right+1);
    }


        public static void main(String[] args) {

            Node root = new Node(1);
            root.left = new Node(2);
            root.right = new Node(3);
            root.left.left = new Node(4);
            root.right.right = new Node(5);
            root.left.left.left = new Node(6);
            root.right.right.right = new Node(7);

            System.out.println(count(root));
        }
    }
