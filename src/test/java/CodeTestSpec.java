import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.function.Function;

/*
 *   Please code the tests in the format of reverseArray_returnsExpectedResult. This is an example of how we write our tests at Cardano.
 *
 *   Test 1-4 tests are easy as the function returns a result that can be asserted. Tests 5-7 are more difficult to assert as they are
 *   void, use your knowledge to write a meaningful test.
 *
 *   Feel free to use the internet to help you with you answers but make sure you understand the answer as we will ask you questions.
 */

public class CodeTestSpec {
    @Test
    public void reverseArray_returnsExpectedResult() {
        // arrange
        final String[] EXPECTED = {"x", "y", "z"};

        // act
        final String[] actual = CodeTest.reverseArray(new String[] {"z", "y", "x"});

        // assert
        assertArrayEquals(EXPECTED, actual);
    }

    @Test
    public void uppercaseArray_returnsExpectedResult() {
    	final String[] EXPECTED = {"X", "Y", "Z"};
    	
    	final String[] actual = CodeTest.uppercaseArray(new String[] {"x", "y", "z"});
    	
    	assertArrayEquals(EXPECTED, actual);
    }

    @Test
    public void findWordCount_returnsExpectedResult() {
    	final String text="the cat jumped over the mat";
    	
    	final String word="the";
    	
    	int result=CodeTest.findWordCount(text, word);
    	
    	assertEquals(result, 2);
    }

    @Test
    public void composeU_returnsExpectedResult() {
    	Function<Integer, Integer> f=CodeTest.composeU(i -> i+1, j ->j*3);

    	assertEquals(f.apply(7).intValue(),24);
    }

    @Test
    public void writeContentsToConsole_returnsExpectedResult() {
    	
    	ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    	
    	System.setOut(new PrintStream(outputStreamCaptor));
    	
    	CodeTest.writeContentsToConsole();
    	
    	//put inside the empty String the text from the file
    	assertEquals("", outputStreamCaptor.toString().trim());
    }

    @Test(expected = IllegalArgumentException.class)
    public void handleInvalidArgument_returnsExpectedResult() {
    	CodeTest.handleInvalidArgument();
    }

    @Test
    public void puzzle_returnsExpectedResult() {
    	ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    	
    	System.setOut(new PrintStream(outputStreamCaptor));
    	
    	CodeTest.puzzle();
    	
    	String result=outputStreamCaptor.toString().trim();
    	
    	String[] values=result.split(",");
    	
    	for(int i=1;i<values.length-3;i++) {
    		assertNotEquals(values[i-1], values[i]);
    	}
    	
    	if(values[values.length-3].equals("'Snap'")) {
    		assertNotEquals(values[values.length-3], values[values.length-2]);
    		assertNotEquals(values[values.length-2], values[values.length-1]);
    	}else {
    		assertEquals(values[values.length-3], values[values.length-2]);
    	}
    }
}
