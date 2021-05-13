import java.util.Arrays;

public class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        String[] sortedPhoneBook = Arrays.stream(phone_book).sorted(String::compareTo).toArray(String[]::new);
        for (int idx = 0; idx < sortedPhoneBook.length - 1; idx++) {
            if (sortedPhoneBook[idx + 1].startsWith(sortedPhoneBook[idx])) {
                answer = false;
                break;
            }
        }
        return answer;
    }
}
