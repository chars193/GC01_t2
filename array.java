import java.util.Arrays;

public class array {

	public static void main(String[] args){
		
		int numbers[] = new int [20];
		
		//System.out.println(numbers.length);
		
		for(int i=0; i<numbers.length;i++){
			numbers[i]=i+1;
		}
		
		System.out.println(Arrays.toString(numbers));
		
		
		
		int numbers1[]=new int[20];
		
		for(int i=0; i<numbers1.length;i++){
			numbers1[i]=i+1;
		}
		
		for(int i=0; i<numbers1.length;i++){
			
			if(i==0){
				continue;
			}
			else if(i==19){
				continue;
			}
			
			else{

				numbers1[i]=(numbers[i-1]+numbers[i+1])/2;
			}
				}
		
		System.out.println(Arrays.toString(numbers1));
		
	}

}
