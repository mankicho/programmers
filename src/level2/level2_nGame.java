package level2;

import java.util.Arrays;

public class level2_nGame {
    public static void main(String[] args) {
        new level2_nGame().solution(16, 16, 2, 2);
    }

    public String solution(int n, int t, int m, int p) {
        String answer = "";
        StringBuilder sb = new StringBuilder();

        int num = 1;
        sb.append("0");

        while (sb.length() <= p + m * (t - 1)) {
            StringBuilder tmp = new StringBuilder();
            int mod;
            int divide = num;
            while (divide > 0) {
                mod = divide % n;
                divide /= n;
                switch (mod) {
                    case 10:
                        tmp.append('A');
                        break;
                    case 11:
                        tmp.append('B');
                        break;
                    case 12:
                        tmp.append('C');
                        break;
                    case 13:
                        tmp.append('D');
                        break;
                    case 14:
                        tmp.append('E');
                        break;
                    case 15:
                        tmp.append('F');
                        break;
                    default:
                        tmp.append(mod);
                }
            }
            sb.append(tmp.reverse());
            num++;
        }

//        System.out.println(sb.toString());
        for (int i = 0; i < t; i++) {
            System.out.print(sb.charAt(p - 1));
            p += +m;
        }
        return answer;
    }
}
