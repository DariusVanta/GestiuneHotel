/**
Check in:
Numărul camerei trebuie să fie al unei camere în care nu mai este nimeni cazat. 
Numărul de zile trebuie să fie strict pozitiv.
ID-ultrebuie să fie unic

Check out:
Numărul de cameră trebuie să existe, 
feedback-ul este un string nenul, 
iar rating-ul este întreg între 1 și 5.

**/


package Domain;

public class AccommodationsValidator {

    /**
     * Validates a accommodations.
     * @param accommodations the accommodations to validate.
     * @throws RuntimeException if there are validation errors.
     */
    public void validate(Accommodations accommodations) {

        if (accommodations.getDays() <= 0) {
            throw new RuntimeException("The number of days cannot be 0 or negative!");
        }
		
		//if (accommodations.getId() <= 0) {  //occupancy.containsKey(accommodations.getId())
			
		/* o functie care sa verifice daca este 
        Accommodations accommodations = new Accommodations(id, pers, room, days);
        List<Accommodations> accommodations = repository.getAll();
        for (Accommodations a : accommodations) {
            if (a.getRoom() == room && !a.isCheckOut()) {
                throw new RuntimeException("That room is already taken!");
            }
        }
		*/
        //    throw new RuntimeException("The Id Should be Unique!");
   //     }
		
		if (accommodations.isCheckOut() && accommodations.getRoom() <= 0 && accommodations.getRoom() >= 100) {
            throw new RuntimeException("The number of room is not belongs to our hotel!");
        }
		
	    if (accommodations.isCheckOut() && accommodations.getFeedback() == null) {
            throw new RuntimeException("Should be inserted a feedback!");
        }		
		
		if (accommodations.isCheckOut() && accommodations.getRating() <= 0 && accommodations.getRating() >= 5) {
            throw new RuntimeException("The number of room is not belongs to our hotel!");
        }

    }
}
