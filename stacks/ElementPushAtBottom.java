package stacks;
import java.util.Stack;

public class ElementPushAtBottom {

    static void PushBottom(Stack<Integer> s , int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int top = (int) s.pop();
        PushBottom(s, data);
        s.push(top);


    }
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        PushBottom(s, 50);

        while(!s.isEmpty()){
            int top = s.pop();
            System.out.println(top);
        }


    }
}
