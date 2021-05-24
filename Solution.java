import java.util.*;
import java.text.*;
/*
Write the implementation of the Cricket and Football classes
*/
interface Sport
{
    List<Integer> retired = new ArrayList<Integer>();
    default void calculateAvgAge(int[] age){    ///  Here's we have used java 8 feature, that is we can also defined the method in interface by using default keyword
        double sum=0;
        for(int age1=0;age1<age.length;age1++){
            
            sum=sum+age[age1];
        }
        //System.out.println("sum "+sum);
        double avg = sum/age.length;
        
        System.out.println("The average age of the team is "+new DecimalFormat("####.##").format(avg)); // we are using only 2 digits after decimal
        
    }

    default void retirePlayer(int id){    ///  again Here's we have used java 8 feature, that is we can also defined the method in interface by using default keyword
        
        if(!retired.contains(id)){           /// we are using list for check player is already retired or not
            if(id>=20 ){                      // less then 20 are in retired player according to hackerrank conditions
            System.out.println("Player with id: "+id+" has retired");
           }
        else if( id<=40){                                // greater then 40 are in retired player according to hackerrank conditions
            System.out.println("Player with id: "+id+" has retired");
        }
        }
        else{
            System.out.println("Player has already retired");
        }
        
        retired.add(id);
    }
    default void playerTransfer(int fee, int id){
        
       
            System.out.println("Player with id: "+id+" has been transferred with a fee of "+fee);
   
}
}
class Cricket implements Sport{    // here simply we have only implement interface no need to define the methods of inheritence
    Cricket(){
        System.out.println("A new cricket team has been formed");
    }
    
}
class Football implements Sport{    // again here simply we have only implement interface no need to define the methods of inheritence
    
    Football(){                // default constrtuctor of football class
        System.out.println("A new football team has been formed");
    }
}

public class Solution{
 public static void main(String[] args){
  Scanner sc = new Scanner(System.in);

  Cricket c = new Cricket();
  Football f = new Football();

  int[] age1 = new int[11];
  int[] age2 = new int[11];

  for(int i = 0; i < 2; i++)
   {
    String[] age = sc.nextLine().split(" ");
    if(i == 0){
    int j = 0;
    for(String s : age)
     age1[j++] = Integer.parseInt(s);
    }
    else{
     int j = 0;
     for(String s : age)
      age2[j++] = Integer.parseInt(s);  
    }
   }
// these method we are defined in interface and implement  interface into cricket class and now we are just createing a object of cricket class 
     //and calling method of interface
 
   c.calculateAvgAge(age1);  
     f.calculateAvgAge(age2);

   for(int i = 0; i < 6; i++){
   
   if(i < 3){
    int x = Integer.parseInt(sc.nextLine());

    c.retirePlayer(x);
   }
   else if(i < 5){
    int x = Integer.parseInt(sc.nextLine());
    f.retirePlayer(x);  
   }
   else {
    String[] temp = sc.nextLine().split(" ");  
    f.playerTransfer(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
  } 
 }  
 }
}
