
public class Driver_2 {

   
    public static void main(String[] args) {
        // TODO code application logic here
        MyGraph graph = new MyGraph(5);
        graph.AddVertex("Alice", 18);
        graph.AddVertex("Ben", 20);
        graph.AddVertex("Carrie", 19);
        graph.AddVertex("Ethan", 16);
        graph.AddVertex("Dolan", 21);
        graph.AddEdge("Alice", "Ben");
        graph.AddEdge("Alice", "Dolan");
        graph.AddEdge("Ben", "Alice");   //  should get an error message saying this relation already exists
        graph.AddEdge("Ben", "Dolan");
        graph.AddEdge("Carrie", "Ben");
        graph.AddEdge("Ethan", "Dolan");
        graph.AddEdge("Carrie", "Alice");
        graph.deleteEdge("Carrie", "Ben");
        graph.deleteVertex("Alice");
        System.out.println(graph);
        graph.DFS(graph, "Carrie");
    }

}
