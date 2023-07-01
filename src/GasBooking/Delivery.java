package GasBooking;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import Customer.*;
public class Delivery extends Booking{
    public Delivery(String customerName, String houseNumber, String streetNumber, String pinCode, String phoneNumber, int numberOfConnections) {
        super(customerName, houseNumber, streetNumber, pinCode, phoneNumber, numberOfConnections);
    }
    int customerOtp;
    public String delPersonName;
    public String delPersonMobile;


    public void amountCalc()
    {
        System.out.println("**********Amount Calculation *****************");
       long diff=dt_2.getTime()-dt_1.getTime();
       diff= TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS);
       if(diff>7)
       {
           refund=41.25;
           amount=amount-refund;
       }
        System.out.println("Final Amount is : "+amount);
    }
    public void verifyOtp()
    {
        if(status.equals("B"))
        {
            System.out.println("Please enter otp");
            customerOtp=new Scanner(System.in).nextInt();
            if(customerOtp==otp)
            {
                System.out.println("Otp Matched");
                status="D";
                System.out.println("Delivered");
            }
            else
            {
                System.out.println("Otp Not Matched");
                status="C";
                System.out.println("Cancelled");
            }

        }
        else
        {
            System.out.println("Booking Not Found !!!!!!");
        }
    }
    public void delPersonDetails()
    {
        System.out.println("Enter delivery Person Name");
        delPersonName=new Scanner(System.in).nextLine();
        //System.out.println("Enter delivery Person Number");
        //delPersonMobile=new Scanner(System.in).nextLine();
    }
}
