package org.jmatas.problems.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graph {

    private Map<Node, List<Node>> graph = new HashMap<>();
    private Set<Node> nodes = new HashSet<>();

    public Graph(Map<Node, List<Node>> graph) {
        this.graph = graph;
        this.nodes = allNodes(graph);
    }

    private Set<Node> allNodes(Map<Node, List<Node>> graph) {
        Set<Node> nodes = new HashSet<>();
        for (Map.Entry<Node, List<Node>> entry : graph.entrySet()) {
            Node key = entry.getKey();
            List<Node> value = entry.getValue();
            nodes.add(key);
            for (Node node : value) {
                nodes.add(node);
            }
        }
        return nodes;
    }

    public List<Node> neighbours(Node node) {
        return this.graph.get(node);
    }

    public boolean contains(Node startingNode) {
        return this.nodes.contains(startingNode);
    }
}
