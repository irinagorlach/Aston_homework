package Homework13.SetOfWords;

import java.util.HashMap;
import java.util.Map;

public class SetOfWords {
    public static void main(String[] args) {
        String[] birdName = {"Лазоревка", "Черный стриж", "Воробей", "Большая синица", "Свиристель", "Ласточка", "Удод", "Черный стриж", "Снигирь", "Сойка", "Ворона", "Ласточка", "Филин", "Вяхирь", "Большая выпь"};
        Map<String, Integer> countWords = new HashMap<>();
        for (int i = 0; i < birdName.length; i++) {
            if (countWords.containsKey(birdName[i]))
                countWords.put(birdName[i], countWords.get(birdName[i]) + 1);
            else
                countWords.put(birdName[i], 1);
        }
        System.out.println("Всего птиц: " + countWords);
    }
}
