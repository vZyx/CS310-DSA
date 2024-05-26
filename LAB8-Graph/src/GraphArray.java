import java.util.ArrayList;
import java.util.List;

public class GraphArray {
    private String[] vertex;
    private boolean[][] edges;
    private int numVertices;
    private int numEdges;

    // Constructor
    public GraphArray(int capacity) {
        vertex = new String[capacity];
        edges  = new boolean[capacity][capacity];
    }

    // Get number of edges
    public int getNumEdges() {
        return numEdges;
    }

    // Get number of vertices
    public int getNumVertices() {
        return numVertices;
    }

    // Check if the graph is empty
    public boolean isEmpty() {
        return numVertices == 0;
    }

    public boolean isFull() {
        return numVertices == vertex.length;
    }

    // Clear the graph
    public void clear() {
        numVertices = 0;
        numEdges = 0;
        for (int i = 0; i < vertex.length; i++) {
            vertex[i] = null;
            for (int j = 0; j < vertex.length; j++) {
                edges[i][j] = false;
            }
        }
    }

    // Find vertex by its value
    public int findVertex(String value) {
        for (int i = 0; i < numVertices; i++) {
            if (vertex[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    // Add a vertex
    public void addVertex(String value) {
        if (findVertex(value) != -1) { // found
            System.out.println("addVertex failed - Error: Duplicate vertex " + value);
        }
        if (isFull()) {
            System.out.println("addVertex failed - Error: Full Graph!");
        }
        vertex[numVertices++] = value;
    }

    // Delete a vertex
    public boolean deleteVertex(String value) {
        if (isEmpty()) {
            System.out.println("deleteVertex failed - Error: Empty Graph!");
            return false;
        }

        int index = findVertex(value);
        if (index == -1) { // not found
            System.out.println("deleteVertex failed - Error: Unknown vertex " + value);
            return false;
        }

        // 1. Replace the deleted vertex with the last vertex to avoid many shift operations
        vertex[index] = vertex[numVertices - 1];
        vertex[numVertices - 1] = null;

        // 2. Replace its related edges row and column with the last row and column to avoid many shifts
        for (int j = 0; j < numVertices; j++) { // for rows (out edges)
            if (edges[index][j]) {
                numEdges--;
            }
            edges[index][j] = edges[numVertices - 1][j];
        }

        for (int i = 0; i < numVertices; i++) { // for columns (in edges)
            if (edges[i][index]) {
                numEdges--;
            }
            edges[i][index] = edges[i][numVertices - 1];
        }

        // Clear the last row and column to avoid leftover data
        for (int j = 0; j < numVertices; j++) {
            edges[numVertices - 1][j] = false;
            edges[j][numVertices - 1] = false;
        }

        numVertices--;
        return true;
    }

    // Add an edge
    public boolean addEdge(String v1, String v2) {
        int i = findVertex(v1);
        if (i == -1) { // not found
            System.out.println("addEdge failed - Error: Unknown vertex " + v1);
            return false;
        }

        int j = findVertex(v2);
        if (j == -1) { // not found
            System.out.println("addEdge failed - Error: Unknown vertex " + v2);
            return false;
        }

        if (!edges[i][j]) {
            edges[i][j] = true;
            numEdges++;
        }
        return true; // added successfully
    }

    // Delete an edge
    public boolean deleteEdge(String v1, String v2) {
        if (isEmpty()) {
            System.out.println("deleteEdge failed - Error: Empty Graph!");
            return false;
        }

        int i = findVertex(v1);
        if (i == -1) { // not found
            System.out.println("deleteEdge failed - Error: Unknown vertex " + v1);
            return false;
        }

        int j = findVertex(v2);
        if (j == -1) { // not found
            System.out.println("deleteEdge failed - Error: Unknown vertex " + v2);
            return false;
        }

        if (edges[i][j]) { // only delete if the edge exists
            edges[i][j] = false;
            numEdges--;
            return true;
        } else {
            System.out.println("deleteEdge failed - Error: There is no edge between (" + v1 + ") and (" + v2 + ") to be deleted.");
            return false;
        }
    }

    // Get the outdegree of a vertex
    public int outdegree(String v) {
        if (isEmpty()) {
            System.out.println("degree failed - Error: Empty Graph!");
            return -1;
        }

        int i = findVertex(v);
        if (i == -1) { // not found
            System.out.println("degree failed - Error: Unknown vertex " + v);
            return -1;
        }

        int outdegree = 0;
        for (int j = 0; j < numVertices; j++) {
            if (edges[i][j]) outdegree++;
        }
        return outdegree;
    }

    // Get the indegree of a vertex
    public int indegree(String v) {
        if (isEmpty()) {
            System.out.println("degree failed - Error: Empty Graph!");
            return -1;
        }

        int i = findVertex(v);
        if (i == -1) { // not found
            System.out.println("degree failed - Error: Unknown vertex " + v);
            return -1;
        }

        int indegree = 0;
        for (int j = 0; j < numVertices; j++) {
            if (edges[j][i]) indegree++;
        }
        return indegree;
    }

    // Display the graph (edges)
    public void displayGraph() { // Print all graph nodes and edges
        if (isEmpty()) {
            System.out.println("displayGraph failed - Error: Empty Graph!");
            return;
        }

        System.out.println("\n*** Graph Vertices and their Edges ***");
        for (int i = 0; i < numVertices; i++) {
            System.out.print("\n>> Vertex " + (i + 1) + ": " + vertex[i] + " is connected to ");
            boolean found = false;
            for (int j = 0; j < numVertices; j++) {
                if (edges[i][j]) {
                    if (found) {
                        System.out.print(", ");
                    }
                    found = true;
                    System.out.print(vertex[j]);
                }
            }
            if (!found) {
                System.out.print("Null");
            }
            System.out.println();
        }
    }

    public void displayVertices() { // Simple traverse, just print vertices
        if (isEmpty()) {
            System.out.println("displayVertices failed - Error: Empty Graph!");
            return;
        }

        System.out.println("\n*** Graph Vertices ***");
        for (int i = 0; i < numVertices; i++) {
            System.out.println("Vertex " + (i + 1) + ": " + vertex[i]);
        }
    }

    public static void main(String[] args) {
        System.out.println("<< Testing Directed Graph >>");
        GraphArray g = new GraphArray (4);

        g.addVertex("A");
        g.addVertex("B");
        g.addEdge ("A", "B");
        g.addVertex("C");
        g.addVertex("D");
        g.addEdge ("C", "B");
        g.addEdge ("A", "D");
        //g.clear();

        //print Graph info
        g.displayVertices ();
        g.displayGraph();
        System.out.println("\nNumber of vertices: "+ g.getNumVertices());
        System.out.println("Number of edges: " + g.getNumEdges ());

        System.out.println("\nindeg/outdeg of vertex A: " + g.indegree ("A") + "/" + g. outdegree ("A"));
        System.out.println("indeg/outdeg of vertex D: "   + g.indegree ("D") + "/" + g.outdegree ("D"));
        System.out.println("");

        //try error cases
        g.addVertex("J");
        g.deleteEdge ("A", "C");
        g.deleteVertex ("Z");

        g.deleteEdge ("A", "B");
        g.displayGraph ();
    }
}
