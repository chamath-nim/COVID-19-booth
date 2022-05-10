import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class Booth {
    private Scanner myscan = new Scanner(System.in);
    private static int vaccinNum = 150;
    private static String[] booths = new String[6];
    private static ArrayList<String> patientNames = new ArrayList<>();
    Patient obj1 = new Patient();

    /* view all vaccination booth
       @show all booths by refering they are occupied or not
     */
    public void viewBooths(){
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
    public void viewEmptyBooths(){
        for (int x = 0; x < booths.length; x++) {
            if (booths[x] == (null)) {
                System.out.println("Booth " + (x + 1) + " is empty");
            }
        }
    }
    /*  add patients to booths
        @Alerting if stock reaches 20
     */
    public void addPatient(){
        System.out.print("Enter first name : ");
        String firtname = myscan.nextLine();
        System.out.print("Enter surname : ");
        String surname = myscan.nextLine();
        String full = firtname + " " + surname;
        System.out.print("Enter the name of vaccine you requested\nAvailable vaccines \"AstraZeneca,Sinopharm,Pfizer\" : ");
        String vaccineName = myscan.nextLine();



        if (vaccineName.equalsIgnoreCase("AstraZeneca")) {
            if ((booths[0] == (null)) || (booths[1] == (null))){
                if(booths[0] == (null)) {
                    booths[0] = firtname;
                    System.out.println(full+" added to booth 1");
                }else{
                    booths[1] = firtname;
                    System.out.println(full+" added to booth 2");
                }
                patientNames.add(full);
                obj1.getPatientsData(full,vaccineName);
                vaccinNum--;
                vaccineAlert(vaccinNum);
            } else {
                System.out.println("all booths are occupied \ntry again!");
            }
        } else if (vaccineName.equalsIgnoreCase("Sinopharm")) {
            if ((booths[2] == (null)) || (booths[3] == (null))){
                if(booths[2] == (null)) {
                    booths[2] = firtname;
                    System.out.println(full+" added to booth 3");
                }else{
                    booths[3] = firtname;
                    System.out.println(full+" added to booth 4");
                }
                patientNames.add(full);
                obj1.getPatientsData(full,vaccineName);
                vaccinNum--;
                vaccineAlert(vaccinNum);
            } else {
                System.out.println("all booths are occupied \ntry again!");
            }
        } else if (vaccineName.equalsIgnoreCase("Pfizer")) {
            if ((booths[4] == (null)) || (booths[5] == (null))){
                if(booths[4] == (null)) {
                    booths[4] = firtname;
                    System.out.println(full+" added to booth 5");
                }else{
                    booths[5] = firtname;
                    System.out.println(full+" added to booth 6");
                }
                patientNames.add(full);
                obj1.getPatientsData(full,vaccineName);
                vaccinNum--;
                vaccineAlert(vaccinNum);
            } else {
                System.out.println("all booths are occupied \ntry again!");
            }
        } else {
            System.out.println("You entered vaccine brand is not available");
        }
    }
    /* remove pations from the booth
     */
    public void removePatient(){
        System.out.print("Enter the patient's booth number to be removed (1-6) : ");
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
    public void viewPatientsData(){
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
    public void storeProgramData() throws IOException {
        File myObj = new File("details.txt");
        myObj.createNewFile();
        System.out.println("File created: " + myObj.getName());

        FileWriter myWriter = new FileWriter("details.txt");
        for(int i = 0 ; i< patientNames.size(); i++){
            ArrayList<ArrayList<String>> data = obj1.storeData();
            myWriter.write("Patient's full name              : " + data.get(i).get(0) + "\n" +
                    "Patient's age                    : " + data.get(i).get(1) + "\n" +
                    "Patient's city                   : " + data.get(i).get(2) + "\n" +
                    "Patient's NIC or passport number : " + data.get(i).get(3) + "\n" +
                    "Requested vaccine brand          : " + data.get(i).get(4) + "\n\n");
        }
        myWriter.close();
        System.out.println("Successfully wrote to the file.");

    }
    /* check the file we going to read is exsist or not exsist
        @if file exsist , read all data of the file and output them
     */
    public void loadProgramData() throws IOException{
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
    public void viewRemainingVac(){
        System.out.println("Total of reamining vaccines : "+vaccinNum);
    }

    // add vaccines to current vaccin count
    public void addVaccination(){
        System.out.print("Enter the total of vaccines going to add : ");
        int totAddVac = myscan.nextInt();               //total of vaccines going to add
        myscan.nextLine();
        vaccinNum+=totAddVac;
    }
    // warning alert that remaining number of vaccines reach 20
    public static void vaccineAlert(int num){
        if(vaccinNum<=20){
            System.out.println("Alert : "+vaccinNum+" vaccines reamining");
        }
    }
}

