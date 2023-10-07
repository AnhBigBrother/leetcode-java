package CloneGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    HashMap<Node, Node> m = new HashMap<Node, Node>();
    public Node cloneGraph(Node node) {
        if (m.containsKey(node)){
            return m.get(node);
        }
        Node clone = new Node(node.val);
        m.put(node, clone);
        List <Node> nei = new ArrayList<Node>();
        for (int i=0; i<node.neighbors.size(); i++){
            nei.add(cloneGraph(node.neighbors.get(i)));
        }
        clone.neighbors = nei;
        return clone;
    }
}
