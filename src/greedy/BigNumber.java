package greedy;

import java.util.Arrays;
import java.util.Stack;

public class BigNumber {
    int startIndex;
    int startIndex2;
    int lastIndex;
    int lastIndex2;
    int tmpLast;
    boolean[] visited;

    public static void main(String[] args) {

        System.out.println(new BigNumber().solution("4177252841", 8));
    }

    public String solution(String number, int k) {
        String answer = "";
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<number.length();i++){
            char c = number.charAt(i);
            while(!stack.isEmpty() && stack.peek() < c && k-- > 0){
                stack.pop();
            }
            stack.push(c);
        }

        char[] cArr = new char[number.length()-k];
        for(int i=0;i<stack.size();i++){
            cArr[i] = stack.get(i);
        }

        answer = new String(cArr);
        return answer;
    }


    private int maxValue(int[] arr, int start, int end) {
        int max = 0;
        int maxIdx = 0;

        for (int i = start; i <= end; i++) {
            if (visited[i]) {
                continue;
            }

            if (arr[i] > max) {
                max = arr[i];
                maxIdx = i;

                if (max == 9) {
                    break;
                }
            }
        }

        return maxIdx;
    }
}
