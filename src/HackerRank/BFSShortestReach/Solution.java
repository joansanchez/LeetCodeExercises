package HackerRank.BFSShortestReach;

import java.util.*;

class Node {
    private int dist;
    private Set<Integer> adj;
    private boolean visited;

    public Node() {
        dist = Integer.MAX_VALUE;
        adj = new HashSet<>();
        visited = false;
    }
    public int getDist(){
        return dist;
    }
    public void setDist(int dist){
        this.dist = dist;
    }
    public void addAdj(int node){
        adj.add(node);
    }

    public Set<Integer> getAdj(){
        return adj;
    }

    public void setVisited(){
        visited = true;
    }

    public boolean isVisited(){
        return visited;
    }
}

public class Solution {

    private final static int distance = 6;

    public static int getMinDistantNode(Node nodesList[]){
        int index = -1;
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < nodesList.length; ++i){
            if(!nodesList[i].isVisited() && nodesList[i].getDist() <= minValue){
                index = i;
                minValue = nodesList[i].getDist();
            }
        }
        return index;
    }

    public static void getDistances(Node nodesList[], int startNode){
        nodesList[startNode-1].setDist(0);

        for(int i = 0; i < nodesList.length; ++i) {
            int minDistantIndex = getMinDistantNode(nodesList);
            Node actual = nodesList[minDistantIndex];

            actual.setVisited();
            if (actual.getDist() == Integer.MAX_VALUE) actual.setDist(-1);
            else {
                actual.getAdj().stream().forEach(nodeIndex -> {
                    Node neighbour = nodesList[nodeIndex];
                    if (!neighbour.isVisited() && neighbour.getDist() > actual.getDist() + distance)
                        neighbour.setDist(actual.getDist() + distance);
                });
            }

        }
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named HackerRank.BFSShortestReach.Solution. */
        Scanner scanner = new Scanner(System.in);
        int queries = Integer.parseInt(scanner.nextLine());

        for(int i = 0; i < queries; ++i){
            String[] graphInfo = scanner.nextLine().split(" ");
            int nodes = Integer.parseInt(graphInfo[0]);
            int edges = Integer.parseInt(graphInfo[1]);
            Node nodesList[] = new Node[nodes];

            for (int n = 0; n < nodes; ++n){
                nodesList[n] = new Node();
            }

            for (int e = 0; e < edges; ++e){
                String[] edge = scanner.nextLine().split(" ");
                nodesList[Integer.parseInt(edge[0])-1].addAdj(Integer.parseInt(edge[1])-1);
                nodesList[Integer.parseInt(edge[1])-1].addAdj(Integer.parseInt(edge[0])-1);
            }
            int startNode = Integer.parseInt(scanner.nextLine());
            getDistances(nodesList, startNode);

            boolean firstNumb = true;
            for (int n = 0; n < nodes; ++n){
                if (n != startNode -1 ) {
                    if(firstNumb) {
                        firstNumb = false;
                        System.out.print(nodesList[n].getDist());
                    }
                    else System.out.print(" " + nodesList[n].getDist());
                }
            }
            System.out.println("");
        }
    }


}



