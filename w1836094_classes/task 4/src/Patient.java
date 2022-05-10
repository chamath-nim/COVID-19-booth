import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Patient {
    private static ArrayList<ArrayList<String>> details = new ArrayList<>(); //create a2d arraylist
    static Scanner myscan = new Scanner(System.in);
    String age,city,nic;

    /* get patient's additional data
       @add additional data to a 2d arralist
     */
    public void getPatientsData(String fullname, String vaccine){
        System.out.print("Enter age : ");
        age = myscan.nextLine();
        System.out.print("Enter city : ");
        city = myscan.nextLine();
        System.out.print("Enter NIC or passport number : ");
        nic = myscan.nextLine();
        details.add(new ArrayList<>(Arrays.asList(fullname,age,city,nic,vaccine)));
    }

    // return details arraylist to write the file
    public ArrayList<ArrayList<String>> storeData(){
        return details;
    }
}
