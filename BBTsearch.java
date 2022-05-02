
	import java.util.*;
	
	public class BBTsearch {

	static int MAX_SIZE= 130;
	 
	// BST node
	static class node
	{ int val;
	    node left, right; }
	 
	// Stack type
	static class Stack
	
	{   int size;
	    int top;
	    node []array; }
	 
	// A utility function to create a stack of given size
	static Stack createStack(int size)
	
	{	Stack stack = new Stack();
	    stack.size = size;
	    stack.top = -1;
	    stack.array = new node[stack.size];
	    return stack; }
	 
	// BASIC OPERATIONS OF STACK
	static int isFull(Stack stack)
	{ return (stack.top - 1 == stack.size)?1:0; }
	 
	static int isEmpty(Stack stack)
	{ return stack.top == -1?1:0; }
	 
	static void push(Stack stack, node node)
	
	{ if (isFull(stack)==1)
	        return;
	    stack.array[++stack.top] = node; }
	 
	static node pop(Stack stack)
	
	{  if (isEmpty(stack) == 1)
	        return null;
	    return stack.array[stack.top--]; }
	 
	// Returns true if a pair with target
	// sum exists in BST, otherwise false
	static boolean isPairPresent(node root, int target)
	{
	    // used for reverse inorder traversal
	    Stack s1 = createStack(MAX_SIZE);
	    Stack s2 = createStack(MAX_SIZE);
	 
	    // Note the sizes of stacks is MAX_SIZE,
	    // we can find the tree size and fix stack size
	 
	    boolean done1 = false, done2 = false;
	    int val1 = 0, val2 = 0;
	    node curr1 = root, curr2 = root;
	 
	    // traversals is complete
	    while (true) {
	       
	        // Find next node in Inorder
	        while (done1 == false) {
	            if (curr1 != null) {
	                push(s1, curr1);
	                curr1 = curr1.left; }
	            
	            else {
	                if (isEmpty(s1) == 1)
	                    done1 = true;
	                	else {
	                    curr1 = pop(s1);
	                    val1 = curr1.val;
	                    curr1 = curr1.right;
	                    done1 = true;
	                }
	            }
	        }
	 
	        // right subtree is traversed before left subtree
	        while (done2 == false)
	        {
	            if (curr2 != null)
	            {
	                push(s2, curr2);
	                curr2 = curr2.right;
	            }
	            else {
	                if (isEmpty(s2) == 1)
	                    done2 = true;
	                else {
	                    curr2 = pop(s2);
	                    val2 = curr2.val;
	                    curr2 = curr2.left;
	                    done2 = true;
	                }
	            }
	        }
	 
	        // print the founded paid and return.
	        //The first condition will makes sure that two same values are not added
	        if ((val1 != val2) && (val1 + val2) == target)
	        {
	            System.out.print("Pair Found : " + val1 + " + " + val2 + " = " +  target );
	            return true;
	        }
	 
	        // If sum of current values is smaller  then the required,
	        // then move to next node in normal inorder traversal
	        else if ((val1 + val2) < target)
	            done1 = false;
	 
	        // If sum of current values is greater then the required,
	        // then move to next node in reverse inorder traversal
	        else if ((val1 + val2) > target)
	            done2 = false;
	 
	        // If any of the inorder traversals is
	        // over, then there is no pair
	        // so return false
	        if (val1 >= val2)
	            return false;
	    }
	}
	 
	// utility to create BST
	static node NewNode(int val)
	{
	    node tmp = new node();
	    tmp.val = val;
	    tmp.right = tmp.left = null;
	    return tmp;
	}
	 
	// Driver to test above funtion
	public static void main(String[] args)
	{
	    /*
	                40
	              /    \
	            20      60
	           /  \    /  \
	         10   30  50  70
	                          */
		
	    node root = NewNode(40);
	    root.left = NewNode(20);
	    root.right = NewNode(10);
	    root.left.left = NewNode(30);
	    root.left.right = NewNode(60);
	    root.right.left = NewNode(50);
	    root.right.right = NewNode(70);
	 
	    int target = 130;
	    if (isPairPresent(root , target) == false)
	        System.out.print("No Pair Found");
	}
	}
	 
	// This code is written by Uprant

	


