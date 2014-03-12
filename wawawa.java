import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
public class week3_3{
	public static void main(String arg[]) {
		HashMap<String,Integer> hash = new HashMap<String,Integer>();
		hash=OpenFile(hash);
		Scanner scanner = new Scanner(System.in);
		String string;
		int opt,sum=0,hold=0;
		while(true)	{
			System.out.print("請輸入選項：1)輸入新字串 2)查詢功能 -1)退出:");
			opt=scanner.nextInt();
			if(opt==-1)
				break;
			else if(opt==1){
				System.out.print("請輸入字串：");
				string = scanner.nextLine();
				string = scanner.nextLine();
				String[] tokens = string.split("[ |,|\\.|?|!]");
				for(String S : tokens){
					if(S.length() > 0){
						if(isNumeric_Loop(S) == true) {
							hold = Integer.parseInt(S);
							sum = hold + sum;
						}
						else {
							S=S.toLowerCase();
							if(hash.get(S)== null)
								hash.put(S,1);
							else	{
							int newValue = hash.get(S)+1;
							hash.put(S,newValue);
							}
						}
					}
				}
			}
			else if(opt==2)	{
				for(String key : hash.keySet()){
					System.out.println(key+":"+hash.get(key));
				}
				System.out.println("sum="+sum);
			}
		}
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
public class OpenFile{
	public void OpenFile(HashMap<String,Integer> hash)	{
	try{
		File file = new File("C:\\hw\\week3\\student.txt");
		InputStream is = new FileInputStreamReader(file);
		InputStreamReader is = new FileInputStreamReader(file);
	}catch(java.io.FileNotFoundExcepion e){
		System.out.pintln("File dose not exit!");
	}
}
