import java.util.*;

public class MetroGraph {
    private ArrayList<Edge>[] graph;
    private int v;  // Number of stations (vertices)
    private HashMap<String, Integer> stationToIndex;
    private HashMap<Integer, String> indexToStation;
    private int stationCount;

    @SuppressWarnings("unchecked")
    public MetroGraph(int v) {
        this.v = v;
        this.graph = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            this.graph[i] = new ArrayList<Edge>();
        }
        this.stationToIndex = new HashMap<>();
        this.indexToStation = new HashMap<>();
        this.stationCount = 0;
    }

    // Method to add an edge between two stations
    public void addEdge(String src, String dest, int wt, String colour) {
        // Add stations to the index maps if they don't exist
        if (!stationToIndex.containsKey(src)) {
            stationToIndex.put(src, stationCount);
            indexToStation.put(stationCount, src);
            stationCount++;
        }
        if (!stationToIndex.containsKey(dest)) {
            stationToIndex.put(dest, stationCount);
            indexToStation.put(stationCount, dest);
            stationCount++;
        }

        // Add edges in both directions (undirected graph)
        int srcIndex = getStationIndex(src);
        int destIndex = getStationIndex(dest);
        
        this.graph[srcIndex].add(new Edge(src, dest, wt, colour));
        this.graph[destIndex].add(new Edge(dest, src, wt, colour)); // Add reverse edge
    }

    private int getStationIndex(String station) {
        return stationToIndex.getOrDefault(station, -1);
    }

    public ArrayList<Edge>[] getGraph() {
        return this.graph;
    }

    // Find shortest path using Dijkstra's algorithm
    public void findShortestPath(String source, String destination) {
        int srcIndex = getStationIndex(source);
        int destIndex = getStationIndex(destination);

        if (srcIndex == -1 || destIndex == -1) {
            System.out.println("Invalid station name(s)");
            return;
        }

        // Initialize distances array
        int[] distances = new int[v];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[srcIndex] = 0;

        // Initialize parent array to store the path
        int[] parent = new int[v];
        Arrays.fill(parent, -1);

        // Initialize PriorityQueue for Dijkstra's algorithm
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.distance));
        pq.offer(new Node(srcIndex, 0));

        // Set to keep track of processed vertices
        boolean[] processed = new boolean[v];

        // Dijkstra's algorithm
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int u = current.vertex;

            if (processed[u]) continue;
            processed[u] = true;

            // Process all adjacent vertices
            for (Edge edge : graph[u]) {
                int v = getStationIndex(edge.dest);
                if (!processed[v] && distances[u] != Integer.MAX_VALUE &&
                    distances[u] + edge.wt < distances[v]) {
                    distances[v] = distances[u] + edge.wt;
                    parent[v] = u;
                    pq.offer(new Node(v, distances[v]));
                }
            }
        }

        // Print the path and additional information
        printPath(parent, srcIndex, destIndex, distances[destIndex]);
    }

    // Helper method to print the path
    private void printPath(int[] parent, int srcIndex, int destIndex, int totalTime) {
        if (totalTime == Integer.MAX_VALUE) {
            System.out.println("No path exists between these stations.");
            return;
        }

        // Reconstruct the path
        List<Integer> path = new ArrayList<>();
        for (int at = destIndex; at != -1; at = parent[at]) {
            path.add(at);
        }
        Collections.reverse(path);

        // Print the route
        System.out.println("\nRoute from " + indexToStation.get(srcIndex) + 
                          " to " + indexToStation.get(destIndex) + ":");
        System.out.println("Total estimated time: " + totalTime + " minutes\n");
        
        String currentColor = null;
        for (int i = 0; i < path.size() - 1; i++) {
            int current = path.get(i);
            int next = path.get(i + 1);
            
            // Find the edge connecting these stations
            Edge connectingEdge = null;
            for (Edge edge : graph[current]) {
                if (getStationIndex(edge.dest) == next) {
                    connectingEdge = edge;
                    break;
                }
            }
            
            if (connectingEdge != null) {
                // Print line change if color changes
                if (currentColor != null && !currentColor.equals(connectingEdge.colour)) {
                    System.out.println("↓ Change to " + connectingEdge.colour + " Line");
                }
                currentColor = connectingEdge.colour;
                
                // Print station
                System.out.println(indexToStation.get(current) + 
                                 " -> " + connectingEdge.wt + " min ->");
            }
        }
        // Print final station
        System.out.println(indexToStation.get(path.get(path.size() - 1)));
    }

    // Helper class for Dijkstra's algorithm
    private static class Node {
        int vertex;
        int distance;

        Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }

    // Method to get list of all stations
    public List<String> getAllStations() {
        return new ArrayList<>(stationToIndex.keySet());
    }
}
