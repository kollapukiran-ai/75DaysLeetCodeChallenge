class Solution {
public:
    bool isValid(string s) {
       stack<char> st;

        for(char c : s) {
            // If it's an opening bracket, push it
            if(c == '(' || c == '{' || c == '[') {
                st.push(c);
            } 
            else {
                // If stack is empty, no matching opening bracket
                if(st.empty()) return false;

                char top = st.top();
                st.pop();

                // Check if the pair matches
                if((c == ')' && top != '(') ||
                   (c == '}' && top != '{') ||
                   (c == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // Valid only if no unmatched opening brackets remain
        return st.empty();  
     
    }
};