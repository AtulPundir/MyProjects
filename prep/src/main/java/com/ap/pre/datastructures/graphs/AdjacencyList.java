package com.ap.pre.datastructures.graphs;

import java.util.ArrayList;

public class AdjacencyList {

    public static class Edge {

        int src;
        int dest;
        int wt;

        Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void main(String[] args) {

        int vertex = 4;

        ArrayList<Edge>[] graph = new ArrayList[vertex];

        creategraph(graph);

        for (int i = 0 ; i < graph[2].size(); i++){
            System.out.print(graph[2].get(i).dest);
           System.out.println(" wt = " + graph[2].get(i).wt);

        }

    }

    private static void creategraph(ArrayList<Edge>[] graph) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();

        }

        graph[0].add(new Edge(0, 2, 2));

        graph[1].add(new Edge(1, 2, 10));
        graph[1].add(new Edge(1, 3, 0));

        graph[2].add(new Edge(2, 0, 2));
        graph[2].add(new Edge(2, 1, 10));
        graph[2].add(new Edge(2, 3, -1));

        graph[3].add(new Edge(3, 1, 0));
        graph[3].add(new Edge(3, 2, -1));
    }

}
