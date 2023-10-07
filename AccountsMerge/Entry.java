package AccountsMerge;

import java.util.ArrayList;
import java.util.List;

public class Entry {
    public static void main(String[] args) {
        List<List<String>> accounts = new ArrayList<>();
        List<String> l1 = new ArrayList<>();
        l1.add("John");
        l1.add("johnsmith@mail.com");
        l1.add("john_newyork@mail.com");
        accounts.add(l1);
        List<String> l2 = new ArrayList<>();
        l2.add("John");
        l2.add("johnsmith@mail.com");
        l2.add("john00@mail.com");
        accounts.add(l2);
        List<String> l3 = new ArrayList<>();
        l3.add("Mary");
        l3.add("mary@mail.com");
        accounts.add(l3);
        List<String> l4 = new ArrayList<>();
        l4.add("John");
        l4.add("johnnybravo@mail.com");
        accounts.add(l4);
        List<List<String>> ans =  new Solution().accountsMerge(accounts);
        for(int i=0; i<ans.size(); i++){
            System.out.println(ans.get(i));
        }
    }
}
