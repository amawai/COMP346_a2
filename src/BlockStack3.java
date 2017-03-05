/**
 * Class BlockStack3
 * Implements character block stack and operations upon it.
 *
 * $Revision: 1.4 $
 * $Last Revision Date: 2017/02/08 $
 *
 * @author Serguei A. Mokhov, mokhov@cs.concordia.ca;
 * Inspired by an earlier code by Prof. D. Probst

 */
//import EmptyStackException;

class BlockStack3
{
	/**
	 * # of letters in the English alphabet + 2
	 */
	public static final int MAX_SIZE = 28;

	/**
	 * Default stack size
	 */
	public static final int DEFAULT_SIZE = 6;

	/**
	 * Current size of the stack
	 */
	private int iSize = DEFAULT_SIZE;

	/**
	 * Current top of the stack
	 */
	private int iTop  = 3;

	/**
	 * stack[0:5] with four defined values
	 */
	private char acStack[] = new char[] {'a', 'b', 'c', 'd', '$', '$'};
	
	
	//Part of Task 1
	private int stackAccessCounter = 0;
	

	/**
	 * Default constructor
	 */
	public BlockStack3()
	{
	}

	/**
	 * Supplied size
	 */
	public BlockStack3(final int piSize)
	{


                if(piSize != DEFAULT_SIZE)
		{
			this.acStack = new char[piSize];

			// Fill in with letters of the alphabet and keep
			// 2 free blocks
			for(int i = 0; i < piSize - 2; i++)
				this.acStack[i] = (char)('a' + i);

			this.acStack[piSize - 2] = this.acStack[piSize - 1] = '$';

			this.iTop = piSize - 3;
                        this.iSize = piSize;
		}
	}
	public int getITop(){
		return iTop;
	}
	public int getISize(){
		return iSize;
	}
	public int getAccessCounter(){
		return stackAccessCounter;
	}
	public boolean isEmpty(){
		return (this.iTop == -1);
	}
	/**
	 * Picks a value from the top without modifying the stack
	 * @return top element of the stack, char
	 */
	public char pick()
	{	
		stackAccessCounter++;
		return this.acStack[this.iTop];
	}

	/**
	 * Returns arbitrary value from the stack array
	 * @return the element, char
	 */
	public char getAt(final int piPosition)
	{
		stackAccessCounter++;
		char stackContent;
		try{
			stackContent = this.acStack[piPosition];
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.err.println("out of bounds");
		}
		return this.acStack[piPosition];
	}

	/**
	 * Standard push operation
	 */
	public void push(final char pcBlock)
	{
		stackAccessCounter++;
		try {
			if (this.isEmpty()){
				throw new EmptyStackException("Empty");
			}
			else if (this.getITop() == MAX_SIZE){
				throw new Exception();
			}
			this.acStack[++this.iTop] = pcBlock;
		}
		catch (EmptyStackException e){
			this.acStack[++this.iTop] = 'a';
		}
		catch (Exception e) {
			System.err.println("Max size reached");
		}
	}

	/**
	 * Standard pop operation
	 * @return ex-top element of the stack, char
	 */
	public char pop()
	{	
		stackAccessCounter++;
		char cBlock = '$';
		try{
			if (this.isEmpty()){
				throw new EmptyStackException("Empty");
			}
			cBlock = this.acStack[this.iTop];
			this.acStack[this.iTop--] = '$'; // Leave prev. value undefined
		}
		catch (EmptyStackException e){
			System.err.println("IT'S EMPTY");
		}
		catch (Exception e){
			System.err.println("some exception lmao");
		}
		return cBlock;
	}
}

// EOF