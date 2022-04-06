package one;

import lombok.Data;

import java.util.*;

@Data
class Person implements Cloneable{
    String name;
    int age;
    @Override
    protected Person clone()throws CloneNotSupportedException{
        return (Person)super.clone();
    }
}
/**
 * @author www
 * @version 1.0
 * @date 2021/10/30
 * @effect
 */
public class BCTES {
    public static void main(String[] args) throws CloneNotSupportedException {
        BCTES bctes = new BCTES();
        Person person = new Person();
        person.setName("1");
        person.setAge(20);
        System.out.println(person);
        Person person1=person.clone();
        System.out.println(person1);
        person1.setName("2");
        person1.setAge(21);
        System.out.println(person);
        System.out.println(person1);


    }


    public int count (ArrayList<String> arr) {
        // write code here
        int ans=0;
        for(int i=0;i<arr.size();i++){
            if(khpp(arr.get(i),i))ans++;
        }
        return ans;
    }
 /**
  * * */
    boolean khpp(String str,int x){
        if(str.length()%2!=0||str.length()==0)return false;
        Stack<Character>stack = new Stack<>();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='(')stack.push(str.charAt(i));
            else {
                if(stack.isEmpty())return false;
                else stack.pop();
            }
        }

        if(stack.isEmpty()){
            System.out.print(stack);
            System.out.println(x+"    "+str);
            return true;
        }
        return false;


    }
    public int LSubSequence (int N, ArrayList<Integer> sequence) {
        // write code here
        int ans=1;
        if(N==1)return ans;
        int i,j;
        int dp[]=new int [N];
        dp[0]=1;
        for(i =1;i<N;i++){
            dp[i]=1;
            for(j=0;j<i;j++){
                if(sequence.get(i)>sequence.get(j))
                    dp[i]=Math.max(dp[i],dp[j]+1);
            }
            ans=Math.max(dp[i],ans);
        }
        return ans;
    }
}
