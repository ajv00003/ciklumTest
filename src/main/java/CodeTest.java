import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CodeTest {
    public static void main(String[] args) {
        System.out.println("All Test are implemented, just run them all");
        System.out.println("Is it possible to run them in the main function?");
    }
    
    /*
     * SQL Exercises:
     * 
     * 1.- SELECT DISTINCT * FROM customers;
     * 
     * 2.- INSERT INTO customers (name, mail, password) VALUES ('Angel','angel@mail.com','1234');
     * 
     * 3.- SELECT * FROM customers LEFT JOIN orders ON customers.id=orders.customer_id;
     * 
     */

    public static String[] reverseArray(String[] input) {
    	List<String> input2=Arrays.asList(input);
    	Collections.reverse(input2);
        return (String[]) input2.toArray(input);
    }

    public static String[] uppercaseArray(String[] input) {
    	return Arrays.stream(input).map(String::toUpperCase).toArray(String[]::new);
    }

    public static int findWordCount(String text, String wordToFind) {
    	
    	/* The method header does not correspond with the question in github, but the solution (based in the 
    	 * github statement) wold be something like this...
    	 * 
    	 * Map<String,Integer> m=new HashMap<>();
    	 * Arrays.stream(text.split(" ")).forEach((String s)->m.containsKey(s)?m.put(s,m.get(s)+1):m.put(s,1));
    	 */
    	
    	return (int)Arrays.stream(text.split(" ")).filter(s -> s.equals(wordToFind)).count();
    }

    public static Function<Integer,Integer> composeU(Function<Integer,Integer> f1, Function<Integer,Integer> f2){
    	return f2.compose(f1);
    }

    public static void writeContentsToConsole() {
    	String path="c:/exampleText.txt";//Put here the absolute path to the file
        
    	File f=new File(path);
    	
    	if(f.exists() && f.isFile() && !f.isDirectory()) {
    		try(BufferedReader br=Files.newBufferedReader(f.toPath())){
    			String line=br.readLine();
    			while(line!=null) {
    				System.out.println(line);
    				line=br.readLine();
    			}
    		} catch (IOException e) {
				e.printStackTrace();
			}
    	}
    }

    public static void handleInvalidArgument() {
        String mailAddress="badAddress";
        
        checkMailAdress(mailAddress);
    }
    
    private static void checkMailAdress(String address) {
    	/* this is not the perfect way to check a mail address
    	   but is enough for the purpose of the function */
    	if(!address.matches("(.+)@(.+)\\.(.+)")) { 
    		throw new IllegalArgumentException();
    	}
    }

    public static void puzzle() {
        
        List<Integer> numbers = (List<Integer>) new Random().ints(0,10).limit(10).boxed().collect(Collectors.toList());

        puzzleGame(numbers);
        
    }
    
    /*
     * I made a simple procedure but it would be possible to make  
     * a standalone application that was called from the console
     */
    public static void puzzleGame(List<Integer> l) {
    	Collections.sort(l);
    	
    	if(l!=null && l.size()>1) {
    		int i=0;
    		StringBuilder sb=new StringBuilder();
    		
    		do {
    			i++;
    			sb.append(l.get(i-1));
    			sb.append(",");
    		}while(l.get(i-1).intValue()!=l.get(i).intValue() && i<l.size()-1);
    		
    		sb.append(l.get(i));
    		
    		if(l.get(i-1)==l.get(i)) {
    			sb.append(",'Snap'");
    		}
    		
    		System.out.println(sb.toString());
    	}
    }
}