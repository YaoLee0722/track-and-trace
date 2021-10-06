public class Establishment {

    private String name;

    private String firstLineAddress;

    private String postCode;

    private String maxOccupancy;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstLineAddress() {
        return firstLineAddress;
    }

    public void setFirstLineAddress(String firstLineAddress) {
        this.firstLineAddress = firstLineAddress;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getMaxOccupancy() {
        return maxOccupancy;
    }

    public void setMaxOccupancy(String maxOccupancy) {
        this.maxOccupancy = maxOccupancy;
    }

    public Establishment(String name, String firstLineAddress, String postCode, String maxOccupancy) {
        this.name = name;
        this.firstLineAddress = firstLineAddress;
        this.postCode = postCode;
        this.maxOccupancy = maxOccupancy;
    }

    public Establishment(String name, String firstLineAddress, String postCode) {
        this.name = name;
        this.firstLineAddress = firstLineAddress;
        this.postCode = postCode;
    }

    public Establishment(){}

    @Override
    public String toString() {
        return "Name: " + name + '\n'
                + "Address: "+firstLineAddress +" "+ postCode+"\n";
    }

    public static void main(String[] args) {
        Establishment some_coffee_house = new Establishment("Some Coffee House", "1 King Street", "FA1 3KE", "6");
        Establishment some_coffee_house2 = new Establishment("Some Coffee House", "1 King Street", "FA1 3KE", "6");

        System.out.println(some_coffee_house.toString());
        System.out.println(some_coffee_house2.toString());
    }
}
