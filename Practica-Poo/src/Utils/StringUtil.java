package Utils;

public class StringUtil {

    public static String rpad(String s,char c,int n) {

        if(s == null || s.length() <= n) {
            return s;
        }

        StringBuffer sb = new StringBuffer(s);
        for(int i = sb.length() ; i < n ; i++) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static String lpad(String s,char c,int n) {
        if(s == null || s.length() <= n) {
            return s;
        }

        StringBuffer sb = new StringBuffer(s);
        for(int i = 0 ; i < n-s.length() ; i++) {
            sb.setCharAt(0, c);
        }
        return sb.toString();
    }

    public static String ltrim(String s) {
        if(s == null) {
            return null;
        }

        StringBuffer sb = new StringBuffer(s);
        char [] chars = s.toCharArray();
        for(int i = 0 ; i < s.length() ; i++) {
            if(chars[0] == ' ') {
                sb.delete(0,1);
            } else {
                return sb.toString();
            }
        }
        return sb.toString();

    }

    public static String rtrim(String s) {
        if(s == null) {
            return null;
        }

        StringBuffer sb = new StringBuffer(s);
        char [] chars = s.toCharArray();
        for(int i = s.length()-1 ; i >= 0 ; i--) {
            if(chars[i] == ' ') {
                sb.delete(i,i-1);
            } else {
                return sb.toString();
            }
        }
        return sb.toString();

    }

    public static String trim(String s) {
        String response = ltrim(s);
        response = rtrim(response);
        return response;
    }

    public static int indexOfN(String s,char c,int n) {
        if(s == null || n <= 0) {
            return -1;
        }

        int count = 0;
        char [] chars = s.toCharArray();
        for(int i = 0 ; i < s.length() ; i++) {
            if(chars[i] == c) {
                count++;
            }
            if(count == n) {
                return i;
            }
        }
        return -1;
    }
}
