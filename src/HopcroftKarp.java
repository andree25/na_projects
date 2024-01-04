import java.util.*;

//Hopcroft-Karp algorithm finds the maximum matching in a bipartite graph efficiently.
//It uses a combination of breadth-first search (BFS) and depth-first search (DFS) to find augmenting paths,
//gradually increasing the number of matched vertices until no more augmenting paths exist, giving the maximum matching.

class HopcroftKarp {

    // BFS to find augmenting paths
    private static boolean bfs(List<Integer>[] graph, int[] pairU, int[] pairV, int[] dist) {
        Queue<Integer> queue = new LinkedList<>();
        for (int u = 1; u < pairU.length; u++) {
            if (pairU[u] == 0) {
                dist[u] = 0;
                queue.add(u);
            } else {
                dist[u] = Integer.MAX_VALUE;
            }
        }

        dist[0] = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            if (dist[u] < dist[0]) {
                for (int v : graph[u]) {
                    if (dist[pairV[v]] == Integer.MAX_VALUE) {
                        dist[pairV[v]] = dist[u] + 1;
                        queue.add(pairV[v]);
                    }
                }
            }
        }

        return dist[0] != Integer.MAX_VALUE;
    }

    // DFS for finding augmenting paths
    private static boolean dfs(List<Integer>[] graph, int[] pairU, int[] pairV, int[] dist, int u) {
        if (u != 0) {
            for (int v : graph[u]) {
                if (dist[pairV[v]] == dist[u] + 1 && dfs(graph, pairU, pairV, dist, pairV[v])) {
                    pairV[v] = u;
                    pairU[u] = v;
                    return true;
                }
            }

            dist[u] = Integer.MAX_VALUE;
            return false;
        }
        return true;
    }

    // Function to find the maximum matching in a bipartite graph
    static int maxMatching(List<Integer>[] graph, int n, int m) {
        int[] pairU = new int[n + 1];
        int[] pairV = new int[m + 1];
        int[] dist = new int[n + 1];
        int matching = 0;

        while (bfs(graph, pairU, pairV, dist)) {
            for (int u = 1; u <= n; u++) {
                if (pairU[u] == 0 && dfs(graph, pairU, pairV, dist, u)) {
                    matching++;
                }
            }
        }
        return matching;
    }

    public static void main(String[] args) {
        // Number of vertices in sets U and V
        int n = 4; // Number of vertices in set U
        int m = 4; // Number of vertices in set V

        // Constructing the bipartite graph (Modify as needed)
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Adding edges to the bipartite graph (Modify as needed)
        graph[1].add(1);
        graph[1].add(2);
        graph[2].add(2);
        graph[2].add(3);
        graph[3].add(3);
        graph[3].add(4);
        graph[4].add(4);

        // Finding the maximum matching and printing the result
        int maxMatching = maxMatching(graph, n, m);
        System.out.println("Maximum Matching: " + maxMatching);
    }
}
