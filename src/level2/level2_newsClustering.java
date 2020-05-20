package level2;

import java.util.*;

class level2_newsClustering {

    public int solution(String s1, String s2) {
        String str1 = s1.toLowerCase();
        String str2 = s2.toLowerCase();

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        String check = "[a-z]";
        for (int i = 0; i < str1.length() - 1; i++) {
            if (str1.substring(i, i + 1).matches(check) && str1.substring(i + 1, i + 2).matches(check)) {
                list1.add(str1.substring(i, i + 2));
            }
        }
        for (int i = 0; i < str2.length() - 1; i++) {
            if (str2.substring(i, i + 1).matches(check) && str2.substring(i + 1, i + 2).matches(check)) {
                list2.add(str2.substring(i, i + 2));
            }
        }

        if (list1.size() > list2.size()) {
            List<String> temp = list1;
            list1 = list2;
            list2 = temp;
        }

        if(list1.isEmpty() && list2.isEmpty()){
            return 65536;
        }
        int count1 = 0;
        for (String ss1 : list1) {
            for (String ss2 : list2) {
                if (ss1.equals(ss2)) {
                    list2.remove(ss1);
                    list2.add("");
                    count1++;
                    break;
                }
            }
        }

        if (count1 == 0) {
            return 0;
        }
        int count2 = list1.size() + list2.size() - count1;

        return (int) (65536 * (count1 / (double) count2));
    }

}