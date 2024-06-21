package Homework13.WordCounter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordCounter {
    public Map<String, Integer> countWords(List<String> words) {
        Map<String, Integer> countWords = new HashMap<>();

        for (String word : words) {
            if (countWords.containsKey(word)) {
                countWords.put(word, countWords.get(word) + 1);
            } else {
                countWords.put(word, 1);
            }
        }
        return countWords;
    }
}
