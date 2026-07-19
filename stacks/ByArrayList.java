package stacks;

import java.util.ArrayList;

  class Stack{
     ArrayList<Integer> list = new ArrayList<>();

     Boolean isEmpty(){
        return  list.isEmpty();
    }

     void push(int data){
        list.add(data);
    }

     int pop(){
        int top = list.remove(list.size()-1);
        
        return top;
    }

     int peek(){
        int top = list.get(list.size()-1);
        return top;
    }

}
public class ByArrayList {
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(10);
        s.push(20);
        s.push(30);
        

        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
        System.out.println(s.isEmpty());
    }
}
