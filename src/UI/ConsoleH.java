package UI;

import Domain.Accommodations;
import Service.HotelAccommodationsService;

import java.util.Map;
import java.util.Scanner;

public class ConsoleH {

    private HotelAccommodationsService service;
    private Scanner scanner;

    public ConsoleH(HotelAccommodationsService service) {
        this.service = service;
        scanner = new Scanner(System.in);
    }

    private void showMenu() {
        System.out.println("1. Check in");
        System.out.println("2. Check out:");
        System.out.println("3. Afi?are camere:");
        System.out.println("a. Afisare situatie actuala cazari");
        System.out.println("x. Iesire");
    }

    public void run() {

        while (true) {
            showMenu();
            String option = scanner.nextLine();
            if (option.equals("1")) {
                handleCheckIn(); // handleServiceEntry();
            } else if (option.equals("2")) {
                handleCheckOut(); //handleServiceExit();
            } else if (option.equals("3")) {
                handleRoomsRatings();
            } else if (option.equals("a")) {
                handleShowAll();
            } else if (option.equals("x")) {
                break;
            }
        }
    }


     private void handleCheckOut() {  // private void handleServiceExit() {
        try {
            System.out.println("Dati numarul camerei:");
            int room = Integer.parseInt(scanner.nextLine());
            System.out.println("Dati feedback:");
            String feedback = scanner.nextLine();
            System.out.println("Dati ratingul:");
            int rating = Integer.parseInt(scanner.nextLine());

            service.checkOut(room, feedback, rating);
        } catch (RuntimeException runtimeException) {
            System.out.println("Avem erori: " + runtimeException.getMessage());
        }
    }


    private void handleRoomsRatings() {
        Map<Double, Integer> reports = service.getReports();
        for (Double rating : reports.keySet()) {

            System.out.println("Numar camera: " + reports.get(rating) + " rating: " + rating);
        }
    }


    private void handleShowAll() {
        for (Accommodations a : service.getAll())
            System.out.println(a);
    }

  private void  handleCheckIn() {

        try {
            System.out.println("Dati id-ul cazare:");
            int id = Integer.parseInt(scanner.nextLine());
			System.out.println("Dati numarul de persoane:"); 
			int pers = Integer.parseInt(scanner.nextLine());
			System.out.println("Dati numarul camerei:");
            int room = Integer.parseInt(scanner.nextLine());
            System.out.println("Dati numarul de zile:");
            int days = Integer.parseInt(scanner.nextLine());

            service.checkIn(id, pers, room, days);
        } catch (RuntimeException runtimeException) {
            System.out.println("Avem erori: " + runtimeException.getMessage());
        }
    }
}
