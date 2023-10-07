package LeetCode.GasStation;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        CircleLinkedlist cl = new CircleLinkedlist(0, gas[0], cost[0]);
        makeCircle(cl, gas, cost);
        Queue <CircleLinkedlist> q = new LinkedList<>();
        if (cl.getGas() - cl.getCost() >= 0){
            CircleLinkedlist c = cl;
            q.offer(c);
        }
        CircleLinkedlist cl1 = cl.getNext();
        while (cl1 != cl){
            if (cl1.getGas() - cl1.getCost() > 0){
                CircleLinkedlist c = cl1;
                q.offer(c);
            }
            cl1 = cl1.getNext();
        }
        while(!q.isEmpty()){
            CircleLinkedlist c = q.poll();
            if (check(c) == true) {return c.getPos();}
        }
        return -1;
    }
    public boolean check (CircleLinkedlist cl){
        int d = 0;
        CircleLinkedlist c = cl.getNext();
        d = cl.getGas() - cl.getCost();
        while (c != cl){
            d = d + c.getGas() - c.getCost();
            if (d < 0){return false;}
            c = c.getNext();
        }
        return true;
    }
    public void makeCircle(CircleLinkedlist cl, int[] gas, int[] cost){
        CircleLinkedlist c = cl;
        for (int i=1; i<gas.length; i++){
            c.setNext(new CircleLinkedlist(i, gas[i], cost[i]));
            c = c.getNext();
        }
        c.setNext(cl);
    }
}