/**
* <h1>StackCall</h1>
* This program is used to show the demo of
* classes:VariableStack and FixedStack
* @author  Vikas
* @version 1.0
* @since   2017-05-05 
*/

package myPack;

public class StackCall {

	public static void main(String[] args) {
		FixedStack fixedStack = new FixedStack(2);
		fixedStack.push(2);
		fixedStack.push(5);
		fixedStack.push(7);
		
		VariableStack variableStack = new VariableStack(2);
		variableStack.push(1);
		variableStack.push(3);
		variableStack.push(4);
			
	}

}

/*class FixedStack  can accept a fixed numbers of integers. 
The size of the Stack is specified in the constructor.
If the number of integers exceed the size, “Stack overflow” message will be displayed.*/
class FixedStack implements Stack{
	private int[] stack; //declaring an array stack of type integer
	private int stackSize; //will be used to specify the stackSize
	private int top;  //will be used to refer to the current index
	
	//constructor which will initialize the stack with the given stackSize
	public FixedStack(int stackSize) {
		top = -1;
		this.stackSize = stackSize;
		stack = new int[stackSize];
	}
    
	//this method will push the element into the stack
	//if stack size is full it will display "Stack OverFlow"
	@Override
	public boolean push(int i) {
		if(!isFull()){
			top++;
			stack[top] = i;
			System.out.println("Inside FixedStack");
			System.out.println("Element pushed successfully");
			for(int s:stack){
				System.out.println(s);
			}
			return true;
		}else {
			System.out.println("Inside FixedStack");
			System.out.println("Stack Overflow");
			return false;	
		}
		
	}

	//This method will return the top of the stack.
	@Override
	public int pop() {
		return stack[top--];
	}
	
	//to check if the stack is full
	public boolean isFull(){
		return(top == stack.length-1);
	}
	
}

/*class VariableStack that can accept numbers more than its size. 
The size of the Stack will be specified in the constructor. If the number of integers exceed the size,
the stack should automatically grow to accommodate the new element.
*/
class VariableStack implements Stack{
	private int[] stack; //declaring an array stack of type integer
	private int stackSize; //will be used to specify the stackSize
	private int top;  //will be used to refer to the current index
	
	//constructor which will initialize the stack with the given stackSize
	public VariableStack(int stackSize) {
		top = -1;
		this.stackSize = stackSize;
		stack = new int[stackSize];
	}
	
	//this method will push the element into the stack
	//if stack size is full it will increase the size of the stack dynamically
	@Override
	public boolean push(int i) {
		System.out.println();
		System.out.println("Inside VariableStack");
		if(!isFull()){
			top++;
			stack[top] = i;
			System.out.println("Element pushed successfully");
			return true;
		}else {
			System.out.println("Old Stack is full growing the stack dynamically");
			System.out.println("Old Stack Size is: "+stackSize);
			this.increaseStackCapacity();
			top++;
			stack[top] = i;
			System.out.println("Element pushed successfully with increased stack size of: "+stackSize);
			for(int s:stack){
			System.out.println(s);
			}
			return true;	
		}
	}
	
	//when stack size is full this method will increase the stackSize
	private void increaseStackCapacity(){
        
        int[] newStack = new int[this.stackSize+1];
        for(int i=0;i<stackSize;i++){
            newStack[i] = this.stack[i];
        }
        this.stack = newStack;
        this.stackSize = this.stackSize+1;
    }
	
	//This method will return the top of the stack.
	@Override
	public int pop() {
		return stack[top--];
	}
	
	//to check if the stack is full
	public boolean isFull(){
		return(top == stack.length-1);
	}

	
}