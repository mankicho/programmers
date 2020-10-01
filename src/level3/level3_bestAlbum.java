package level3;

import java.util.*;

public class level3_bestAlbum {
    public static void main(String[] args) {
        new level3_bestAlbum().solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500});
    }

    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        Map<String, List<PlayList>> map = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            if (map.get(genre) == null) {
                map.put(genre, new ArrayList<>());
            }

            map.get(genre).add(new PlayList(i, plays[i]));
        }

        List<Integer> result = new ArrayList<>();
        while (!map.isEmpty()) {
            Map.Entry<String, List<PlayList>> entry = null;
            int totalPlay = 0;
            for (Map.Entry<String, List<PlayList>> tmp : map.entrySet()) {
                int sum = 0;
                for (int i = 0; i < tmp.getValue().size(); i++) {
                    sum += tmp.getValue().get(i).totalPlay;
                }
                if (sum >= totalPlay) {
                    totalPlay = sum;
                    entry = tmp;
                }
            }


            List<PlayList> playLists = entry.getValue();
            playLists.sort((o1, o2) -> Integer.compare(o2.totalPlay, o1.totalPlay));
            for (int i = 0; i < playLists.size() && i < 2; i++) {
                result.add(playLists.get(i).number);
            }
            map.remove(entry.getKey());
        }
        answer = new int[result.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}

class PlayList {
    int number;
    int totalPlay;

    public PlayList(int number, int totalPlay) {
        this.number = number;
        this.totalPlay = totalPlay;
    }

    public String toString() {
        return number + "," + totalPlay;
    }
}