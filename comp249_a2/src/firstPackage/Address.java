// -----------------------------------------------------
// Part: 1
// Written by: (include your name(s) and student ID(s))
// -----------------------------------------------------
package firstPackage;


public class Address {

    /*private attributes ensure data security*/
    private String validFrom;
    private String validTo;
    private String date = "2021-3-1";//default date

    /*default constructor*/
    public Address() {
        this.validFrom = null;
        this.validTo = null;
    }
    /*parameterized constructor*/
    public Address(String validFrom, String validTo) {
        this.validFrom = validFrom;
        this.validTo = validTo;
    }
    /*copy constructor*/
    public Address(Address address) {
        this.validFrom = address.validFrom;
        this.validTo = address.validTo;
    }

    /*accessors, mutators*/
    public String getValidFrom() {
        return validFrom;
    }
    public void setValidFrom(String validFrom) {
        this.validFrom = validFrom;
    }
    public String getValidTo() {
        return validTo;
    }
    public void setValidTo(String validTo) {
        this.validTo = validTo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    /*overridden toString() method must return a clear description and information of the object*/
    @Override
    public String toString() {
        if(isObsolete()) {
            return "is valid from " + validFrom +
                    " to " + validTo + " and therefore obsolete on " + date;
        }else {
            return "is valid from " + validFrom +
                    " to " + validTo + " and therefore still usable on " + date;
        }
    }

    /*overridden equals()*/
    @Override
    public boolean equals(Object otherObject) {

        if(otherObject==null)
            return false;
        else if(getClass() != otherObject.getClass())
            return false;
        else{
            Address otherAddress = (Address)otherObject;
            return validFrom.equals(otherAddress.validFrom) && validTo.equals(otherAddress.validTo);
        }

    }
//        if (this == o) return true;//same object
//        if(o == null) return false;//passed object (to compare to) is null
//        if (!(o instanceof Address)) return false;//different type
//
//        /*Two objects are equal if all the values of all their attributes are equal*/
//        Address address = (Address) o;
//        return validFrom.equals(address.validFrom) &&
//                validTo.equals(address.validTo);
//    }

    private boolean isObsolete(){
        String [] todayStrings = date.split("-");
        String [] validFromStrings = validFrom.split("-");
        String [] validToStrings = validTo.split("-");

        /*validation of date limit ex:2020/10/10 to 2020/10/1*/
        if(obsoleteYear(validFromStrings[0],validToStrings[0])){//ex: 2020 to 2010 which is obsolete
            return true;
        }else {
            if(validFromStrings[0].equals(validToStrings[0])){//same year ex: 2020/10 to 2020/3
                if(obsoleteMonth(validFromStrings[1],validToStrings[1])){
                    return true;
                }else {
                    if(validFromStrings[1].equals(validToStrings[1])){//same month ex: 2020/10/10 to 2020/10/1
                        if(obsoleteDay(validFromStrings[2],validToStrings[2])){
                            return true;
                        }
                    }
                }
            }
        }
        /*First case: past date limit
         * ex:1998-05-21 to 2010-10-03 and today is 2021/3/1*/
        if(obsoleteYear(todayStrings[0],validToStrings[0])){ //valid from date is before today's date
            return true;
        }else {
            if(todayStrings[0].equals(validToStrings[0])){//same year ex: 2020/10 to 2020/3
                if(obsoleteMonth(todayStrings[1],validToStrings[1])){
                    return true;
                }else {
                    if(todayStrings[1].equals(validToStrings[1])){//same month ex: 2020/10/10 to 2020/10/1
                        if(obsoleteDay(todayStrings[2],validToStrings[2])){
                            return true;
                        }
                    }
                }
            }
        }
        /*Second case: future date limit
         * date limits of 2021-10-18 to 2023-4-20 and today is 2021/3/1*/
        if(obsoleteYear(validFromStrings[0],todayStrings[0])){ //valid from date is after today's date
            return true;
        }else {
            if(validFromStrings[0].equals(todayStrings[0])){//same year ex: 2020/10 to 2020/3
                if(obsoleteMonth(validFromStrings[1],todayStrings[1])){
                    return true;
                }else {
                    if(validFromStrings[1].equals(todayStrings[1])){//same month ex: 2020/10/10 to 2020/10/1
                        if(obsoleteDay(validFromStrings[2],todayStrings[2])){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }


    //validfrom > validto return true
    private boolean obsoleteYear(String year1,String year2){
        return Integer.parseInt(year1) > Integer.parseInt(year2);
    }
    private boolean obsoleteMonth(String month1,String month2){
        return Integer.parseInt(month1) > Integer.parseInt(month2);
    }
    private boolean obsoleteDay(String day1,String day2){
        return Integer.parseInt(day1) > Integer.parseInt(day2);
    }

    //overload
    public boolean isObsolete(int year,int month,int day){
        setDate((year)+ "-" + (month) + "-" + (day));
        return isObsolete();
    }
}
