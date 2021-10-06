import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.Calendar;

public class User {

    private String name;

    private static String dateOfBirth;

    private String email;

    private String contactNumber;

    private int age;




    public User(){}


    public User(String name, String dateOfBirth, String email, String contactNumber){
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.contactNumber =contactNumber;
        String[] split = dateOfBirth.split("\\/");
        Integer year = Integer.valueOf(split[2]);
        LocalDate now = LocalDate.now();
        int yearNow = now.getYear();

        this.age = yearNow - year;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return
                "  Name " + name +" | "+ "Contact Number "+contactNumber+"\n"+
                        "  Date of Birth " + dateOfBirth + '\n' +
                        "  Email " + email + '\n' +
                        "  Age " + age+ '\n';
    }

    public static void main(String[] args) {
        User jordanBarnes = new User("Jordan Barnes", "24/09/1995", "jordan.barnes@newcastle.ac.uk", "07123456789");
        System.out.println(jordanBarnes.toString());
    }
}