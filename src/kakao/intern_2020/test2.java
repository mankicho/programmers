package kakao.intern_2020;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 수식 최대화
 */
public class test2 {
    public static void main(String[] args) {

        System.out.println(Math.abs(1000100010001000L));
        String expression = "50*60+70-2*10-555*912";
        System.out.println(new test2().solution(expression));
    }

    public long solution(String expression) {

        List<Character> operators = new ArrayList<>();
        List<String> numbers = new ArrayList<>();
        int idx = 0;
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (c == '*' || c == '+' || c == '-') {
                numbers.add(expression.substring(idx, i));
                operators.add(c);
                idx = i + 1;
            }
        }

        numbers.add(expression.substring(idx));

        char[] chars1 = new char[]{'*', '-', '+'};
        char[] chars2 = new char[]{'*', '+', '-'};
        char[] chars3 = new char[]{'-', '+', '*'};
        char[] chars4 = new char[]{'-', '*', '+'};
        char[] chars5 = new char[]{'+', '-', '*'};
        char[] chars6 = new char[]{'+', '*', '-'};

        LinkedList<char[]> queue = new LinkedList<>();
        queue.add(chars1);
        queue.add(chars2);
        queue.add(chars3);
        queue.add(chars4);
        queue.add(chars5);
        queue.add(chars6);

        long max = 0;
        while (!queue.isEmpty()) {
            char[] chars = queue.poll();

            List<String> tmpList2 = new ArrayList<>(numbers);
            List<Long> tmpList = tmpList2.stream().map(Long::parseLong).collect(Collectors.toList());
            List<Character> tmpCharList = new ArrayList<>(operators);
            int tmp = 0;
            for (int i = 0; i < chars.length; i++) {
                char oper = chars[i];

                Iterator<Character> characterIterator = tmpCharList.iterator();

                int iterIdx = 0;
                while (characterIterator.hasNext()) {
                    if (characterIterator.next() == oper) {
                        long value1 = tmpList.get(iterIdx);
                        long  value2 = tmpList.get(iterIdx + 1);
                        switch (oper) {
                            case '*':
                                tmpList.set(iterIdx, value1 * value2);
                                break;
                            case '-':
                                tmpList.set(iterIdx, value1 - value2);
                                break;
                            default:
                                tmpList.set(iterIdx, value1 + value2);
                                break;
                        }
                        tmpList.remove(iterIdx + 1);
                        iterIdx--;
                        characterIterator.remove();
                    }
                    iterIdx++;
                }
            }
            if (Math.abs(tmpList.get(0)) > max) {
                max = Math.abs(tmpList.get(0));
            }
        }
        return max;
    }
}