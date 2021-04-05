// -----------------------------------------------------
// Part: 1
// Written by: (include your name(s) and student ID(s))
// -----------------------------------------------------
package thirdPackage;
import firstPackage.Address;


public class PostOfficeBoxAddress extends GeographicAddress {

    /*private attributes ensure data security*/

    private int boxLobbyDoorCode;

    /*default constructor*/
    public PostOfficeBoxAddress() {
        super();
    }
    /*parameterized constructor*/
    public PostOfficeBoxAddress(String validFrom, String validTo, String addressLine, String city, String regionOrState, String zipOrPostCode, Locale locale, int boxLobbyDoorCode) {
        super(validFrom, validTo,addressLine,city,regionOrState,zipOrPostCode,locale);
        this.boxLobbyDoorCode = boxLobbyDoorCode;
    }
    /*copy constructor*/
    public PostOfficeBoxAddress(PostOfficeBoxAddress address) {
        super(address);
        this.boxLobbyDoorCode = address.boxLobbyDoorCode;
    }

    /*accessors, mutators*/
    public int getBoxLobbyDoorCode() {
        return boxLobbyDoorCode;
    }
    public void setBoxLobbyDoorCode(int boxLobbyDoorCode) {
        this.boxLobbyDoorCode = boxLobbyDoorCode;
    }

    /*overridden toString() method must return a clear description and information of the object*/
    @Override
    public String toString() {
        return "This PostOfficeBoxAddress :" +
                " " + getAddressLine() +
                " " + getCity() +
                " " + getRegionOrState() +
                " " + getZipOrPostCode() +
                " (" + getLocale().toString() + ") " +
                " " + "(box lobby door code: " + boxLobbyDoorCode +
                " )" +
                ", " + callBaseToString();
    }

    /*overridden equals()*/
    @Override
    public boolean equals(Object otherObject) {

        if(otherObject==null)
            return false;
        else if(getClass()!=otherObject.getClass())
            return false;
        else{
            PostOfficeBoxAddress otherAddress = (PostOfficeBoxAddress) otherObject;
            return  this.getValidFrom().equals(otherAddress.getValidFrom())&&
                    this.getValidTo().equals(otherAddress.getValidTo())&&
                    boxLobbyDoorCode == otherAddress.boxLobbyDoorCode &&
                    getAddressLine().equals(otherAddress.getAddressLine()) &&
                    getCity().equals(otherAddress.getCity()) &&
                    getRegionOrState().equals(otherAddress.getRegionOrState()) &&
                    getZipOrPostCode().equals(otherAddress.getZipOrPostCode()) &&
                    getLocale().equals(otherAddress.getLocale());

        }
//        if (this == o) return true;//same object
//        if(o == null) return false;//passed object (to compare to) is null
//        if (!(o instanceof PostOfficeBoxAddress)) return false;//different type
//
//        /*Two objects are equal if all the values of all their attributes are equal*/
//        PostOfficeBoxAddress that = (PostOfficeBoxAddress) o;
//        return  this.getValidFrom().equals(that.getValidFrom())&&
//                this.getValidTo().equals(that.getValidTo())&&
//                boxLobbyDoorCode == that.boxLobbyDoorCode &&
//                addressLine.equals(that.addressLine) &&
//                city.equals(that.city) &&
//                regionOrState.equals(that.regionOrState) &&
//                zipOrPostCode.equals(that.zipOrPostCode) &&
//                locale.equals(that.locale);
    }
}
