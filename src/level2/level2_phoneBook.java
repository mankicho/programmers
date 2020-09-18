package level2;

public class level2_phoneBook {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        for (int i = 0; i < phone_book.length; i++) {
            String str = phone_book[i];
            for (int j = 0; j < phone_book.length; j++) {
                if (i == j) {
                    continue;
                }
                if (phone_book[j].startsWith(str)) {
                    return false;
                }
            }
        }
        return answer;
    }
}
