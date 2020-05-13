//Aashima Mehta
//CS 143
//Core Topics: Circular LinkedList
//This program will is based upon Josephus Problem, in which the you eliminate
//people until there's just one "survivor" left.

import java.util.*;
import java.io.*;

public class JosephusSim {
   private PersonNode circle;     // a PersonNode pointer that tracks first node
   private int size;              // the number of people in the circle
   private int eliminationCount;  // the number to count to for elimination       
   private PersonNode track;      // a PersonNode pointer to help with elimination

   public JosephusSim(String fileName) {
      try {
         Random rand = new Random();
         // load names from the file in order, generating a singly linked list of PersonNodes
         Scanner file = new Scanner(new File(fileName));
         PersonNode node = new PersonNode(file.next());
         circle = node;
         eliminationCount = 1;
         PersonNode cur = node;
         while(file.hasNext()){
            while(cur.next != null){
               cur = cur.next;
            }
            String word = file.next();
            PersonNode node2 = new PersonNode(word, cur.next);
            cur.next = node2;
            cur = cur.next;
            eliminationCount++;
         }
         // make the ring circular by attaching last node's next to front
         PersonNode last = cur; //last node
         cur.next = circle;
         // remember the last node as the one in front of the next to get eliminated
        
         // generate, print, and save the random elimination count
         size = eliminationCount;
         eliminationCount = rand.nextInt(eliminationCount/2) + 1;
         System.out.println("=== Elimination count is " + eliminationCount + " ===");
         
      } catch(FileNotFoundException e) {
         System.out.println("Something went wrong with " + fileName);
      }
   }
   
   public void eliminate() {
      // count to the elimination count
      PersonNode cur = circle;
      String eliminated = "";
      if(eliminationCount == 1 && !isOver()){
         eliminated = circle.name;
         circle = circle.next;
         // print who will be eliminated
         System.out.println(eliminated + " is eliminated!");
         // eliminate the person and update "front" of the circle and size
         size--;
      }
     else if(!isOver()){
         for(int i = 0; i < eliminationCount-2; i++){
            cur = cur.next;
         }
         eliminated = cur.next.name;
         track = cur.next.next;
         // print who will be eliminated
         System.out.println(eliminated + " eliminated!");
         // eliminate the person and update "front" of the circle and size
         cur.next = cur.next.next;
         circle = track;
         size--;
      }  
      
   }
   
   public boolean isOver() {
      // check if there's only one person left in the circle
      return size == 1;
   }
   
   public String toString() {
      Random rand = new Random();
      String word = "";
      // if there's only one person left, print them as the last survivor
      if(isOver())
         word += circle.name + " is the last survivor!";
      // print the remaining survivors (watch out for infinite loop since list is circular)
      else{
         PersonNode cur = circle;
         word += "Remaining surviors: ";
         for(int i = 0; i < size; i++){
            word += (i+1) + "-" + cur.name;
            if(i != size - 1)
               word += ", ";
            cur = cur.next;
         }  
      }
      return word;
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
 Roshani is the last survivor!
 
 */