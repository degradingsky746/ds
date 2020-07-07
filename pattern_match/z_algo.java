import java.util.*;

public class z_algo{

	private int[] calz(String s){

		int z[] = new int [s.length()];
		int left=0,right=0;
		int k;

		for(k=1;k<s.length();k++){
			if(k > right){
				left=right=k;
				while(right < s.length() && s.charAt(right)==s.charAt(right-left)){
					right++;
				}
				z[k] = right - left;
				right--;
			}
			else{
				int k1 = k -left;
				if(z[k1]<=right-k){
					z[k]=z[k1];
				}
				else{
					left=k;
					while(right < s.length() && s.charAt(right)==s.charAt(right-left)){
						right++;
					}
					z[k]=right-left;
					right--;
				}
			}
		}

		return z;

	}
	public static void main(String[] args) {
		String s = "aaabcxyzaaaabczaaczabbaaaaaabc";
		String pat = "aaabc";
		char a[] = new char[s.length()+pat.length()+1];
		int i;
		for(i=0;i<pat.length();i++){
			a[i]=pat.charAt(i);
		}
		a[i]='%';
		i++;
		int j=0;
		for(j=0,i=i;j<s.length();j++,i++){
			a[i]=s.charAt(j);
		}
		String f = new String(a);
		z_algo zz = new z_algo();
		int res[] = zz.calz(f);
		for(int k=pat.length()+1;k<f.length();k++){
			if(res[k]==pat.length()){
				System.out.println(k-pat.length()-1);
			}
		}		
	}
}