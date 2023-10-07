package LeetCode.TimeBasedKeyValueStore;


import java.util.HashMap;
import java.util.TreeMap;

public class TimeMap {
    HashMap<String, TreeMap<Integer, String>> x;
    public TimeMap() {
        x = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!x.containsKey(key)){
            x.put(key, new TreeMap<Integer,String>());
        }
        x.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if (x.containsKey(key)){
            TreeMap<Integer, String> t = x.get(key);
            if ( t != null ){
                Integer f = t.floorKey(timestamp);
                if (f != null){
                    return t.get(f);
                }
            }
        }
        return "";
    }
}
