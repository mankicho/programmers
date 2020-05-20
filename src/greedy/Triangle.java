package greedy;

import java.util.Arrays;

public class Triangle {
    public static void main(String[] args) {
        System.out.println(new Triangle().solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));
    }


    public int solution(int[][] triangle) {
        int[][] result = new int[triangle.length][];
        for (int i = 0; i < triangle.length; i++) {
            result[i] = new int[triangle[i].length];
        }

        result[0][0] = triangle[0][0];

        for (int i = 1; i < triangle.length; i++) {
            int colIndex = 0;
            for (int j = 0; j < triangle[i].length - 1; j++) {

                for (int k = colIndex; k < colIndex + 2; k++) {
                    int tmp = result[i - 1][colIndex] + triangle[i][k];
                    if (result[i][k] < tmp) {
                        result[i][k] = tmp;
                    }
                }
                colIndex++;
            }
        }
        Arrays.sort(result[triangle.length - 1]);
        return result[triangle.length - 1][triangle.length - 1];
    }
}
