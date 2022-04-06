package one;

import com.sun.imageio.plugins.common.I18N;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author www
 * @version 1.0
 * @date 2021/10/7
 * @effect
 */
public class DFS {
    //电话号码字母组合
    char[][] m={
            {},
            {},
            {'a','b','c'} ,{'d','e','f'},
            {'g','h','i'},{'j','k','l'},{'m','n','o'},
            {'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}
    };
    public List<String>letterCombinations(String digits){
        List<String>res = new ArrayList<>();
        if(digits==null)return res;
        dfs1(digits,0,new StringBuilder(),res);
        return res;
    }
    void dfs1(String str,int index,StringBuilder sb,List<String>res){
        //截至条件
        if(index==str.length()){
            res.add(sb.toString());
            return;
        }
        //候选节点
        for (char c : m[str.charAt(index) - '0']) {
            sb.append(c);
            dfs1(str,index+1,sb,res);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    //组合总和
    public List<List<Integer>>combinationSum(int[] candidates,int target){
        List<List<Integer>>res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs2(candidates,target,new ArrayList<>(),res,0,0);
        return res;
    }
    void dfs2(int[] p,int t,List<Integer>chain,List<List<Integer>>res, int sum, int idx){
        //截至条件
        if(sum==t){
            res.add(new ArrayList<>(chain));
            return;
        }
        //候选节点
        for (int i = idx; i < p.length; i++) {
            if(sum+p[i]>t)break;
            chain.add(p[i]);
            dfs2(p,t,chain,res,sum+p[i],i);
            chain.remove(chain.size()-1);
        }
    }
    //组合总和2
    public List<List<Integer>>combinationSum2(int[] candidates,int target){
        List<List<Integer>>res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs3(candidates,target,new ArrayList<>(),res,0,0);
        return res;
    }
    void dfs3(int[] p,int t,List<Integer>chain,List<List<Integer>>res,int sum,int index){
        //截至条件
        if(sum==t){
            res.add(new ArrayList<>(chain));
            return;
        }
        //候选节点
        for (int i = index; i < p.length; i++) {
            if(sum+p[i]>t)break;
            //剪枝
            if(i>index&&p[i]==p[i-1])continue;
            chain.add(p[i]);
            dfs3(p,t,chain,res,sum+p[i],i+1);
            chain.remove(chain.size()-1);
        }
    }
    //全排列
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>res = new ArrayList<>();
        if(nums==null)return res;
        dfs4(nums,res,new ArrayList());
        return res;
    }
    void dfs4(int p[],List<List<Integer>>res,List<Integer> chain){
        //截至条件
        if(chain.size()==p.length){
            res.add(new ArrayList<>(chain));
            return;
        }
        //候选条件
        for (int i = 0; i < p.length; i++) {
            //筛选
            if(!chain.contains(p[i])) {
                chain.add(p[i]);
                dfs4(p,res,chain);
                chain.remove(chain.size()-1);
            }
        }
    }
    //全排列2
    boolean[] vis;
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>>res = new ArrayList<>();
        if(nums==null)return res;
        vis = new boolean[nums.length];
        Arrays.sort(nums);
        dfs5(nums,res,new ArrayList(),0);
        return res;
    }
    void dfs5(int p[],List<List<Integer>>res,List<Integer> chain,int index){
        //截至条件
        if(index==p.length){
            res.add(new ArrayList<>(chain));
            return;
        }
        //候选条件
        for (int i = 0; i < p.length; i++) {
            //剪枝
            if(vis[i] || i>0&&p[i]==p[i-1]&&!vis[i-1])continue;
            chain.add(p[i]);
            vis[i] = true;
            dfs5(p,res,chain,index+1);
            vis[i] = false;
            chain.remove(chain.size()-1);
        }
    }
    //括号生成
    public List<String> generateParenthesis(int n) {
        // write code here
        ArrayList<String> res = new ArrayList<>();
        dfs6(0,0,n,new StringBuffer(),res);
        return res;
    }
    void dfs6(int l,int r,int n,StringBuffer buffer,ArrayList<String> res){
        //截至条件
        if(r>l||l>n||r>n)return;
        if(l==n&&r==n){
            res.add(buffer.toString());
            return;
        }
        //候选条件
        buffer.append('(');
        dfs6(l+1,r,n,buffer,res);
        buffer.deleteCharAt(buffer.length()-1);
        buffer.append(')');
        dfs6(l,r+1,n,buffer,res);
        buffer.deleteCharAt(buffer.length()-1);
    }
    private int dis[][]={{1,0},{0,1},{-1,0},{0,-1}};
    //offer12
    public boolean exist(char[][] board, String word) {
        char []words=word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(dfs7(board,words,i,j,0))return true;
            }
        }
        return false;
    }
    boolean dfs7(char[][] board,char[] words,int i,int j,int k){
        //截至条件
        if(i<0||j<0||i>=board.length||j>=board[0].length||board[i][j] != words[k])return false;
        if(k==words.length-1)return true;
        board[i][j]='/';

        for (int l = 0; l < dis.length; l++) {
            for (int n = 0; n < dis[0].length; n++) {
               if(dfs7(board,words,i+dis[l][n],j+dis[l][n],k+1))return true;
            }
        }
        //还原
        board[i][j] = words[k];
        return false;
    }
}
