import java.io.StringReader;

public class Simulator {
    public static boolean run(DFA dfa, String input) {
        // Get the start state
        String currentState = dfa.startState;

        // Iterate through the input string
        /*for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            // Get the next state based on the current state and the input character
            // currentState = dfa.getNextState(currentState, c);
            // dfa.transitions.get(0);
            // If the next state is null, it means the input string is not accepted
            if (currentState == null) {
                return false;
            }
        }*/
        StringBuilder strInput = new StringBuilder(input);
        int len = strInput.length();
        char c;
        String transition = "";
        transition += currentState + "_";
        for(int i = 0; i < len; i++) {
            c = strInput.charAt(i);
            transition += c;
            String check = dfa.transitions.get(transition);
            System.out.println(transition);
            if (check == null) {
                System.out.println("error invalid string");
                return false;
            }
            transition = check + "_";
        }
        // System.out.println("good so far...");
        transition = transition.substring(0, 1);
        System.out.println(transition);
        // Check if the final state is reached after processing the input string
        return dfa.finalStates.contains(transition);
    }
}