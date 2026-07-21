package stacks;
import java.util.Stack;


public class MaxHistogramRectengular {
    static void max(int[] arr){
        int[] nsr = new int[arr.length];
        int[] nsl = new int[arr.length];

        int maxArea = 0;

        Stack<Integer> st = new Stack<>();

        // next smallest right 
        for(int i=arr.length-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nsr[i] =-1;
            }
            else{
                nsr[i] = st.peek();
            }

            st.push(i);
        }

        st = new Stack<>();

        //next smallest left
        for(int i= 0;i<arr.length;i++){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i] ){
                st.pop();
            }
            if(st.isEmpty()){
                nsl[i] = -1;
            }
            else{
                nsl[i] = st.peek();
            }

            st.push(i);
        }

        // now calulate the maximun rectengular area

        for(int i=0;i<arr.length;i++){
            int height = arr[i];
            int width = nsr[i] - nsl[i] - 1;

            int currArea = height * width;
            maxArea = Math.max(currArea, maxArea);
        }

        System.out.println("Max area is: " + maxArea);
        
    }
    public static void main(String[] args) {
        int[] arr = {5,3,6,2,5,40,1};

        max(arr);

    }
}
