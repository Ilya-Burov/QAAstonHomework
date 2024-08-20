import java.util.ArrayList;
import java.util.List;

public class Park {
    private String name;
    private List<Attraction> attractions;
    public Park(String name){
        this.name = name;
        this.attractions = new ArrayList<>();
    }
    public void addAttraction(String name, String openingHours, double price) {
        attractions.add(new Attraction(name, openingHours, price));
    }
    public void displayAttractions() {
        System.out.println("Аттракционы в парке " + name + ":");
        for (Attraction attraction : attractions){
            System.out.println(attraction);
        }
    }
    private class Attraction{
        private String name;
        private String openingHours;
        private double price;
        public Attraction(String name, String openingHours, double price) {
            this.name = name;
            this.openingHours = openingHours;
            this.price = price;
        }
        @Override
        public String toString(){
            return "Аттракцион: " + name + ", Время работы: " + openingHours + ", Стоимость: " + price + " руб.";
        }
    }
}



