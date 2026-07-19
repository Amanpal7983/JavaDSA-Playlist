package stacks;
import java.util.Stack;
public class ReverseString {
    static String reverse(String s){
        Stack<Character> st = new Stack<>();
        int idx = 0;
       
        while(idx<s.length()){
             st.push(s.charAt(idx));
             idx++;
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            char ch = st.pop();
            sb.append(ch);
        }
        
        return sb.toString();
    } 
        
    
    public static void main(String[] args) {
        String s = "hello";
        String ans = reverse(s);
        System.out.println(ans);
    }
}
