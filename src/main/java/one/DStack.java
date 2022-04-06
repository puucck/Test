package one;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author www
 * @version 1.0
 * @date 2021/10/8
 * @effect
 */
public class DStack {
    public static void main(String[] args) {
        DStack dStack = new DStack();
        int arr[]={73,74,75,71,69,72,76,73};
        int brr[]=dStack.dailyTemperatures(arr);
        for (int i : brr) {
            System.out.printf(i+" ");
        }

    }
    //最高温度
    public int [] dailyTemperatures(int[] temp){
      int [] res = new int[temp.length];
      //定义单调栈   大的在栈底,小的在栈顶
      Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < temp.length; i++) {
            while (!deque.isEmpty()&&temp[i]>temp[deque.peek()]){
                //将新的元素放到栈中合适位置,小于改数的出栈
                res[deque.peek()]=i- deque.pop();;
            }
            deque.push(i);
        }
      return res;
    }
    //接雨水
    public int trap(int[] height) {
        int res =0;

        return res;
    }
}
