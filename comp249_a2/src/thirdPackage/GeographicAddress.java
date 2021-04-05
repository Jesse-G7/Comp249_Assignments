// -----------------------------------------------------
// Part: 1
// Written by: (include your name(s) and student ID(s))
// -----------------------------------------------------
package thirdPackage;
import firstPackage.Address;

public class GeographicAddress extends Address {

    /*private attributes ensure data security*/
    private String addressLine;
    private String city;
    private String regionOrState;
    private String zipOrPostCode;
    private Locale locale;

    /*default constructor*/
    public GeographicAddress() {
        super();
        this.addressLine = null;
        this.city = null;
        this.regionOrState = null;
        this.zipOrPostCode = null;
        this.locale = null;
    }
    /*parameterized constructor*/
    public GeographicAddress(String validFrom, String validTo, String addressLine, String city, String regionOrState, String zipOrPostCode, Locale locale) {
        super(validFrom, validTo);
        this.addressLine = addressLine;
        this.city = city;
        this.regionOrState = regionOrState;
        this.zipOrPostCode = zipOrPostCode;
        this.locale = new Locale(locale);    //point to a copy with different address
    }
    /*copy constructor*/
    public GeographicAddress(GeographicAddress address) {
        super(address);
        this.addressLine = address.addressLine;
        this.city = address.city;
        this.regionOrState = address.regionOrState;
        this.zipOrPostCode = address.zipOrPostCode;
        this.locale = new Locale(address.locale);
    }

    /*accessors, mutators*/
    public String getAddressLine() {
        return addressLine;
    }
    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getRegionOrState() {
        return regionOrState;
    }
    public void setRegionOrState(String regionOrState) {
        this.regionOrState = regionOrState;
    }
    public String getZipOrPostCode() {
        return zipOrPostCode;
    }
    public void setZipOrPostCode(String zipOrPostCode) {
        this.zipOrPostCode = zipOrPostCode;
    }
    public Locale getLocale() {
        return new Locale(locale);
    }
    public void setLocale(Locale locale) {
        this.locale = new Locale(locale);
    }

    /*overridden toString() method must return a clear description and information of the object*/
    @Override
    public String toString() {
        return "This GeographicAddress " +
                addressLine +
                " " + city +
                " " + regionOrState +
                " " + zipOrPostCode +
                " (" + locale.toString() + ") " +
                ", " + super.toString();
    }

    /* used for child class to call base toString method */
    protected String callBaseToString(){
        return super.toString();
    }


    /*overridden equals()*/
    @Override
    public boolean equals(Object otherObject) {

        if(otherObject==null)
            return false;
        else if(getClass()!=otherObject.getClass())
            return false;
        else{
            GeographicAddress otherAddress = (GeographicAddress) otherObject;
            return this.getValidFrom().equals(otherAddress.getValidFrom())&&
                    this.getValidTo().equals(otherAddress.getValidTo())&&
                    addressLine.equals(otherAddress.addressLine)&&
                    city.equals(otherAddress.city)&&
                    regionOrState.equals(otherAddress.regionOrState)&&
                    zipOrPostCode.equals(otherAddress.regionOrState)&&
                    locale.equals(otherAddress.locale);
        }
//        if (this == o) return true;//same object
//        if(o == null) return false;//passed object (to compare to) is null
//        if (!(o instanceof GeographicAddress)) return false;//different type
//
//        /*Two objects are equal if all the values of all their attributes are equal*/
//        GeographicAddress that = (GeographicAddress) o;
//        return  this.getValidFrom().equals(that.getValidFrom())&&
//                this.getValidTo().equals(that.getValidTo())&&
//                addressLine.equals(that.addressLine) &&
//                city.equals(that.city) &&
//                regionOrState.equals(that.regionOrState) &&
//                zipOrPostCode.equals(that.zipOrPostCode) &&
//                locale.equals(that.locale);
    }

}
