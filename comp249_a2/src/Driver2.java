// -----------------------------------------------------
// Part: 2
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



public class Driver2 {

    public static Address[] copyAddresses(Address [] addresses){
        int length = addresses.length;
        Address[] copiedAddresses = new Address[length];
        for (int i = 0; i < length; i++) {
            copiedAddresses[i] = new Address(addresses[i]);//use copy constructor
        }
        return copiedAddresses;
    }

    public static void main(String[] args) {

        /*Create various objects from the 6 classes,Some of them are obsolete addresses*/
        WebPageAddress webPageAddress1 = new WebPageAddress("2021-10-18","2023-4-20","concordia","index.html");
        EmailAddress emailAddress1 = new EmailAddress("2021-10-18","2023-4-20","dave.velop","cleancode","app");
        TelecomAddress telecomAddress1 = new TelecomAddress("2019-10-18","2020-4-20","+1","(0)",208,123456,789,"mobile");
        Locale locale = new Locale("CA",124,"Canada");
        GeographicAddress geographicAddress1 = new GeographicAddress("2020-10-18","2023-4-20","123 happy street","montreal","quebec","h4a 1aa",locale);
        PostOfficeBoxAddress postOfficeBoxAddress1 = new PostOfficeBoxAddress("2020-10-18","2023-4-20","123 happy street","montreal","quebec","h1a 1aa",locale,1);
        GeneralDeliveryAddress generalDeliveryAddress1 = new GeneralDeliveryAddress("2020-10-18","2023-4-20","123 happy street","montreal","quebec","h1a 1aa",telecomAddress1);
        WebPageAddress webPageAddress2 = new WebPageAddress("2021-10-18","2023-4-20","mcgill","index.html");
        WebPageAddress webPageAddress3 = new WebPageAddress("2021-10-18","2023-4-20","concordia","index.html");
        WebPageAddress webPageAddress4 = new WebPageAddress("1991-10-18","2200-4-20","xx","index.html");
        EmailAddress emailAddress4 = new EmailAddress("2022-10-18","2023-4-20","jack.velop","cleancode","app");
        TelecomAddress telecomAddress4 = new TelecomAddress("2022-10-18","2023-4-20","+1","(0)",208,123456,789,"mobile");
        Locale locale4 = new Locale("US",840,"The United States of America");
        GeographicAddress geographicAddress4 = new GeographicAddress("2008-10-18","2023-4-20","123 happy street","montreal","quebec","h4a 1aa",locale);
        PostOfficeBoxAddress postOfficeBoxAddress4 = new PostOfficeBoxAddress("2020-10-18","2023-4-20","321 happy street","quebec","quebec","s1a 1aa",locale4,1);
        GeneralDeliveryAddress generalDeliveryAddress4 = new GeneralDeliveryAddress("2020-10-18","2023-4-20","123 sad street","quebec","quebec","s1a 1aa",telecomAddress1);
        WebPageAddress webPageAddress5 = new WebPageAddress("1991-10-18","2200-4-20","yy","index.html");


        /*Create an array of 15 to 20 these address objects and fill that array with various objects*/
        System.out.println("Create an array of 15 to 20 these address objects and copyAddressObjects() method to create a copy of that array:");
        Address [] addresses = new Address[15];
        addresses[0] = webPageAddress1;
        addresses[1] = emailAddress1;
        addresses[2] = telecomAddress1;
        addresses[3] = geographicAddress1;
        addresses[4] = postOfficeBoxAddress1;
        addresses[5] = generalDeliveryAddress1;
        addresses[6] = webPageAddress2;
        addresses[7] = webPageAddress3;
        addresses[8] = webPageAddress4;
        addresses[9] = emailAddress4;
        addresses[10] = telecomAddress4;
        addresses[11] = geographicAddress4;
        addresses[12] = postOfficeBoxAddress4;
        addresses[13] = generalDeliveryAddress4;
        addresses[14] = webPageAddress5;
        System.out.println("Original values:");
        for (int i = 0; i < addresses.length; i++) {
            System.out.println(addresses[i]);
        }
        /*call the copyAddressObjects() method to ceate a copy of that array*/
        System.out.println("Copied values:");
        Address [] copiedAddresses = copyAddresses(addresses);
        for (int i = 0; i < copiedAddresses.length; i++) {
            System.out.println(copiedAddresses[i].toString());
        }

        System.out.println();
        System.out.println("The results are not correct,because without specification of class types in their constructors, they all used their parent(base) class constructor, in this example they all uses Address's copy constructor to copy from Originals.");
    }
}
