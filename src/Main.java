import Domain.AccommodationsValidator;
import Repository.AccommodationsRepository;
import Service.HotelAccommodationsService;
import UI.ConsoleH;

public class Main {

    public static void main(String[] args) {
        AccommodationsValidator validator = new AccommodationsValidator();
        AccommodationsRepository repository = new AccommodationsRepository(validator);
        HotelAccommodationsService service = new HotelAccommodationsService(repository);
        ConsoleH console = new ConsoleH(service);
        console.run();
    }
}