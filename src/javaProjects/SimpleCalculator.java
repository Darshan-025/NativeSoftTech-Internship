package javaProjects;

import java.util.Scanner;

public class SimpleCalculator {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char choice;
		do {
			System.out.println("Simple Calculator");
			System.out.println("1.Addition");
			System.out.println("2.Subtraction");
			System.out.println("3.Multiplication");
			System.out.println("4.Division");
			System.out.println("5.Exit");
			System.out.println("Enter what you want to perform(1-5):\n");
			
			int operation = sc.nextInt();
			
			if(operation == 5) {
				System.out.println("Exiting Calculator");
				break;
			}
			
			System.out.println("Enter the first number:");
			double num1 = sc.nextDouble();
			System.out.println("Enter the second number");
			double num2 = sc.nextDouble();
			
			try {
				switch(operation) {
				case 1 : System.out.println("Result: "+(num1 + num2));
						break;
				case 2 : System.out.println("Result: "+(num1 - num2));
						break;
				case 3 :System.out.println("Result: "+(num1 * num2));
						break;
				case 4 :{
					if(num2 == 0) throw new ArithmeticException("Cannot divide by zero");
					System.out.println("Result: "+(num1/num2));
				}
				default : System.out.println("Invalid Operation");		
				}
			}catch(Exception e) {
				System.out.println("Error: "+e.getMessage());
			}
			
			System.out.println("Do you want to perform another operation(y/n)");
			choice = sc.next().charAt(0);
		}while(choice == 'y' || choice == 'Y');	
	}
}
