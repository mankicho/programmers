package level2;

public class level2_nextBigNumber {
    public int solution(int n) {
        int answer = n;

        int length = lengthOfOne(n);
        int number = numberOfOne(n, length);

        while (true) {
            answer++;
            int len = lengthOfOne(answer);
            int num = numberOfOne(answer, len);

            if (num == number) {
                break;
            }
        }
        return answer;
    }

    public int lengthOfOne(int n) {
        int length = 0;
        while (n >= 1) {
            length++;
            n /= 2;
        }
        return length;
    }

    public int numberOfOne(int n, int length) {
        int number = 0;
        for (int i = 0; i < length; i++) {
            if ((n & (1 << i)) != 0) {
                number++;
            }
        }
        return number;
    }

}
