import java.util.Scanner;
import java.util.Stack;

public class TextEditor {
    // Stack to store previous states of the text for undo functionality
    private static Stack<String> textStack = new Stack<>();
    // Current state of the text
    private static String currentText = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter 'help' to see available commands.");

        // Continuous loop until exit command is given
        while (true) {
            // Prompt the user for input
            System.out.print("Input: ");
            String input = scanner.nextLine();

            // Check for exit command
            if (input.equals("exit")) {
                break;
            }

            // Process user input
            processInput(input);
        }

        scanner.close();
    }

    // Process user input
    private static void processInput(String input) {
        // Split input into command and arguments
        String[] tokens = input.split(" ", 2);
        String command = tokens[0].toLowerCase();

        // Check the command and execute the corresponding functionality
        if (input.equals("help")) {
            printHelpList();
        } else if ( (command.equals("append"))) {

            if (tokens.length < 2) {
                // Handle case when there are insufficient arguments for append command
                System.out.println("Invalid input for append command");
            } else {
                // Append text to the current state
                appendText(tokens[1]);
            }
        } else if (command.equals("remove")) {
            if (tokens.length < 2) {
                // Handle case when there are insufficient arguments for remove command
                System.out.println("Invalid input for remove command");
            } else {
                // Remove characters from the end of the current state
                removeChars(Integer.parseInt(tokens[1]));
            }
        } else if (command.equals("display")) {
            // Display the current state of the text
            displayText();
        } else if (command.equals("undo")) {
            // Undo the last operation
            undo();
        } else {
            // Handle case when an unknown command is entered
            System.out.println("Unknown command");
        }
    }

    private static void printHelpList() {
        System.out.println("Available commands:");
        System.out.println("- append <text>: Add new text to the end of the current text.");
        System.out.println("- remove <count>: Delete the specified number of characters from the end of the current text.");
        System.out.println("- display: Show the current content of the text.");
        System.out.println("- undo: Revert the text to the state before the most recent append or remove operation.");
    }
    // Append text to the current state
    private static void appendText(String text) {
        // Push current state to stack for undo
        textStack.push(currentText);
        // Append text to current state
        currentText += text;
        System.out.println("(text is now \"" + currentText + "\")");
    }

    // Remove characters from the end of the current state
    private static void removeChars(Integer n) {
        if (n >= currentText.length()) {
            // If n is greater than or equal to the length of the current text, set text to empty
            currentText = "";
        } else {
            // Push current state to stack for undo
            textStack.push(currentText);
            // Remove last n characters from current state
            currentText = currentText.substring(0, currentText.length() - n);
        }
        System.out.println("(text is now \"" + currentText + "\")");
    }

    // Display the current state of the text
    private static void displayText() {
        System.out.println("\"" + currentText + "\"");
    }

    // Undo the last operation
    private static void undo() {
        if (!textStack.isEmpty()) {
            // Pop the previous state from the stack and set current state to it
            currentText = textStack.pop();
            System.out.println("(undo operation performed)");
        } else {
            // Handle case when there are no operations to undo
            System.out.println("Nothing to undo");
        }
    }
}
