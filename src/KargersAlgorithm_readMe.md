# Karger's Algorithm for Minimum Cut

This Java application demonstrates the implementation of Karger's Algorithm to find the minimum cut in an undirected graph.

## Getting Started
### Prerequisites
To run this application, you need:

- Java Development Kit (JDK) installed on your machine (version 8 or higher)

- A Java IDE such as IntelliJ IDEA, Eclipse, or any text editor for Java

### Installation
- Clone or download this repository to your local machine.

``` git clone https://github.com/andree25/NetzwerkAlgorithmen.git ```

- Open the project in your Java IDE.

- Ensure the JDK is properly configured in your development environment.

### Running the Application
- Open the KargersAlgorithm.java file in your Java IDE.

- Run the main method located in the KargersAlgorithm class.

- The program will execute Karger's Algorithm on a sample undirected graph specified in the main method and display the minimum cut in the console output.

### Usage
You can modify the undirected graph in the main method by adding or removing edges to test the algorithm on different graphs.

### Example
Suppose you want to find the minimum cut in an undirected graph with vertices and edges as follows:

```
Vertices: 1, 2, 3, 4
Edges:
1 - 2
1 - 3
2 - 3
2 - 4
3 - 4
```
You can modify the main method as:

```
public static void main(String[] args) {
    // Constructing the graph (Modify as needed)
    int V = 4; // Number of vertices
    List<List<Integer>> graph = new ArrayList<>(V);
    for (int i = 0; i < V; i++) {
        graph.add(new ArrayList<>());
    }

    // Adding edges to the graph (Modify as needed)
    graph.get(0).add(1);
    graph.get(0).add(2);
    graph.get(1).add(0);
    graph.get(1).add(2);
    graph.get(1).add(3);
    graph.get(2).add(0);
    graph.get(2).add(1);
    graph.get(2).add(3);
    graph.get(3).add(1);
    graph.get(3).add(2);

    // Finding the minimum cut and printing the result
    int minCut = minCut(graph);
    System.out.println("Minimum Cut: " + minCut);
}
```