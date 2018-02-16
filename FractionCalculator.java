import java.util.Scanner;
import java.util.*;

public class FractionCalculator {
    public static Scanner input=new Scanner(System.in);
    public static int a,b;//they are integers entered by the user

    public static void main(String[] args)
    {
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println("This Program is a fraction calculator");
        System.out.println("It will add, subtract, multiply and divide fractions until you type Q to quit.");
        System.out.println("Please enter your fractions in the form a/b,where a and b are integers");
        System.out.println("-------------------------------------------------------------------------------------------");
        while(true) {
            String operation = getOperation();
            if(operation.equals("q") || operation.equals("Q"))
                break;
            Fraction a =getFraction();//1st fraction
            Fraction b=getFraction();//2nd fraction
            Fraction result;//result
            if (operation.equals("+"))
            {
                result=a.add(b);
                System.out.println(a.toString()+"+"+b.toString()+"="+result.toString());
            }else if(operation.equals("-"))
            {
                result=a.subtract(b);
                System.out.println(a.toString()+"-"+b.toString()+"="+result.toString());
            }else if(operation.equals("*"))
            {
                result=a.multiply(b);
                System.out.println(a.toString()+"*"+b.toString()+"="+result.toString());
            }else if(operation.equals("/"))
            {
                result=a.divide(b);
                System.out.println(a.toString()+"/"+b.toString()+"="+result.toString());
            }else if(operation.equals("="))
            {
                if(a.equals(b))
                {
                    System.out.println(a.toString()+ " = "+ b.toString());
                }
                else
                {
                    System.out.println(a.toString()+ "!="+ b.toString());
                }
            }
        }
    }
    public static String getOperation()
    {

        System.out.print("Please enter a mathematical operation (+,-,/,*,= or Q to quit): ");
        char c = input.next().charAt(0);

        String validinput="+-/*=qQ";
        while(validinput.indexOf(c)==-1)//it means the character entered by the user is not in the valid input string
        {
            System.out.print("Invalid Operation\n"+"Please enter a mathematical operation (+,-,/,*,= or Q to quit): ");
            c=input.next().charAt(0);
        }
        if(c=='Q'||c=='q')
        {
            System.exit(0);
        }
        return Character.toString(c);

    }
    //to check that the string entered by the user is valid or not
    public static boolean validFraction(String s)
    {
        s=s.replaceAll("-","");//replaces all the - from the strings
        if(s.indexOf('/')==-1)//means / is not in the string
        {
            //If there is no "/" character, then every character in the string must be a number
           if(isNumber(s))
           {
               return true;
           }
           else{
               return false;
           }
        }
        else
        {
            //if there is "/" character
            String num,den;//substring for numerator and denominator
            num=s.substring(0,s.indexOf('/'));
            den=s.substring(s.indexOf('/')+1);
            if(num.equals("") || den.equals("") || !isNumber(num) || !isNumber(den) || Integer.parseInt(den)==0) {
                return false;
            }
            else {
                return true;
            }
        }

    }
    //helper method to check if the string is made up of numbers
    public static boolean isNumber(String s)
    {
            try {
                int i=Integer.parseInt(s);
                return true;
            }
            catch (NumberFormatException a)
            {
                     return false;
              }
    }
    public static Fraction getFraction()
    {
        while(true) {
            System.out.print("Please enter a fraction(a/b) or integer(a):");
            String s = input.next();
            int num, den;
            if (validFraction(s)) {
                if (s.indexOf('/') == -1) {

                    num = Integer.parseInt(s);
                    den = 1;
                } else {

                    num = Integer.parseInt(s.substring(0, s.indexOf('/')));
                    den = Integer.parseInt(s.substring(s.indexOf('/') + 1));
                }
                Fraction fo=new Fraction(num,den);
                return fo;
            }
            else
            {
                System.out.println("Invalid fraction. Please enter (a/b) or(a), where a and b are integers and b not be 0");
            }
        }

    }
}
