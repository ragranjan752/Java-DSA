package Stack;

import java.util.Stack;

public class BalanceBracket {

    public static void main(String[] args) {

    }

    // Checks whether all brackets are balanced and correctly matched
    public boolean isValid(String s) {

        // Stack is used to store opening brackets
        Stack<Character> st = new Stack<>();

        // Traverse the string character by character
        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // If it is an opening bracket,
            // push it into the stack
            if (ch == '(' || ch == '[' || ch == '{') {

                st.push(ch);

            } else {

                // If closing bracket comes but stack is empty,
                // there is no opening bracket to match it
                if (st.isEmpty()) {
                    return false;
                }

                // Get the top opening bracket
                // without removing it
                char top = st.peek();

                // Check whether opening and closing brackets
                // are of the same type
                if (sameStyle(top, ch)) {

                    // Matching pair found,
                    // so remove the opening bracket
                    st.pop();

                } else {

                    // Brackets are of different types
                    return false;
                }
            }
        }

        // If stack is empty,
        // every opening bracket has been matched
        return st.isEmpty();
    }

    // Checks whether two brackets form a valid pair
    static boolean sameStyle(char a, char b) {

        if (a == '(' && b == ')') {
            return true;
        }

        if (a == '[' && b == ']') {
            return true;
        }

        if (a == '{' && b == '}') {
            return true;
        }

        return false;
    }
}