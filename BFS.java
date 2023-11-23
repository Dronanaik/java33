package hardik;

import java.util.*;

class Graph {
    private int V; // Number of vertices
    private List<List<Integer>> adj; // Adjacency list

    // Create a graph with V vertices
    public Graph(int V) {
        this.V = V;
        adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    // Add an edge to the graph
    public void addEdge(int v, int w) {
        adj.get(v).add(w);
    }

    // Perform BFS starting from a given source vertex
    public void BFS(int startNode) {
        // Create an array to keep track of visited nodes
        boolean[] visited = new boolean[V];

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<>();

        // Mark the source node as visited and enqueue it
        visited[startNode] = true;
        queue.add(startNode);

        System.out.println("Nodes reachable from " + startNode + " using BFS:");

        while (!queue.isEmpty()) {
            // Dequeue a vertex from the queue
            startNode = queue.poll();
            System.out.print(startNode + " ");

            // Get all adjacent vertices of the dequeued vertex
            // If an adjacent vertex has not been visited, mark it as visited and enqueue it
            for (Integer neighbor : adj.get(startNode)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(7);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);

        int startNode = 0;
        graph.BFS(startNode);
    }
}