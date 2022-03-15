import com.sun.xml.internal.ws.api.pipe.NextAction;

public class KMP {
    //next数组 记住一句话 求当前字符前面的字符串的最长前后缀匹配的长度  不包含当前字符！！！  最长匹配长度不能包含整个字符串！！！
    public int[] getNext(String s){

        int[] next = new int[s.length()];
        char[] str = s.toCharArray();
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int cn = 0;
        while (i < next.length){
            if(str[cn] == str[i-1]){
                next[i] = cn + 1;
                i++;
                cn++;
            }
            else if(next[cn] == -1){
                next[i] = 0;
                i++;
            }else {
                cn = next[cn];
            }
        }

        return next;
    }

    public int strStr(String haystack, String needle) {
        if(haystack == null || haystack.length() == 0 ) return -1;
        if(needle == null || needle.length() == 0)  return 0;

        int i = 0;
        int j = 0;
        char[] s = haystack.toCharArray();
        char[] t = needle.toCharArray();
        int[] next = getNext(needle);
        while (i < s.length && j < t.length){
            if(s[i] == s[j]){
                i++;
                j++;
            }else {
                j = next[j];
            }
        }
        return j == t.length ? i - j : -1;
    }
}
