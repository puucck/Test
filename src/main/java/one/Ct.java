package one;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

}
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

}
interface Test{
    int add(int a);
    default int add2(int a){
        return  a+a;
    }
}
@Data
@NoArgsConstructor
@AllArgsConstructor
class Po{
   String name;
   int age;


   public int hashCoe(){
       System.out.println(name);
       return this.name.hashCode();
   }

}
public class Ct  {

    public static void main(String[] args) throws Exception {
        Ct ct = new Ct();

        List<Character> list = Arrays.asList('a', 'z');
        Character[] arr = (Character[]) list.toArray();

    }
    //剑指offer12

    //494
    /**
     * sum(+)+sum(-)=target
     * */
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum<target|| (sum + target) % 2 == 1)return 0;
        int m=(sum+target)/2;
        int dp[]=new int [m+1];
        dp[0]=1;
        for(int i=0;i<nums.length;i++){
            for(int j=m;j>=nums[i];j--){
                dp[j]+=dp[j-nums[i]];
            }
        }
        return dp[m];
    }
    //1155
    public int numRollsToTarget(int n, int k, int target) {

        int dp[][]=new int [n+1][target+1];
        dp[0][0]=1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                for (int l = 1; l <=k &&j>=l; l++) {
                    dp[i][j]+=dp[i-1][j-l];
                }
            }
        }
        return dp[n][target];
    }

    //416
    public boolean canPartition(int[] nums) {
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }
        if(sum%2==1)return false;
        int ans= sum/2;
        int dp[]=new int[ans+1];
        for(int i=0;i<nums.length;i++){
            for(int j=ans;j>=nums[i];j--){
                dp[j]=Math.max(dp[j],dp[j-nums[i]]+nums[i]);
            }
        }
        for (int i = 0; i < ans+1; i++) {
            System.out.print(dp[i]+" ");
        }
        return dp[ans]==ans;
    }

    public int calculate(String s) {
        char op='+';
        int num=0,num1=0,num2=0;
        StringBuffer buffer = new StringBuffer(s);
        buffer.append('x');
        char str[]=buffer.toString().toCharArray();
        for (char c:str){
            if(c==' ')continue;
            else if(c>='0'&&c<='9')num=num*10+c-'0';
            else{
                if(op=='+'||op=='-'){
                    num1+=num2;
                    num2=op=='+'?num:-num;
                }
                else if(op=='*')num2*=num;
                else num2/=num;
                op=c;
                num=0;
            }
        }
        return num1+num2;
    }

    public float one(int n) {
        int nums[]=new int[2];
        for (int i = 0; i < 2; i++) {
            nums[i]=n%10;
            n/=10;
        }

        return  (float)(n+nums[1]/10.0+nums[0]/100.0);
    }


        int shu_chu(){ int n,q;
        Scanner scanner = new Scanner(System.in);
        n=scanner.nextInt();
        int arr[][]=new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0]=scanner.nextInt();
            arr[i][1]=scanner.nextInt();
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });

        System.out.println(arr);
        int max=0;
        int k=0;
        for (int i = 0; i <n; i++) {
            if(arr[i][1]==0)max+=arr[i][0];
            else {k=i;break;}
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        for (int i = k; i < n; i++) {
            for (int j = k; j <i; j++) {

            }
        }
        return max;
        }

    //3
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0||s==null)return 0;
        HashMap map = new HashMap<Character,Integer>();
        return 0;
    }
    //5
    public String longestPalindrome(String s) {
        if(s.length()==1)return s;
        int max=1;
        int start=0;
        int end=0;
        for(int i=0;i<s.length()-1;i++){
            int odd=isPalindrome(s,i,i);
            int eve=isPalindrome(s,i,i+1);
            max=Math.max(odd,eve);
            if(max>end-start){
                start = i - (max - 1)/2;
                end = i + max/2;
                }
            }
        return s.substring(start,end+1);
    }
    int isPalindrome(String s,int left,int right){
       int i=left;
       int j=right;
       while (i>0&&j<s.length()){
           if(s.charAt(i)==s.charAt(j)){
               j++;
               i--;
           }else break;
       }
       return j-i-1;
    }
    //6
    public String convert(String s, int numRows) {
        if(s.length()<3)return s;
        ArrayList<StringBuilder> res = new ArrayList();
        for (int i = 0; i < numRows; i++) {
            res.add(new StringBuilder());
        }
        int flag=-1,hang=0;
        for(char c:s.toCharArray()){
            res.get(hang).append(c);
            if(hang==0||hang==numRows-1)flag=-flag;
            hang+=flag;
        }
        StringBuffer buffer = new StringBuffer();
        for (StringBuilder re : res) {
            buffer.append(re);
        }
        return buffer.toString();
    }
    static String  dscf(String str1,String str2){
        int[] num1 = new int[str1.length()];
        int[] num2 = new int[str2.length()];
        int[] result = new int[str1.length() + str2.length()];

        //将两个字符串转成整型数组，顺序转换，数组下标越小，数字对应的位数越高
        for (int i = 0;i < str1.length(); i++){
            num1[i]=str1.charAt(i)-'0';
//            num1[i] = Integer.parseInt(str1.substring(i,i+1));
        }
        for (int i = 0;i < str2.length(); i++){
            num2[i] = Integer.parseInt(str2.substring(i,i+1));
        }

        //两大数相乘
        for (int a = 0;a < str1.length(); a++){
            for (int b = 0;b < str2.length(); b++){
                result[a+b] += num1[a]*num2[b];
            }
        }

        ////判断是否需要进位，满10进1,因为存储顺序与位数高低相反，所以采用逆序进位
        int temp;
        for (int k = result.length-1; k > 0; k--){
            temp=result[k]/10;  //数组下标大的向数组下标小的进位
            result[k-1] += temp;
            result[k] = result[k]%10;
        }

        //将结果数组逆序转化为字符串
        String resultstr = "";
        for (int i = 0; i < result.length-1; i++){
            resultstr += "" + result[i];
        }

        return resultstr;
    }
    //26 快慢指针
    public int removeDuplicates(int[] nums) {
        //0-slow为不重复字符串slow-fast为待审阅字符串
        int slow=0,fast;
        int len=0;
        for (fast = 1; fast < nums.length; fast++) {
            if(nums[slow]!=nums[fast]){
                nums[++slow]=nums[fast];
            }
        }
        return ++slow;
    }
    //59
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==0||nums==null)return new int[0];
        int ans[]=new int[nums.length-k+1];
        Deque<Integer>deque = new LinkedList();
        int len=0;
        for(int i=0,j=k-1;j<nums.length;j++,i++){
            while(!deque.isEmpty()&&nums[i]>=deque.peekLast()){
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }
        return ans;
    }
    // 79
