import java.util.Scanner;
import java.util.Stack;
import java.util.Map;
import java.util.HashMap;

public class ArithmeticExpressionEvaluator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an arithmetic expression: ");
        String expression = scanner.nextLine();
        scanner.close();

        int result = evaluateExpression(expression);
        System.out.println("Result: " + result);
    }

    public static int evaluateExpression(String expression) {
        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();

        Map<Character, Integer[]> operatorMap = new HashMap<>();
        operatorMap.put('+', new Integer[]{1, 2});
        operatorMap.put('-', new Integer[]{1, 2});
        operatorMap.put('*', new Integer[]{3, 4});
        operatorMap.put('/', new Integer[]{3, 4});

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == ' ') {
                continue; // Skip whitespace
            } else if (Character.isDigit(ch)) {
                StringBuilder sb = new StringBuilder();
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    sb.append(expression.charAt(i++));
                }
                i--; // Move back one step since the loop increments i
                operands.push(Integer.parseInt(sb.toString()));
            } else if (ch == '(') {
                operators.push(ch);
            } else if (ch == ')') {
                while (operators.peek() != '(') {
                    char operator = operators.pop();
                    int b = operands.pop();
                    int a = operands.pop();
                    operands.push(applyOperator(operatorMap, operator, a, b));
                }
                operators.pop(); // Discard '('
            } else if (isOperator(ch)) {
                while (!operators.isEmpty() && precedence(ch) <= precedence(operators.peek())) {
                    char operator = operators.pop();
                    int b = operands.pop();
                    int a = operands.pop();
                    operands.push(applyOperator(operatorMap, operator, a, b));
                }
                operators.push(ch);
            }
        }

        while (!operators.isEmpty()) {
            char operator = operators.pop();
            int b = operands.pop();
            int a = operands.pop();
            operands.push(applyOperator(operatorMap, operator, a, b));
        }

        return operands.pop();
    }

    public static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    public static int precedence(char operator) {
        if (operator == '+' || operator == '-') {
            return 1;
        } else if (operator == '*' || operator == '/') {
            return 2;
        }
        return 0;
    }

    public static int applyOperator(Map<Character, Integer[]> operatorMap, char operator, int a, int b) {
        Integer[] precedenceValues = operatorMap.get(operator);
        if (precedenceValues != null) {
            int precedence = precedenceValues[0];
            if (precedence == 1) {
                return operator == '+' ? a + b : a - b;
            } else if (precedence == 3) {
                return operator == '*' ? a * b : a / b;
            }
        }
        return 0;
    }
}
