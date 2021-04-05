import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String file1 = "Car Maintenance Record.csv";
        String file8 = "Car Maintenance Record.txt";
        String file3 = "Car Maintenance Record.xlsx";

        String file2 = "Car Rental Record.csv";
        String file4 = "Car Rental Record.txt";

        String file5 = "Car Rental Record no DrivLic.csv";
        String file6 = "Car Rental Record no DrivLic.txt";

        String file7 = "Car Rental Record no plate.csv";
        String file9 = "Car Rental Record no plate.txt";



        String logFile = "log.txt";

        File[] files = {new File(file2),new File(file4),new File(file6)};
        Scanner[] sc = new Scanner[files.length];
        PrintWriter[] pw = new PrintWriter[files.length];
        PrintWriter logPw = null;
        String[] jsonFileNames = new String[files.length];


        for (int i = 0; i < files.length; i++) {
            jsonFileNames[i] = processFilesForValidation(sc[i], pw[i], logPw, files[i],logFile);
        }

        Scanner keyIn = new Scanner(System.in);
        System.out.print("Please enter the name of one of the created output files to display: ");
        String fileName = keyIn.nextLine();

        try{
            findMatchingFile(fileName,jsonFileNames);
        } catch (FileNotFoundException e){
            System.out.print("File invalid. You are given a last chance to enter the correct name of one of the created output files to display: ");
            fileName = keyIn.nextLine();
            try{
                findMatchingFile(fileName,jsonFileNames);
            }catch (FileNotFoundException e2){
                keyIn.close();
                System.out.println("You have exhausted your last chance to enter a valid file name. Program will exit.");
                System.exit(0);
            }
        }

        keyIn.close();

        try{
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String text = br.readLine();
            while(text!=null){
                System.out.println(text);
                text = br.readLine();
            }
        }catch (FileNotFoundException e){
            System.out.println("Problem opening "+fileName+" file.");

        }catch (IOException e){
            System.out.println("An error has occurred while reading from "+fileName+" file.");
        }

    }


    public static void findMatchingFile(String fileName,String[] jsonFileNames)throws FileNotFoundException {
        for (int i = 0; i < jsonFileNames.length; i++) {
            if (jsonFileNames[i].equals(fileName))
                break;
            else if (i == (jsonFileNames.length - 1))
                throw new FileNotFoundException();
        }
    }




    public static String processFilesForValidation(Scanner sc,PrintWriter pw,PrintWriter logPw,File file,String logFile) {

        try {
            sc = new Scanner(new FileInputStream(file.getName()));
        }catch (FileNotFoundException e){
            System.out.println("Could not open input file "+file.getName()+" for reading. Please check if file exists! " +
                    "Program will terminate after closing any opened files.");
            sc.close();
            System.exit(0);
        }

        String[] attributes = sc.nextLine().split(",");
        int missingCount = 0;
        //count the missing filed of attributes
        for(String attribute : attributes){
            if(attribute.equals(""))
                missingCount++;
        }

        String data[];
        int lineCount = 0;
        String missingDataField = null;
        String jsonFile = file.getName().replaceAll("\\s","");
        jsonFile = jsonFile.substring(0,jsonFile.indexOf("."))+".json";

        try {
            pw = new PrintWriter(new FileOutputStream(jsonFile));
            try {
                logPw = new PrintWriter(new FileOutputStream(logFile,true));
            }catch (FileNotFoundException e){
                //log file can not be created
                System.out.println("Log file can not be created. Program will exit");
                System.exit(0);
            }
            pw.println("[");

            while (sc.hasNextLine()) {
                String replaced = sc.nextLine().replace("\"","").replace(", ",".");
                data = replaced.split(",");

                lineCount++; //for log file

                pw.println("{");

                for(int i=0;i< attributes.length;i++) {
                    try{
                        if (attributes[i].equals(""))
                            throw new CSVFileInvalidException();
                        else if(data[i].equals("")) {
                            missingDataField = attributes[i];     //find the corresponding field for the missing data
                            throw new CSVDataMissing();
                        }
                    }catch (CSVFileInvalidException e){
                        //user message
                        System.out.println("File "+file.getName()+" is invalid: filed is missing.\n" +
                                "File is not converted to JSON.");
                        //write to log file
                        logPw.println("File "+file.getName()+" is invalid.\n" +
                                "Missing filed: "+(attributes.length-missingCount)+" detected, "+missingCount+" missing.");
                        for(int j=0;j<attributes.length;j++){
                            if(attributes[j].equals("")){
                                logPw.print("***");
                            }else
                                logPw.print(attributes[j]+((j== attributes.length-1)?"\n":","));
                        }
                        File deleteFile = new File(jsonFile);
                        deleteFile.delete(); //delete this incomplete file since attribute missing

                        logPw.println();
                        logPw.close();
                        sc.close();
                        pw.close();
                        System.exit(0);


                    }catch (CSVDataMissing e) {
                        //user message
                        System.out.println("In file "+file.getName()+" line "+lineCount+" is not converted to JSON: missing data.");
                        //write to log file
                        logPw.println("In file "+file.getName()+" line "+lineCount);
                        for(String d:data){
                            d = d.replace(".",", ");
                            if(d.equals(""))
                                logPw.print("*** ");
                            logPw.print(d+" ");
                        }
                        logPw.println("\nMissing: "+ missingDataField+"\n");
                    }

                    //proceeding this method
                    try{
                        int d = Integer.parseInt(data[i]);
                        pw.println("\""+attributes[i]+"\": "+d+((i!=(attributes.length-1))?",":""));
                    }catch (NumberFormatException e){
                        pw.println("\""+attributes[i]+"\": "+"\""+data[i]+"\""+((i!=(attributes.length-1))?",":""));
                    }
                }
                pw.println((sc.hasNextLine())? "},":"}");

            }
            pw.println("]");
            sc.close();
            pw.close();
            logPw.close();

        }catch (FileNotFoundException e) {
            //display message can not create json file
            System.out.println("Could not create "+jsonFile+" for writing. Erasing created output files. Program will terminate. ");
            //delete all created file
            //close input files and exit program
            File deleteFile = new File(jsonFile);
            pw.close();
            boolean isDeleted = deleteFile.delete();
            System.out.println(isDeleted?"File is deleted":"File is not deleted");
            System.exit(0);

        }


        return jsonFile;


    }







}