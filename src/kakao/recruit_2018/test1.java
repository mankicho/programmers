package kakao.recruit_2018;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.util.Comparator.comparingLong;

public class test1 {
    public static void main(String[] args) {

        String[] lines = new String[]{"2016-09-15 20:59:57.421 0.351s",
                "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s",
                "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s",
                "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s",
                "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s",
                "2016-09-15 21:00:02.066 2.62s"};

        System.out.println(new test1().solution(lines));
        System.out.println(
                new test1().solution(new String[]{"2016-09-15 23:59:59.999 0.001s"}));
    }

    public int solution(String[] lines) {
        int answer = 0;

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date d = new Date();
        String date = "2016-09-15";

        List<Node> list = new ArrayList<>();
        for (int i = 0; i < lines.length; i++) {
            String[] split = lines[i].split(" ");

            try {
                long t = format.parse(date + " " + split[1]).getTime();
                double minus = Double.parseDouble(split[2].replace('s', ' ')) * 1000;
                list.add(new Node(i, t - (int) minus + 1, t));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        list.sort(comparingLong(o -> o.start));


        int max = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            Node n = list.get(i);
            int sum = 0;
            for (int j = 0; j < list.size(); j++) {
                Node node = list.get(j);

                if (node.start <= n.end + 999 && node.end >= n.end) {
                    sum++;
                }
            }
            if (sum > max) {
                max = sum;
            }
        }

        for (int i = 0; i < list.size(); i++) {
            Node n = list.get(i);
            int sum = 0;
            for (int j = 0; j < list.size(); j++) {
                Node node = list.get(j);

                if (node.end >= n.start && node.start <= n.start + 999) {
                    sum++;
                }
            }

            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }

    class Node {
        int id;
        long start;
        long end;

        public Node(int id, long start, long end) {
            this.id = id;
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "id=" + id +
                    ", start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}
