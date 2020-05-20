package greedy;

import java.util.Arrays;

public class PhyCloth {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] arr = new int[n+2];

        Arrays.sort(lost);
        Arrays.sort(reserve);
        for (int i = 1; i < arr.length - 1; i++) {
            arr[i] = 1;
        }

        for (int i = 0; i < reserve.length; i++) {
            arr[reserve[i]] = 2;
        }

        for (int i = 0; i < lost.length; i++) {
            arr[lost[i]]--;
        }
        for (int i = 0; i < lost.length; i++) {
            int k = lost[i];
            if (arr[k] == 0 && arr[k - 1] == 2) {
                arr[k]++;
                arr[k - 1]--;
            } else if (arr[k] == 0 && arr[k + 1] == 2) {
                arr[k]++;
                arr[k + 1]--;
            }
        }

        for(int i=0;i<arr.length;i++){
            if(arr[i] == 1){
                answer++;
            }
        }
        return answer;
    }
}
