import java.util.Scanner;

public class calculator {
	
	public static int add(int a, int b){
		int result=a+b;
		return result;
	}
	
	public static int substract(int a, int b){
		int result=a-b;
		return result;
	}
	
	public static double multipy(double a , double b){
		double result = a*b;
		return result;
	}
	
	public static double divide(double a, double b){
		double result = a/b;
		return result;
	}
	
	public static long factorial(int n){
		if(n==1){
			return 1;
		}
		return n*factorial(n-1);
	}
	
	public static void exit(){
		System.exit(0);
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Please input your first number: ");
		int a1=sc.nextInt();
		System.out.println("Please input your second number: ");
		int a2=sc.nextInt();
		
		System.out.println("Please choose your method:");
		String callMethod= sc.next();
		
		switch(callMethod){
		
		case "add":
			System.out.println(add(a1,a2));
			break;
			
		case "substract":
			System.out.println(substract(a1,a2));
			break;
			
		case "multiply":
			System.out.println(multipy(a1,a2));
			break;
			
		case "divide":
			System.out.println(divide(a1,a2));
		}
		
		
		System.out.println("Please input a number to do factorial: ");
		int a3=sc.nextInt();
		System.out.println("The result is :"+ factorial(a3));
	
		
	}
		


}
