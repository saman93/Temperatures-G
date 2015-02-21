import java.util.Scanner;


public class Main {

	
	public static void main(String[] args) {
		
		int[][] t;
		double AH,AL;
		int min, max;
		
		t=inputTempForYear();
		AH = calculateAverageHigh(t);
		AL = calculateAverageLow(t);
		min = findLowestTemp(t);
		max = findHighestTemp(t);
		
		for(int i=0; i<12; i++){
			
			System.out.println(Month.values()[i] +" has a High of "+t[i][0]+" and Low of "+t[i][1]);
			
		}
		System.out.println("the average high temp is "+AH);
		System.out.println("the average low temp is "+AL);
		System.out.println("The highest temp is "+t[max][0]+" for "+ Month.values()[max]);
		System.out.println("The lowest temp is "+t[min][1]+" for "+ Month.values()[min]);
		
	}
	
	public static Scanner keyboard = new Scanner(System.in);
	
	public static void inputTempForMonth(int m, int[][] t){
		
		do{
			System.out.print("Input high temp for "+Month.values()[m]+": ");
			t[m][0]= keyboard.nextInt();
			System.out.print("Input low temp for "+Month.values()[m]+": ");
			t[m][1]= keyboard.nextInt();
			if(t[m][0]<t[m][1])
				System.out.println("Invalid temp");
			
		}while(t[m][0]<t[m][1]);
			
	}
	
	public static int[][] inputTempForYear(){
		int[][] t = new int[12][2];
		for(int m=0; m<12; m++){
			
			inputTempForMonth(m, t);
		}
		
		return t;
	}
	
	public static double calculateAverageHigh(int[][] t){
		double AH=0;
		
		for(int m=0; m<12; m++){
			
			AH+=t[m][0];
			
		}
		return AH/12;
	}
	
	public static double calculateAverageLow(int[][] t){
		double AL=0;
		
		for(int m=0; m<12; m++){
			
			AL+=t[m][1];
			
		}
		return AL/12;
	}
	
	public static int findLowestTemp(int[][] t){
		int min = t[0][1];
		int j=0;
		for(int i=0; i<12; i++){
			
			if(t[i][1]<min){
				min=t[i][1];
				j=i;
			}
		}
		return j;
	}
	
	public static int findHighestTemp(int[][] t){
		int max = t[0][0];
		int j=0;
		for(int i=0; i<12; i++){
			
			if(t[i][0]>max){
				max=t[i][0];
				j=i;
			}
		}
		return j;
	}

}
