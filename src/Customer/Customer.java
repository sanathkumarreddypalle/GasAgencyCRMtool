package Customer;
import AgencyDetails.gasAgency;
public class Customer implements gasAgency{
    public String name;
    public String street;


    public String area;

    public String pinCode;
    public String mobile;

    public Customer(String name, String street, String area, String pinCode, String phoneNumber) {
        this.name = name;
        this.street = street;
        this.area = area;
        this.pinCode = pinCode;
        this.mobile = mobile;
    }
}
