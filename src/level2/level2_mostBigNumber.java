package level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Stream;

public class level2_mostBigNumber {
    public static void main(String[] args) {

        System.out.println(new level2_mostBigNumber().solution(new int[]{999, 998, 997, 979, 999, 996, 995, 994, 993, 992, 991, 990, 989, 222}));
    }

    public String solution(int[] numbers) {
        String answer = "";
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]);
        }

        list.sort((o1, o2) -> {
            String str1 = o1 + "";
            String str2 = o2 + "";

            return Integer.parseInt(str2 + str1) - Integer.parseInt(str1 + str2);
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        if(sb.charAt(0) == '0'){
            return "0";
        }

        return sb.toString();
    }
}
