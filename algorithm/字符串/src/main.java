import javax.swing.*;
import java.util.*;

public class main {
    public static void main(String[] args) {
        System.out.println("  aa  ");
        repeatedSubstringPattern("abac");
    }
    public void reverseString(char[] s) {
        int h = 0, t = s.length - 1;
        char temp;
        while (h < t){
            temp = s[h];
            s[h] = s[t];
            s[t] = temp;
            h++;
            t--;
        }
    }

    public static void reverseStr(char[] s, int start, int end) {
        int h = start, t = end;
        char temp;
        while (h < t){
            temp = s[h];
            s[h] = s[t];
            s[t] = temp;
            h++;
            t--;
        }
    }

    public static String reverseStr(String s, int k) {
        //可优化为空间复杂度On
        int slow = 0, fast = 2*k - 1;
        char[] ch = s.toCharArray();
        while (fast < s.length()){
            reverseStr(ch, slow, slow + k - 1);
            slow = fast + 1;
            fast = slow + 2*k - 1;
        }
        if(ch.length - slow < k)    reverseStr(ch, slow, ch.length - 1);
        else reverseStr(ch, slow, slow + k - 1);

//        return Arrays.toString(ch);
        return String.valueOf(ch);
    }


    //熟悉api
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        List<String> list = Arrays.asList(words);
        Collections.reverse(list);
        return String.join(" ", list);

    }

    public String reverseLeftWords(String s, int n) {
        char[] str = s.toCharArray();
        reverseStr(str, 0, n - 1);
        reverseStr(str, n, str.length - 1);
        reverseStr(str,0, str.length - 1);
        return String.valueOf(str);
    }

    public int strStr(String haystack, String needle){
        if(haystack == null || haystack.length() == 0 ) return -1;
        if(needle == null || needle.length() == 0)  return 0;

        int i = 0;
        int j = 0;
        char[] s = haystack.toCharArray();
        char[] t = needle.toCharArray();
        int[] next = getNext(needle);
        while (i < s.length && j < t.length){
            if(s[i] == t[j]){
                i++;
                j++;
            }else if(next[j] != -1){
                j = next[j];
            }else {
                i++;
            }
        }

        return j == t.length ? i - j : -1;
    }


    public int[] getNext(String s){
        if(s.length() == 1) return new int[]{-1};
        int[] next = new int[s.length()];
        char[] str = s.toCharArray();
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int cn = 0;  // str[next[i-1]]
        while (i < next.length){
            if(str[cn] == str[i-1]){
                next[i++] = ++cn;
            }else if(next[cn] == -1){
                next[i++] = 0;
            }else {
                cn = next[cn];
            }
        }

        return next;
    }

    //kmp未AC
    public static boolean repeatedSubstringPattern(String s) {
        int[] next = next(s.toCharArray());
        int len = s.length();

        return len % (len - (next[len - 1] + 1)) == 0;
    }

    public static int[] next(char[] str){
        if(str.length == 1) return new int[] {-1};
        int[] next = new int[str.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int cn = 0;
        while (i < str.length){
            if(str[i-1] == str[cn])     next[i++] = ++cn;
            else if(next[cn] != -1)     cn = next[cn];
            else                        next[i++] = 0;
        }

        return next;
    }
}
