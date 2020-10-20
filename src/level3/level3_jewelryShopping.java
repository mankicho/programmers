package level3;

import java.util.*;

public class level3_jewelryShopping {
    public static void main(String[] args) {
    }

    public int[] solution(String[] gems) {
        int[] answer = {};
        Set<String> set = new HashSet<>(Arrays.asList(gems));
        ArrayList<int[]> result = new ArrayList<>();
        int pre = 0;
        int post = 0;
        Map<String, Integer> map = new HashMap<>();

        while (post < gems.length) {
            while (post < gems.length && map.size() < set.size()) {
                map.putIfAbsent(gems[post], 0);
                map.put(gems[post], map.get(gems[post]) + 1);
                post++;
            }

            while (pre < gems.length && map.size() == set.size()) {
                map.put(gems[pre], map.get(gems[pre]) - 1);
                if (map.get(gems[pre]) == 0) {
                    map.remove(gems[pre]);
                    answer = new int[]{pre + 1, post};
                    result.add(answer);
                }
                pre++;
            }

        }
        result.sort(Comparator.comparingInt(arr -> arr[1] - arr[0]));
        answer = result.get(0);
        return answer;
    }
}