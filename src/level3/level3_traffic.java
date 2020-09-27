package level3;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class level3_traffic {
    public static void main(String[] args) throws Exception {
        new level3_traffic().solution(new String[]{"2016-09-15 20:59:57.421 0.351s"
                , "2016-09-15 20:59:58.233 1.181s", "2016-09-15 20:59:58.299 0.8s", "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s",
                "2016-09-15 21:00:00.464 1.466s", "2016-09-15 21:00:00.741 1.581s"
                , "2016-09-15 21:00:00.748 2.31s", "2016-09-15 21:00:00.966 0.381s"
                , "2016-09-15 21:00:02.066 2.62s"}
        );


    }

    public int solution(String[] lines) {
        int answer = 0;
        Traffic[] traffics = new Traffic[lines.length];
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
        for (int i = 0; i < lines.length; i++) {
            int lastIndex = lines[i].lastIndexOf(" ");
            String processTime = lines[i].substring(lastIndex).replace("s", "");
            String endTime = lines[i].substring(1, lastIndex);
            try {
                Date endDate = format.parse(endTime);
                double pTime = Double.parseDouble(processTime)-0.001d;
                Calendar cal = Calendar.getInstance();
                cal.setTime(endDate);
                cal.add(Calendar.MILLISECOND, (int) (pTime * -1000));

                traffics[i] = new Traffic(i, cal.getTime(), endDate);
            } catch (Exception e) {
            }
        }

        for (int i = 0; i < traffics.length; i++) {
            Traffic traffic = traffics[i];
            Calendar cal = Calendar.getInstance();
            Calendar cal2 = Calendar.getInstance();
            Calendar cal3 = Calendar.getInstance();
            Calendar cal4 = Calendar.getInstance();
            cal.setTime(traffic.start);
            cal2.setTime(traffic.end);
            cal3.setTime(traffic.start);
            cal4.setTime(traffic.end);
            cal.add(Calendar.MILLISECOND, 999);
            cal2.add(Calendar.MILLISECOND, 999);
            cal3.add(Calendar.MILLISECOND, -999);
            cal4.add(Calendar.MILLISECOND, -999);

            Date startPlusOne = cal.getTime(); // 시작 + 1
            Date endPlusOne = cal2.getTime(); // 끝 + 1
            Date startMinusOne = cal3.getTime(); // 시작 -1
            Date endMinusOne = cal4.getTime(); // 끝 -1

//            System.out.println(format.format(traffic.start)+", " + format.format(cal.getTime())+", "+ format.format(cal3.getTime()));
//            System.out.println(format.format(traffic.end)+", " + format.format(cal2.getTime())+", "+ format.format(cal4.getTime()));
            System.out.println();
            int ansOfAfterStart = 0;
            int ansOfAfterEnd = 0;
            int ansOfLaterStart = 0;
            int ansOfLaterEnd = 0;
            for (int j = 0; j < traffics.length; j++) {
                Traffic target = traffics[j];
                if (target.number == traffic.number) {
                    continue;
                }

                if (target.start.compareTo(traffic.start) >= 0 && target.start.compareTo(startPlusOne) <= 0) {
//                    System.out.println("ansOfStart++");
                    ansOfAfterStart++;
                } else if (target.start.compareTo(traffic.end) >= 0 && target.start.compareTo(endPlusOne) <= 0) {
//                    System.out.println("ansOfStart++");
                    ansOfAfterStart++;
                }

                if (target.start.compareTo(traffic.start) <= 0 && target.start.compareTo(startMinusOne) >= 0) {
                    ansOfLaterStart++;
                } else if (target.start.compareTo(traffic.end) <= 0 && target.start.compareTo(endMinusOne) >= 0) {
                    ansOfLaterStart++;
                }

                if (target.end.compareTo(traffic.start) >= 0 && target.end.compareTo(startPlusOne) <= 0) {
//                    System.out.println("ansOfEnd++");
                    ansOfAfterEnd++;
                } else if (target.end.compareTo(traffic.end) >= 0 && target.end.compareTo(endPlusOne) <= 0) {
//                    System.out.println("ansOfEnd++");
                    ansOfAfterEnd++;
                }

                if (target.end.compareTo(traffic.start) <= 0 && target.end.compareTo(startMinusOne) >= 0) {
                    ansOfLaterEnd++;
                } else if (target.end.compareTo(traffic.end) <= 0 && target.end.compareTo(endMinusOne) >= 0) {
                    ansOfLaterEnd++;
                }
            }
//            System.out.println(i + "번째 AOS = " + ansOfStart + " , AOE = " + ansOfEnd);
//            System.out.println("------------------------------");

            answer = Math.max(answer, Math.max(Math.max(ansOfAfterStart, ansOfAfterEnd), Math.max(ansOfLaterStart, ansOfLaterEnd)));
        }

        return answer + 1;
    }
}

class Traffic {
    int number;
    Date start;
    Date end;
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");

    public Traffic(int number, Date start, Date end) {
        this.number = number;
        this.start = start;
        this.end = end;
    }

    public String toString() {
        return format.format(this.start) + " ~ " + format.format(this.end);
    }
}
