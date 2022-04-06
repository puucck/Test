package one;

import java.util.ArrayList;

/**
 * @author www
 * @version 1.0
 * @date 2021/10/11
 * @effect
 */
public class DP {
    //nums 10,9,2,5,3,7,101,18
    //dp   1 ,1,1,1,1,1,1  ,1
    //最长递增子序列
    public int lengthOfLIS(int[] nums) {
        int dp[] = new int[nums.length+1];
        dp[0]=1;
        int n = nums.length;
        int max = 1;
        for(int i=1;i<n;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j])
                dp[i]=Math.max(dp[i],dp[j]+1);
            }
            max =Math.max(dp[i],max);
        }
        return max;
    }
    //最长递增子序列2
    //nums 10,9,2,5,3,7,101,18
    //新建一个list,遍历nums,若大于list中所有的值将nums[i]添加到list
    //否则将num[i]替换
    //例子
    // 10
    // 9
    // 2
    // 2,5     2,3    2,3,7    2,3,7,101  2,3,18,101
    //二分
    public int lengthOfLIS2(int[] nums) {
        ArrayList<Integer>list = new ArrayList<>();
        list.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            int len = list.size();
            if(nums[i]>list.get(len-1))list.add(nums[i]);
            else{
                int l=0,r=len-1,L=0;
                while (l<=r){
                    int mid = (l+r)/2;
                    if(list.get(mid)>=nums[i]){
                        r=mid-1;
                        L=r;
                    }
                    else l=mid+1;
                }
                list.set(L+1,nums[i]);
            }
        }
        return list.size();
    }

}
