import java.util.*;

class sw{


	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int n = s.nextInt();

		char bride[] = s.nextLine().toCharArray();

		char groom[] = s.nextLine().toCharArray();

		List<Character> groom_list = new ArrayList<Character>();
		List<Character> bride_list = new ArrayList<Character>();

		for(int t=0;t<n;t++){
			bride_list.add(bride);
			groom_list.add(groom[t]);
		}

		while(bride_list.size()!=0){
			i=0;
			if(bride_list[i]==groom_list[i]){
				bride_list.remove(i);
				groom_list.remove(i);
				continue;
			}

			int rem = groom_list.size();
			int count=0;
			while(bride_list[i]!=groom_list[i]&&count<rem){
				char temp = groom_list[i];
				groom_list.remove(i);
				groom_list.append(temp);
				count+=1;

			}
			if(count==rem) 
				break;
			else 
				if(bride_list[i]==groom_list[i]){
					bride_list.remove(i);
					groom_list.remove(i);
					continue;					
				}
		}

		System.out.println(bride_list.size());
	}
}