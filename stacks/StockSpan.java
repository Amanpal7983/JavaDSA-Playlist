package stacks;
import java.util.Stack;

public class StockSpan {
    static void stockSpan(int[] stock , int[] span){
        Stack<Integer> st = new Stack<>();
        span[0] = 1;
        st.push(0);
        for(int i=1;i<stock.length;i++){
            int curr = stock[i];
            while(!st.isEmpty() && curr>stock[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                span[i] = i+1;
            }
            else{
                int prevhigh = st.peek();
                span[i] = i-prevhigh;
            }
            st.push(i);
        }
    }
    public static void main(String[] args) {
        int[] stock = {100,80,90,100,60,75,100};
        int[] span = new int[stock.length];

        stockSpan(stock,span);

        for(int ele:span){
            System.out.println(ele);
        }
    }
}
