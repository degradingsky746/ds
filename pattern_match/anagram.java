class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> a = new ArrayList<List<String>>();
        ArrayList<String> strs_new = new ArrayList<String>();
        for(String s :strs){
            strs_new.add(s);
        }
        int len = strs_new.size();
        int count=0,i=0;
        while(strs_new.size()!=0){
            //System.out.println("before"+a.size());
          a.add(new ArrayList<String>());
            //System.out.println("after"+a.size());
            String temp = new String(strs_new.get(0));
            a.get(i).add(temp);
            //System.out.println("first"+a.get(0).get(0));
            for(int j=1;j<strs_new.size();j++){
                int flag = 1;
                int comp[] = new int[26];
                String temp2 = strs_new.get(j);
                if(temp.length()==temp2.length()){
                    for(int x=0;x<temp.length();x++){
                        comp[temp.charAt(x)-97]+=1;
                        comp[temp2.charAt(x)-97]-=1;
                    }
                    for(int z:comp){
                        if(z!=0){
                            flag=0;
                            break;
                        } 
                    }
                    if(flag==1) {
              //          System.out.println("a.get me jane k pehle"+i);
              //          System.out.println("kya add kar re h"+temp2);
                        a.get(i).add(temp2);
                        count+=1;}
                }
            }
            /*for(String s : a[0]){
                a.get(i).remove(s);                
            }*/
            int t_l=a.get(i).size();
            for(int t=0;t<t_l;t++){
                String s = a.get(i).get(t);
                strs_new.remove(s);
                //System.out.println("str size"+strs_new.size());
            }
            //System.out.println("inci hua");
            i+=1;
        }
        return a;
        /*List<List<String>> b = new ArrayList<List<String>>();
        for(int p=0;p<a.size();p++){
            List<String> temp = new ArrayList<String>();
            for(int q=0;q<a.get(p).size();q++){
                
                temp.add(a.get(p).get(q));
                
            }
            b.add(temp);
        }
        return b;*/
    }
}