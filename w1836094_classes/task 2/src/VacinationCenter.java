import java.io.IOException;
import java.util.Scanner;
public class VacinationCenter {

    static String reply;
    public static void main(String[] args) throws IOException {

        Scanner myscan = new Scanner(System.in);
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
            Booth obj1 = new Booth();

            if ((reply.equals("100")) || (reply.equalsIgnoreCase("VVB"))) {
                obj1.viewBooths();
            } else if ((reply.equals("101")) || (reply.equalsIgnoreCase("VEB"))) {
                obj1.viewEmptyBooths();
            } else if ((reply.equals("102")) || (reply.equalsIgnoreCase("APB"))) {
                obj1.addPatient();
            } else if ((reply.equals("103")) || (reply.equalsIgnoreCase("RPB"))) {
                obj1.removePatient();
            } else if ((reply.equals("104")) || (reply.equalsIgnoreCase("VPS"))) {
                obj1.viewPatientsData();
            } else if ((reply.equals("105")) || (reply.equalsIgnoreCase("spd"))) {
                obj1.storeProgramData();
            } else if ((reply.equals("106")) || (reply.equalsIgnoreCase("LPD"))) {
                obj1.loadProgramData();
            } else if ((reply.equals("107")) || (reply.equalsIgnoreCase("VRV"))) {
                obj1.viewRemainingVac();
            } else if ((reply.equals("108")) || (reply.equalsIgnoreCase("AVS"))) {
                obj1.addVaccination();
            }else if((reply.equals("999")) || (reply.equalsIgnoreCase("EXT"))){
                System.out.println("Thank you!" );
                break;
            }else{
                System.out.println("Something went wrong\n"+"Try again!");
            }
        }
        while (true);
        }
}

