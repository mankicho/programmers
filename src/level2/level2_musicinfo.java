package level2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class level2_musicinfo {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        Date d1 = null;
        Date d2 = null;

        List<String[]> result = new ArrayList<>();
        m = m.replace("C#", "H");
        m = m.replace("D#", "I");
        m = m.replace("F#", "J");
        m = m.replace("G#", "K");
        m = m.replace("A#", "L");
        System.out.println("m = " + m);
        for (String str : musicinfos) {
            String[] tmp = str.split(",");
            try {
                d1 = format.parse(tmp[0]);
                d2 = format.parse(tmp[1]);

//                System.out.println(d1.toString());
//                System.out.println(d2.toString());
            } catch (ParseException e) {
                e.printStackTrace();
            }

            int playTime = (d2.getHours() - d1.getHours()) * 60 + (d2.getMinutes() - d1.getMinutes());
            int tmpPlay = (d2.getHours() - d1.getHours()) * 60 + (d2.getMinutes() - d1.getMinutes());
//            System.out.println("playTIme = " + playTime);
            StringBuilder sb = new StringBuilder();

            String melody = tmp[3];

            melody = melody.replace("C#", "H");
            melody = melody.replace("D#", "I");
            melody = melody.replace("F#", "J");
            melody = melody.replace("G#", "K");
            melody = melody.replace("A#", "L");

            System.out.println("melody = " + melody);
            int index = 0;
            while (playTime >= 0) {
                char c = melody.charAt(index++);
                sb.append(c);

                playTime--;
                if (index == melody.length()) {
                    index -= melody.length();
                }
            }
            String str2 = sb.toString();
            System.out.println("str2 = " + str2);
            if (str2.contains(m)) {

                result.add(new String[]{tmpPlay + "", tmp[2]});
            }
        }
        if (result.size() == 1) {
            return result.get(0)[1];
        }

        int max = 0;
        for (String[] arr : result) {
            int time = Integer.parseInt(arr[0]);
            if (time > max) {
                max = time;
            }
        }

        for (int i = 0; i < result.size(); i++) {
            System.out.println(Arrays.toString(result.get(i)));
        }
        for (String[] arr : result) {
            if (arr[0].equals(max + "")) {
                return arr[1];
            }
        }

        return "'(None)'";
    }
}
