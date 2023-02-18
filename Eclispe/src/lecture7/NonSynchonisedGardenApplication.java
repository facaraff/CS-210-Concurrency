package lecture7;
import java.util.Scanner;

import lecture6.Garden;


public class NonSynchonisedGardenApplication {

    public static void main(String[] args) {
        Garden garden;
        Scanner scan = new Scanner(System.in);
        garden = new Garden(); // create a garden

        while(true){
            try {
                garden.go();             
            } catch (InterruptedException ex) {}
            // count at the end
            System.out.println(garden.getCount());
            // ask to continue
            System.out.println("Have another go? \n(press 0 for no, any >0 for yes) ");
            int choice = scan.nextInt();
            if (choice == 0)
                break;
        }
       
        scan.close();   
     }

}
