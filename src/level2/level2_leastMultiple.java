package level2;

public class level2_leastMultiple {
    public static void main(String[] args) {
        System.out.println(new level2_leastMultiple().solution(new int[]{2, 6, 8, 14}));
    }

    public int solution(int[] arr) {
        int answer = 0;
        int max = 0;
        int first = arr[0];
        int idx = 0;
        int sum = 1;

        // 2 6 8 14
        while (idx < arr.length) {
            int second = arr[idx];
            sum *= arr[idx];
            int a = first > second ? first : second;
            int b = first > second ? second : first;

            int mod = b;

            while (mod != 0) {
                mod = a % b;
                a = b;
                b = mod;
            }
            first = a;
            idx++;
        }
        int divide = (int) Math.pow(first, arr.length - 1);

        answer = sum / divide;
        return answer;
    }
}
