package org.jmatas.problems.graph;

import static java.util.Objects.isNull;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class ShortestPath {

    private Set<Node> visited = new HashSet<>();
    private Optional<Integer> shortestPathSize = Optional.empty();
    private Node givenStartingNode;
    private Node givenEndingNode;

    public Integer shortestPath(Graph graph, Node startingNode, Node endingNode) {
        validateInput(graph, startingNode, endingNode);
        givenStartingNode = new Node(startingNode.getId());
        givenEndingNode = new Node(endingNode.getId());

        return pathSize(startingNode, endingNode, graph, visited).orElseThrow(
                () -> new IllegalArgumentException("There is no path between nodes"));
    }

    private Optional<Integer> pathSize(Node startingNode, Node endingNode, Graph graph, Set<Node> visited) {
        if (startingNode.equals(endingNode)) {
            return Optional.of(0);
        }
        if (visited.contains(startingNode)) {
            return Optional.empty();
        }
        visited.add(startingNode);

        Optional<Integer> currentSize = Optional.empty();
        for (Node neighbour : graph.neighbours(startingNode)) {
            currentSize = pathSize(neighbour, endingNode, graph, visited)
                    .map(size -> ++size);

            if (isShorter(currentSize) && isComplete(startingNode, endingNode)) {
                this.shortestPathSize = currentSize;
            }
        }
        return currentSize;
    }

    private boolean isComplete(Node startingNode, Node endingNode) {
        return startingNode.equals(givenStartingNode) && endingNode.equals(givenEndingNode);
    }

    private boolean isShorter(Optional<Integer> currentSize) {
        if (currentSize.isEmpty()) {
            return false;
        }
        if (shortestPathSize.isEmpty()) {
            return true;
        }
        return currentSize.get() < shortestPathSize.get();
    }

    private static void validateInput(Graph graph, Node startingNode, Node endingNode) {
        if (isNull(startingNode)) {
            throw new IllegalArgumentException("The starting node can't be null");
        }
        if (isNull(endingNode)) {
            throw new IllegalArgumentException("The ending node can't be null");
        }
        if (isNull(graph)) {
            throw new IllegalArgumentException("Graph can't be null");
        }
        if (!graph.contains(startingNode)) {
            throw new IllegalArgumentException("The starting node not exists");
        }
        if (!graph.contains(endingNode)) {
            throw new IllegalArgumentException("The ending node not exists");
        }
    }

}
