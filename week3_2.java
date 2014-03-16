import java.io.*;
import java.util.*;

public class week3_2	{
	public static void main(String arg[]) {
		HashMap<String,Integer> hash = new HashMap<String,Integer>();
		Scanner scanner = new Scanner(System.in);
		int opt=0,grade=0;
		String string ="";
		while(true)	{
			System.out.print("請輸入選項：1)輸入新成績資訊 2)查詢功能 3)全部列出 -1)退出:");
			opt=scanner.nextInt();
			if(opt == -1)
				break;
			else if(opt == 1){
				System.out.print("請輸入學生姓名：");
				string = scanner.nextLine();
				string = scanner.nextLine();
				if(hash.get(string)!=null){
					System.out.println("此學生資料已存在!\r\n");
					continue;
				}
				System.out.print("請輸入成績：");
				grade = scanner.nextInt();
				if(grade>100||grade<0){
					System.out.println("成績資訊錯誤!\r\n");
					continue;
				}
				hash.put(string,grade);
			}	
			else if(opt == 2){
				System.out.print("請輸入學生姓名：");
				string = scanner.nextLine();
				string = scanner.nextLine();
				if(hash.get(string) == null)
					System.out.println("沒有這筆學生資料!");
				else 
					System.out.println(string +"   "+ hash.get(string));
			}
			else if(opt == 3) 		
				for(String key : hash.keySet()){
						System.out.println(key+":"+hash.get(key));
			}
		}				
	}
}
