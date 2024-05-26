package Recursion.lab;


import java.util.Scanner;

public class Recursion {

    public static void main(String[] args) {
        System.out.print("Please enter a number: ");
        Scanner input=new Scanner(System.in);
        int number=input.nextInt();
        System.out.println("The sum is : "+sum(Math.abs(number)) );
    }//end of main

    public static int sum(int number){
        if(number==0)
            return number;
        else
            return (number%10)+sum(number/10);
    }//end of sum method

}//end of class
