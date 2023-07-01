package AgencyDetails;

public interface gasAgency {
    public String agencyName="Sanath gas Distribution";
    public String agencyPhone="8790979727";
    public int agencyCode=144;
    default void agencyDetails()
    {
        System.out.println("                   Name of the Agency : "+agencyName);
        System.out.println("                   Agency Code : "+agencyCode);
        System.out.println("                   Agency PhoneNumber : "+agencyPhone);
    }

}
