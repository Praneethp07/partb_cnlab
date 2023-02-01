import java.util.*;
public class leakybucket{
    public static void main(String []args){
      int a[] = new int[100];
      int drop=0;
      int rem=0;
      int accepted = 0;
      int leaked = 0;
      final int buck_cap = 4;
      int rate = 3;
      Scanner sc = new Scanner(System.in);
      System.out.println("enter the no of packets");
      int n = sc.nextInt();
      System.out.println("enter the of packets");
      for(int i=0;i<n;i++)
      a[i] =  sc.nextInt();
      
      System.out.println("index\tpackets\taccepted\tleaked\trem");

      for(int i=0;i<n;i++){
        drop =0;
        if(a[i]!=0){
          if(a[i]<=buck_cap){
            accepted=a[i];
            if(accepted>rate){
              leaked = rate;
            }else{
              leaked = accepted+rem;
            }
            if(accepted<leaked){
              rem = 0;
            }else{
              rem = accepted-leaked;           
            }
            
          }else{
            drop = 1;
            rem =0;
            leaked = 0;
          }
          if(drop == 1){
            System.out.println(i+"\t"+a[i]+"\t"+"dropped"+"\t\t"+leaked+"\t"+rem);
          }
          else{
            System.out.println(i+"\t"+a[i]+"\t"+accepted+"\t\t"+leaked+"\t"+rem);
          }
        }else{
          accepted = 0;
          leaked = accepted+rem;
          rem = accepted-leaked;
          System.out.println(i+"\t"+a[i]+"\t"+accepted+"\t\t"+leaked+"\t"+rem);
        }
      }
      
    }
}
