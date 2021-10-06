import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Controller {

    private String establishmentCSVFileURI;

    ArrayList<Establishment> establishmentArrayList = new ArrayList<>();

    ArrayList<Event> eventArrayList = new ArrayList<>();
    public Controller() {
    }

    public Controller(String establishmentCSVFileURI) {
        this.establishmentCSVFileURI = establishmentCSVFileURI;
    }

    public void readCsvFile(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(establishmentCSVFileURI));
            reader.readLine();
            String line = null;
            while((line=reader.readLine())!=null){
                String[] item = line.split(",");
                Establishment establishment = new Establishment(item[0], item[1], item[2], item[3]);
                establishmentArrayList.add(establishment);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Boolean addEvent(Event addEvent){
        for (Event event : this.eventArrayList) {
            if (addEvent.equals(event)){
                return false;
            }
        }
        eventArrayList.add(addEvent);
        return true;
    }

    public Boolean addEstablishment(Establishment addEstablishment){
        for (Establishment establishment : this.establishmentArrayList) {
            if (addEstablishment.equals(establishment)){
                return false;
            }
        }
        establishmentArrayList.add(addEstablishment);
        return true;
    }

    public ArrayList<Event> filterEventByEstablishment(String EstablishmentName){
        ArrayList<Event> list = new ArrayList<>();
        for (Event event : this.eventArrayList) {
            if(event.getEstablishment().getName().equals(EstablishmentName)){
                list.add(event);
            }
        }
        return list;
    }

    public ArrayList<Event> filterEventByDate(String date){

        String[] date1 = date.split("/");
        Integer year1 = Integer.valueOf(date1[2]);
        Integer month1 = Integer.valueOf(date1[1]);
        Integer day1 = Integer.valueOf(date1[0]);


        ArrayList<Event> list = new ArrayList<>();
        for (Event event : this.eventArrayList) {
            String eventDate = event.getEventDate();
            String[] strings = eventDate.split("/");
            Integer year = Integer.valueOf(strings[2]);
            Integer month = Integer.valueOf(strings[1]);
            Integer day = Integer.valueOf(strings[0]);
            if (((year-year1)*365+(month-month1)*30+day-day1)>0){
                list.add(event);
            }
        }
        return list;
    }

    public ArrayList<Event> filterEventByUser(String name,String email){
        ArrayList<Event> list = new ArrayList<>();
        for (Event event : this.eventArrayList) {
            User user = event.getUser();
            if (user.getEmail().equals(email)&&user.getName().equals(name)){
                list.add(event);
            }
        }
        return list;
    }





    public static void main(String[] args) {
        Controller controller = new Controller("C:\\Users\\60512\\IdeaProjects\\csc8011-track-and-trace\\src\\establishments.csv");
        controller.readCsvFile();
        for (Establishment establishment : controller.establishmentArrayList) {
            System.out.println(establishment.toString());
        }
    }
}
