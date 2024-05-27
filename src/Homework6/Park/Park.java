package Homework6.Park;

import java.util.ArrayList;
import java.util.List;


public class Park {

    public class Attraction {
        private String attractionName;
        private String attractionWorkingHours;
        private int attractionPrice;

        public Attraction(String attractionName, String attractionWorkingHours, int attractionPrice) {
            this.attractionName = attractionName;
            this.attractionWorkingHours = attractionWorkingHours;
            this.attractionPrice = attractionPrice;
        }
    }

    private List<Attraction> attractions;
    private int maxNumberOfAttractions;

    public Park(int maxNumberOfAttractions) {
        this.attractions = new ArrayList<>();
        this.maxNumberOfAttractions = maxNumberOfAttractions;
    }

    public void addAttraction(String attractionName, String attractionWorkingHours, int attractionPrice) {
        if (attractions.size() < maxNumberOfAttractions) {
            Attraction attraction = new Attraction(attractionName, attractionWorkingHours, attractionPrice);
            attractions.add(attraction);
        } else {
            System.out.println("Невозможно выполнить добавление аттракциона. В парке нет места.");
        }
    }

    public void printAttractionsInfo() {
        for (int i = 0; i < attractions.size(); i++) {
            System.out.println("--------------------");
            Attraction attraction = attractions.get(i);
            System.out.println("Название аттракциона: " + attraction.attractionName);
            System.out.println("Время работы аттракциона: " + attraction.attractionWorkingHours);
            System.out.println("Стоимость аттракциона: " + attraction.attractionPrice);
        }
    }
}
