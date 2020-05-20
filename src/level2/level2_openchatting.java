package level2;

import java.util.*;

public class level2_openchatting {
    public String[] solution(String[] record) {
        String[] answer;

        List<String> result = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        for (String str : record) {
            String[] tmp = str.split(" ");

            if (tmp[0].equals("Enter")) {
                map.put(tmp[1], tmp[2]);
            } else if (tmp[0].equals("Change")) {
                map.put(tmp[1], tmp[2]);
            }

        }

        for (String str : record) {
            String[] tmp = str.split(" ");

            System.out.println("tmp[0] = " + tmp[0]);
            if (tmp[0].equals("Enter")) {
                result.add(map.get(tmp[1])+"님이 들어왔습니다.");
                System.out.println("enter");
            }else if(tmp[0].equals("Leave")){
                result.add(map.get(tmp[1])+"님이 나갔습니다.");
                System.out.println("leave");
            }

        }

        answer = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}
