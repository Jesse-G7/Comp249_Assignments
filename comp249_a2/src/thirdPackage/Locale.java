// -----------------------------------------------------
// Part: 1
// Written by: (include your name(s) and student ID(s))
// -----------------------------------------------------
package thirdPackage;

public class Locale {

    /*private attributes ensure data security*/
    private String two_letterCountryCode;
    private int numericCountryCode;
    private String englishLanguageCountryName;

    /*default constructor*/
    public Locale() {
        this.two_letterCountryCode = null;
        this.numericCountryCode = 0;
        this.englishLanguageCountryName = null;
    }
    /*parameterized constructor*/
    public Locale(String two_letterCountryCode, int numericCountryCode, String englishLanguageCountryName) {
        this.two_letterCountryCode = two_letterCountryCode;
        this.numericCountryCode = numericCountryCode;
        this.englishLanguageCountryName = englishLanguageCountryName;
    }
    /*copy constructor*/
    public Locale(Locale locale) {
        this.two_letterCountryCode = locale.two_letterCountryCode;
        this.numericCountryCode = locale.numericCountryCode;
        this.englishLanguageCountryName = locale.englishLanguageCountryName;
    }

    /*accessors, mutators*/
    public String getTwo_letterCountryCode() {
        return two_letterCountryCode;
    }
    public void setTwo_letterCountryCode(String two_letterCountryCode) {
        this.two_letterCountryCode = two_letterCountryCode;
    }
    public int getNumericCountryCode() {
        return numericCountryCode;
    }
    public void setNumericCountryCode(int numericCountryCode) {
        this.numericCountryCode = numericCountryCode;
    }
    public String getEnglishLanguageCountryName() {
        return englishLanguageCountryName;
    }
    public void setEnglishLanguageCountryName(String englishLanguageCountryName) {
        this.englishLanguageCountryName = englishLanguageCountryName;
    }

    /*overridden toString() method must return a clear description and information of the object*/
    @Override
    public String toString() {
        return "Locale : " +
                two_letterCountryCode +
                " " + numericCountryCode +
                " " + englishLanguageCountryName;
    }

    /*overridden equals() method*/
    @Override
    public boolean equals(Object otherObject) {

        if(otherObject==null)
            return false;
        else if(getClass() != otherObject.getClass())
            return false;
        else{
            Locale otherLocale = (Locale) otherObject;
            return  numericCountryCode == otherLocale.numericCountryCode &&
                    two_letterCountryCode.equals(otherLocale.two_letterCountryCode)&&
                    englishLanguageCountryName.equals(otherLocale.englishLanguageCountryName);
        }
//        if (this == o) return true;//same object
//        if(o == null) return false;//passed object (to compare to) is null
//        if (!(o instanceof Locale)) return false;//different type
//
//        Locale locale = (Locale) o;
//        return  numericCountryCode == locale.numericCountryCode &&
//                two_letterCountryCode.equals(locale.two_letterCountryCode) &&
//                englishLanguageCountryName.equals(locale.englishLanguageCountryName);
    }
}
