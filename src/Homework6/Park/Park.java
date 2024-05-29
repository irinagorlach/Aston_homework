package Homework6.Park;


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

    private Attraction[] attractions;
    private int numberOfAttractions;

    public Park(int maxNumberOfAttractions) {
        attractions = new Attraction[maxNumberOfAttractions];
        int numberOfAttractions = 0;
    }

    public void addAttraction(String attractionName, String attractionWorkingHours, int attractionPrice) {
        if (numberOfAttractions < attractions.length) {
            attractions[numberOfAttractions++] = new Attraction(attractionName, attractionWorkingHours, attractionPrice);
        } else {
            System.out.println("Невозможно выполнить добавление аттракциона. В парке нет места.");
        }
    }

    public void printAttractionsInfo() {
        for (int i = 0; i < numberOfAttractions; i++) {
            System.out.println("--------------------");
            Attraction attraction = attractions[i];
            System.out.println("Название аттракциона: " + attraction.attractionName);
            System.out.println("Время работы аттракциона: " + attraction.attractionWorkingHours);
            System.out.println("Стоимость аттракциона: " + attraction.attractionPrice);
        }
    }

}
