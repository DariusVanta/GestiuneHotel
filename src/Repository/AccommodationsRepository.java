package Repository;

import Domain.Accommodations;
import Domain.AccommodationsValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccommodationsRepository {

    private Map<Integer, Accommodations> occupancy = new HashMap<>();

    private AccommodationsValidator validator;

    /**
     * Instantiates a repository for cars.
     * @param validator the validator used.
     */
    public AccommodationsRepository(AccommodationsValidator validator) {
        this.validator = validator;
        // low coupling, high cohesion
//        this.validator = new CarValidator();
    }

    // metode CRUD: Create, Read, Update, Delete

    /**
     * ...
     * @param accommodations
     */
    public void add(Accommodations accommodations) {
        if (occupancy.containsKey(accommodations.getId())) {
            throw new RuntimeException("An accomodation with that id already exists!");
        }

        validator.validate(accommodations);
        occupancy.put(accommodations.getId(), accommodations);
    }

    /**
     * ...
     * @param accommodations
     */
    public void update(Accommodations accommodations) {
        if (!occupancy.containsKey(accommodations.getId())) {
            throw new RuntimeException("There is no accomodation with the given id to update!");
        }

        validator.validate(accommodations);
        occupancy.put(accommodations.getId(), accommodations);
    }

    /**
     * @return a list of all cars.
     */
    public List<Accommodations> getAll() {

        return new ArrayList<>(occupancy.values());
//        return (List<Car>)storage.values();
        //return storage.values().toArray();
    }
}
