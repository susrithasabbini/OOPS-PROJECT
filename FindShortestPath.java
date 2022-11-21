import java.io.*;
import java.util.*;

class FindShortestPath {
    static class AdjListNode {
        int vertex, weight;

        AdjListNode(int v, int w)
        {
            vertex = v;
            weight = w;
        }
        int getVertex() { return vertex; }
        int getWeight() { return weight; }
    }


    public static int[] dijkstra(
            int V, ArrayList<ArrayList<AdjListNode> > graph,
            int src)
    {
        int[] distance = new int[V];
        for (int i = 0; i < V; i++)
            distance[i] = Integer.MAX_VALUE;
        distance[src] = 0;

        PriorityQueue<AdjListNode> pq = new PriorityQueue<>(
                (v1, v2) -> v1.getWeight() - v2.getWeight());
        pq.add(new AdjListNode(src, 0));

        while (pq.size() > 0) {
            AdjListNode current = pq.poll();

            for (AdjListNode n :
                    graph.get(current.getVertex())) {
                if (distance[current.getVertex()]
                        + n.getWeight()
                        < distance[n.getVertex()]) {
                    distance[n.getVertex()]
                            = n.getWeight()
                            + distance[current.getVertex()];
                    pq.add(new AdjListNode(
                            n.getVertex(),
                            distance[n.getVertex()]));
                }
            }
        }

        return distance;
    }

    public static void main(String[] args)
    {
        int V = 8;
        ArrayList<ArrayList<AdjListNode> > graph
                = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        int source = 0;
        graph.get(0).add(new AdjListNode(1, 40));
        graph.get(0).add(new AdjListNode(2, 35));
        graph.get(0).add(new AdjListNode(3, 26));
        graph.get(0).add(new AdjListNode(4, 15));
        graph.get(0).add(new AdjListNode(5, 21));
        graph.get(0).add(new AdjListNode(6, 31));
        graph.get(0).add(new AdjListNode(7, 19));
        graph.get(1).add(new AdjListNode(4, 44));
        graph.get(1).add(new AdjListNode(6, 67));
        graph.get(2).add(new AdjListNode(6, 58));
        graph.get(2).add(new AdjListNode(5, 48));
        graph.get(3).add(new AdjListNode(5, 39));
        graph.get(3).add(new AdjListNode(7, 37));
        graph.get(4).add(new AdjListNode(7, 18));

        int[] distance = dijkstra(V, graph, source);

        System.out.println(" Drop Points"
                + " Minimum Distance (km)");
        for (int i = 0; i < V; i++) {
            System.out.println(i + "			 "
                    + distance[i]);
        }
    }
}
