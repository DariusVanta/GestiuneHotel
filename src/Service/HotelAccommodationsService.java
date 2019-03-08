package Service;

import Domain.Accommodations;
import Repository.AccommodationsRepository;

import java.util.*;

public class HotelAccommodationsService {

    private AccommodationsRepository repository;

    /**
     * ...
     *
     * @param repository
     */
    public HotelAccommodationsService(AccommodationsRepository repository) {
        this.repository = repository;
    }

    /**
     * ...
     *
     * @param id
     * @param pers
     * @param room
     * @param days
     */
    public void checkIn(int id, int pers, int room, int days) {

        Accommodations accommodation = new Accommodations(id, pers, room, days);
        List<Accommodations> accommodations = repository.getAll();
        for (Accommodations a : accommodations) {
            if (a.getRoom() == room && !a.isCheckOut()) {
                throw new RuntimeException("That room is already taken!");
            }
        }
        repository.add(accommodation);
    }

    /**
     * @param room
     * @param feedback
     * @param rating
     */
    public void checkOut(int room, String feedback, int rating) {
        Accommodations accommodationsOnRoom = null;
        List<Accommodations> accommodations = repository.getAll();
        for (Accommodations a : accommodations) {
            if (a.getRoom() == room && !a.isCheckOut()) {
                accommodationsOnRoom = a;
            }
        }

        if (accommodationsOnRoom != null) {
            accommodationsOnRoom.setFeedback(feedback);
            accommodationsOnRoom.setRating(rating);
            accommodationsOnRoom.setIsCheckOut(true);
            repository.update(accommodationsOnRoom);
        } else {
            throw new RuntimeException("There is nobody accomodate on the given room!");
        }
    }

    public List<Accommodations> getAll() {
        return repository.getAll();
    }

    public Set<Integer> getAllRooms() {
        Set<Integer> room = new HashSet<>();
        List<Accommodations> accommodationList = getAll();
        for (Accommodations accommodation : accommodationList) {
            room.add(accommodation.getRoom());
        }
        return room;
    }

    public List<Integer> getAllByRoom(int room) {
        List<Integer> rating = new ArrayList<>();

        for (Accommodations accommodations : getAll()) {
            if (accommodations.getRoom() == room) {
                rating.add(accommodations.getRating());
            }
        }
        return rating;
    }

    public Double getAverage(List<Integer> ratings) {

        double sum = 0;
        for (Integer rating : ratings) {
            sum += rating;
        }
        return sum / ratings.size();
    }

    public Map<Double, Integer> getReports() {
        Map<Double, Integer> reports = new HashMap<>();
        for (Integer room : getAllRooms()) {
            List<Integer> rating = getAllByRoom(room);
            Double average = getAverage(rating);
            reports.put(average, room);
        }
        Map<Double, Integer> descReports = new TreeMap<>(new Comparator<Double>() {
            @Override
            public int compare(Double rating1, Double rating2) {
                return rating2.compareTo(rating1);
            }
        });
        descReports.putAll(reports);
        return reports;
    }

}
