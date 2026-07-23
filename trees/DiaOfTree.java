package trees;

//this class Info is used for second method only . not applicable for first method
class Info{
    int dia;
    int ht;

    Info(int dia ,int ht){
        this.dia = dia;
        this.ht = ht;
    }
}

public class DiaOfTree {

    // first Method

    static int height(Node root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    static int dia(Node root){
        if(root ==null){
            return 0;
        }

        int leftDia = dia(root.left);
        int leftHeight = height(root.left);

        int rightDia = dia(root.right);
        int rightHeight = height(root.right);

        int selfDia = leftHeight + rightHeight + 1;

        return Math.max(selfDia , Math.max(leftDia,rightDia));
    }

    //This is the second Method
    
    static Info dia2(Node root){
        if(root == null){
            return new Info(0,0);
        }

        Info left = dia2(root.left);
        Info right = dia2(root.right);

        int dia = Math.max(Math.max(left.dia,right.dia),left.ht+right.ht +1);
        int ht = Math.max(left.ht ,right.ht)+1;
        return new Info(dia,ht);
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.right = new Node(5);
        root.left.left.left = new Node(6);
        root.right.right.right = new Node(7);

        System.out.println(dia(root));
        System.out.println(dia2(root).dia);

    }

}
