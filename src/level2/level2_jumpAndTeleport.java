package level2;

public class level2_jumpAndTeleport {
    public static void main(String[] args) {
        new level2_jumpAndTeleport().solution(10000000);
    }

    public int solution(int n) {
        int ans = 0;

        int size = getSize(n);
        for (int i = 0; i < size; i++) {
            if ((n & (1 << i)) != 0) {
                ans++;
            }
        }
        return ans;
    }

    public int getSize(int n) {
        int value = 0;
        while (n >= 1) {
            value++;
            n /= 2;
        }
        return value;
    }
}
