package level3;

public class level3_palindrome {

    public int solution(String s) {
        System.out.println(s.length());
        int answer = 0;
        if (s.length() == 1) {
            return 1;
        }

        for (int i = 0; i < s.length() && s.length() - i > answer; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                int tmp = i;
                int tmp2 = j;
                int palin = 0;

                boolean isPalindrome = true;
                while (tmp <= tmp2) {
                    if (s.charAt(tmp) != s.charAt(tmp2)) {
                        isPalindrome = false;
                        break;
                    }

                    if (tmp == tmp2) {
                        palin++;
                    } else {
                        palin += 2;
                    }
                    tmp++;
                    tmp2--;
                }

                if (isPalindrome && palin > answer) {
                    answer = palin;
                }
            }
        }

        if (answer == 0) {
            return 1;
        }
        return answer;
    }
}
