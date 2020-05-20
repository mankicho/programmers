package level3;

import java.util.ArrayList;
import java.util.List;

public class level3_tile {
    public static void main(String[] args) {
        System.out.println(new level3_tile().solution(100));
    }

    public int solution(int n) {
        int a = 1;
        int b = 2;
        int c = 0;

        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }

        for (int i = 3; i <= n; i++) {
            c = (a + b) % 1000000007;
            a = b;
            b = c;
        }

        return c;
    }


}