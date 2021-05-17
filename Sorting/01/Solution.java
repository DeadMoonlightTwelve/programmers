import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *  프로그래머스 - K번째 수  
 */
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        return Arrays.stream(commands)
                .mapToInt(c -> {
                    return IntStream.range(c[0] - 1, c[1])
                            .map(i -> array[i])
                            .sorted()
                            .boxed()
                            .collect(Collectors.toList())
                            .get(c[2] - 1);
                })
                .toArray();
    }
}