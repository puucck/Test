package MyThread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.locks.LockSupport;

/**
 * @author www
 * @version 1.0
 * @date 2021/9/14
 * @effect
 */
public class ThreadAlternatePrint {
    public static void main(String args[]) {
        int n=0;
        Scanner scanner = new Scanner(System.in);
        n=scanner.nextInt();
        int arr[]=new int[n];
        int i=0,j,k;
        while (n>0){
            arr[i++] = scanner.nextInt();
            n--;
        }
        Arrays.sort(arr);
        for(k=0;k<arr.length;k++){
            if(arr[k]>=0)break;
        }
        if(k==arr.length)k=arr.length-1;
        int sum=0,sum2=0,k2=k;
        for(j=1;k<arr.length;k++,j++){
            sum+=arr[k]*j;
        }
        for(j=1;k<arr.length;k++,j++){
            sum+=arr[k]*j;
        }
        System.out.println(sum);
    }

    public void quick_sort(int nums[],int left,int right){
        if(left>=right)return;
        int temp=nums[left];
        int i=left;
        int j=right-1;
        while(i<j){
            while(nums[j]>=temp&&i<j)j--;
            while(nums[i]<=temp&&i<j)i++;
            if(i<j){
                int k=nums[i];
                nums[i]=nums[j];
                nums[j]=k;
            }
        }
        nums[left]=nums[i];
        nums[i]=temp;
        quick_sort(nums,left,right-1);
        quick_sort(nums,i+1,right);
    }
}
