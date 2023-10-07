package LeetCode.GasStation;

public class CircleLinkedlist {
    private int pos;
    private int gas;
    private int cost;
    private CircleLinkedlist next;

    public CircleLinkedlist(int pos, int gas, int cost){
        this.pos = pos;
        this.gas = gas;
        this.cost = cost;
        this.next = null;
    }
    public int getPos(){
        return this.pos;
    }
    public int getGas(){
        return this.gas;
    }
    public int getCost(){
        return this.cost;
    }
    public CircleLinkedlist getNext(){
        return this.next;
    }
    public void setNext(CircleLinkedlist c){
        this.next = c;
    }
}
