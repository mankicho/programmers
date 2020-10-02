package level3;

public class level3_pedestrianHeaven {
    int MOD = 20170805;
    int answer = 0;

    final static private int a = 0;

    public static void main(String[] args) {
//        System.out.println(new level3_pedestrianHeaven().solution(3, 6, new int[][]{{0, 2, 0, 0, 0, 2}, {0, 0, 2, 0, 1, 0}, {1, 0, 0, 2, 2, 0}}));
//        System.out.println(new level3_pedestrianHeaven().solution(3, 3, new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}));
        System.out.println(new level3_pedestrianHeaven().solution(4, 6, new int[][]{{0, 0, 0, 0, 0, 0}, {0, 0, 2, 2, 0, 0}, {1, 1, 0, 2, 0, 2}, {1, 0, 0, 2, 0, 0}}));
        System.out.println((20 + 20) % 3);
    }

    public int solution(int m, int n, int[][] cityMap) {
        int[][] dp = new int[m][n];

        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (cityMap[i][j] == 0) {
                    if (i < m - 1 && j < n - 1) {
                        dp[i + 1][j] = (dp[i + 1][j] + dp[i][j]) % MOD;
                        dp[i][j + 1] = (dp[i][j + 1] + dp[i][j]) % MOD;
                    } else if (i < m - 1) {
                        dp[i + 1][j] = (dp[i + 1][j] + dp[i][j]) % MOD;
                    } else if (j < n - 1) {
                        dp[i][j + 1] = dp[i][j + 1] + dp[i][j] % MOD;
                    }
                } else if (cityMap[i][j] == 2) {
                    if (i < m - 1 && j < n - 1) {
                        dp[i + 1][j] = (dp[i + 1][j] + setDP(i, j, -1, cityMap, dp)) % MOD;
                        dp[i][j + 1] = (dp[i][j + 1] + setDP(i, j, 1, cityMap, dp)) % MOD;
                    } else if (i == m - 1) {
//                        dp[i][j + 1] -= setDP(i, j, -1, cityMap, dp);
                        dp[i][j + 1] = (dp[i][j + 1] + setDP(i, j, 1, cityMap, dp)) % MOD;
                    } else if (j == n - 1) {
//                        dp[i+1][j] -= setDP(i,j,1,cityMap,dp);
                        dp[i + 1][j] = (dp[i + 1][j] + setDP(i, j, -1, cityMap, dp)) % MOD;
                    }
                } else {
                    dp[i][j] = 0;
                }
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

//        for (int i = m - 1; i >= 0; i--) {
//            if (cityMap[i][n - 1] == 2) {
//                dp[m - 1][n - 1] -= setDP(i, n - 1, 1, cityMap, dp);
//            }
//        }
//        System.out.println(dp[m - 1][n - 1]);
        answer = dp[m - 1][n - 1];
        return answer;
    }

    public int setDP(int row, int col, int direction, int[][] cityMap, int[][] dp) {
        int value = 0;
        if (direction > 0) {
            for (int i = col; i >= 0; i--) {
                if (cityMap[row][i] != 2) {
                    value = dp[row][i];
                    break;
                }
            }
        } else {
            for (int i = row; i >= 0; i--) {
                if (cityMap[i][col] != 2) {
                    value = dp[i][col];
                    break;
                }
            }
        }
        return value;
    }
}
