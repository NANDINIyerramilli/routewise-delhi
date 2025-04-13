public class Edge {
    String src;
    String dest;
    int wt;  // time between stations in minutes
    String colour;  // metro line color

    public Edge(String src, String dest, int wt, String colour) {
        this.src = src;
        this.dest = dest;
        this.wt = wt;
        this.colour = colour;
    }
}
