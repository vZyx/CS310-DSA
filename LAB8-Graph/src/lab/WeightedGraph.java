package lab;

public class WeightedGraph {
    public int[][] edge;
    public String[] vertice;
    public int eSize=0;
    public int vSize=0;

    public WeightedGraph(int size) {
        edge = new int[size][size];
        vertice=new String[size];
        eSize=vSize=size;
    }

    public int getEdgeSize(){
        return eSize;
    }

    public int getVertSize(){
        return vSize;
    }

    public boolean isEdge(int Row, int Col){
        return edge[Row][Col]>0;
    }

    public void setVertice(int Row, String str){
        vertice[Row]=str;
    }

    public String getVertice(int Row){
        return vertice[Row];
    }

    public void setEdge(int Row, int Col, int Weight){
        edge[Row][Col]=Weight;
    }

    public int getEdge(int Row, int Col){
        return edge[Row][Col];
    }

    public void removeEdge(int Row, int Col){
        edge[Row][Col]=0;
    }

    public void countVertice(){
        int count;
        for (int Row=0; Row<vSize; Row++){
            count=0;
            for (int Col=0; Col<vSize; Col++)
                if(isEdge(Row, Col))
                    count++;

            System.out.println(vertice[Row]+": "+count);

        }
    }

    public void printVertice(){
        for (int Row=0; Row<vSize; Row++){
            System.out.println(vertice[Row]+"->");
            for (int Col=0; Col<vSize; Col++){
                if(isEdge(Row, Col))
                    System.out.println(vertice[Col]+": "+edge[Row][Col]+", ");
            }
            System.out.println();

        }
    }

    public static void main(String[] args)
    {
        WeightedGraph g1 = new WeightedGraph(5);
        g1.setVertice(0, "A");
        g1.setVertice(1, "B");
        g1.setVertice(2, "C");
        g1.setVertice(3, "D");
        g1.setVertice(4, "E");

        g1.setEdge(0, 1, 5);
        g1.setEdge(0, 4, 3);
        g1.setEdge(1, 2, 2);
        g1.setEdge(2, 3, 4);
        g1.setEdge(3, 4, 1);
        g1.setEdge(4, 2, 7);

        System.out.println("Graph Vertices:");
        for (int i = 0; i < g1.getVertSize(); i++) {
            System.out.println("Vertex " + i + ": " + g1.getVertice(i));
        }

        System.out.println("\nGraph Edges:");
        g1.printVertice();

        System.out.println("\nCount of Vertices:");
        g1.countVertice();

        System.out.println("\nEdge between A and B: " + g1.getEdge(0, 1));
        System.out.println("Edge between A and E: " + g1.getEdge(0, 4));

        g1.removeEdge(0, 1);
        System.out.println("\nGraph Edges after removing edge between A and B:");
        g1.printVertice();

        System.out.println("\nCount of Vertices after removing edge:");
        g1.countVertice();
    }

}

