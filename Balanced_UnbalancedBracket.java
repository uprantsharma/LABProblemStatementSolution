	import java.util.Deque;
	import java.util.ArrayDeque;
	//import java.util.Scanner;
	
public class Balanced_UnbalancedBracket {	 
	   
	    static boolean isBracketsBalanced(String expr) {  
	        Deque<Character> stack = new ArrayDeque<Character>();
	 
	        // Traversing the Expression
	        for (int i = 0; i < expr.length(); i++)
	        {
	            char x = expr.charAt(i);
	 
	            if (x == '(' || x == '[' || x == '{')
	            {
	                stack.push(x);
	                continue;
	            }
	 
	            if (stack.isEmpty())
	                return false;
	            char check;
	            switch (x) {
	            case ')':
	                check = stack.pop();
	                if (check == '{' || check == '[')
	                    return false;
	                break;
	 
	            case '}':
	                check = stack.pop();
	                if (check == '(' || check == '[')
	                    return false;
	                break;
	 
	            case ']':
	                check = stack.pop();
	                if (check == '(' || check == '{')
	                    return false;
	                break;
	            }
	        }
	 
	        // Check Empty Stack
	        return (stack.isEmpty());
	    }
	 
	    // Driver code
	    public static void main(String[] args) {
	    	
	     
	    	//String expr = "([[{}]])";
	        String expr = "([[{}]]))";
	 
	        // Function call
	        if (isBracketsBalanced(expr))
	            System.out.println("The entered String has Balanced Brackets");
	        else
	            System.out.println("The entered Strings do not contain Balanced Brackets");
	    }
	
}







