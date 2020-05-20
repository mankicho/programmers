package level2;

import java.util.Stack;

public class level2_compression {
    public String solution(String p) {

        String[] str = divide(p);
        if (str[0].equals("") && str[1].equals("")) {
            return "";
        }
        if (isRight(str[0])) {
            String result = solution(str[1]);
            return str[0] + result;
        } else {

            String r = solution(str[1]);
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            sb.append(r);
            sb.append(")");

            String sub = str[0].substring(1, str[0].length() - 1);

            for (int i = 0; i < sub.length(); i++) {
                char c = sub.charAt(i);
                if (c == '(') {
                    sb.append(")");
                } else {
                    sb.append("(");
                }
            }
            return sb.toString();
        }
    }


    public String[] divide(String p) {
        int count = 0;
        int count2 = 0;
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            if (c == '(') {
                count++;
            } else {
                count2++;
            }
            sb.append(c);

            if (count == count2) {
                index = i + 1;
                break;
            }
        }
        String u = sb.toString();
        String v = p.substring(index);

        return new String[]{u, v};
    }

    public boolean isRight(String u) {
        Stack<Character> stack = new Stack<>();

        boolean isRight = true;
        for (int i = 0; i < u.length(); i++) {
            char c = u.charAt(i);
            if (c == '(') {
                stack.add(c);
            } else {
                if (stack.size() == 0) {
                    isRight = false;
                    break;
                }
                stack.pop();
            }
        }

        return isRight;
    }
}
