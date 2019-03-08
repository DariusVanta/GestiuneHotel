package Domain;

public class Accommodations {
    private int id, room, pers, days; 
    private boolean isCheckOut;
    private String report;
	private String feedback;
    private int rating;

    @Override
    public String toString() {
        return "Accommodations{" +
                "id=" + id +
				", pers=" + pers +
                ", room=" + room +
                ", days=" + days +
                ", isCheckOut=" + isCheckOut +'\'' +
				", report='" + report + '\'' +
                ", rating=" + rating +
				", feedback='" + feedback + 
                '}';
    }

    public Accommodations(int id, int pers, int room, int days) {
        this.id = id;
		this.pers = pers;
        this.room = room;
        this.days = days;
        isCheckOut = false; // nu e necesar, e default
    }

    public  Accommodations(int id, int pers, int room, int days, boolean isCheckOut, String report, String feedback, int rating) {
        this.id = id;
		this.pers = pers;
        this.room = room;
        this.days = days;
        this.isCheckOut = isCheckOut;
        this.report = report;
        this.feedback = feedback;
		this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPers() {
        return pers;
    }

    public void setPers(int pers) {
        this.pers = pers;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }
	
    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }
	

    public boolean isCheckOut() {
        return isCheckOut;
    }

    public void setIsCheckOut(boolean isCheckOut) {
        this.isCheckOut = isCheckOut;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
	
    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
