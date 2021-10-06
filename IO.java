import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class IO {

    private Controller controller = new Controller();

    public Boolean solid = true;

    public String getInput(){
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        return text;
    }

    public String input(){
        System.out.println(
                "1. Record and Event"+"\n"
                        +"2. Add Establishment"+"\n"
                        +"3. Filters ---->"+"\n"
                        +"     3.1. Records by Establishment"+"\n"
                        +"     3.2. Records by Date"+"\n"
                        +"     3.3. Records by Name"+"\n"
                        +"     3.4. Go Back"+"\n"
                        +"4. Print Events"+"\n"
                        +"5. Print Establishments"+"\n"
                        +"6. Exit the program"+"\n"
                        +"7. FilterEventByEstablishment"+"\n"
                        +"8. FilterEventByDate"+"\n"
                        +"9. FilterEventByUser"+"\n"
        );
        String input = this.getInput();
        return input;
    }

    public void HandleScan(String text){

        switch (text){
            case "1":{
                System.out.println("please input Event");

                System.out.println("Event ID:");
                String EventID = this.getInput();
                Integer eventID = Integer.valueOf(EventID);

                System.out.println("eventDate:");
                String eventDate = this.getInput();

                System.out.println("eventTime:");
                String eventTime = this.getInput();

                System.out.println("partyNumber:");
                String partyNumberString = this.getInput();
                Integer partyNumber = Integer.valueOf(partyNumberString);

                System.out.println("Username:");
                String userName = this.getInput();

                System.out.println("dateOfBirth:");
                String dateOfBirth = this.getInput();

                String[] date = dateOfBirth.split("/");

                Integer year = Integer.valueOf(date[2]);
                Integer month = Integer.valueOf(date[1]);
                Integer day = Integer.valueOf(date[0]);

                String timeStr1= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));



                String[] now = timeStr1.split("-");
                Integer nowYear = Integer.valueOf(now[0]);
                Integer nowMonth = Integer.valueOf(now[1]);
                Integer nowDay = Integer.valueOf(now[2]);

                int i = (nowYear - year) * 365 + (nowMonth - month) * 30 + nowDay - day;
                if (i<0){
                    System.out.println("your input dateOfBirth is wrong ,you can try again");
                    System.out.println("will return the top you can check check");
                    return;
                }




                System.out.println("email:");
                String email = this.getInput();
                String format = "\\p{Alpha}\\w{2,15}[@][a-z0-9]{3,}[.]\\p{Lower}{2,}";
                if (!email.matches(format)){
                    System.out.println("your input e-mail is wrong !!!");
                    System.out.println("will return the top you can check check");
                    return;
                }

                System.out.println("contactNumber:");
                String contactNumberString = this.getInput();
                if (contactNumberString.length()!=11){
                    System.out.println("your input contactNumber is not right");
                    System.out.println("will return the top you can check check");
                    return;
                }
                Integer contactNumber = Integer.valueOf(contactNumberString);

                System.out.println("name:");
                String name = this.getInput();

                System.out.println("firstLineAddress:");
                String firstLineAddress = this.getInput();

                System.out.println("postCode:");
                String postCode = this.getInput();

                System.out.println("maxOccupancy:");
                String maxOccupancy = this.getInput();

                Establishment establishment = new Establishment(name, firstLineAddress, postCode, maxOccupancy);
                User user = new User();
                Event event = new Event(eventID, eventDate, eventTime, partyNumber);
                event.setUser(user);
                event.setEstablishment(establishment);
                controller.eventArrayList.add(event);
                controller.establishmentArrayList.add(establishment);
                System.out.println("OK,will return top menu");
            }
            case "2":{System.out.println("please input Establishment:");

                System.out.println("name:");
                String name = this.getInput();

                System.out.println("firstLineAddress:");
                String firstLineAddress = this.getInput();

                System.out.println("postCode:");
                String postCode = this.getInput();

                System.out.println("maxOccupancy:");
                String maxOccupancy = this.getInput();

                Establishment establishment = new Establishment(name, firstLineAddress, postCode, maxOccupancy);
                controller.establishmentArrayList.add(establishment);
                System.out.println("OK,will return top menu");}
            case "3.1":{ controller.eventArrayList.sort(Comparator.comparing(o -> o.getEstablishment().getName()));
                for (Event event : controller.eventArrayList) {
                    System.out.println(event.toString());
                }

                System.out.println("OK,will return top menu");}
            case "3.2":{ controller.eventArrayList.sort((o1, o2) -> {
                String[] strings = o1.getEventDate().split("/");
                Integer year = Integer.valueOf(strings[2]);
                Integer month = Integer.valueOf(strings[1]);
                Integer day = Integer.valueOf(strings[0]);
                Integer result = (year - 2000) * 365 + month * 30 + day;
                String[] strings1 = o2.getEventDate().split("/");
                Integer year1 = Integer.valueOf(strings1[2]);
                Integer month1 = Integer.valueOf(strings1[1]);
                Integer day1 = Integer.valueOf(strings1[0]);
                Integer result1 = (year1 - 2000) * 365 + month1 * 30 + day1;
                return result - result1;
            });
                for (Event event : controller.eventArrayList) {
                    System.out.println(event.toString());
                }

                System.out.println("OK,will return top menu");}
            case "3.3":{   controller.eventArrayList.sort(Comparator.comparing(Event::getId));
                for (Event event : controller.eventArrayList) {
                    System.out.println(event.toString());
                }

                System.out.println("OK,will return top menu");
            }
            case "3.4":{}
            case "4":{ for (Event event : controller.eventArrayList) {
                System.out.println(event.toString());
            }

                System.out.println("**********");
                System.out.println("finish");
                System.out.println("**********");
            }
            case "5":{  for (Establishment establishment : controller.establishmentArrayList) {
                System.out.println(establishment.toString());
            }
                System.out.println("**********");
                System.out.println("finish");
                System.out.println("**********");}
            case "6":{this.solid = false;}

            case "7":{  System.out.println("input EstablishmentName");
                String EstablishmentName = this.getInput();
                ArrayList<Event> event = controller.filterEventByEstablishment(EstablishmentName);
                for (Event event1 : event) {
                    System.out.println(event1.toString());
                }
                System.out.println("**********");
                System.out.println("finish");
                System.out.println("**********");}
            case "8":{ System.out.println("input Date");
                String Date = this.getInput();
                ArrayList<Event> event = controller.filterEventByDate(Date);
                for (Event event1 : event) {
                    System.out.println(event1.toString());
                }
                System.out.println("**********");
                System.out.println("finish");
                System.out.println("**********");}
            case "9":{    System.out.println("input name");
                String name = this.getInput();
                System.out.println("input email");
                String email = this.getInput();

                ArrayList<Event> events = controller.filterEventByUser(name, email);
                for (Event event : events) {
                    System.out.println(event.toString());
                }
                System.out.println("**********");
                System.out.println("finish");
                System.out.println("**********");}

            break;
            default:
                throw new IllegalStateException("Unexpected value: " + text);
        }
    }



    public static void main(String[] args) {
        IO io = new IO();
        while (io.solid){
            String input = io.input();
            io.HandleScan(input);
        }
    }
}