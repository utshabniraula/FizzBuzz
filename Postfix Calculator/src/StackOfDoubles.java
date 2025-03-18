import java.util.LinkedList;

/**
 * A stack implementation for storing double values.
 * This class implements the Stack<Double> interface.
 */
public class StackOfDoubles implements Stack<Double> {
    private LinkedList<Double> stackData; // LinkedList to store stack elements

    /**
     * Constructor to initialize the stack.
     */
    public StackOfDoubles() {
        stackData = new LinkedList<>(); // Initialize the LinkedList
    }

    /**
     * Checks if the stack is empty.
     * @return true if the stack is empty, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return stackData.isEmpty(); // Use LinkedList's isEmpty method
    }

    /**
     * Pushes a value onto the top of the stack.
     * @param value The value to push onto the stack.
     */
    @Override
    public void push(Double value) {
        stackData.add(value); // Add the value to the end of the LinkedList
    }

    /**
     * Pops the top value from the stack and returns it.
     * @return The value popped from the stack.
     * @throws IllegalStateException if the stack is empty.
     */
    @Override
    public Double pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot pop from an empty stack.");
        }
        return stackData.removeLast(); // Remove and return the last element
    }

    /**
     * Returns the top value from the stack without removing it.
     * @return The value at the top of the stack.
     * @throws IllegalStateException if the stack is empty.
     */
    @Override
    public Double peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot peek from an empty stack.");
        }
        return stackData.getLast(); // Return the last element without removing it
    }
}