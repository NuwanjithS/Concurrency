public class Customer {
    private String customerID;
    private String firstName;
    private String lastName;
    private String contactNo;
    private String address;
    private String nicNo;


    public Customer(String customerID, String firstName, String lastName, String contactNo, String address, String nicNo){
        supper();
        this.customerID=customerID;
        this.firstName=firstName;
        this.lastName=lastName;
        this.contactNo=contactNo;
        this.address=address;
        this.nicNo=nicNo;

    }
}
