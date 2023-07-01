package GasBooking;

import Customer.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Booking extends gasConnection{
    public double otp=5678, amount=825,refund=0.0;;

  public  String dt,delDate,status,Mobilenumber="970123471";
     public Date dt_1,dt_2;
    public void getDate()
        {
            System.out.println("Enter Booking Date");
        dt=new Scanner(System.in).nextLine();
        SimpleDateFormat DateFormate=new SimpleDateFormat("dd/MM/yyyy");
        try {
            dt_1 = DateFormate.parse(dt);
        }
        catch(Exception e)
        {
            System.out.println("Error in this block"+e);
        }
        System.out.println("Enter Delivery Date");
        delDate=new Scanner(System.in).nextLine();
        try
        {
            dt_2=DateFormate.parse(delDate);
        }
        catch(Exception e)
        {
            System.out.println("Error is in dt_2 block"+e);
        }
        try
        {
            long diff=dt_2.getTime()-dt_1.getTime();
            long newDiff=TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
            if(newDiff>7)
            {
                status="P";
            }
        }
        catch(Exception e)
            {
                System.out.println("Error in the finding Difference"+e);
            }

    }
    public Booking(String customerName, String houseNumber, String streetNumber, String pinCode, String phoneNumber, int numberOfConnections) {
        super(customerName, houseNumber, streetNumber, pinCode, phoneNumber, numberOfConnections);

    }
    public int  validate()
    {
        long diff=dt_1.getTime()-lastDate.getTime();
        diff=TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS);
        if(numberOfCylinders==1)
        {
            if(diff<30)
            {
                System.out.println("Not Elligigble gor Booking");
                status = "C";
                return 0;
            }
            else {
                status="B";
                lastDate=dt_1;
                return 1;
            }
        }
       else  if(numberOfCylinders==2)
        {
            if(diff<50)
            {
                System.out.println("Not Elligible for Booking");
                status="C";
                return 0;
            }
            else
            {
                status="B";
                lastDate=dt_1;
                return 1;
            }

        }
      return 0;
    }
}
