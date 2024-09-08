import java.util.*;
public class Main {
    public static void main(String[] args) {
        String[] words = {
                "apple", "banana", "apple", "orange", "banana", "grape",
                "pear", "apple", "lemon", "grape", "pear", "orange",
                "watermelon", "lemon", "orange", "kiwi", "grape", "apple"
        };
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        System.out.println("Список уникальных слов:");
        for (String word : wordCount.keySet()) {
            System.out.println(word);
        }
        System.out.println("\nВстречаемость каждого слова:");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Ivanov", "123-456");
        phoneBook.add("Petrov", "789-101");
        phoneBook.add("Ivanov", "654-321");
        phoneBook.add("Sidorov", "112-233");
        System.out.println("Телефоны Ivanov: " + phoneBook.get("Ivanov"));
        System.out.println("Телефоны Petrov: " + phoneBook.get("Petrov"));
        System.out.println("Телефоны Sidorov: " + phoneBook.get("Sidorov"));
        System.out.println("Телефоны неизвестной фамилии: " + phoneBook.get("Unknown"));
    }
}