package Homework13.WordCounter;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<String> birdName = Arrays.asList("Лазоревка", "Черный стриж", "Воробей", "Большая синица", "Свиристель", "Ласточка", "Удод", "Черный стриж", "Снигирь", "Сойка", "Ворона", "Ласточка", "Филин", "Вяхирь", "Большая выпь");

        WordCounter wordCounter = new WordCounter();
        Map<String, Integer> countWords = wordCounter.countWords(birdName);

        System.out.println("Всего птиц: " + countWords);
    }
}
