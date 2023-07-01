package Customer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class gasConnection extends Customer{
  public  int numberOfCylinders;

    static int connectionNumber=100;
    {
        connectionNumber+=1;
    }

    public  String date;
    public Date lastDate=null;
 SimpleDateFormat dateFormate=new SimpleDateFormat( "dd/MM/yyyy" );

    public gasConnection(String customerName, String houseNumber, String streetNumber, String pinCode, String phoneNumber, int numberOfConnections) {
        super(customerName, houseNumber, streetNumber, pinCode, phoneNumber);
        this.numberOfCylinders = numberOfConnections;
    }

    public void getLastDate() {
        System.out.println("Please Enter Your Last Booking Date");
        date=new Scanner(System.in).nextLine();
        try
        {
            lastDate= (dateFormate.parse(date));
        }
        catch (Exception e)
        {
            System.out.println("Error is in this Block"+e);
        }
    }
}
