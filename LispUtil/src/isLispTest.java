import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 * 
 *  @author Alan
 *  @version Sep 25, 2021
 */
class isLispTest
{



    @Test
    void testHelloWorld()
    {
        String s = "(print \"Hello, world!\")";
        assertTrue(LispUtilities.isLisp(s));
    }

    @Test
    void testBlankString()
    {
        String s = "";
        assertTrue(LispUtilities.isLisp(s));        
    }
    
    @Test
    void testComment()
    {
        String s = ";test";
        assertTrue(LispUtilities.isLisp(s));
    }
    
    @Test
    void testCommentWithParenth() {
        String s = ";test(";
        assertTrue(LispUtilities.isLisp(s));
    }
    
    @Test
    void testLispWithComment () {
        String s = "(print \\\"Hello, world!\\\");prints Hellow, world!";
        assertTrue(LispUtilities.isLisp(s));
    }
    
    @Test
    void testLispWithOddParenth() {
        String s = "(print \\\"Hello, world!";
        assertFalse(LispUtilities.isLisp(s));
    }
    
    @Test
    void testLispWithCommentParenth() {
        String s = "(print \"Hello, world!\";Random ( comment";
        assertFalse(LispUtilities.isLisp(s));
    }
    
    @Test
    void testNestedParen() {
        String s = "(print (type-of x))";
        assertTrue(LispUtilities.isLisp(s));
    }
    
    @Test 
    void testNestedBadParenth() {
        String s = "(print (type-of x)";
        assertFalse(LispUtilities.isLisp(s));
    }
    
    @Test
    void testNestedWithCommentParenth() {
        String s = " (cons 1 '(2 3))\r\n"
            + " ;Output: (1 2 3)";
        assertTrue(LispUtilities.isLisp(s));
    }
    
    
    
}
