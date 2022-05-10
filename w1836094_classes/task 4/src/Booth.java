import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
public class Booth {
    private Scanner myscan = new Scanner(System.in);
    private static int vaccinNum = 150;
    private static String[] booths = new String[6];
    private static ArrayList<String> patientNames = new ArrayList<>();
    private static LinkedList<String> waitingAStra = new LinkedList<>();
    private static LinkedList<String> waitingSino = new LinkedList<>();
    private static LinkedList<String> waitingPfiz = new LinkedList<>();
    static String full;

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
        full = firtname + " " + surname;
        System.out.print("Enter the name of vaccine you requested\nAvailable vaccines \"AstraZeneca,Sinopharm,Pfizer\" : ");
        String vaccineName = myscan.nextLine();

        if (vaccineName.equalsIgnoreCase("AstraZeneca")) {
            obj1.getPatientsData(full,vaccineName);

            if (booths[0] == (null)) {
                booths[0] = full;
                System.out.println("You added to booth 1");
                patientNames.add(full);
                vaccinNum--;
                vaccineAlert(vaccinNum);
            } else if (booths[1] == (null)) {
                booths[1] = full;
                System.out.println("You added to booth 2");
                patientNames.add(full);
                vaccinNum--;
                vaccineAlert(vaccinNum);
            } else {
                waitingAStra.add(full);
                System.out.println("all booths are occupied \nyou added to the AstraZeneca waiting list");
            }
        } else if (vaccineName.equalsIgnoreCase("Sinopharm")) {
            obj1.getPatientsData(full,vaccineName);

            if (booths[2] == (null)) {
                booths[2] = full;
                System.out.println("You added to booth 3");
                patientNames.add(full);
                vaccinNum--;
                vaccineAlert(vaccinNum);
            } else if (booths[3] == (null)) {
                booths[3] = full;
                System.out.println("You added to booth 4");
                patientNames.add(full);
                vaccinNum--;
                vaccineAlert(vaccinNum);
            } else {
                waitingSino.add(full);
                System.out.println("all booths are occupied \nyou added to the Sinopharm waiting list");
            }
        } else if (vaccineName.equalsIgnoreCase("Pfizer")) {
            obj1.getPatientsData(full,vaccineName);

            if (booths[4] == (null)) {
                booths[4] = full;
                System.out.println("You added to booth 5");
                patientNames.add(full);
                vaccinNum--;
                vaccineAlert(vaccinNum);
            } else if (booths[5] == (null)) {
                booths[5] = full;
                System.out.println("You added to booth 6");
                patientNames.add(full);
                vaccinNum--;
                vaccineAlert(vaccinNum);
            } else {
                waitingPfiz.add(full);
                System.out.println("all booths are occupied \nyou added to the Pfizer waiting list");
            }
        } else {
            System.out.println("You entered vaccine brand is not available");
        }
    }
    /* remove pations from the booth
     */
    public void removePatient() {
        System.out.print("Enter the patient's booth number to be removed (1-6) : ");
        int num = myscan.nextInt();
        if((num>0) && (num<7)) {
            System.out.println(booths[num-1]+" is removed from the booth "+num);
            booths[num - 1] = null;
            myscan.nextLine();
            if ((num == 1) || (num == 2)) {
                if (waitingAStra.size() > 0) {
                    patientNames.add(full);
                    vaccinNum--;
                    if (num == 1) {
                        booths[num - 1] = waitingAStra.get(0);
                    } else {
                        booths[num - 1] = waitingAStra.get(0);
                    }
                    System.out.println(waitingAStra.get(0) + " added to the booth " + num);
                    waitingAStra.removeFirst();
                }
            }
            if ((num == 3) || (num == 4)) {
                if (waitingSino.size() > 0) {
                    patientNames.add(full);
                    vaccinNum--;
                    if (num == 3) {
                        booths[num - 1] = waitingSino.get(0);
                    } else {
                        booths[num - 1] = waitingSino.get(0);
                    }
                    System.out.println(waitingSino.get(0) + " added to the booth " + num);
                    waitingSino.removeFirst();
                }
            }
            if ((num == 5) || (num == 6)) {
                if (waitingPfiz.size() > 0) {
                    patientNames.add(full);
                    vaccinNum--;
                    if (num == 5) {
                        booths[num - 1] = waitingPfiz.get(0);
                    } else {
                        booths[num - 1] = waitingPfiz.get(0);
                    }
                    System.out.println(waitingPfiz.get(0) + " added to the booth " + num);
                    waitingPfiz.removeFirst();
                }
            }
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
        ArrayList<ArrayList<String>> data = obj1.storeData();
        for(int i = 0 ; i< patientNames.size(); i++){

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

