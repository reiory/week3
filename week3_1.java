import java.io.*;
import java.util.*;

public class week3_1
{
	public static void main(String arg[]) {
		System.out.print("請輸入字串：");
		Scanner scanner=new Scanner(System.in);
		String string = scanner.nextLine();
		String[] tokens = string.split("[ |,|\\.|?|!]");
		for(String S : tokens){
			System.out.println(S);
		}
	}
}
