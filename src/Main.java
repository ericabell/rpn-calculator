import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
	    // create a variable that will hold the stack
        Stack<Double> stack = new Stack();

        // variables to hold two operands
        Double operand1 = 0.0;
        Double operand2 = 0.0;

        // use Scanner to read user input line-by-line
        Scanner scanner1 = new Scanner(System.in);

        // print some instructions for the user
        System.out.println("Each number or operator followed by Enter");

        boolean done = false;

        // loop as long as we aren't done
        while( !done ) {
            String input = scanner1.nextLine();

            switch(input) {
                case "+":
                    operand1 = stack.pop();
                    operand2 = stack.pop();
                    stack.push(operand1+operand2);
                    break;
                case "-":
                    operand1 = stack.pop();
                    operand2 = stack.pop();
                    stack.push(operand1-operand2);
                    break;
                case "*":
                    operand1 = stack.pop();
                    operand2 = stack.pop();
                    stack.push(operand1*operand2);
                    break;
                case "/":
                    operand1 = stack.pop();
                    operand2 = stack.pop();
                    stack.push(operand1/operand2);
                    break;
                case "exit":
                    done = true;
                    break;
                default:
                    stack.push(Double.parseDouble(input));

            }
            System.out.println(stack);
        }
        System.out.println("Done!");
    }
}
