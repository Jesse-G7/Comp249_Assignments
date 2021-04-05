// -----------------------------------------------------
// Part: 1
// Written by: (include your name(s) and student ID(s))
// -----------------------------------------------------
package secondPackage;
import firstPackage.Address;

public class TelecomAddress extends Address {

    private String countryCode;
    private String nationalDirectDialingPrefix;
    private int areaCode;
    private long number;
    private int extension;
    private String physicalType;

    /*default constructor*/
    public TelecomAddress() {
        super();//trigger ancestor classes
    }
    /*parameterized constructor*/
    public TelecomAddress(String validFrom,String validTo,String countryCode, String nationalDirectDialingPrefix, int areaCode, long number, int extension, String physicalType) {
        super(validFrom,validTo);//trigger ancestor classes
        this.countryCode = countryCode;
        this.nationalDirectDialingPrefix = nationalDirectDialingPrefix;
        this.areaCode = areaCode;
        this.number = number;
        this.extension = extension;
        this.physicalType = physicalType;
    }
    /*copy constructor*/
    public TelecomAddress(TelecomAddress address) {
        super(address.getValidFrom(),address.getValidTo());//trigger ancestor classes
        this.countryCode = address.countryCode;
        this.nationalDirectDialingPrefix = address.nationalDirectDialingPrefix;
        this.areaCode = address.areaCode;
        this.number = address.number;
        this.extension = address.extension;
        this.physicalType = address.physicalType;
    }

    /*accessors, mutators*/
    public String getCountryCode() {
        return countryCode;
    }
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
    public String getNationalDirectDialingPrefix() {
        return nationalDirectDialingPrefix;
    }
    public void setNationalDirectDialingPrefix(String nationalDirectDialingPrefix) {
        this.nationalDirectDialingPrefix = nationalDirectDialingPrefix;
    }
    public int getAreaCode() {
        return areaCode;
    }
    public void setAreaCode(int areaCode) {
        this.areaCode = areaCode;
    }
    public long getNumber() {
        return number;
    }
    public void setNumber(long number) {
        this.number = number;
    }
    public int getExtension() {
        return extension;
    }
    public void setExtension(int extension) {
        this.extension = extension;
    }
    public String getPhysicalType() {
        return physicalType;
    }
    public void setPhysicalType(String physicalType) {
        this.physicalType = physicalType;
    }

    /*overridden toString() method must return a clear description and information of the object*/
    @Override
    public String toString() {
        return "This TelecomAddress :" +
                " " + countryCode +
                " " + nationalDirectDialingPrefix +
                " " + areaCode +
                " " + number +
                " ext. " + extension +
                " " +physicalType +
                ", " + super.toString();
    }

    /*overridden equals()*/
    @Override
    public boolean equals(Object otherOject) {
        if(otherOject==null)
            return false;
        else if(getClass() != otherOject.getClass())
            return false;
        else{
            TelecomAddress otherAddress = (TelecomAddress) otherOject;
            return  this.getValidFrom().equals(otherAddress.getValidFrom())&&
                    this.getValidTo().equals(otherAddress.getValidTo())&&
                    areaCode == otherAddress.areaCode &&
                    number == otherAddress.number &&
                    extension == otherAddress.extension &&
                    countryCode.equals(otherAddress.countryCode) &&
                    nationalDirectDialingPrefix.equals(otherAddress.nationalDirectDialingPrefix) &&
                    physicalType.equals(otherAddress.physicalType);
        }
    }
//        if (this == o) return true;//same object
//        if(o == null) return false;//passed object (to compare to) is null
//        if (!(o instanceof TelecomAddress)) return false;//different type
//
//        /*Two objects are equal if all the values of all their attributes are equal*/
//        TelecomAddress that = (TelecomAddress) o;
//        return  this.getValidFrom().equals(that.getValidFrom())&&
//                this.getValidTo().equals(that.getValidTo())&&
//                areaCode == that.areaCode &&
//                number == that.number &&
//                extension == that.extension &&
//                countryCode.equals(that.countryCode) &&
//                nationalDirectDialingPrefix.equals(that.nationalDirectDialingPrefix) &&
//                physicalType.equals(that.physicalType);
//    }

}
