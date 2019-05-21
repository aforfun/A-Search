import java.util.*;

public class NeuRun {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[][][] arr = new int[n][n][2];
        int max = 0;
        int edgecount = 0;
        while (max < n) {
            int a = s.nextInt();
            int m = s.nextInt();
            if (m != 0) {
                for (int u = 1; u <= m; u++) {
                    int to = s.nextInt();
                    for (int r = 0; r < 2; r++) {
                        int dort = s.nextInt();
                        arr[a - 1][to - 1][r] = dort;
                        arr[to - 1][a - 1][r] = dort;
                        edgecount++;
                    }
                }
            }
            max++;
        }

        int msg = s.nextInt();
        int[][] msgarr = new int[msg][2];
        for (int i = 1; i <= msg; i++) {
            msgarr[i][0] = s.nextInt();
            msgarr[i][1] = s.nextInt();
        }
        boolean distance = false;
        System.out.println("Is distance or time more important for you? type d for distance an t for time :)");
        if(s.next().equalsIgnoreCase("d")){
            distance = true;
        }else{
            distance = false;
        }
        Edges[] edges = new Edges[edgecount];
        int i =0;
        for(int[]a = ){

        }
        Graph g = new Graph(edges);
        g.calculateShortestDistance();
        for (int i = 1; i <= msg; i++) {
            int fr = msgarr[i][0];
            int to = msgarr[i][1];


        }
        }
    }

