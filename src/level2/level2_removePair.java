package level2;

import java.util.Stack;

public class level2_removePair {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            char chr = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(chr);
            } else {
                if (chr == stack.peek()) {
                    stack.pop();
                } else {
                    stack.push(chr);
                }
            }
        }

        if (stack.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }
}
