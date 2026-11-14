public class PocketCalculator {
    // Conversion: O(n) time and O(n) stack space. Evaluation: O(n) time and O(n) stack space.
    public static String toPostfix(String infix) {
        char[] operators = new char[infix.length()];
        int top = -1;
        StringBuilder postfix = new StringBuilder();

        for (int i = 0; i < infix.length(); i++) {
            char token = infix.charAt(i);
            if (Character.isDigit(token)) {
                postfix.append(token);
            } else if (token == '(') {
                operators[++top] = token;
            } else if (token == ')') {
                while (top >= 0 && operators[top] != '(') postfix.append(operators[top--]);
                if (top < 0) throw new IllegalArgumentException("Unmatched closing bracket.");
                top--;
            } else if (isOperator(token)) {
                while (top >= 0 && operators[top] != '(' && precedence(operators[top]) >= precedence(token)) {
                    postfix.append(operators[top--]);
                }
                operators[++top] = token;
            } else {
                throw new IllegalArgumentException("Invalid character: " + token);
            }
        }

        while (top >= 0) {
            if (operators[top] == '(') throw new IllegalArgumentException("Unmatched opening bracket.");
            postfix.append(operators[top--]);
        }
        return postfix.toString();
    }

    public static int evaluate(String postfix) {
        int[] values = new int[postfix.length()];
        int top = -1;
        for (int i = 0; i < postfix.length(); i++) {
            char token = postfix.charAt(i);
            if (Character.isDigit(token)) {
                values[++top] = token - '0';
            } else {
                int right = values[top--];
                int left = values[top--];
                switch (token) {
                    case '+': values[++top] = left + right; break;
                    case '-': values[++top] = left - right; break;
                    case '*': values[++top] = left * right; break;
                    case '/':
                        if (right == 0) throw new ArithmeticException("Division by zero.");
                        values[++top] = left / right;
                        break;
                    default: throw new IllegalArgumentException("Invalid operator: " + token);
                }
            }
        }
        return values[top];
    }

    private static boolean isOperator(char token) { return token == '+' || token == '-' || token == '*' || token == '/'; }
    private static int precedence(char operator) { return (operator == '*' || operator == '/') ? 2 : 1; }

    public static void main(String[] args) {
        for (String infix : new String[]{"2+3*4", "(2+3)*4", "8/2-3"}) {
            String postfix = toPostfix(infix);
            System.out.println(postfix + " = " + evaluate(postfix));
        }
    }
}
