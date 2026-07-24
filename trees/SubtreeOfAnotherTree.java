package trees;

public class SubtreeOfAnotherTree {

    static Boolean subTree(Node root, Node subRoot) {
        if (root == null) {
            return false;
        }

        if (root.data == subRoot.data) {
            if (isIdentical(root, subRoot)) {
                return true;
            }
        }

        return subTree(root.left, subRoot) || subTree(root.right, subRoot);

    }

    static Boolean isIdentical(Node root, Node subRoot) {
        // identical ki jagah non-identical ko find karna easy rahega 

        if (root == null && subRoot == null) {
            return true;
        } else if (root == null || subRoot == null || root.data != subRoot.data) {
            return false;

        }

        if (!isIdentical(root.left, subRoot.left)) {
            return false;
        }

        if (!isIdentical(root.right, subRoot.right)) {
            return false;
        }

        return true;

    }

    public static void main(String[] args) {
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

        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(10);
        subRoot.left.left = new Node(4);
        subRoot.left.right = new Node(7);

        System.out.println(subTree(root, subRoot));
    }
}
