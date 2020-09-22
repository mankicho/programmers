package level2;

public class level2_expressionInteger {
    public static void main(String[] args) {
        new level2_expressionInteger().solution(15);
    }

    public int solution(int n) {
        int answer = 0;
        int start = 1;
        int minus = 1;
        int sum = 0;
        while (start <= n+1) {
            if (sum == n) {
                answer++;
            }
            if (sum + start > n) {
                sum -= minus;
                minus++;
                continue;
            }
            sum += start;
            start++;
        }
        System.out.println("answer = " + answer);
        return answer;
    }
}
