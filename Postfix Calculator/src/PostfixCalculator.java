/**
 * A postfix calculator that evaluates postfix expressions.
 *
 *Author Utshab Niraula
 */



import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * This class uses a stack to store operands and a map to store operator implementations.
 */
public class PostfixCalculator {
    private StackOfDoubles operandStack; // Stack to store operands (numbers)
    private Map<String, Operator> operatorMap; // Map to store operator symbols and their implementations

    /**
     * Constructor to initialize the calculator.
     * Populates the operator map with supported operators.
     */
    public PostfixCalculator() {
        operandStack = new StackOfDoubles(); // Initialize the operand stack
        operatorMap = new HashMap<>(); // Initialize the operator map

        // Add supported operators to the map
        operatorMap.put("+", new AdditionOperator()); // Addition operator
        operatorMap.put("add", new AdditionOperator()); // Alternate symbol for addition
        operatorMap.put("sub", new SubtractionOperator()); // Alternate symbol for subtraction
        operatorMap.put("-", new SubtractionOperator()); // Subtraction operator
        operatorMap.put("*", new MultiplicationOperator()); // Multiplication operator
        operatorMap.put("mult", new MultiplicationOperator()); // Alternate symbol for multiplication
        operatorMap.put("/", new DivisionOperator()); // Division operator
        operatorMap.put("div", new DivisionOperator()); // Alternate symbol for division
        operatorMap.put("=", new PrintOperator()); // Print operator (displays the top of the stack)
        operatorMap.put("print", new PrintOperator()); // Alternate symbol for print
        operatorMap.put("sqrt", new SquareRootOperator()); // Square root operator
    }

    /**
     * Stores an operand (number) on the stack.
     * @param value The operand to store.
     */
    public void storeOperand(double value) {
        operandStack.push(value); // Push the operand onto the stack
    }

    /**
     * Evaluates an operator using the operands on the stack.
     * @param operatorSymbol The symbol of the operator to evaluate.
     * @throws IllegalArgumentException if the operator symbol is unknown.
     * @throws IllegalStateException if there are not enough operands for the operator.
     */
    public void evalOperator(String operatorSymbol) {
        Operator operator = operatorMap.get(operatorSymbol); // Look up the operator in the map
        if (operator == null) {
            throw new IllegalArgumentException("Unknown operator: " + operatorSymbol);
        }

        int numArgs = operator.numArgs(); // Get the number of arguments required by the operator
        List<Double> operands = new ArrayList<>(); // List to store operands for the operator
        for (int i = 0; i < numArgs; i++) {
            if (operandStack.isEmpty()) {
                throw new IllegalStateException("Not enough operands for operator: " + operatorSymbol);
            }
            operands.add(0, operandStack.pop()); // Pop operands from the stack and add to the list
        }

        double result = operator.eval(operands); // Evaluate the operator with the operands
        operandStack.push(result); // Push the result back onto the stack
    }

    /**
     * Nested class for the addition operator.
     */
    private class AdditionOperator implements Operator {
        @Override
        public int numArgs() {
            return 2; // Addition requires 2 operands
        }

        @Override
        public double eval(List<Double> args) {
            return args.get(0) + args.get(1); // Return the sum of the operands
        }
    }

    /**
     * Nested class for the subtraction operator.
     */
    private class SubtractionOperator implements Operator {
        @Override
        public int numArgs() {
            return 2; // Subtraction requires 2 operands
        }

        @Override
        public double eval(List<Double> args) {
            return args.get(0) - args.get(1); // Return the difference of the operands
        }
    }

    /**
     * Nested class for the multiplication operator.
     */
    private class MultiplicationOperator implements Operator {
        @Override
        public int numArgs() {
            return 2; // Multiplication requires 2 operands
        }

        @Override
        public double eval(List<Double> args) {
            return args.get(0) * args.get(1); // Return the product of the operands
        }
    }

    /**
     * Nested class for the division operator.
     */
    private class DivisionOperator implements Operator {
        @Override
        public int numArgs() {
            return 2; // Division requires 2 operands
        }

        @Override
        public double eval(List<Double> args) {
            if (args.get(1) == 0) {
                throw new ArithmeticException("Division by zero is not allowed.");
            }
            return args.get(0) / args.get(1); // Return the quotient of the operands
        }
    }

    /**
     * Nested class for the print operator.
     * This operator prints the top value of the stack without modifying it.
     */
    private class PrintOperator implements Operator {
        @Override
        public int numArgs() {
            return 1; // Print requires 1 operand
        }

        @Override
        public double eval(List<Double> args) {
            double value = args.get(0); // Get the operand
            System.out.println(value); // Print the operand
            return value; // Return the operand unchanged
        }
    }

    /**
     * Nested class for the square root operator.
     */
    private class SquareRootOperator implements Operator {
        @Override
        public int numArgs() {
            return 1; // Square root requires 1 operand
        }

        @Override
        public double eval(List<Double> args) {
            double value = args.get(0); // Get the operand
            if (value < 0) {
                throw new ArithmeticException("Square root of a negative number is not allowed.");
            }
            return Math.sqrt(value); // Return the square root of the operand
        }
    }
}