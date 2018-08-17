import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter; 
import java.io.FileNotFoundException;
import java.io.IOException; 
import java.util.Arrays;
/**
* <h1>Hash Tables!</h1>
* The Hash Tables program implements Hashfunctions
* then calculates the number of duplicates(the number of times each value appears),
* probability and entropy of each Hash function.
* <p>
* 
*
* @author  Anele Chila
* @version 1.0
* @since   2017-05-03
*/

public class HashTable
{
   int tableSize;
   
   /**
   * This is the main method which makes use of Hash function methods.
   * @param args Unused.
   */
   
   public static void main(String[] args)
   {
      int n = 20011;
      int m = 20011;
      double sum = 0;
      //HashTable ht = new HashTable(m);
      int[] a = new int[n];
      Arrays.fill(a,(-1));  
         
      Scanner s = new Scanner(System.in);
      System.out.println("Enter a function , hashWorst/hash1/hash2/hash3 :");
      String hash = s.next();
      try { 
       HashTable ht = new HashTable(m);

       //String hash = "hash3";
       BufferedReader inputStream = new BufferedReader(new FileReader("data.tar-1-1")); 
       //PrintWriter outputStream = new PrintWriter(new FileOutputStream("numbered.txt")); 
       int count = 0; 
       String line = inputStream.readLine();
       int hashVal;
       while (line != null){
         //outputStream.println(count + " " + line);
         line = inputStream.readLine();
          //System.out.println( ht.hash3(line));
        
        if(hash.equals("hash3")){
         hashVal = ht.hash3(line);
          String z = ""  +ht.hash3(line);
         if(z != null){
            //System.out.println(z);
            a[count] = hashVal;
         }
         else
            //a[count] = z;
            
            System.out.println("wwww");}
         
        else if(hash.equals("hash1")){
         hashVal = ht.hash1(line);
         String z = ""  +ht.hash1(line);
         if(z != null)
         {
            //System.out.println(z);
            a[count] = hashVal;
         }
         else
            //a[count] = z;
            
            System.out.println("wwww");}

        else if(hash.equals("hash2")){
         hashVal = ht.hash2(line);
         String z = ""  +ht.hash2(line);
         if(z != null)
         {
            //System.out.println(z);
            a[count] = hashVal;
         }
         else
            //a[count] = z;
            
            System.out.println("wwww");}

        /*else if(hash.equals("hash1")){
         hashVal = ht.hashWorst(line);
         a[count] = hashVal;}*/
        else if(hash.equals("hashWorst")){
         hashVal = 1;
         a[1] = hashVal;
        }
        else 
         System.out.print("Enter The correct function !!");
       count++;


       }
      int[] Na = new int[n];
      Arrays.fill(Na,(-1));
      int[] control = new int[n];
      Arrays.fill(control,(-1));
      
   
      System.out.println("\nHash values | Counts | Probability | -P(x)log10(P(x)):\n");
      for(int i = 0; i < n;i++){
           // HashTable gt = null;
          int c = 0;
         if(ht.contains(control,a[i]) == false){
            //int c = 0;
            for(int j =0;j<n;j++){
               if(a[j] == a[i] && a[i] != -1)// && j != i)
                  c++;
            }

            double p = (double)c/10000;
            double e;
            if( p != 0)
              e = -p*Math.log(p);
            else 
              e = 0;
            sum +=e;
            double x = (double)a[i];
            System.out.printf("%11.5f |",x);//ln(a[i]+" | "+c + " | "+p +" | " + e );
            System.out.printf("%7.5f |", (double)c);
            System.out.printf("%12.5f |", (double)p);
            System.out.printf("%17.5f |", (double)e);
            System.out.println();
            control[i] = a[i];
            if(a[i]>0)
               Na[a[i]] = c;
            else if(a[i]<0 && Na[(-1)*a[i]] == -1)
               Na[(-1)*a[i]] = c;
         }
        }
        System.out.println("Enthropy H(X) is " + sum);
      //  System.out.println("\nNumber of #val counts:\n");
       //for(int k : Na){
         //System.out.println(k);
       //}

       inputStream.close();
       //outputStream.close();
       } 
       catch(FileNotFoundException e) {
         System.out.println("Problem opening files."); } 
       catch(IOException e)
       { 
         System.out.println("Error reading from original.txt.");
       }
      
   }
   /**
   * This contructor sets the default value 
   * of the size to the size entered .
   * @param tableSize This is the size of the array to store hashValues .
   * 
   */
   
   public HashTable(int tableSize){
      this.tableSize = tableSize;
   }
   /**
   * This method checks if a value is contained in an array ,
   * if found - true, if not found - false.
   * @param arr This is the array to be traverse .
   * @param item This is the value to searched for in the array.
   * @return boolean A boolean value True/False is returned.
   */
   
    public static boolean contains(int[] arr, int item) {
      for (int n : arr) {
         if (item == n) {
            return true;
         }
      }
      return false;
   }
   
   /**
   *This method hashes a full name in the 
   *worst case .
   *@param key Aceepts a string full name.
   *@return int Returns a hash value.
   */
   public int hashWorst(String key){
      int hashVal = 1;
      return hashVal;
   }
   /**
   *This method hashes a full name
   *to add Unicode values .
   *@param key Aceepts a string full name.
   *@return int Returns a hash value.
   */

   public int hash1 ( String key )
   {
      int hashVal = 0;
      if(key != null){
      for( int i = 0; i < key.length(); i++ )
         hashVal += key.charAt(i);
         
      //if(hashVal != 0)
         return hashVal % tableSize;
      //else
        // return 0;
      }
      else{
         //System.out.println("Key is null");
         return 0 ;
         }

   }
   /**
   *This method hashes a full name
   *to add shifted Unicode values .
   *@param key Aceepts a string full name.
   *@return int Returns a hash value.
   */

   public int hash2 ( String key )
   {
      int hashVal = 0;
      if(key != null){
         for( int i = 0; i < key.length(); i++ )
            hashVal = (37 * hashVal) + key.charAt(i);
         //if(hashVal != 0)
          return hashVal % tableSize;
         //else
           // return 0;
       }
       else{
         //System.out.println("Key is null");
         return 0;
         }
   }
 
   /**
   *A faster hash function that takes advantage of overflow
   *@param key Aceepts a string full name.
   *@return int Returns a hash value.
   */

   
   public int hash3 ( String key )
   {
      int hashVal = 0;
      if(key != null){
      for( int i = 0; i < key.length(); i++ ){
         hashVal = (37 * hashVal) + key.charAt(i);}
      hashVal %= tableSize;
      if(hashVal<0)
      hashVal += tableSize; 
      if(hashVal != 0)
      return hashVal;
      else
         return 0;
      }
      else
      {
         //System.out.println("Key is null");
         return 0;
         }
    }


}

