package level3;

public class level3_steppingStoneCrossing {
    public static void main(String[] args) {
        System.out.println(new level3_steppingStoneCrossing().solution(new int[]{2, 4, 5, 3, 2, 1, 4, 2, 5, 1}, 3));
    }

    public int solution(int[] stones, int k) {
        int answer = 0;
        int start = 1;
        int end = 200000000;
        while (start < end) {
            int[] clones = stones.clone();
            int mid = (start + end) / 2;
            for (int i = 0; i < clones.length; i++) {
                clones[i] -= mid;
            }

            int maxLength = 0;

            for (int i = 0; i < clones.length; i++) {
                if (clones[i] <= 0) {
                    int length = 0;
                    for (int j = i; j < clones.length; j++) {
                        if (clones[j] <= 0) {
                            length++;
                        } else {
                            break;
                        }
                    }
                    if (length != 0) {
                        if (length > maxLength) {
                            maxLength = length;
                        }
                        i += length;
                    }
                }
            }

            if (maxLength >= k) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        answer = start;
        return answer;
    }
}
