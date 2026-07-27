package trees;

import java.util.ArrayList;

public class LowestCommonAncestor {

    static Boolean path(Node root, int n, ArrayList<Node> path) {
        if (root == null) {
            return false;
        }

        path.add(root);
        if(root.data == n){
          return true;
        }

        Boolean left = path(root.left, n, path);
        Boolean right = path(root.right, n, path);

        if (left || right) {
            return true;
        }

        path.remove(path.size()-1);
        return false;

    }

    static Node lca(Node root, int n1, int n2) {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        path(root, n1, path1);
        path(root, n2, path2);

        int i = 0;
        for (; i < path1.size() && i < path2.size();i++) {
            if (path1.get(i) != path2.get(i))
            break;
        }
        Node lcaNode = path1.get(i - 1);
        return lcaNode;
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

        int n1 = 4;
        int n2 = 7;

        System.out.println(lca(root, n1, n2).data);
    }
}
