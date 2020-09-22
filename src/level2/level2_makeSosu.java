package level2;

import java.util.Arrays;

public class level2_makeSosu {
    public static void main(String[] args) {
        new level2_makeSosu().solution(new int[]{2,2,2,2,2});
    }

    public int solution(int[] nums) {
        int answer = 0;
        Arrays.sort(nums);

        int max = nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3];
        System.out.println("max = " + max);
        int[] dp = new int[max + 1];
        for (int i = 0; i < nums.length - 2; i++) {
            int first = nums[i];
            for (int j = i + 1; j < nums.length - 1; j++) {
                int second = nums[j];
                for (int k = j + 1; k < nums.length; k++) {
                    int third = nums[k];
                    int target = first + second + third;
                    System.out.println("first = " + first + "," + "second = " + second + "," + "third = " + third + "," +
                            "target = " + target);
                    if (isSosu(target) && dp[target] == 0) {
                        dp[target] = 1;
                        answer++;
                    }
                }
            }

        }
        System.out.println("answer = " + answer);
        return answer;

    }

    boolean isSosu(int n) {
        int sqrt = (int) Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
