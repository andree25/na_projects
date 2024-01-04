import java.util.*;

//Gabow's algorithm is used to find strongly connected components in a directed graph.
//It employs two depth-first searches (DFS).
//The first pass fills a stack based on the finishing times of vertices.
//The second pass explores the transposed graph, identifying SCCs based on the order of vertices popped from the stack.

class GabowsAlgorithm {

    // DFS function for the first pass
    private static void dfs(List<List<Integer>> graph, int u, Stack<Integer> stack, boolean[] visited) {
        visited[u] = true;
        for (int v : graph.get(u)) {
            if (!visited[v]) {
                dfs(graph, v, stack, visited);
            }
        }
        stack.push(u);
    }

    // Transpose the graph
    private static List<List<Integer>> transpose(List<List<Integer>> graph) {
        int V = graph.size();
        List<List<Integer>> transposedGraph = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            transposedGraph.add(new ArrayList<>());
        }

        for (int u = 0; u < V; u++) {
            for (int v : graph.get(u)) {
                transposedGraph.get(v).add(u);
            }
        }
        return transposedGraph;
    }

    // Fill order of vertices for the second pass
    private static void fillOrder(List<List<Integer>> graph, int u, boolean[] visited, Stack<Integer> stack) {
        visited[u] = true;
        for (int v : graph.get(u)) {
            if (!visited[v]) {
                fillOrder(graph, v, visited, stack);
            }
        }
        stack.push(u);
    }

    // Function to find strongly connected components
    static List<List<Integer>> stronglyConnectedComponents(List<List<Integer>> graph) {
        int V = graph.size();
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(graph, i, stack, visited);
            }
        }

        List<List<Integer>> SCCs = new ArrayList<>();
        Arrays.fill(visited, false);

        List<List<Integer>> transposedGraph = transpose(graph);

        while (!stack.isEmpty()) {
            int u = stack.pop();
            if (!visited[u]) {
                List<Integer> component = new ArrayList<>();
                fillOrder(transposedGraph, u, visited, stack);

                while (!stack.isEmpty()) {
                    int v = stack.pop();
                    component.add(v);
                    visited[v] = true;
                }
                SCCs.add(component);
            }
        }
        return SCCs;
    }

    public static void main(String[] args) {
        int V = 5; // Number of vertices

        // Constructing the graph (Modify as needed)
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // Adding edges to the graph (Modify as needed)
        graph.get(1).add(0);
        graph.get(0).add(2);
        graph.get(2).add(1);
        graph.get(0).add(3);
        graph.get(3).add(4);

        // Finding strongly connected components and printing the result
        List<List<Integer>> SCCs = stronglyConnectedComponents(graph);

        System.out.println("Strongly Connected Components:");
        for (List<Integer> component : SCCs) {
            System.out.println(component);
        }
    }
}
