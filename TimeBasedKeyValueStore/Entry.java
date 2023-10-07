package LeetCode.TimeBasedKeyValueStore;

public class Entry {
    public static void main(String[] args) {
        TimeMap t = new TimeMap();
        t.set("Love", "High", 10);
        t.set("Love", "Low", 20);
        t.set("Love", "High", 30);
        t.set("Love", "Low", 40);
        t.set("Love", "High", 50);
        System.out.println(t.get("Love", 35));
    }
}
