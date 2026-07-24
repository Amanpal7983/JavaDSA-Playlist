package trees;
// use of hashMaps 
// use of horizontal distance (root ke liye c,left child ki x-1 and right child ki x+1) and root always 0

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

//use of level order traversal


class Information {

    Node node;
    int horizontalDistance;

    Information(Node node, int hd) {
        this.horizontalDistance = hd;
        this.node = node;

    }

}

public class TopViewOfTree {

    static void topView(Node root) {

        Queue<Information> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();

        int min = 0, max = 0;

        q.add(new Information(root, 0));
        q.add(null);

        while (!q.isEmpty()) {
            Information curr = q.remove();
            if (curr == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                if (!map.containsKey(curr.horizontalDistance)) {
                    map.put(curr.horizontalDistance, curr.node);
                }

                if (curr.node.left != null) {
                    q.add(new Information(curr.node.left, curr.horizontalDistance - 1));
                    min = Math.min(min, curr.horizontalDistance - 1);
                }
                if (curr.node.right != null) {
                    q.add(new Information(curr.node.right, curr.horizontalDistance + 1));
                    max = Math.max(max, curr.horizontalDistance + 1);
                }
            }

        }

        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i).data + " ");
        }
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

        topView(root);
    }

}