//    public boolean exist(char[][] board, String word) {
//        char
//    }
    void dfs(){}
    //91
    public int numDecodings(String s) {
        int len=0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='0')len++;
        }
        if(s.length()-len<2)return 1;
        char res[]=s.substring(len,s.length()).toCharArray();
        int dp[]=new int[res.length+1];
        dp[0]=1;
        for (int i = 0; i < res.length; i++) {
            if(res[i]!='0')dp[i+1]=0;
            else dp[i+1]=dp[i];
            if(i>0&&(res[i]=='1'||res[i]=='2'&&res[i-1]<=6))
                dp[i]+=dp[i-1];
        }
        return dp[dp.length];
    }
    //187
    public List<String> findRepeatedDnaSequences(String s) {
        ArrayList<String> ans= new ArrayList<>();
        if(s.length()<11)return ans;
        for(int i=0;i<s.length();i+=10){
            ans.add(s.substring(i,i+10));
        }
        return ans;
    }
    public int mySqrt(int x) {
        for(int i=x/2;i>0;i--){
            if(i*i<x)return i;
        }
        return 1;
    }

    //leet-``code.952
    public int largestComponentSize(int[] nums) {
        return 0;
    }
    public int maxAddNums (int[] nums) {
        int max=0;
        for (int i = 0; i < nums.length; i++) {
            int sum=nums[i];
            int j;
            for (j = i+1; j < nums.length; j++) {
                sum+=nums[j];
            }
            System.out.println("sum="+sum+" j="+j+" i="+i);
            while (j<nums.length&&sum<0&&j>i){
                sum-=nums[j];
                j--;
            }
            if(sum>0&&(j-i)>max)max=j-i;
        }
        return max;
    }
    public int splitInOrder (int[] nums) {
        // write code here
        int res=nums[0];
        List<Integer>list = new ArrayList<>();
        list.add(res);
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]>=res){
                if(nums[i-1]==list.get(list.size()-1))
                    System.out.println("i="+i);
                list.add(nums[i]);
                res=nums[i];
            }
        }
        if(list.get(0)==list.get(list.size()-1))return 1;

        if(list.size()==nums.length)return 0;
        else return list.size();
    }





























    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer,Integer>map=new HashMap();
        for (int i = 0; i < arr.length; i++) {
            if(!map.containsKey(arr[i]))
                map.put(arr[i],1);
            else map.put(arr[i],map.get(arr[i])+1);
        }
        map.forEach((key,v)-> System.out.println(key+" "+v));
        return 0;
    }
    public int[][] reconstructQueue(int[][] people){
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]!=o2[0]){
                    return o2[0]-o1[0];
                }else {
                    return o1[1]-o2[1];
                }
            }
        });
        List<int[]>ans = new ArrayList<int[]>();
        for (int[] person : people) {
            System.out.println(person[1]+" "+person[0]+","+person[1]);
            ans.add(person[1],person);
        }
        return ans.toArray(new int[ans.size()][]);
    }

    public int distributeCandies(int[] candyType) {
        Set <Integer> set = new HashSet();
        for (int i : candyType) {
            set.add(i);
        }
        return Math.min(set.size(),candyType.length/2);
    }

    //leetcode 7 整数反转
    public int reverse(int x) {
        int n=0;
        int sum=0;
        boolean flag=false;
        while (x!=0){
            n=x%10;
            if(sum>Integer.MAX_VALUE/10||sum<Integer.MIN_VALUE/10) {
                flag=true;
            }
            sum=sum*10+n;
            x/=10;
        }
        if(flag)return 0;
        return sum;
    }
    //leetcode 7 字符串转整数
    public int myAtoi(String s) {
        if(s.length()==0)return 0;
        int i=0;
        while(i<s.length()&&s.charAt(i)==' ')i++;
        if(i==s.length())return 0;
        boolean op=true;
        if(s.charAt(i)=='-'){
            op=false;
            i++;
        }
        else if(s.charAt(i)=='+'){
            op=true;
            i++;
        }
        else if(!Character.isDigit(s.charAt(i)))return 0;
        int ans=0;
        StringBuffer buffer = new StringBuffer();
        while (i<s.length()&&Character.isDigit(s.charAt(i))){
            int n=s.charAt(i)-'0';
            if(ans>Integer.MAX_VALUE/10){
                return op?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            ans=ans*10+n;
            i++;
        }
        return op?-ans:ans;
    }
    public int myAtoi2(String s) {
        int i=0;
        while (i<s.length()&&s.charAt(i)==' ')i++;
        Pattern pattern = Pattern.compile("^[+-]?\\d+");
        Matcher m = pattern.matcher(s);
        int sum=0;
        if(m.find()){
            try{
                sum=Integer.parseInt(s.substring(m.start(),m.end()));
            }catch (Exception e){
                sum=s.charAt(0)=='-'?Integer.MIN_VALUE:Integer.MAX_VALUE;
            }
        }
        return sum;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0||lists==null)return null;
        PriorityQueue<ListNode> queue = new PriorityQueue(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if(o1.val<o2.val)return -1;
                else if(o1.val==o2.val)return 0;
                else return 1;
            }
        });
        ListNode res=new ListNode(0);
        ListNode p= res;
        for (ListNode node : lists) {
            if (node != null) queue.add(node);
        }
        while (!queue.isEmpty()) {
            p.next = queue.poll();
            p = p.next;
            if (p.next != null) queue.add(p.next);
        }
        return res.next;
    }
    int generateParenthesis(int n) {
        // write code here
        ArrayList<String> res = new ArrayList<>();
        dfs(0,0,n,new StringBuffer(),res);
        return res.size();
    }
    void dfs(int l,int r,int n,StringBuffer buffer,ArrayList<String> res){
        //
        if(r>l||l>n||r>n)return;
        if(l==n&&r==n){
            res.add(buffer.toString());
            return;
        }
        buffer.append('(');
        dfs(l+1,r,n,buffer,res);
        buffer.deleteCharAt(buffer.length()-1);
        buffer.append(')');
        dfs(l,r+1,n,buffer,res);
        buffer.deleteCharAt(buffer.length()-1);
    }
    //Offer 4
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int row=0;
        int col=matrix[0].length-1;
        System.out.println(row+" "+col+" "+matrix[row][col]);
        while(row<matrix.length&&col>=0){
            if(target>matrix[row][col]) {
                row++;
                continue;
            }
            else if(target<matrix[row][col]){
                col--;
                continue;
            }
            else return true;
        }
        return false;
    }
    public int findKthLargest(int[] nums, int k) {
        return 2;
    }
















}





