import java.util.HashMap;

/**
 *  Utilities used to help determine if inputs meet
 *  LISP syntax.
 *  
 *  @author Alan
 *  @version Sep 25, 2021
 */
public final class LispUtilities
{
    
    /**
     * 
     * Returns a boolean if input has the correct amount of parenthesis
     * @param s
     * @return true or false
     */
    public static boolean hasCorrectParenthesis(String s) {
        HashMap <Character, Integer> map = new HashMap <Character, Integer>();
        
        //remove comments
        s = s.replaceAll(";.*\\R*", "");
        
        //remove alphanumeric characters
        s = s.replaceAll("\\w", "");
        
        if(s.length() == 0) {
            return true;
        }
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            }
        }
        
        
        return map.get('(') == map.get(')');
    }
}
