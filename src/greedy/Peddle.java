package greedy;


import java.util.Arrays;

public class Peddle {
    private int[][] result;
    private boolean[][] visited;

    public static void main(String[] args) {
        int m = 5;
        int n = 5;
        int[][] puddles = new int[][]{{2, 2},{1,2},{3,2},{4,2},{5,2}};

        System.out.println(new Peddle().solution(m, n, puddles));
    }
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        int[][] a = {{2, 3}};
//        System.out.println(solution.solution(1, 95, a));
//    }


    public int solution(int m, int n, int[][] puddles) {
        visited = new boolean[n + 2][m + 2];
        result = new int[n + 2][m + 2];

        for (int i = 0; i < result.length; i++) {
            result[i][0] = Integer.MAX_VALUE;
            result[i][result[0].length - 1] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < result[0].length; i++) {
            result[0][i] = Integer.MAX_VALUE;
            result[result.length - 1][i] = Integer.MAX_VALUE;
        }
        for (int[] tmp : puddles) {
            int a = tmp[0]; // 벽의 row
            int b = tmp[1]; // 벽의 col

            result[a][b] = Integer.MAX_VALUE;
        }

        result[1][1] = 0;
        visited[1][1] = true;
        for (int i = 1; i < result.length - 1; i++) {
            for (int j = 1; j < result[0].length - 1; j++) {

                if (result[i][j] == Integer.MAX_VALUE) {
                    continue;
                }

                result[i][j] = min(i, j);
            }
        }
        for (int i = 1; i < result.length - 1; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
        return result[n][m] - 1;
    }

    private int min(int row, int col) {
        if (!visited[row - 1][col] && !visited[row][col - 1]) {
            return 0;
        } else if (!visited[row - 1][col] && visited[row][col - 1]) {
            visited[row][col] = true;
            return result[row][col - 1] + 1;
        } else if (!visited[row][col - 1] && visited[row - 1][col]) {
            visited[row][col] = true;
            return result[row - 1][col] + 1;
        }
        visited[row][col] = true;
        return result[row][col - 1] > result[row - 1][col] ? result[row - 1][col]+1 : result[row][col - 1]+1;
    }

}
