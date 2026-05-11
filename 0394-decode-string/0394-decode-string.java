class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        
        StringBuilder current = new StringBuilder();
        int k = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = k * 10 + (c - '0');   // build the number
            } 
            else if (c == '[') {
                countStack.push(k);       // save the repeat count
                stringStack.push(current); // save the current string
                current = new StringBuilder();
                k = 0;
            } 
            else if (c == ']') {
                int repeat = countStack.pop();
                StringBuilder decoded = stringStack.pop();
                
                while (repeat-- > 0) {
                    decoded.append(current);
                }
                current = decoded;
            } 
            else {
                current.append(c);        // normal character
            }
        }
        return current.toString();
    }
}
