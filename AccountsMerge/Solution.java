package AccountsMerge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> merged = Merge(accounts);
        while(!merged.equals(accounts)){
            accounts = merged;
            merged = Merge(accounts);
        }
        return accounts;
    }
    public List<List<String>> Merge(List<List<String>> accounts) {
        HashMap<String, Integer> son = new HashMap<>();
        HashMap<Integer, Set<String>> daddy = new HashMap<>();
        for (int i=0; i<accounts.size(); i++){
            daddy.put(i, new TreeSet<String>());
            int k = -1;
            for (int j=1; j<accounts.get(i).size(); j++){
                String s = accounts.get(i).get(j);
                if (son.containsKey(s)){
                    k = son.get(s);
                    break;
                }
            }
            if (k == -1){
                for (int j=1; j<accounts.get(i).size(); j++){
                    String s = accounts.get(i).get(j);
                    daddy.get(i).add(s);
                    son.put(s, i);
                }
            }
            else {
                for (int j=1; j<accounts.get(i).size(); j++){
                    String s = accounts.get(i).get(j);
                    daddy.get(k).add(s);
                    son.put(s, k);
                }
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for (int i=0; i<accounts.size(); i++){
            if (daddy.get(i).size() != 0){
                List<String> l = new ArrayList<>();
                l.add(accounts.get(i).get(0));
                l.addAll(daddy.get(i));
                ans.add(l);
            }
        }
        return ans;
    }
}
