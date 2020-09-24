package level2;

import java.util.ArrayList;
import java.util.List;

public class level2_joyStick {
    public static void main(String[] args) {
        System.out.println(new level2_joyStick().solution("ABABAAAAABA"));
    }

    public int solution(String name) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < name.length(); i++) {
            char chr = name.charAt(i);
            if (chr != 'A') {
                list.add(i);
            }
            answer += Math.min('Z' - chr + 1, chr - 'A');
        }
        int path = findShortPath(name, list);
        System.out.println("path = " + path);
        answer += path;
        return answer;
    }

    public int findShortPath(String name, List<Integer> list) {

        int a = 0, c = 0, d = 0;

        a = list.get(list.size() - 1);
        int idx = name.length() - 1;
        int idxOfA = idx;
        int idxOfFirstA = idx;
        while (idx >= 0) {
            char chr = name.charAt(idx);
            idxOfA = idx;
            if (chr == 'A') {
                for (int i = idx; i >= 0 / 2; i--) {
                    if (name.charAt(i) == 'A') {
                        idxOfFirstA = i;
                    } else {
                        break;
                    }
                }
                break;
            }
            idx--;
        }
        c = (name.length() - idxOfA - 1) * 2 + idxOfFirstA - 1;

        idx = 0;
        idxOfA = 0;
        idxOfFirstA = 0;
        while (idx < name.length()) {
            idxOfFirstA = idx;
            if (name.charAt(idx) == 'A') {
                for (int i = idx; i < name.length(); i++) {
                    if (name.charAt(i) == 'A') {
                        idxOfA = i;
                    } else {
                        break;
                    }
                }
                break;
            }
            idx++;
        }
        System.out.println(idxOfFirstA + "," + idxOfA);
        d = (idxOfFirstA - 1) * 2 + name.length() - idxOfA - 1;
        System.out.println(a + "," + c + "," + d);
        return Math.min(a, Math.min(c, d));
    }
}
