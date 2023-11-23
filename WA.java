package hardik;

import java.util.*;

public class WA {
    public static void transitiveClosure(List<List<Integer>> graph) {
        int V = graph.size();

        // Initialize the result matrix with the original graph
        List<List<Boolean>> reach = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            reach.add(new ArrayList<>());
            for (int j = 0; j < V; j++) {
                reach.get(i).add(graph.get(i).contains(j));
            }
        }

        // Apply Warshall's algorithm
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    reach.get(i).set(j, reach.get(i).get(j) || (reach.get(i).get(k) && reach.get(k).get(j)));
                }
            }
        }

        System.out.println("Transitive closure matrix:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                System.out.print(reach.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>();
        graph.add(Arrays.asList(0, 1));
        graph.add(Collections.emptyList());
        graph.add(Arrays.asList(2));
        graph.add(Collections.emptyList());

        transitiveClosure(graph);
    }
}