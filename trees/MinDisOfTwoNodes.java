package trees;

import java.util.ArrayList;

public class MinDisOfTwoNodes {

    static int MinDist(Node root, int n1, int n2) {
        Node lcaNd = lca(root, n1, n2);
        int dist1 = distance(lcaNd, n1);
        int dist2 = distance(lcaNd, n2);

        return dist1 + dist2;
    }

    static int distance(Node root, int n) {
        if (root == null) {
            return -1;
        }

        if (root.data == n) {
            return 0;
        }

        int leftDist = distance(root.left, n);
        int rightDist = distance(root.right, n);

        if (leftDist == -1 && rightDist == -1) {
            return -1;
        } else if (leftDist == -1) {
            return rightDist + 1;
        } else {
            return leftDist + 1;
        }
    }

    static Node lca(Node root, int n1, int n2) {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        path(root, n1, path1);
        path(root, n2, path2);

        int i = 0;
        for (; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i) != path2.get(i)) {
                break;
            }
        }
        Node lcaNode = path1.get(i - 1);
        return lcaNode;
    }

    static Boolean path(Node root, int n, ArrayList<Node> path) {
        if (root == null) {
            return false;
        }

        path.add(root);
        if (root.data == n) {
            return true;
        }

        Boolean left = path(root.left, n, path);
        Boolean right = path(root.right, n, path);

        if (left || right) {
            return true;
        }

        path.remove(path.size() - 1);
        return false;

    }

    public static void main(String[] args) {
        //  1
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

        int n1 = 2;
        int n2 = 20;

        System.out.println(MinDist(root, n1, n2));
    }
}
