package LeetCode.QueueUsingStack;

import java.util.*;


public class MyQueue {
    Stack<Integer> st;

    public MyQueue() {
        this.st = new Stack<Integer>();    
    }
    
    public void push(int x) {
        this.st.push(x);
    }
    
    public int pop() {
        Stack <Integer> ts = new Stack<Integer>();
        while (!st.empty()){
            int x = st.peek();
            ts.push(x);
            st.pop();
        }
        int ans = ts.peek();
        ts.pop();
        while (!ts.empty()){
            int y = ts.peek();
            st.push(y);
            ts.pop();
        }
        return ans;
    }
    
    public int peek() {
        Stack <Integer> ts = new Stack<Integer>();
        while (!st.empty()){
            int x = st.peek();
            ts.push(x);
            st.pop();
        }
        int ans = ts.peek();
        while (!ts.empty()){
            int y = ts.peek();
            st.push(y);
            ts.pop();
        }
        return ans;
    }
    
    public boolean empty() {
        if (st.empty()){return true;}
        return false;
    }
}