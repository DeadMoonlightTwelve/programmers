import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

class Solution {
    public static int[] solution(String[] genres, int[] plays) {
        Map<String, Map<Integer, Integer>> musicMap = IntStream.range(0, genres.length)
                .boxed()
                .collect(groupingBy(i -> genres[i], toMap(i -> i, i -> plays[i])));

        return musicMap.entrySet().stream()
                .collect(toMap(Map.Entry::getKey, e -> e.getValue().values().stream().reduce(0, Integer::sum)))
                .entrySet().stream()
                .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                .flatMap(entry -> {
                    return musicMap.get(entry.getKey())
                            .entrySet().stream()
                            .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                            .limit(2);
                })
                .map(Map.Entry::getKey)
                .mapToInt(i -> i)
                .toArray();
    }
}
