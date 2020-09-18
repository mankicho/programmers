package level2;

import java.util.ArrayList;
import java.util.List;

public class level2_findSosu {
    boolean[][] visited;
    List<Integer> result = new ArrayList<>();

    String[] strs;

    public int solution(String numbers) {
        int answer = 0;
        visited = new boolean[numbers.length()][numbers.length()];

        strs = numbers.split("");

//        System.out.println(Arrays.toString(strs));
        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            visited[i][i] = true;
            if (isSosu(s) && !isInArr(s)) {
                result.add(Integer.parseInt(s));
            }
            fun(strs, s, i);
        }

        answer = result.size();
//        System.out.println(result);
        return answer;
    }

    boolean isSosu(String str) {
        int a = Integer.parseInt(str);
        if (a == 0 || a == 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(a); i++) {
            if (a % i == 0) {
                return false;
            }
        }
        return true;
    }

    void fun(String[] arr, String str, int index) {
        for (int i = 0; i < arr.length; i++) {
            if (visited[index][i]) {
                continue;
            }
            if (isSosu(str + arr[i]) && !isInArr(str + arr[i])) {
                result.add(Integer.parseInt(str + arr[i]));
            }
            visited[index][i] = true;
            fun(arr, str + arr[i], index);
            visited[index][i] = false;
        }
    }

    boolean isInArr(String s) {
        int a = Integer.parseInt(s);
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i) == a) {
                return true;
            }
        }
        return false;
    }
}
