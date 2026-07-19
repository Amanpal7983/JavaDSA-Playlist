package stacks;
import java.util.Stack;
public class ReverseStack {
    static void PushB(Stack<Integer> s , int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int top = s.pop();
        PushB(s, data);
        s.push(top);
    }

    static void print(Stack<Integer> st){
        while(!st.isEmpty()){
            System.out.println(st.pop());
        }
    }
    
    static void reverse(Stack<Integer> st){
        if(st.isEmpty()){
            return;
        }
        int ele = st.pop();
        reverse(st);
        PushB(st, ele);
    }
    
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);

        reverse(st);
        print(st);
    }
}
