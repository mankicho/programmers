package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConnectLand {
    int[][] origin;
    int[][] finalGraph;
    int[] distance;
    int[] from;

    public static void main(String[] args) {
        System.out.println(new ConnectLand().solution(4, new int[][]{{0, 1, 1}, {0, 2, 2}, {2, 3, 1}}));
    }

    public int solution(int n, int[][] costs) {
        origin = new int[n][n];
        distance = new int[n];
        from = new int[n];
        finalGraph = new int[2][n - 1];

        for (int i = 0; i < n; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < origin.length; i++) {
            Arrays.fill(origin[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < origin.length; i++) {
            origin[i][i] = 0;
        }

        for (int i = 0; i < costs.length; i++) {
            int startNode = costs[i][0];
            int endNode = costs[i][1];
            int weight = costs[i][2];

            origin[startNode][endNode] = weight;
            origin[endNode][startNode] = weight;
        }

        System.out.println(Arrays.deepToString(origin));
        int start = 0;
        setFinalGraph(start, n);

        int answer = 0;
        for (int i = 0; i < finalGraph[0].length; i++) {
            int a = finalGraph[0][i];
            int b = finalGraph[1][i];

            answer += origin[a][b];
        }
        System.out.println(Arrays.deepToString(finalGraph));
        return answer;
    }
//        System.out.println(new ConnectLand().solution(4, new int[][]{{0, 1, 1}, {0, 2, 2}, {2, 3, 1}}));
    private void setFinalGraph(int start, int n) {
        for (int i = 0; i < n; i++) {
            from[i] = start;
            distance[i] = origin[start][i];
        }

        distance[start] = 0;
        for (int i = 0; i < n - 1; i++) {
            System.out.println(Arrays.toString(distance));

            int minIndex = minNode(distance);
            finalGraph[0][i] = from[minIndex];
            finalGraph[1][i] = minIndex;

            distance[minIndex] = 0;
            for (int j = 0; j < distance.length; j++) {
                if (origin[minIndex][j] < distance[j]) {
                    from[j] = minIndex;
                    distance[j] = origin[minIndex][j];
                }
            }

            System.out.println("now = " + Arrays.toString(distance));
        }

    }

    private int minNode(int[] dist) {
        int minValue = Integer.MAX_VALUE;
        int min = 0;
        for (int i = 0; i < dist.length; i++) {
            if (dist[i] == 0) {
                continue;
            }
            if (dist[i] < minValue) {
                minValue = dist[i];
                min = i;
            }
        }
//        System.out.println("min = " + min);
        return min;
    }
}
