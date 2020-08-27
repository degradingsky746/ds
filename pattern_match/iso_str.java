import java.util.*;

class iso_str{
	public static void main(String args[]){
	Scanner s = new Scanner(System.in);
	int t;
	t = s.nextInt();
	while(t--!=0){	
		Set<String> set = new HashSet<String>();
		String str1 = s.nextLine();
		String str2 = s.nextLine();
		//str1 to str2
		for(int i=0;i<str1.length();i++){
			if(set.contain(str1.charAt(i))==false){
				set.add(str1.charAt(i));

			}
		}		
		}



	}

}