// -----------------------------------------------------
// Part: 1
// Written by: (include your name(s) and student ID(s))
// -----------------------------------------------------
import firstPackage.Address;
import secondPackage.EmailAddress;
import secondPackage.TelecomAddress;
import secondPackage.WebPageAddress;
import thirdPackage.GeneralDeliveryAddress;
import thirdPackage.GeographicAddress;
import thirdPackage.Locale;
import thirdPackage.PostOfficeBoxAddress;



public class Driver1 {

    public static void main(String[] args) {

        /*Create various objects from the 6 classes,Some of them are obsolete addresses*/
        WebPageAddress webPageAddress1 = new WebPageAddress("2021-10-18","2023-4-20","concordia","index.html");
        EmailAddress emailAddress1 = new EmailAddress("2021-10-18","2023-4-20","dave.velop","cleancode","app");
        TelecomAddress telecomAddress1 = new TelecomAddress("2019-10-18","2020-4-20","+1","(0)",208,123456,789,"mobile");
        Locale locale = new Locale("CA",124,"Canada");
        GeographicAddress geographicAddress1 = new GeographicAddress("2020-10-18","2023-4-20","123 happy street","montreal","quebec","h4a 1aa",locale);
        PostOfficeBoxAddress postOfficeBoxAddress1 = new PostOfficeBoxAddress("2020-10-18","2023-4-20","123 happy street","montreal","quebec","h1a 1aa",locale,1);
        GeneralDeliveryAddress generalDeliveryAddress1 = new GeneralDeliveryAddress("2020-10-18","2023-4-20","123 happy street","montreal","quebec","h1a 1aa",telecomAddress1);

        /*display all their information by taking advantage of the toString() method*/
        System.out.println(webPageAddress1.toString());
        System.out.println(emailAddress1.toString());
        System.out.println(telecomAddress1.toString());
        System.out.println(geographicAddress1.toString());
        System.out.println(postOfficeBoxAddress1.toString());
        System.out.println(generalDeliveryAddress1.toString());
        System.out.println("\n");

        /*test equals()*/
        System.out.println("Test equals():");
        /*different types*/
        System.out.println("Different types:");
        System.out.println("(web page address: " + webPageAddress1.toString() +") is equals to email address : ("+ emailAddress1.toString() + ")? :" +webPageAddress1.equals(emailAddress1));
        /*same type,different values*/
        System.out.println("Same type,different values:");
        WebPageAddress webPageAddress2 = new WebPageAddress("2021-10-18","2023-4-20","mcgill","index.html");
        System.out.println("(web page address: " + webPageAddress1.toString() +") is equals to web page address : ("+ webPageAddress2.toString() + ")? :" +webPageAddress1.equals(webPageAddress2));
        /*same type,same values*/
        System.out.println("Same type,same values:");
        WebPageAddress webPageAddress3 = new WebPageAddress("2021-10-18","2023-4-20","concordia","index.html");
        System.out.println("(web page address: " + webPageAddress1.toString() +") is equals to web page address : ("+ webPageAddress3.toString() + ")? :" +webPageAddress1.equals(webPageAddress3));
        System.out.println("\n");

        /*Create an array of 15 to 20 these address objects and fill that array with various objects*/
        System.out.println("Create an array of 15 to 20 these address objects and Call the traceObsoleteAddresses() method to trace and display all information of all obsolete Addresses along with their location (index) in the array:");
        System.out.println("Passed date is 2022-10-1.");
        Address [] addresses = new Address[18];
        addresses[0] = webPageAddress1;
        addresses[1] = emailAddress1;
        addresses[2] = telecomAddress1;
        addresses[3] = geographicAddress1;
        addresses[4] = postOfficeBoxAddress1;
        addresses[5] = generalDeliveryAddress1;
        addresses[6] = webPageAddress2;
        addresses[7] = webPageAddress3;
        WebPageAddress webPageAddress4 = new WebPageAddress("1991-10-18","2200-4-20","xx","index.html");
        EmailAddress emailAddress4 = new EmailAddress("2022-10-18","2023-4-20","jack.velop","cleancode","app");
        TelecomAddress telecomAddress4 = new TelecomAddress("2022-10-18","2023-4-20","+1","(0)",208,123456,789,"mobile");
        Locale locale4 = new Locale("US",840,"The United States of America");
        GeographicAddress geographicAddress4 = new GeographicAddress("2008-10-18","2023-4-20","123 happy street","montreal","quebec","h4a 1aa",locale);
        PostOfficeBoxAddress postOfficeBoxAddress4 = new PostOfficeBoxAddress("2020-10-18","2023-4-20","321 happy street","quebec","quebec","s1a 1aa",locale4,1);
        GeneralDeliveryAddress generalDeliveryAddress4 = new GeneralDeliveryAddress("2020-10-18","2023-4-20","123 sad street","quebec","quebec","s1a 1aa",telecomAddress1);
        addresses[8] = webPageAddress4;
        addresses[9] = emailAddress4;
        addresses[10] = telecomAddress4;
        addresses[11] = geographicAddress4;
        addresses[12] = postOfficeBoxAddress4;
        addresses[13] = generalDeliveryAddress4;
        WebPageAddress webPageAddress5 = new WebPageAddress("1991-10-18","2200-4-20","yy","index.html");
        addresses[14] = webPageAddress5;

        /*Call the traceObsoleteAddresses() method with the array created above, along with any date*/
        traceObsoleteAddresses(addresses,2022,10,1);
    }

    public static void traceObsoleteAddresses(Address [] addresses,int year,int month,int day){
        Address address;
        int index;
        for (int i = 0; i < addresses.length; i++) {
            index = i + 1;
            if(addresses[i] == null){//empty address
                return;
            }
            address = addresses[i];
            if(address.isObsolete(year,month,day)){     //this method set date at the same time
                System.out.println("Index " + index +": "+ address.toString());
            }else {
                System.out.println("Index " + index + ": " + "this address is not obsolete");
            }
        }
    }
}
