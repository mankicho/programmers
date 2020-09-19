package level2;

import java.util.Stack;

public class level2_makeBigNumber {
    public static void main(String[] args) {
        new level2_makeBigNumber().solution("4177252841", 9);
    }

    public String solution(String number, int k) {
        String answer = "";
        Stack<Character> stack = new Stack<>();
        int index = 0;
        int length = number.length() - k;
        stack.push(number.charAt(index++));

        while (!stack.isEmpty() & k > 0 && index < number.length()) {
            if (Integer.parseInt(stack.peek() + "") < Integer.parseInt(number.charAt(index) + "")) {
                stack.pop();
                k--;
                if (stack.isEmpty()) {
                    stack.push(number.charAt(index++));
                }
            } else {
                stack.push(number.charAt(index++));
            }
        }
        if (index != number.length()) {
            for (int i = index; i < number.length(); i++) {
                stack.push(number.charAt(i));
            }
        }
        Stack<Character> tmp = new Stack<>();

        while (stack.size() > length) {
            stack.pop();
        }
        while (!stack.isEmpty()) {
            tmp.push(stack.pop());
        }
        StringBuilder sb = new StringBuilder();

        while (!tmp.isEmpty()) {
            sb.append(tmp.pop());
        }
        answer = sb.toString();
        System.out.println(answer);
        return answer;
    }
}
