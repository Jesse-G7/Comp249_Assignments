// -----------------------------------------------------
// Part: 1
// Written by: (include your name(s) and student ID(s))
// -----------------------------------------------------
package secondPackage;
import firstPackage.Address;

public class EmailAddress extends Address {

    /*private attributes ensure data security*/
    private String userName;
    private String domainName;
    private String TLD;
    private String dot;
    private String at;

    /*default constructor*/
    public EmailAddress() {
        super();//trigger ancestor classes
        this.dot = ".";
        this.at = "@";
    }
    /*parameterized constructor*/
    public EmailAddress(String validFrom,String validTo,String userName, String domainName, String TLD) {
        super(validFrom,validTo);//trigger ancestor classes
        this.userName = userName;
        this.domainName = domainName;
        this.TLD = TLD;
        this.dot = ".";
        this.at = "@";
    }
    /*copy constructor*/
    public EmailAddress(EmailAddress address) {
        super(address.getValidFrom(),address.getValidTo());//trigger ancestor classes
        this.userName = address.userName;
        this.domainName = address.domainName;
        this.TLD = address.TLD;
        this.dot = ".";
        this.at = "@";
    }

    /*accessors, mutators*/
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getDomainName() {
        return domainName;
    }
    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }
    public String getTLD() {
        return TLD;
    }
    public void setTLD(String TLD) {
        this.TLD = TLD;
    }

    /*overridden toString() method must return a clear description and information of the object*/
    @Override
    public String toString() {
        return "This email address: " +
                userName + at +
                domainName + dot + TLD
                + ", " + super.toString();
    }

    /*overridden equals()*/
    @Override
    public boolean equals(Object otherObject) {

        if(otherObject==null)
            return false;
        else if(getClass() != otherObject.getClass())
            return false;
        else{
            EmailAddress otherAddress = (EmailAddress) otherObject;
            return  this.getValidFrom().equals(otherAddress.getValidFrom())&&
                    this.getValidTo().equals(otherAddress.getValidTo())&&
                    userName.equals(otherAddress.userName)&&
                    domainName.equals(otherAddress.domainName)&&
                    TLD.equals(otherAddress.TLD);
        }

    }
//        if (this == o) return true;//same object
//        if(o == null) return false;//passed object (to compare to) is null
//        if (!(o instanceof EmailAddress)) return false;//different type
//
//        /*Two objects are equal if all the values of all their attributes are equal*/
//        EmailAddress that = (EmailAddress) o;
//        return  this.getValidFrom().equals(that.getValidFrom())&&
//                this.getValidTo().equals(that.getValidTo())&&
//                userName.equals(that.userName) &&
//                domainName.equals(that.domainName) &&
//                TLD.equals(that.TLD);
    }

