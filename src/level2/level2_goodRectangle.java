package level2;

public class level2_goodRectangle {
    public static void main(String[] args) {
        System.out.println(new level2_goodRectangle().solution(11, 6));
        System.out.println(Long.MAX_VALUE);
    }

    public long solution(int w, int h) {
        long answer = 1;

        int length = Math.min(w, h);
        int height = Math.max(w, h);
        int remain = length;

        while (remain > 0) {
            remain = height % length;
            height = length;
            length = remain;
        }

        answer = (long) w * (long) h - height * (h / height + w / height - 1);

        return answer;
    }
}
