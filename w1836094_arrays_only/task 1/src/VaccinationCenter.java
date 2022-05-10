import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class VaccinationCenter {
    static Scanner myscan = new Scanner(System.in);
    static String reply;
    static int vaccinNum = 150;
    static String[] booths = new String[6];
    static ArrayList<String> patientNames = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to COVID-19 Vaccination Center !\n");

        do {
            System.out.println("\n100 or VVB: View all Vaccination Booths\n" +
                    "101 or VEB: View all Empty Booths\n" +
                    "102 or APB: Add Patient to a Booth\n" +
                    "103 or RPB: Remove Patient from a Booth\n" +
                    "104 or VPS: View Patients Sorted in alphabetical order\n" +
                    "105 or SPD: Store Program Data into file\n" +
                    "106 or LPD: Load Program Data from file\n" +
                    "107 or VRV: View Remaining Vaccinations\n" +
                    "108 or AVS: Add Vaccinations to the Stock\n" +
                    "999 or EXT: Exit the Program\n");
            System.out.print("Enter the suitable keynumber or keyword according to your need : ");
            reply = myscan.nextLine();

            if ((reply.equals("100")) || (reply.equalsIgnoreCase("VVB"))) {
                viewBooths();
            } else if ((reply.equals("101")) || (reply.equalsIgnoreCase("VEB"))) {
                viewEmptyBooths();
            } else if ((reply.equals("102")) || (reply.equalsIgnoreCase("APB"))) {
                addPatient();
            } else if ((reply.equals("103")) || (reply.equalsIgnoreCase("RPB"))) {
                removePatient();
            } else if ((reply.equals("104")) || (reply.equalsIgnoreCase("VPS"))) {
                viewPatientsData();
            } else if ((reply.equals("105")) || (reply.equalsIgnoreCase("spd"))) {
                storeProgramData();
            } else if ((reply.equals("106")) || (reply.equalsIgnoreCase("LPD"))) {
                loadProgramData();
            } else if ((reply.equals("107")) || (reply.equalsIgnoreCase("VRV"))) {
                viewRemainingVac();
            } else if ((reply.equals("108")) || (reply.equalsIgnoreCase("AVS"))) {
                addVaccination();
            }else if((reply.equals("999")) || (reply.equalsIgnoreCase("EXT"))){
                System.out.println("Thank you!" );
                break;
            }else{
                System.out.println("Something went wrong\n"+"Try again!");
            }
        }
        while (true);
    }

    /* view all vaccination booth
       @show all booths by refering they are occupied or not
     */
    public static void viewBooths(){
        for (int x = 0; x < booths.length; x++) {
            if (booths[x] == (null)) {
                System.out.println("Booth " + (x + 1) + " is empty");
            } else {
                System.out.println("Booth " + (x + 1) + " occupied by " + booths[x]);
            }
        }
    }

    /* view all empty booths
       @ only view empty booths
     */
    public static void viewEmptyBooths(){
        for (int x = 0; x < booths.length; x++) {
            if (booths[x] == (null)) {
                System.out.println("Booth " + (x + 1) + " is empty");
            }
        }
    }

    /*  add patients to booths
        @Alerting if stock reaches 20
     */
    public static void addPatient(){
        System.out.print("Enter patient name : ");
        String name = myscan.nextLine();
        int boothNum;
        do {
            System.out.print("Enter booth number (1-6): ");
            boothNum = myscan.nextInt();
        }
        while ((1 > boothNum) || (boothNum > 6));
        myscan.nextLine();
        if(booths[boothNum-1] == (null)) {
            booths[boothNum - 1] = name;
            patientNames.add(name);
            System.out.println(name+" entered to the booth "+boothNum);
            vaccinNum--;
            if (vaccinNum<=20){
                System.out.println("Alert : "+vaccinNum+" vaccines reamining");
            }
        }
        else{
            System.out.println("You entered booth already occupied, try again");
        }
    }

    /* remove pations from the booth
     */
    public static void removePatient(){
        System.out.print("Enter the patient's booth number to be removed ");
        int num = myscan.nextInt();
        myscan.nextLine();
        if((num>0) && (num<7)) {
            System.out.println(booths[num-1]+" is removed from the booth "+num);
            booths[num - 1] = null;
        }
        else {
            System.out.println("something went wrong!");
        }
    }
    // show all patients who already waccinated in alphabetical order
    public static void viewPatientsData(){
        /*for(int j=0;j<patientNames.size();j++) {
            for (int i = j + 1; i < patientNames.size(); i++) {
                if ((patientNames.get(i)).compareToIgnoreCase(patientNames.get(j)) < 0) {
                    String t = patientNames.get(j);
                    patientNames.set(j, patientNames.get(i));
                    patientNames.set(i, t);
                }
            }
        }
        for (String patientName : patientNames) {
            System.out.println(patientName);
        }*/
        String[] names = new String[6];
        for(int z = 0; z<booths.length; z++){
            if(booths[z] == (null)){
                names[z] = "null";
            }else {
                names[z] = booths[z];
            }
        }
        for (int j = 0; j<6; j++) {
            for (int i = j + 1; i < names.length; i++) {
                if ((names[j].compareTo(names[i]) > 0)) {
                    String temp = names[j];
                    names[j] = names[i];
                    names[i] = temp;
                }
            }
        }
        for(int a = 0; a< names.length; a++){
            if(!(names[a].equalsIgnoreCase("null"))) {
                System.out.println(names[a]);
            }
        }
    }
    /* create a new text file called "filename.txt"
        @store all patient data to already created file
     */
    public static void storeProgramData() throws IOException {
        File myObj = new File("details.txt");
        myObj.createNewFile();
        System.out.println("File created: " + myObj.getName());

        FileWriter myWriter = new FileWriter("details.txt");
        for(int i = 0 ; i< patientNames.size(); i++){
            myWriter.write(patientNames.get(i)+"\n");
        }
        myWriter.close();
        System.out.println("Successfully wrote to the file.");

    }
    /* check the file we going to read is exsist or not exsist
        @if file exsist , read all data of the file and output them
     */
    public static void loadProgramData() throws IOException{
        File obj1 = new File("details.txt");
        if(obj1.exists()){
            System.out.println("exsist");
            Scanner myReader = new Scanner(obj1);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        }
        else {
            System.out.println("mentioned file doesn't exsist");
        }

    }
    // show the total of remaining vaccines
    public static void viewRemainingVac(){
        System.out.println("Total of reamining vaccines : "+vaccinNum);
    }

    // add vaccines to current vaccin count
    public static void addVaccination(){
        System.out.print("Enter the total of vaccines going to add : ");
        int totAddVac = myscan.nextInt();               //total of vaccines going to add
        myscan.nextLine();
        vaccinNum+=totAddVac;
    }
}
