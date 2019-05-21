import java.util.ArrayList;

public class Graph {


    private final Node[] nodes;
    private final int noOfNodes;
    private final Edges[] edges;
    private final int noOfEdges;

    public Graph(Edges[] edges){
        this.edges =edges;
        this.noOfNodes = calculateNoOfNodes(edges);
        this.nodes = new Node[this.noOfNodes];

        for(int n =0;n<this.noOfNodes;n++){
            this.nodes[n]= new Node();
        }
        this.noOfEdges = edges.length;

        for(int edgeToAdd = 0; edgeToAdd< this.noOfEdges;edgeToAdd++){
            this.nodes[edges[edgeToAdd].getFromNodeIndex()].getEdges().add(edges[edgeToAdd]);
            this.nodes[edges[edgeToAdd].getToNodeIndex()].getEdges().add(edges[edgeToAdd]);
        }

    }

    public Node[] getNodes(){
        return nodes;
    }

    public int getNoOfNodes(){
        return noOfNodes;
    }

    public Edges[] getEdges(){
        return edges;
    }

    public int getNoOfEdges(){
        return noOfEdges;
    }

    private int calculateNoOfNodes(Edges[] edges) {
        int noOfNode =0;

        for(Edges e : edges ){
            if(e.getToNodeIndex()>noOfNode)
                noOfNode = e.getToNodeIndex();
            if(e.getFromNodeIndex()> noOfNode)
                noOfNode =e.getFromNodeIndex();

        }
        noOfNode++;
         return noOfNode;
    }

    public void calculateShortestDistance(){
        this.nodes[0].setDistanceFromSource(0);
        int nextNode =0;

        for (Node node : this.nodes) {
            ArrayList<Edges> currentNodeEdges = this.nodes[nextNode].getEdges();

            for(int jointEdges=0;jointEdges<currentNodeEdges.size();jointEdges++){
                int neighbourIndex = currentNodeEdges.get(jointEdges).getNeighbourIndex(nextNode);

                if (!this.nodes[neighbourIndex].isVisited()){
                    int tentative = this.nodes[nextNode].getDistanceFromSource()+currentNodeEdges.get(jointEdges).getLength();

                    if(tentative < nodes[neighbourIndex].getDistanceFromSource()){
                        nodes[neighbourIndex].setDistanceFromSource(tentative);
                    }
                }
            }
            nodes[nextNode].setVisited(true);
            nextNode = getNodeShortestDistanced();
        }
    }

    private int getNodeShortestDistanced(){
        int storedNodeIndex = 0;
        int storedDist = Integer.MAX_VALUE;

        for(int i =0;i<this.nodes.length;i++){
            int currentDist = this.nodes[i].getDistanceFromSource();

            if(!this.nodes[i].isVisited() && currentDist< storedDist){
                storedDist = currentDist;
                storedNodeIndex = i;
            }
        }
        return storedNodeIndex;
    }

    public void printResult(){
        String output ="Number of nodes = " + this.noOfNodes;
        output += "\nNumber of edges = "+this.noOfEdges;

        for(int i =0; i<this.nodes.length;i++){
            output +="\nThe shortest distance from node 0 to node " +i+ " is "+ nodes[i].getDistanceFromSource();
        }
        System.out.println(output);
    }
}
