# Gabow's Algorithm for Strongly Connected Components

This Java application demonstrates the implementation of Gabow's Algorithm to find strongly connected components (SCCs) in a directed graph.

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
- Open the GabowsAlgorithm.java file in your Java IDE.

- Run the main method located in the GabowsAlgorithm class.

- The program will execute the Gabow's Algorithm on a sample directed graph specified in the main method and display the strongly connected components in the console output.

### Usage
You can modify the graph in the main method by adding or removing edges to test the algorithm on different directed graphs.

### Example
Suppose you want to find strongly connected components in a directed graph with vertices and edges as follows:
```
Vertices: 0, 1, 2, 3, 4
Edges:
1 -> 0
0 -> 2
2 -> 1
0 -> 3
3 -> 4
```
You can modify the graph in the main method as:

```
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
```