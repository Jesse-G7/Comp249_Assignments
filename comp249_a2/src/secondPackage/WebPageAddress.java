// -----------------------------------------------------
// Part: 1
// Written by: (include your name(s) and student ID(s))
// -----------------------------------------------------
package secondPackage;
import firstPackage.Address;

public class WebPageAddress extends Address {

    /*private attributes ensure data security*/
    private String www;
    private String dot;
    private String domainName;
    private String slash;
    private String resourceName;

    /*default constructor*/
    public WebPageAddress() {
        super();  //trigger default constructor in base class
        this.dot = ".";
        this.slash = "/";
        this.www = "www";
        this.domainName = "domainName";
        this.resourceName = "resourceName(optional)";
    }
    /*parameterized constructor*/
    public WebPageAddress(String validFrom,String validTo,String domainName, String resourceName) {
        super(validFrom,validTo);
        this.dot = ".";
        this.slash = "/";
        this.www = "www";
        this.domainName = domainName;
        this.resourceName = resourceName;
    }
    /*copy constructor*/
    /* ************** */
    public WebPageAddress(WebPageAddress address) {
        super(address.getValidFrom(),address.getValidTo());
        this.dot = ".";
        this.slash = "/";
        this.www = "www";
        this.domainName = address.domainName;
        this.resourceName = address.resourceName;
    }

    /*accessors, mutators*/
    public String getDomainName() {
        return domainName;
    }
    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }
    public String getResourceName() {
        return resourceName;
    }
    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    /*overridden toString() method must return a clear description and information of the object*/
    @Override
    public String toString() {
        return "This WebPageAddress : " +
                www +
                dot +
                domainName +
                slash +
                resourceName +
                ", " + super.toString();
    }

    /*overridden equals()*/
    @Override
    public boolean equals(Object otherObject) {
        if(otherObject==null)
            return false;
        else if(getClass() != otherObject.getClass())
            return false;
        else{
            WebPageAddress otherAddress = (WebPageAddress) otherObject;
            return  this.getValidFrom().equals(otherAddress.getValidFrom())&&
                    this.getValidTo().equals(otherAddress.getValidTo())&&
                    domainName.equals(otherAddress.domainName) &&
                    resourceName.equals(otherAddress.resourceName);
        }
//        if (this == o) return true;//same object
//        if(o == null) return false;//passed object (to compare to) is null
//        if (!(o instanceof WebPageAddress)) return false;//different type

        /*Two objects are equal if all the values of all their attributes are equal*/
//        WebPageAddress that = (WebPageAddress) o;
//        return  this.getValidFrom().equals(that.getValidFrom())&&
//                this.getValidTo().equals(that.getValidTo())&&
//                domainName.equals(that.domainName) &&
//                resourceName.equals(that.resourceName);
    }

}
