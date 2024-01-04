import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//Karger's algorithm is a randomized algorithm used to find the minimum cut in an undirected graph.
//It repeatedly contracts randomly chosen edges until only two vertices remain, representing a cut in the graph.
//The number of edges crossing the cut is the minimum cut.

class KargersAlgorithm {

    // Function to find the minimum cut in a graph
    static int minCut(List<List<Integer>> graph) {
        int vertices = graph.size();

        // While there are more than 2 vertices
        while (vertices > 2) {
            Random random = new Random();
            int u = random.nextInt(vertices);
            List<Integer> adjU = graph.get(u);

            int v = random.nextInt(adjU.size());
            int vertexToMerge = adjU.get(v);

            // Merging vertices by adding all edges from the vertex to merge
            graph.get(u).addAll(graph.get(vertexToMerge));

            // Redirecting edges from the merged vertex to the current vertex
            for (int i = 0; i < vertices; i++) {
                List<Integer> adj = graph.get(i);
                for (int j = 0; j < adj.size(); j++) {
                    if (adj.get(j) == vertexToMerge) {
                        adj.set(j, u);
                    }
                }
            }

            // Removing self-loops from the current vertex
            while (graph.get(u).remove(Integer.valueOf(u))) {
            }

            vertices--;
        }

        // Counting the minimum cuts in the remaining graph
        int cuts = 0;
        for (int i = 0; i < graph.get(0).size(); i++) {
            if (graph.get(0).get(i) != 0) {
                cuts++;
            }
        }

        return cuts;
    }

    public static void main(String[] args) {
        // Constructing the graph (Modify graph as needed)
        int V = 4;
        List<List<Integer>> graph = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // Adding edges to the graph (Modify edges as needed)
        graph.get(0).add(1);
        graph.get(0).add(2);
        graph.get(0).add(3);
        graph.get(1).add(0);
        graph.get(1).add(3);
        graph.get(2).add(0);
        graph.get(2).add(3);
        graph.get(3).add(0);
        graph.get(3).add(1);
        graph.get(3).add(2);

        // Finding the minimum cut and printing the result
        System.out.println("Minimum Cut: " + minCut(graph));
    }
}
