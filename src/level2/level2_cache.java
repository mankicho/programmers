package level2;

import java.util.LinkedList;
import java.util.Queue;

public class level2_cache {
    public int solution(int cacheSize, String[] cities) {
        int answer = 5;

        for (int i = 0; i < cities.length; i++) {
            cities[i] = cities[i].toLowerCase();
        }
        if (cacheSize == 0) {
            return 5 * cities.length;
        }

        int index = 0;
        LinkedList<String> queue = new LinkedList<>();
        queue.push(cities[index++]);
        while (index != cities.length) {
            String city = cities[index];

            if (queue.contains(city)) {
                queue.remove(city);
                queue.addLast(city);
                answer++;
            } else {
                if (queue.size() < cacheSize) {
                    queue.addLast(city);
                } else {
                    queue.pollFirst();
                    queue.addLast(city);
                }
                answer += 5;
            }
            index++;
        }
        return answer;
    }
}
