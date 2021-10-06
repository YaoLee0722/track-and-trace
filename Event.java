public class Event {
    private Integer id;

    private User user = null;

    private String eventDate;

    private String eventTime;

    private int partyNumber;

    private Establishment establishment = null;

    public Event(Integer id, String eventDate, String eventTime, int partyNumber) {
        this.id = id;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.partyNumber = partyNumber;
    }


    public Event(User user, String eventDate, int partyNumber, Establishment establishment) {
        this.user = user;
        this.eventDate = eventDate;
        this.partyNumber = partyNumber;
        this.establishment = establishment;
    }

    public Event(Integer id, User user, String eventDate, String eventTime, int partyNumber, Establishment establishment) {
        this.id = id;
        this.user = user;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.partyNumber = partyNumber;
        this.establishment = establishment;
    }

    public Event(User user, int partyNumber, Establishment establishment) {
        this.user = user;
        this.partyNumber = partyNumber;
        this.establishment = establishment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public int getPartyNumber() {
        return partyNumber;
    }

    public void setPartyNumber(int partyNumber) {
        this.partyNumber = partyNumber;
    }

    public Establishment getEstablishment() {
        return establishment;
    }

    public void setEstablishment(Establishment establishment) {
        this.establishment = establishment;
    }

    @Override
    public String toString() {
        return "Event ID: " + id + " | " +"Recorded User"+"\n"
                + "    Name "+user.getName()+"\n"
                + "    Date of Birth "+user.getDateOfBirth()+"\n"
                + "    Email jordan "+user.getEmail()+"\n"
                + "    Contact Number "+user.getContactNumber()+"\n"
                + "    Age "+user.getAge()+"\n"
                + " Date "+ this.eventDate+"\n"
                + " Time "+ this.eventTime+"\n"
                + " Party Size "+ this.partyNumber+"\n"
                + " Establishment"+"\n"
                + "    Name: "+establishment.getName()+"\n"
                + "    Address: "+establishment.getFirstLineAddress()+" "+establishment.getPostCode();
    }


    public static void main(String[] args) {
        User jordanBarnes = new User("Jordan Barnes", "24/09/1995", "jordan.barnes@newcastle.ac.uk", "07123456789");
        Establishment some_coffee_house = new Establishment("Some Coffee House", "1 King Street", "12");
        Event event = new Event(12, jordanBarnes, "20/06/2020", "12:00", 2, some_coffee_house);
        System.out.println(event.toString());
    }
}