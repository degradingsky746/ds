public class rabin_karp{

	private int prime=101;

	public int patternSearch(char []text, char []pat){
		int m = pat.length;
		int n = text.length;
		long patternHash = createHash(pat,m-1);
		long textHash = createHash(text,m-1);

		for(int i=0;i<=n-m-1;i++){
			if(textHash == patternHash && checkEqual(text,i,i+m-1,pat,0,m-1)){
				return i;
			}
			if(i<=n-m-1){
				textHash = recalHash(textHash,i,i+m,text,m);
			}
		} 

		return -1;
	}

	public long recalHash(long oldHash,int prev,int next,char []text,int m){
		long newHash = oldHash - text[prev];
		newHash = newHash/prime;
		//System.out.println(next);
		newHash += text[next]*Math.pow(prime,m-1);
		return newHash;
	}

	public boolean checkEqual(char []text,int x1,int x2,char []pat,int y1,int y2){
		for(int i=x1,j=y1;i<=x2;i++,j++){
			if(text[i]!=pat[j]){
				return false;
			}
		}
		return true;
	}

	public long createHash(char []ch,int end){
		long hash = 0;
		for(int i=0;i<ch.length;i++){
			hash += ch[i]*Math.pow(prime,i);
		}
		return hash;
	}

	public static void main(String[] args) {
		//String s = "aaabcxyzaaaabczaaczabbaaaaaabc";
		//String pat = "aaabc";
		rabin_karp rk = new rabin_karp();
		System.out.println(rk.patternSearch("TusharRoy".toCharArray(), "Tus".toCharArray()));
	}

}