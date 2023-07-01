package Main;

import java.nio.file.FileSystemNotFoundException;
import Customer.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import  Customer.Customer;
import GasBooking.*;
import AgencyDetails.*;

import static AgencyDetails.gasAgency.*;

public class Main {
    static int count,dcount,ccount,pcount,bcount;
    static  String dpname;

    public static void cylindercount(Delivery[] obj)
    {
        String[] months = new String[]{"Janvary", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        for(Delivery delivery:obj)
        {
            count=0;
            System.out.print("In the Month of "+months[delivery.dt_2.getMonth()]+"--");
            System.out.print("In the area "+delivery.area);
            if(delivery.status.equals("D"))
            {
                count+=delivery.numberOfCylinders;
            }
            System.out.print("-- "+count+"Cylinders Delivered");
        }
        System.out.println();
    }
    public static void lateDel(Delivery[] obj) {
        String[] months = new String[]{"Janvary", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        int[] month = new int[12];
        for (Delivery delivery : obj)
        {
            System.out.println("In the Month of "+months[delivery.dt_2.getMonth()]+" : ");
            System.out.println("IN "+delivery.area);
            if (delivery.status.equals("Delivered")  )
            {
                  count+=delivery.numberOfCylinders;
            }
            System.out.println("-"+count+"Delivered");
        }
        System.out.println();
    }
    /*






     */
    public static void checkLateDel(Delivery[] obj)
    {
        String[] months = new String[]{"Janvary", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        int[] month=new int[12];
        for(Delivery delivery : obj)
        {
            if(delivery.status.equals("Delivered") && delivery.amount<800 )
            {
                month[delivery.dt_2.getMonth()]++;
            }
        }
        for(int i=0;i<12;i++)
        {
            if(month[i]!=0)
            {
                System.out.println("In the month : "+months[i]+"there are : "+ month[i]+"Late Deliveres");
            }
            System.out.println();
        }
        System.out.println();
    }
    /*



    */

 public static void numberOfSingleCylinder(Delivery[] obj)
 {
     System.out.println("Number of Single Cylinder Users");
     for(int i=0;i<obj.length;i++)
     {
         if(obj[i].numberOfCylinders==1)
         {
             System.out.println("---- Customer Name--- : "+obj[i].name+" ");
             System.out.println("-----Customer Mobile Number  :  "+obj[i].mobile+" ");
             System.out.println("-----Customer Gas ID :  "+(i+101)+" ");
         }
         System.out.println();
     }
 }
 /*





  */
 public static void DeliveryDetails(Delivery[] obj){
        System.out.println("--------Delivery Details----------");
        System.out.println("Please Enter Delivery PersonName");
        dpname=new Scanner(System.in).nextLine();
        for(Delivery delivery:obj)
        {
            if(delivery.status.equals("d") && delivery.delPersonName.equals(dpname))
            {
                System.out.println("Name Of the Customer : "+delivery.name);
                System.out.println("Address of the customer   "+delivery.area+"-"+delivery.street+"-"+delivery.mobile);
            }
        }
        System.out.println();
 }
         public static void Report(Delivery[] obj)
          {
              for(int i=0;i<obj.length;i++)
              {
                  if(obj[i].status.equals(("D")))
                  {
                      dcount++;
                  }
                  else if(obj[i].status.equals(("B")))
                  {
                      bcount++;
                  }
                  else if(obj[i].status.equals(("C")))
                  {
                      ccount++;
                  }
                  else if(obj[i].status.equals("P"))
                  {
                      pcount++;
                  }
              }
              System.out.println("Booked");
              System.out.println("--- "+bcount+" Booked");
              System.out.println("Delivered");
              System.out.println("--- "+dcount+"Delivered");
              System.out.println("Pending");
              System.out.println("---- "+pcount+"Pending");
              System.out.println("Cancelled");
              System.out.println("--- "+ccount+"Cancelled");
          }
    public static void printInvoice(Delivery[] obj)
    {
        Date d=new Date();
        SimpleDateFormat sfd=new SimpleDateFormat("dd/MM/yyyy");
        String invoiceDate= sfd.format(d);
        for(int i=0;i<obj.length;i++)
        {
            if(obj[i].status.equals("D"))
            {
                System.out.println("------------------------------------------------------------------");
                System.out.println("                     !!!! INVOICE !!!!                                    ");
                System.out.println("-------------------------------------------------------------------");
                System.out.println("Gas Agency Code :  "+agencyCode+"        Date Of Invoice : "+invoiceDate);
                System.out.println("Agencyy Name  :  "+agencyName+"          Agency Phone Number  :  "+agencyPhone);
                System.out.println("Connection Number  :  "+(i+101)+"Contact Name  :  "+obj[i].name);
                System.out.println("Booking Date  :  "+sfd.format(obj[i].dt_1)+"Customer Phone Number  :  "+obj[i].mobile);
                System.out.println("-----------------------------------------------------------------");
                System.out.println("Amount = "+obj[i].amount);
                System.out.println("Refunf = "+obj[i].refund);
                long total_amount= (long) (obj[i].amount-obj[i].refund);
                System.out.println("Total Amount : "+total_amount);
                System.out.println("---------------------------------------------------------------------");
                System.out.println("Delivery Person Name  :  "+obj[i].delPersonName+"Delivery person Mobile Number : "+obj[i].delPersonMobile);
                System.out.println("Delivery Date  :  "+sfd.format(obj[i].dt_2));
                System.out.println("-----------------------------------------------------------------------------------------");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("**********************************************************************************************");
        System.out.println("                                        SUNNY GAS AGENCY                                      ");
        System.out.println("**********************************************************************************************");
        Delivery[] obj=new Delivery[5];
        obj[0]=new Delivery("Swapna","19-3-3/1","Markendeya Colony","505209","9553215244",1);
        obj[1]=new Delivery("Gopal Reddy","19-2-164/1","Ashok nagar","505209","9849838589",2);
        obj[2]=new Delivery("Sanath","103-3/2","Markendeya Coolony","505209","8790979727",1);
        obj[3]=new Delivery("Aishwarya","19-3-10/1","Ramnagar","500010","9515445282",1);
        obj[4]=new Delivery("Sai","19-3-1-2-3-4-4/1","Laxminagar","505209","9177416077",1);
    for(Delivery delivery:obj)
    {
        delivery.agencyDetails();
        delivery.delPersonDetails();
        delivery.getLastDate();
        delivery.getDate();
        if(delivery.validate()==1)
        {
            delivery.amountCalc();
        }
        delivery.verifyOtp();

    }
    printInvoice(obj);
    Report(obj);
    cylindercount(obj);
    lateDel(obj);
    DeliveryDetails(obj);
    numberOfSingleCylinder(obj);
    checkLateDel(obj);
    }
}
