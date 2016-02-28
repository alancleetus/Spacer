import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
public class EssayFormatter
{
   private File f ;
   
   //file processor
   //cover page maker-input fields
   //work cited page creator - input fields

   public EssayFormatter()
   {
      Scanner in = fileProcessor();
      completelyReformat(in);
   }
   
   private Scanner fileProcessor()
   {
      do{
         String fileName = JOptionPane.showInputDialog(null, "Enter File Name:");
      
         if(!fileName.contains("."))   fileName += ".txt";
         
         f= new File(fileName);
      }while(!f.exists());
      Scanner in;
      try{
         in = new Scanner(f);
         return in; 
      }
      catch(Exception FileNotFoundException)
      {
         System.out.println("This shouldnt happen");
      }
      in = new Scanner(System.in);
      return in;
   }
   //reformatter(destroy spacing, recreate spacing)

   private void completelyReformat(Scanner inputFile)
   {
      String output = new String();
      while(inputFile.hasNextLine())
      {
         String paragraph = inputFile.nextLine().replaceAll("\\s+", " ").trim();
         output+="\t"+paragraph+"\n";
      }
      System.out.println(output);
      System.out.println(output.replace(". ",".  "));
      
   }
   
   private void writeToFile(File f, String output)
   {
      try
      {
         PrintStream outFile = new PrintStream(f);
         outFile.println(output);
      }
      catch(Exception e)
      {
         System.out.println("3r40r");
      }
   
   }   
   public static void main(String [] args)
   {
      EssayFormatter e = new EssayFormatter();
      
   }
}