
import java.util.*;

public class Lab_16_85 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the total number of nodes : ");
        int nodes = sc.nextInt();
        Graph g = new Graph(nodes);
        
        System.out.print("Enter total number of edges : ");
        int edges = sc.nextInt();
        for (int i = 1; i <= edges; i++) {
            System.out.print("Start[" + i + "] : ");
            int start = sc.nextInt();
            System.out.print("End[" + i + "] : ");
            int end = sc.nextInt();
            g.addEdge(start, end);
        }
        
        System.out.print("Enter the node you want to start with for DFS: ");
        int startDFS = sc.nextInt();
        System.out.println("DFS Traversal:");
        g.DFS(startDFS);
        
        System.out.print("Enter the node you want to start with for BFS: ");
        int startBFS = sc.nextInt();
        System.out.println("BFS Traversal:");
        g.BFS(startBFS);
        
        sc.close();
    }
}

class Graph {
    private int V;
    private ArrayList<Integer>[] adj;
    private Queue<Integer> queue;

    @SuppressWarnings("unchecked")
    Graph(int v) {
        V = v;
        adj = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new ArrayList<>();
        }
        queue = new LinkedList<>(); 
    }

    void addEdge(int v, int w) {
        if (v < V && w < V) { 
            adj[v].add(w);
            adj[w].add(v); 
        } else {
            System.out.println("Invalid edge: (" + v + ", " + w + ")");
        }
    }

    void DFS(int start) {
        if (start < 0 || start >= V) {
            System.out.println("Invalid start node for DFS.");
            return;
        }
        boolean[] visited = new boolean[V];
        System.out.println("Starting DFS from node " + start);
        DFSUtil(start, visited);
        System.out.println();
    }

    private void DFSUtil(int node, boolean[] visited) {
        if (visited[node]) {
            return;
        }
        visited[node] = true;
        System.out.print(node + " ");
        for (int neighbor : adj[node]) {
            if (!visited[neighbor]) {
                DFSUtil(neighbor, visited);
            }
        }
    }

    void BFS(int start) {
        if (start < 0 || start >= V) {
            System.out.println("Invalid start node for BFS.");
            return;
        }
        boolean[] visited = new boolean[V];
        queue.clear();
        visited[start] = true;
        queue.add(start);
        
        System.out.println("Starting BFS from node " + start);
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");
            
            for (int neighbor : adj[node]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }
}
