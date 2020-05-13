import java.util.*;

public class JosephusDriver {

   public static void main(String[] args) {
      Scanner console = new Scanner(System.in);
      JosephusSim simulation = new JosephusSim("names.txt");
      
      while(!simulation.isOver()) {
         System.out.println(simulation);
         System.out.println("\nContinue elimination? <press enter>");
         console.nextLine(); // make the user hit enter to continue
         simulation.eliminate();
      }
      
      System.out.println(simulation);
   }

}
/*
 === Elimination count is 3 ===
 Remaining surviors: 1-Muhammad, 2-Jose, 3-Amandeep, 4-Robin, 5-Anh, 6-Fumi, 7-Roshani, 8-Noah, 9-Isaac, 10-Keerthi, 11-Peter
 
 Continue elimination? <press enter>
 
 Amandeep eliminated!
 Remaining surviors: 1-Robin, 2-Anh, 3-Fumi, 4-Roshani, 5-Noah, 6-Isaac, 7-Keerthi, 8-Peter, 9-Muhammad, 10-Jose
 
 Continue elimination? <press enter>
 
 Fumi eliminated!
 Remaining surviors: 1-Roshani, 2-Noah, 3-Isaac, 4-Keerthi, 5-Peter, 6-Muhammad, 7-Jose, 8-Robin, 9-Anh
 
 Continue elimination? <press enter>
 
 Isaac eliminated!
 Remaining surviors: 1-Keerthi, 2-Peter, 3-Muhammad, 4-Jose, 5-Robin, 6-Anh, 7-Roshani, 8-Noah
 
 Continue elimination? <press enter>
 
 Muhammad eliminated!
 Remaining surviors: 1-Jose, 2-Robin, 3-Anh, 4-Roshani, 5-Noah, 6-Keerthi, 7-Peter
 
 Continue elimination? <press enter>
 
 Anh eliminated!
 Remaining surviors: 1-Roshani, 2-Noah, 3-Keerthi, 4-Peter, 5-Jose, 6-Robin
 
 Continue elimination? <press enter>
 
 Keerthi eliminated!
 Remaining surviors: 1-Peter, 2-Jose, 3-Robin, 4-Roshani, 5-Noah
 
 Continue elimination? <press enter>
 
 Robin eliminated!
 Remaining surviors: 1-Roshani, 2-Noah, 3-Peter, 4-Jose
 
 Continue elimination? <press enter>
 
 Peter eliminated!
 Remaining surviors: 1-Jose, 2-Roshani, 3-Noah
 
 Continue elimination? <press enter>
 
 Noah eliminated!
 Remaining surviors: 1-Jose, 2-Roshani
 
 Continue elimination? <press enter>
 
 Jose eliminated!
 Roshani is the last survivor!*/