package stacks;

import java.util.Stack;

public class NextGreaterElement {

    static int[] next(int[] arr) {
        int n = arr.length;
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() &&  arr[i] >= arr[st.peek()]) {
                st.pop();
            }

            if (st.isEmpty()) {
                nge[i] = -1;
            } else {
                nge[i] = arr[st.peek()];
            }

            st.push(i);
        }

        return nge;
    }

    public static void main(String[] args) {
        int[] arr = {1, 8, 3, 5, 2, 1, 6, 4};

        int[] ans =next(arr);

        for(int ele:ans){
            System.out.println(ele);
        }
    }
}
