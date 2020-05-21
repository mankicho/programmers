package dynamic;

import java.util.Arrays;

public class CardGame {
    public static void main(String[] args) {
        new CardGame().solution(new int[]{1,1,1,1,3}, new int[]{2,3,1,1,1});
    }

    public int solution(int[] left, int[] right) {
        int answer = 0;
        int sum = 0;


        int l = 0, r = 0;

        while ((l < left.length && r < right.length)) {
            int leftValue = left[l]; //1
            int rightValue = right[r]; //2
            if (leftValue > rightValue) {
                System.out.println("여기");
                while (r < right.length && right[r] < leftValue) {
                    System.out.println("l = " + l + " r = " + r);
                    sum += right[r];
                    r++;
                }
            } else {
                System.out.println("저기");
                System.out.println("l : " + l + " r : " + r);
                int count = 0;

                while (l < left.length && left[l] <= rightValue) {
                    l++;
                    count++;
                }

                if (l == left.length) {
                    l = l - count + 1;
                    r++;
                }
//                System.out.println("l = " + l + ", r = " + r);
            }
        }
        System.out.println(sum);
        return sum;
    }
}