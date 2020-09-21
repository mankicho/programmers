package level2;

import java.util.Arrays;

public class level2_jadenCase {
    public static void main(String[] args) {
        char chr = '2';
        char chr1 = 'd';

        System.out.println(new level2_jadenCase().solution("3people unFollowed me"));
        System.out.println(new level2_jadenCase().solution("for the last week"));
    }

    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        boolean isFirstCharacter = true;

        for (int i = 0; i < s.length(); i++) {
            char chr = s.charAt(i);
            if (chr == ' ') {
                sb.append(chr);
                isFirstCharacter = true;
            } else {
                if (isFirstCharacter) {
                    sb.append(Character.toUpperCase(chr));
                    isFirstCharacter = false;
                } else {
                    sb.append(Character.toLowerCase(chr));
                }
            }
        }
        answer = sb.toString();
        return answer;
    }
}
