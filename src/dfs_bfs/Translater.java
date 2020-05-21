package dfs_bfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Translater {
    String[][] relation;
    String[] startRelation;
    String[] words;
    boolean[] visited;
    int count;
    List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        String begin = "hit";
        String target = "log";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        new Translater().solution(begin, target, words);
    }

    public int solution(String begin, String target, String[] words) {
        this.words = words;
        relation = new String[words.length][words.length];
        startRelation = new String[words.length];

        for (int i = 0; i < startRelation.length; i++) {
            String s = words[i];
            if (transable(begin, s)) {
                startRelation[i] = s;
            }
        }

//        System.out.println(Arrays.toString(startRelation));
//        System.out.println(Arrays.toString(words));
        for (int i = 0; i < words.length; i++) {
            String me = words[i];
            for (int j = 0; j < words.length; j++) {
                String you = words[j];
                if (j == i) {
                    relation[i][j] = "";
                    continue;
                }
                if (transable(me, you)) {
                    relation[i][j] = you;
                    relation[j][i] = me;
                } else {
                    relation[i][j] = "";
                }
            }
        }

//        System.out.println(Arrays.deepToString(relation));

        if (hasTarget(startRelation, target)) {
            System.out.println(1);
            return 1;
        }
        for (int i = 0; i < startRelation.length; i++) {
            count = 0;
            visited = new boolean[words.length];
            if (startRelation[i] == null) {
                continue;
            }
            dfs(i, target);
//            System.out.println(list);
        }
        if (list.isEmpty()) {
            return 0;
        }
        Collections.sort(list);
        return list.get(0);
    }


    private void dfs(int index, String target) {
        visited[index] = true;
        count++;
        if (hasTarget(relation[index], target)) {
            list.add(count + 1);
            return;
        }
        for (int i = 0; i < relation[index].length; i++) {
            if (relation[index][i].equals("")) {
                continue;
            }
            if (!visited[i]) {
                dfs(i, target);
            }
        }
    }

    private boolean hasTarget(String[] arr, String target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null && arr[i].equals(target)) {
                return true;
            }
        }
        return false;
    }

    private boolean transable(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            char d = b.charAt(i);

            if (c == d) {
                count++;
            }
        }
        if (count == a.length() - 1) {
            return true;
        }
        return false;
    }
}
