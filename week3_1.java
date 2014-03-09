import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
public class week3_1
{
	boolean isNumeric_Loop;
	public static void main(String[] arg) {
		System.out.print("請輸入字串：");
		int sum=0;
		int hold=0;
		Scanner scanner=new Scanner(System.in);
		String string = scanner.nextLine();
		String[] tokens = string.split("[ |,|\\.|?|!]");
		for(String S : tokens){
			if(S.length()>0){
				if(isNumeric_Loop(S) == true) {
					hold = Integer.parseInt(S);
					sum = hold + sum;
				}
				else {
					S=S.toLowerCase();
					System.out.println(S);
				}
			}
		}
		System.out.println("sum="+sum);
	}
	
	public static boolean isNumeric_Loop(String str) {          
		for (int i = str.length();--i>=0;){                 
			if (!Character.isDigit(str.charAt(i))){                  
				return false;              
			}         
		}          
		return true;      
	}
}
