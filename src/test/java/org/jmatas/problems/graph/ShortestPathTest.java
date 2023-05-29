package org.jmatas.problems.graph;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowableOfType;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ShortestPathTest {

    private final ShortestPath shortestPath = new ShortestPath();

    @Nested
    @DisplayName("The shortest path method")
    class shortestPathMethod {

        @Test
        @DisplayName("should throw exception when the graph is null")
        void should_throw_exception_when_the_graph_is_null() {
            // Arrange

            // Action
            IllegalArgumentException error = catchThrowableOfType(
                    () -> shortestPath.shortestPath(null, new Node(1), new Node(2)),
                    IllegalArgumentException.class);

            // Assert
            assertThat(error.getMessage()).isEqualTo("Graph can't be null");
        }

        @Test
        @DisplayName("should throw exception when the starting node is null")
        void should_throw_exception_when_the_staring_node_is_null() {
            // Arrange
            Node node1 = new Node(1);
            Node node2 = new Node(2);
            Graph givenGraph = new Graph(Map.of(
                    node1, List.of(node2)));


            // Action
            IllegalArgumentException error = catchThrowableOfType(
                    () -> shortestPath.shortestPath(givenGraph, null, node2),
                    IllegalArgumentException.class);

            // Assert
            assertThat(error.getMessage()).isEqualTo("The starting node can't be null");
        }

        @Test
        @DisplayName("should throw exception when the ending node is null")
        void should_throw_exception_when_the_ending_node_is_null() {
            // Arrange
            Node node1 = new Node(1);
            Node node2 = new Node(2);
            Graph givenGraph = new Graph(Map.of(
                    node1, List.of(node2)));


            // Action
            IllegalArgumentException error = catchThrowableOfType(
                    () -> shortestPath.shortestPath(givenGraph, node1, null),
                    IllegalArgumentException.class);

            // Assert
            assertThat(error.getMessage()).isEqualTo("The ending node can't be null");
        }

        @Test
        @DisplayName("should return 0 when the starting and ending node is the same")
        void should_return_one_when_the_starting_and_ending_node_is_the_same() {
            // Arrange
            Node node1 = new Node(1);
            Node node2 = new Node(2);
            Graph givenGraph = new Graph(Map.of(
                    node1, List.of(node2)));

            // Action
            Integer shortestPathSize = shortestPath.shortestPath(givenGraph, node1, node1);

            // Assert
            assertThat(shortestPathSize).isEqualTo(0);
        }

        @Test
        @DisplayName("should throw error when the starting node not exists in the graph")
        void should_throw_error_when_the_starting_node_not_exists_in_the_graph() {
            // Arrange
            Node node1 = new Node(1);
            Node node2 = new Node(2);
            Node node3 = new Node(3);
            Node node4 = new Node(4);
            Graph givenGraph = new Graph(Map.of(
                    node1, List.of(node2),
                    node2, List.of(node3),
                    node3, List.of()));

            // Action
            IllegalArgumentException error = catchThrowableOfType(
                    () -> shortestPath.shortestPath(givenGraph, node4, node3),
                    IllegalArgumentException.class);

            // Assert
            assertThat(error.getMessage()).isEqualTo("The starting node not exists");
        }

        @Test
        @DisplayName("should throw error when the ending node not exists in the graph")
        void should_throw_error_when_the_ending_node_not_exists_in_the_graph() {
            // Arrange
            Node node1 = new Node(1);
            Node node2 = new Node(2);
            Node node3 = new Node(3);
            Node node4 = new Node(4);
            Graph givenGraph = new Graph(Map.of(
                    node1, List.of(node2),
                    node2, List.of(node3),
                    node3, List.of()));

            // Action
            IllegalArgumentException error = catchThrowableOfType(
                    () -> shortestPath.shortestPath(givenGraph, node1, node4),
                    IllegalArgumentException.class);

            // Assert
            assertThat(error.getMessage()).isEqualTo("The ending node not exists");
        }

        @Test
        @DisplayName("should throw error when there is no path between the nodes")
        void should_throw_error_when_there_is_no_path_between_the_nodes() {
            // Arrange
            Node node1 = new Node(1);
            Node node2 = new Node(2);
            Node node3 = new Node(3);
            Node node4 = new Node(4);
            Graph givenGraph = new Graph(Map.of(
                    node1, List.of(node2),
                    node2, List.of(node3),
                    node3, List.of()));

            // Action
            IllegalArgumentException error = catchThrowableOfType(
                    () -> shortestPath.shortestPath(givenGraph, node3, node2),
                    IllegalArgumentException.class);

            // Assert
            assertThat(error.getMessage()).isEqualTo("There is no path between nodes");
        }

        @Test
        @DisplayName("should return the path when there is a unique path between the nodes")
        void should_return_the_path_when_there_is_a_unique_path_between_the_nodes() {
            // Arrange
            Node node1 = new Node(1);
            Node node2 = new Node(2);
            Node node3 = new Node(3);
            Node node4 = new Node(4);
            Node node5 = new Node(5);
            Graph givenGraph = new Graph(Map.of(
                    node1, List.of(node2),
                    node2, List.of(node4),
                    node3, List.of(node2),
                    node4, List.of(node5),
                    node5, List.of()));

            // Action
            Integer path = shortestPath.shortestPath(givenGraph, node3, node5);

            // Assert
            assertThat(path).isEqualTo(3);
        }

        @Test
        @DisplayName("should return the shortest path when there is more than one path")
        void should_return_the_shortest_path_when_there_is_more_than_one_path() {
            // Arrange
            Node node1 = new Node(1);
            Node node2 = new Node(2);
            Node node3 = new Node(3);
            Node node4 = new Node(4);
            Node node5 = new Node(5);
            Graph givenGraph = new Graph(Map.of(
                    node1, List.of(node2, node5),
                    node2, List.of(node3),
                    node3, List.of(node4),
                    node4, List.of(),
                    node5, List.of(node4)));

            // Action
            Integer path = shortestPath.shortestPath(givenGraph, node1, node4);

            // Assert
            assertThat(path).isEqualTo(2);
        }
    }

}
