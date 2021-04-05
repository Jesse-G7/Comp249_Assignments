// -----------------------------------------------------
// Part: 1
// Written by: (include your name(s) and student ID(s))
// -----------------------------------------------------
package thirdPackage;
import firstPackage.Address;
import secondPackage.TelecomAddress;


public class GeneralDeliveryAddress extends Address {

    /*private attributes ensure data security*/
    private String addressLine;
    private String city;
    private String regionOrState;
    private String zipOrPostCode;
    private TelecomAddress telecomAddress;// Composite

    /*default constructor*/
    public GeneralDeliveryAddress() {
        super();
    }
    /*parameterized constructor*/
    public GeneralDeliveryAddress(String validFrom, String validTo, String addressLine, String city, String regionOrState, String zipOrPostCode, TelecomAddress telecomAddress) {
        super(validFrom, validTo);
        this.addressLine = addressLine;
        this.city = city;
        this.regionOrState = regionOrState;
        this.zipOrPostCode = zipOrPostCode;
        this.telecomAddress = new TelecomAddress(telecomAddress);
    }
    /*copy constructor*/
    public GeneralDeliveryAddress(GeneralDeliveryAddress address) {
        super(address);
        this.addressLine = address.addressLine;
        this.city = address.city;
        this.regionOrState = address.regionOrState;
        this.zipOrPostCode = address.zipOrPostCode;
        this.telecomAddress = new TelecomAddress(address.telecomAddress);
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
    public String getZipOrPostCodeString() {
        return zipOrPostCode;
    }
    public void setZipOrPostCodeString(String zipOrPostCodeString) {
        this.zipOrPostCode = zipOrPostCodeString;
    }
    public TelecomAddress getTelecomAddress() {
        return new TelecomAddress(telecomAddress);
    }
    public void setTelecomAddress(TelecomAddress telecomAddress) {
        this.telecomAddress = new TelecomAddress(telecomAddress);
    }

    /*overridden toString() method must return a clear description and information of the object*/
    @Override
    public String toString() {
        return "This GeneralDeliveryAddress : " +
                addressLine +
                " " + city +
                " " + regionOrState +
                " " + zipOrPostCode +
                " (" + telecomAddress + ") " +
                ", " + super.toString();
    }

    /*overridden equals()*/
    @Override
    public boolean equals(Object otherObject) {


        if(otherObject==null)
            return false;
        else if(getClass()!=otherObject.getClass())
            return false;
        else{
            GeneralDeliveryAddress otherAddress = (GeneralDeliveryAddress) otherObject;
            return  this.getValidFrom().equals(otherAddress.getValidFrom())&&
                    this.getValidTo().equals(otherAddress.getValidTo())&&
                    addressLine.equals(otherAddress.addressLine) &&
                    city.equals(otherAddress.city) &&
                    regionOrState.equals(otherAddress.regionOrState) &&
                    zipOrPostCode.equals(otherAddress.zipOrPostCode) &&
                    telecomAddress.equals(otherAddress.telecomAddress);

        }
//        if (this == o) return true;//same object
//        if(o == null) return false;//passed object (to compare to) is null
//        if (!(o instanceof GeneralDeliveryAddress)) return false;//different type
//
//        /*Two objects are equal if all the values of all their attributes are equal*/
//        GeneralDeliveryAddress that = (GeneralDeliveryAddress) o;
//        return  this.getValidFrom().equals(that.getValidFrom())&&
//                this.getValidTo().equals(that.getValidTo())&&
//                addressLine.equals(that.addressLine) &&
//                city.equals(that.city) &&
//                regionOrState.equals(that.regionOrState) &&
//                zipOrPostCodeString.equals(that.zipOrPostCodeString) &&
//                telecomAddress.equals(that.telecomAddress);
    }

}
