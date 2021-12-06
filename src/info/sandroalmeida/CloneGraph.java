package info.sandroalmeida;

import java.util.*;

public class CloneGraph {

    public static GraphNode cloneGraph(GraphNode node) {

        if(node == null && node.neighbors == null) return node;

        // key = original node
        // value = copied node + Status if it's visited or not
        Map<GraphNode, Map.Entry<GraphNode, Boolean>> nodesMap = new HashMap<>();
        Queue<GraphNode> queue = new LinkedList<>();
        queue.add(node);

        // creating first node for the result
        GraphNode newRoot = new GraphNode(node.val);
        Map.Entry<GraphNode, Boolean> entryRoot = new AbstractMap.SimpleEntry<>(newRoot, false);
        nodesMap.put(node,entryRoot);

        while(!queue.isEmpty()){
            GraphNode current = queue.poll();

            // copying main node
            GraphNode newNode;
            Map.Entry<GraphNode, Boolean> newEntry;
            if(!nodesMap.containsKey(current)){
                newNode = new GraphNode(current.val);
                newEntry = new AbstractMap.SimpleEntry<>(newNode, false);
                nodesMap.put(current,newEntry);
            } else{
                newEntry = nodesMap.get(current);
                newNode = newEntry.getKey();
            }

            // copying neighbors nodes
            List<GraphNode> neighbors = null;
            if(!newEntry.getValue()){
                neighbors = current.neighbors;
            }
            if(neighbors != null && !neighbors.isEmpty()){
                for(GraphNode neighbor: neighbors){
                    queue.add(neighbor);
                    GraphNode newNeighbor = new GraphNode(neighbor.val);
                    Map.Entry<GraphNode, Boolean> newNeighborEntry = new AbstractMap.SimpleEntry<>(newNeighbor, false);
                    nodesMap.put(neighbor, newNeighborEntry);
                    newNode.neighbors.add(newNeighbor);
                }
            }
            newEntry.setValue(true);
            nodesMap.put(current, newEntry);
        }

        return newRoot;
    }

    public static void main(String[] args) {
        GraphNode node1 = new GraphNode(1);
        GraphNode node2 = new GraphNode(2);
        GraphNode node3 = new GraphNode(3);
        GraphNode node4 = new GraphNode(4);
        node1.neighbors.add(node2);
        node1.neighbors.add(node3);
        node1.neighbors.add(node4);
        node2.neighbors.add(node4);
        node3.neighbors.add(node4);

        GraphNode copy1 = cloneGraph(node1);
    }
}
