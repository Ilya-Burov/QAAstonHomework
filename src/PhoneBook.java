import java.util.*;
public class PhoneBook {
    private Map<String, List<String>> phoneBook;
    public PhoneBook() {
        phoneBook = new HashMap<>();
    }
    public void add(String lastName, String phoneNumber) {
        phoneBook.computeIfAbsent(lastName, k -> new ArrayList<>()).add(phoneNumber);
    }
    public List<String> get(String lastName) {
        return phoneBook.getOrDefault(lastName, Collections.emptyList());
    }
}