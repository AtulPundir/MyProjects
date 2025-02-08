package com.ap.pre.datastructures.walmart.imp;

import java.util.*;

public class NodeRemoval {
    public static int removeNodes(int[][] edges) {
        int n = edges.length;
        List<Set<Integer>> graph = new ArrayList<>();
        
        // Initialize graph representation
        for (int i = 0; i < n; i++) {
            graph.add(new HashSet<>());
        }

        // Build the graph from the input arrays
        for (int i = 0; i < n; i++) {
            for (int neighbor : edges[i]) {
                graph.get(i).add(neighbor);
                graph.get(neighbor).add(i);  // Undirected edge
            }
        }

        int steps = 0;
        boolean removed = true;

        // Loop until no nodes can be removed
        while (removed) {
            removed = false;
            Set<Integer> toRemove = new HashSet<>();

            // Find all nodes with 0 or 1 neighbors
            for (int i = 0; i < n; i++) {
                if (graph.get(i).size() <= 1) {
                    toRemove.add(i);
                }
            }

            // If there are nodes to remove
            if (!toRemove.isEmpty()) {
                removed = true;
                steps++;
                // Remove the identified nodes and their edges
                for (int node : toRemove) {
                    graph.get(node).clear();  // Remove all neighbors
                    for (int i = 0; i < n; i++) {
                        graph.get(i).remove(node);  // Remove the node from all other neighbors' lists
                    }
                }
            }
        }

        return steps;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[][] edges1 = {
            {6, 5, 0, 2, 1, 4},
            {4, 4, 2, 1, 0, 1}
        };
        System.out.println("Steps required: " + removeNodes(edges1));  // Output: 2

        // Test Case 2
        int[][] edges2 = {
            {0, 1, 2},
            {1, 2, 0}
        };
        System.out.println("Steps required: " + removeNodes(edges2));  // Output: 1
    }
}


/*
 * 
Nodes are marked from 0-N. Remove nodes with count of edges atmost 1.
Find how many steps are required to reach a state where we cannot remove any nodes or all the nodes are removed.

I/P 
[6,5,0,2,1,4]
[4,4,2,1,0,1]
O/P => 2

I/P
[0,1,2]
[1,2,0]
O/P => 1
 * 
 */