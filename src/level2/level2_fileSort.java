package level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class level2_fileSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new level2_fileSort().solution(new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2"})));
    }

    public String[] solution(String[] files) {
        String[] answer = new String[files.length];

        ArrayList<MyFile> list = new ArrayList<>();

        for (int i = 0; i < files.length; i++) {
            int index_file1 = 0;
            String file = files[i];
            StringBuilder head = new StringBuilder();
            StringBuilder number = new StringBuilder();
            StringBuilder tail = new StringBuilder();

            while (index_file1 < file.length() && !Character.isDigit(file.charAt(index_file1))) {
                head.append(file.charAt(index_file1));
                index_file1++;
            }

            while (index_file1 < file.length() && Character.isDigit(file.charAt(index_file1))) {
                number.append(file.charAt(index_file1));
                index_file1++;
            }

            while (index_file1 < file.length()) {
                tail.append(file.charAt(index_file1++));
            }

            list.add(new MyFile(head.toString(), number.toString(), tail.toString()));
        }

        list.sort(Comparator.comparing(MyFile::getHead).thenComparing(MyFile::getNumber));

        for (int i = 0; i < files.length; i++) {
            answer[i] = list.get(i).toString();
        }

        return files;
    }

    class MyFile {
        String head;
        String number;
        String tail;

        public MyFile(String head, String number, String tail) {
            this.head = head;
            this.number = number;
            this.tail = tail;
        }

        public String getHead() {
            return head.toLowerCase();
        }

        public int getNumber() {
            return Integer.parseInt(number);
        }

        public String getTail() {
            return tail;
        }

        public String toString() {
            return head + number + tail;
        }

    }

}