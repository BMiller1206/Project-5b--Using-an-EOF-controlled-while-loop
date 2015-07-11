//*****************************************************************************
//Name: Brent Miller
//Date: 070615
//Project Name: Project 5b: Using an EOF Controlled While Loop
//Description: This project will use an EOF controlled while loop to access
//data from a file. The program will calculate the weekly gross pay based
//on hours and rate for hourly employees, those that have an 'h' in the 
//classification field or on the value in the salary field for those with a 
//classification of 's'. Hourly employees with more than 40 hours worked in a
//week will be paid at time and 1/2 for all hours over 40 worked in the week.
//*****************************************************************************
package project5b;

//libraries
import java.io.FileInputStream;
import java.io.FileReader; 
import java.io.PrintWriter; 
import java.io.FileNotFoundException; 
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.text.DecimalFormat;

//begin class Project5a
public class Project5b 
{
    //begin main
    public static void main(String[] args) throws FileNotFoundException
    {
        //declaration and initialization
        int employeeNumber = 0, exemptions = 0;
        double hours = 0.0, payRate = 0.0, salary = 0.0, grossPay = 0.0;
        String filingStatus = " ", classification = " ";
        
        DecimalFormat twoDecimal = new DecimalFormat("$###,###,###.00");       
        Scanner console = new Scanner(new FileReader("EmployeeData.dat"));
        //Scanner console = new Scanner(System.in);	
        //console = new Scanner(System.in); 
        
        //Data types defined in the read file
//        employeeNumber = console.nextInt();
//        filingStatus = console.next();
//        exemptions = console.nextInt();
//        classification = console.next();
//        hours = console.nextDouble();
//        payRate = console.nextDouble();
//        salary = console.nextDouble();
        
        while (console.hasNext())  
        {
             //Data types defined in the read file
            employeeNumber = console.nextInt();
            filingStatus = console.next();
            exemptions = console.nextInt();
            classification = console.next();
            hours = console.nextDouble();
            payRate = console.nextDouble();
            salary = console.nextDouble();
            
            double temp =0.0;
            if (hours >40)
            {
                temp = ((hours - 40) * ((payRate*.5)+payRate)); 
                grossPay = temp + (40*payRate);
            }//end if
            else
            {
                grossPay =(hours * payRate);
            }//end else
            
            //Individual print out statements for each employee
            JOptionPane.showMessageDialog(null, "Employee number: " + employeeNumber + "\n"
                + "Filing status: " + filingStatus + "\nExemptions: " + exemptions + "\n"
                + "Classification: " + classification + "\nHours: " + hours + "\n"
                + "Pay rate: " + payRate + "\nSalary: " + salary + "\nGross pay: " + twoDecimal.format(grossPay));
        }//end while

//        //Individual print out statements for each employee
//        JOptionPane.showMessageDialog(null, "Employee number: " + employeeNumber + "\n"
//                + "Filing status: " + filingStatus + "\nExemptions: " + exemptions + "\n"
//                + "Classification: " + classification + "\nHours: " + hours + "\n"
//                + "Pay rate: " + payRate + "\nSalary: " + salary + "\nGross pay: " + grossPay);   
        
    }//end main    
}//end class Project5a
