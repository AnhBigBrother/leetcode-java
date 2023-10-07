import java.util.HashMap;
import java.util.Stack;

public class FreqStack {
    HashMap<Integer, Stack<Integer>> count;
    HashMap<Integer, Integer> Freq;
    int maxFreq;
    public FreqStack() {
        maxFreq = 0;
        count = new HashMap<>();
        Freq = new HashMap<>();
    }
    public void push(int val) {
        int f = Freq.getOrDefault(val, 0)+1;
        Freq.put(val, f);
        if (!count.containsKey(f)){count.put(f, new Stack<Integer>());}
        count.get(f).add(val);
        maxFreq = Math.max(maxFreq, f);
    }
    public int pop() {
        int x = count.get(maxFreq).pop();
        Freq.put(x, maxFreq-1);
        if (count.get(maxFreq).size() == 0){maxFreq--;}
        return x;
    }
}
class run {
    public static void main(String[] args) {
        FreqStack freqStack = new FreqStack();
        freqStack.push(4); // The stack is [5]
        freqStack.push(0); // The stack is [5,7]
        freqStack.push(9); // The stack is [5,7,5]
        freqStack.push(3);
        freqStack.push(4);
        freqStack.push(2);   
        System.out.println(freqStack.pop()); 
        freqStack.push(6); // The stack is [5,7,7]
        System.out.println(freqStack.pop()); 
        freqStack.push(1); // The stack is [5,7,7,4]
        System.out.println(freqStack.pop()); 
        freqStack.push(1); // The stack is [5,7,4,5]
        System.out.println(freqStack.pop()); 
        freqStack.push(4); // The stack is [5,7,4,5]
        System.out.println(freqStack.pop()); 
        System.out.println(freqStack.pop()); 
        System.out.println(freqStack.pop()); 
        System.out.println(freqStack.pop()); 
        System.out.println(freqStack.pop()); 
        System.out.println(freqStack.pop()); 
    }
}