package greedy;

import java.util.*;

public class ControlCamera {
    public static void main(String[] args) {
//        int[][] tmp = new int[][]{{10, 10}, {10, 10}, {10, 10}, {10, 10}, {10, 15}};
        new ControlCamera().solution(new int[][]{{-20, 15}, {-18, 12}, {-16, 11}, {-12, 13}, {11, 20}, {19, 30}, {22, 29}, {25, 26}
                }
        );
    }

    public int solution(int[][] routes) {
        Arrays.sort(routes, (o1, o2) -> o1[0] > o2[0] ? 1 : -1);
        for (int[] tmp : routes) {
            System.out.println(Arrays.toString(tmp));
        }
        int ans = 0;
        int startCamera = 30001;
        for (int i = routes.length - 1; i >= 0; i--) {
            int[] a = routes[i];
            if (a[1] < startCamera) {
                ans++;
                startCamera = a[0];
//                System.out.println("now startCamera " + startCamera);
            }
        }
        System.out.println(ans);
        return ans;

    }
//     Arrays.sort(routes, (o1, o2) -> o1[0] > o2[0] ? o1[0] : o2[0]);
//        int ans = 0;
//        int startCamera = 30001;
//        for (int[] a : routes) {
//            if (a[1] < startCamera) {
//                ans++;
//                startCamera = a[0];
//            }
//        }
//        return ans;
}
