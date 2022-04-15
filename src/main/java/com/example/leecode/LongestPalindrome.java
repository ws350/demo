package com.example.leecode;

/**
 * @author xiaoma
 * @desc ...最大回文字串
 * 对于一个字串而言，如果他是回文串，并且长度大于2，那么将它的首尾去掉后，它
 * 依然是个回文串。例如“ababa ，如果我们已经知道bab是个回文串，那么ababa一定是个回文串。
 * 这样的思路，我们可以用动态规划的方法，用p(i,j)表示字符串s的第i到j个字符组成的串（s[i,j])
 * 是否回文串.如果s[i,j]本身不是回文串，或i>j不合法
 * 动态规划的状态转移方程：p[i,j] = p(i+1,j-1) /\(si==sj)
 * 也就是S[i+1,j-1]是回文串，且si==sj，s[i,j]才是回文串
 *
 * @date 2021-10-11 21:07:57
 */
public class LongestPalindrome {

    public String LongestPalindrome1(String s){
        int len = s.length();
        if(len <2){
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        //dp[i][j]表示s[i...j]是回文串
        boolean[][] dp = new boolean[len][len];
        //初始化：所有的长度为1的字串都是回文串
        for(int i=0;i<len;i++){
            dp[i][i] = true;
        }
        char[] charArray = s.toCharArray();
        for(int l=2;l<=len;l++){
            //枚举左边界，左边界的上限设置可以 宽松一些
            for(int i=0;i<len;i++){

                int j=l+i+1;
                //到了最后边，跳出当前循环
                if(j>=len){
                    break;
                }
                if(charArray[i] !=charArray[j]){
                    dp[i][j] = false;
                }else{
                    if(j-i<3){
                        dp[i][j] = true;

                    }else{
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                //只要dp[i][j]==true成立，就表示字串是回文
                if(dp[i][j] && j-i+1 >maxLen){
                    maxLen = j-i+1;
                    begin = i;
                }
            }


        }
        return s.substring(begin,begin+maxLen);

    }

}
