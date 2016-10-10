import java.util.Scanner;

public class conversion {
	
	//public double converter(double[] array){
		
		
	//}
	
	public static void main(String[] args){
		
		final String[] UNITS={"B","KB","MB","GB"};
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Please input the number: ");
		
		double number=sc.nextInt();
		
		System.out.println("Please input the units: ");
		
		String type=sc.next();
		
		
		switch(type){
		
		case "B":
			for(int i=0; i<UNITS.length;i++){
				System.out.println(number+UNITS[i]);
				number=number/1024.0;
			}
			break;
			
		case "KB":
			for(int i=1; i<UNITS.length;i++){
				System.out.println(number+UNITS[i]);
				number=number/1024.0;
			}
			break;
			
		case "MB":
			for(int i=2; i<UNITS.length;i++){
				System.out.println(number+UNITS[i]);
				number=number/1024.0;

			}
			break;
			
		case "GB":
			for(int i=3; i<UNITS.length;i++){
				number=number/1024.0;
				System.out.println(number+UNITS[i+1]);
			}
			break;
		
		
		}
		
		
	}

}
