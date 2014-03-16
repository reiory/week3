import java.io.*;
import java.util.*;


public class week3_3{
	public static void main(String arg[])throws IOException {
		int opt,sum=0,hold=0;
		HashMap<String,Integer> hash = new HashMap<String,Integer>();
		try{ /*讀取檔案*/
			FileReader file = new FileReader("weekText3_3.txt");
			BufferedReader br = new BufferedReader(file);
			String temp = "";
			isNumeric_Loop numc = new isNumeric_Loop();
			temp = br.readLine();
			sum=Integer.parseInt(temp);
			while((temp = br.readLine()) != null){
				String[] tokens = temp.split("[ |,|\\.|?|!]");
			//	System.out.println(temp);
				int newValue = Integer.parseInt(tokens[1]);
				hash.put(tokens[0],newValue);
			}
			file.close();
		}
		catch(IOException e){
			System.out.println("It doesn't read the file!\n");
		}

//		hash=OpenFile(hash);
		Scanner scanner = new Scanner(System.in);
		String string;
		isNumeric_Loop numc = new isNumeric_Loop();
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
						if(numc.numCheck(S) == true) {
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
		FileWriter fw = new FileWriter("weekText3_3.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		String sv = Integer.toString(sum);
		bw.write(sv);
		bw.newLine();
		for(Object k : hash.keySet()){
			bw.write(k + " " + hash.get(k));
			bw.newLine();
		}
		bw.flush();
		fw.close();
	}
}
class isNumeric_Loop{
	private String str;
	public isNumeric_Loop() {          
		str="";
	}
	public boolean numCheck(String s){
		str=s;
		for (int i = str.length();--i>=0;){                 
			if (!Character.isDigit(str.charAt(i)))                  
				return false;                       
		} 
		return true;		
	}
}
