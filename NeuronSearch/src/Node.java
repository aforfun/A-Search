import java.util.ArrayList;

public class Node {


    private int DistanceFromSource = Integer.MAX_VALUE;
    private boolean visited;
    private ArrayList<Edges> edges = new ArrayList<Edges>();

    public int getDistanceFromSource(){
        return DistanceFromSource;
    }

    public void setDistanceFromSource(int DistanceFromSource){
        this.DistanceFromSource = DistanceFromSource;
    }

    public boolean isVisited(){
        return visited;
    }

    public void setVisited(boolean visited){
        this.visited = visited;
    }

    public ArrayList<Edges> getEdges(){
        return edges;
    }

    public void setEdges(ArrayList<Edges> edges){
        this.edges = edges;
    }

}
