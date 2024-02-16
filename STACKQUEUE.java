// Class representing a stack data structure
class Stack {
    // Initialize as -1, default size as 10, and an array of integers with default size
    public int top = -1;
    public int defaultsize = 10;
    public int[] array = new int[defaultsize];

    // Method to push an integer onto the stack
    public void push(int x) {
        // Check if the stack is full
        if (top == defaultsize - 1) {
            System.out.println("Stack is Full");
            // If the stack is full, do not add the integer and return
            return;
        } else {
            // If the stack is not full, add the integer to the top of the stack
            array[++top] = x;
        }
    }

    // Method to pop an integer from the stack
    public int pop() {
        // Check if the stack is empty
        if (top == -1) {
            System.out.println("Stack is Empty");
            // If the stack is empty, return 0
            return 0;
        } else {
            // If the stack is not empty, return the integer at the top of the stack and remove it
            return array[top--];
        }
    }

    // Method to view the integer at the top of the stack
    public int peek() {
        // Return the integer at the top of the stack
        return array[top];
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        if (top == -1) {
            // If the stack is empty, return true
            return true;
        } else {
            // If the stack is not empty, return false
            return false;
        }
    }

    // Method to check if the stack is full
    public boolean isFull() {
        if (top == defaultsize - 1) {
            // If the stack is full, return true
            return true;
        } else {
            // If the stack is not full, return false
            return false;
        }
    }
}

// Class representing a queue data structure
class Queue {
    // Initialize two stack objects
    Stack inStack = new Stack();
    Stack outStack = new Stack();

    // Method to add an integer to the queue
    public void enqueue(int x) {
        // Push the integer onto the inStack
        inStack.push(x);
    }

    // Method to remove an integer from the queue
    public int dequeue() {
        // Check if the outStack is empty
        if (outStack.isEmpty()) {
            // If the outStack is empty, move all elements from the inStack to the outStack
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }

        // If the outStack is not empty, pop and return the top element
        if (!outStack.isEmpty()) {
            return outStack.pop();
        } else {
            // If both stacks are empty, return 0
            return 0;
        }
    }

    // Method to view the front element of the queue
    public int peek() {
        // If the outStack is empty, move all elements from the inStack to the outStack
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }

        // If the outStack is not empty, return the top element
        if (!outStack.isEmpty()) {
            return outStack.peek();
        } else {
            // If both stacks are empty, return 0
            return 0;
        }
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        // Check if both stacks are empty
        if (inStack.isEmpty() && outStack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}

// STACK&QUEUE class
public class STACKQUEUE {
    public static void main(String[] args) {
        // Create a stack object
        Stack s = new Stack();
        // Create a queue object
        Queue q = new Queue();

        // Push integers onto the stack
        s.push(5);
        s.push(7);
        s.push(8);
        s.push(9);
        s.push(3);

        // View the top element of the stack
        System.out.println("Top element of the stack: " + s.peek());

        System.out.print("The elements in the stack are: ");
        // Loop through the stack and print each element
        for (int i = 0; i <= s.top; i++) {
            System.out.print(s.array[i] + " ");
        }

        System.out.print("\nThe size of the stack is: " + (s.top + 1));

        // Add elements to the queue
        q.enqueue(5);
        q.enqueue(7);
        q.enqueue(8);
        q.enqueue(9);
        q.enqueue(3);

        // View the front element of the queue
        System.out.println("\nFront element of the queue: " + q.peek());

        System.out.print("The elements in the queue are: ");
        // Loop through the queue and print each element
        while (!q.inStack.isEmpty() || !q.outStack.isEmpty()) {
            if (!q.outStack.isEmpty()) {
                System.out.print(q.outStack.peek() + " ");
            } else {
                System.out.print(q.inStack.peek() + " ");
            }
            q.dequeue();
        }

        System.out.print("\nThe size of the queue is: " + (q.inStack.top + q.outStack.top + 2));
    }
}
