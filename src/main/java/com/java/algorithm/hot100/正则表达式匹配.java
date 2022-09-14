package com.java.algorithm.hot100;


/**
   给你一个字符串 s 和一个字符规律 p，
    请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。

    '.' 匹配任意单个字符
    '*' 匹配零个或多个前面的那一个元素
        所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
    eg:
        输入：s = "aa", p = "a*"
        输出：true
        解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 */
public class 正则表达式匹配 {
    public static void main(String[] args) {
        String s = "aa";
        String p = "a*";
        boolean match = isMatch(s, p);
        System.out.println(match);
    }


    /** s是正常字符串，p是正则语句 */
    public static boolean isMatch(String s, String p) {
        
        //如果p的length为0，这时候如果s也为0，明显是匹配的，如果s不为0，那就是不匹配
        if(p.length() ==0) return s.length() ==0;
        
        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();
        // System.out.println(pp.length);
        //头部匹配
        boolean first_match = ss.length !=0 && (ss[0] == pp[0] || pp[0] == '.');
        //如果正则字符串长度大于2，且第二个字符是*
        System.out.println(p.length());
        if(pp.length >= 2 && pp[1] == '*'){
            //可以去匹配后边的
            //如果第一个匹配上了，也可以排除第一个去做匹配，注意长度和下标的匹配
            return isMatch(s, p.substring(2)) || (first_match && isMatch(s.substring(1), p));
        }else{
            // System.out.println("-----2-----");
            //如果正则字符串只有两个或者一个，那就依赖于首个匹配和后边部分匹配了
            return first_match && isMatch(s.substring(1), p.substring(1));
        }
    }
}
