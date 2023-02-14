package lecture6;
import java.util.Scanner;


public class Application {

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
            System.out.println("Have another go? Press 0 for quitting or any other number for continuing: ");
            int choice = scan.nextInt();
            if (choice == 0)
                break;
        }
       
        scan.close();   
     }

}
