# Hopcroft-Karp Algorithm for Maximum Matching in Bipartite Graphs

This Java application demonstrates the implementation of the Hopcroft-Karp Algorithm to find the maximum matching in a bipartite graph.

## Getting Started
### Prerequisites
To run this application, you need:

- Java Development Kit (JDK) installed on your machine (version 8 or higher)

- A Java IDE such as IntelliJ IDEA, Eclipse, or any text editor for Java

### Installation
- Clone or download this repository to your local machine.

``` git clone https://github.com/andree25/na_projects.git ```

- Open the project in your Java IDE.

- Ensure the JDK is properly configured in your development environment.

### Running the Application
- Open the HopcroftKarp.java file in your Java IDE.

- Run the main method located in the HopcroftKarp class.

- The program will execute the Hopcroft-Karp Algorithm on a sample bipartite graph specified in the main method and display the maximum matching in the console output.

### Usage
You can modify the bipartite graph in the main method by adding or removing edges to test the algorithm on different bipartite graphs.

### Example
Suppose you want to find the maximum matching in a bipartite graph with vertices and edges as follows:

```
Vertices in Set U: 1, 2, 3, 4
Vertices in Set V: 5, 6, 7, 8
Edges:
1 -> 5
1 -> 6
2 -> 6
2 -> 7
3 -> 7
3 -> 8
4 -> 8
```
You can modify the main method as:

```
public static void main(String[] args) {
    int n = 4; // Number of vertices in set U
    int m = 4; // Number of vertices in set V

    // Constructing the bipartite graph (Modify as needed)
    List<Integer>[] graph = new ArrayList[n + 1];
    for (int i = 0; i <= n; i++) {
        graph[i] = new ArrayList<>();
    }

    // Adding edges to the bipartite graph (Modify as needed)
    graph[1].add(5);
    graph[1].add(6);
    graph[2].add(6);
    graph[2].add(7);
    graph[3].add(7);
    graph[3].add(8);
    graph[4].add(8);

    // Finding the maximum matching and printing the result
    int maxMatching = maxMatching(graph, n, m);
    System.out.println("Maximum Matching: " + maxMatching);
}
```