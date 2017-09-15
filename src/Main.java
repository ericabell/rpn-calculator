import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static Double[] popTwo(Stack theStack) throws Exception {
        // try to pop two values and return them in an array
        // catch any errors
        Double[] operands = new Double[2];
        try {
            operands[0] = ((Double)theStack.pop());
            operands[1] = ((Double)theStack.pop());
        } catch (Exception e) {
            System.out.println("Sorry, not enough values on the stack!");
            // if we popped just one value but not the second, restore the first
            // value by pushing it on the stack
            if( operands[0] != null ) {
                theStack.push(operands[0]);
            }
            throw new Exception("Problems popping.");
        }
        return operands;
    }

    public static void main(String[] args) {
	    // create a variable that will hold the stack
        Stack<Double> stack = new Stack();

        // variables to hold two operands
        Double[] operands = new Double[2];

        // use Scanner to read user input line-by-line
        Scanner scanner1 = new Scanner(System.in);

        // print some instructions for the user
        System.out.println("Each number or operator followed by Enter");

        boolean done = false;

        // loop as long as we aren't done
        while( !done ) {
            String input = scanner1.nextLine();
            try {
                switch(input) {
                    case "exit":
                        done = true;
                        break;
                    case "swap":
                        operands = popTwo(stack);
                        stack.push(operands[0]);
                        stack.push(operands[1]);
                        break;
                    case "+":
                        operands = popTwo(stack);
                        stack.push(operands[0] + operands[1]);
                        break;
                    case "-":
                        operands = popTwo(stack);
                        stack.push(operands[1] - operands[0]);
                        break;
                    case "*":
                        operands = popTwo(stack);
                        stack.push(operands[0] * operands[1]);
                        break;
                    case "/":
                        operands = popTwo(stack);
                        stack.push(operands[1] / operands[0]);
                        break;
                    default:
                        try {
                            stack.push(Double.parseDouble(input));
                        } catch (NumberFormatException ex) {
                            System.out.println("Please enter a number.");
                        }
                }
            } catch(Exception e) {
                System.out.println("Sorry, couldn't perform the requested operation.");
            }
            System.out.println("Current stack: " + stack);
        }
        System.out.println("Done!");
    }
}
