package Stack;

import java.util.Stack;

public class BasicsSTLOfStacks {
    static void main(String[] args) {
        Stack<String> st = new Stack<>();
        System.out.println(st.isEmpty());
        System.out.println(st.size() == 0);
//        System.out.println(st.peek()); // give error when stack is empty
        st.push("Khushi");
        st.push("Shiwani");
        st.push("Rag Ranjan");
        st.push("Abhimanyu");
        System.out.println(st.size());
        System.out.println(st); // A.S. = O(n)
        st.pop();
        System.out.println(st + " " + st.size());
        System.out.println(st.peek());
        System.out.println(st.pop()); // it returns the topmost element and then removes it
        String s = st.pop();
        System.out.println(s);
    }
}
