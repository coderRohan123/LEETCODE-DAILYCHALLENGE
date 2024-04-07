def checkValidString( s):
    # Stacks to store indices of open brackets and asterisks
    open_brackets = []
    asterisks = []

    for i, ch in enumerate(s):
        # If current character is an open bracket, push its index onto the stack
        if ch == "(":
            open_brackets.append(i)
        # If current character is an asterisk, push its index onto the stack
        elif ch == "*":
            asterisks.append(i)
        # current character is a closing bracket ')'
        else:
            # If there are open brackets available, use them to balance the closing bracket
            if open_brackets:
                open_brackets.pop()
            elif asterisks:
                # If no open brackets are available, use an asterisk to balance the closing bracket
                asterisks.pop()
            else:
                # nnmatched ')' and no '*' to balance it.
                return False

    # Check if there are remaining open brackets and asterisks that can balance them
    while open_brackets and asterisks:
        # If an open bracket appears after an asterisk, it cannot be balanced, return false
        if open_brackets.pop() > asterisks.pop():
            return False  # '*' before '(' which cannot be balanced.

    # If all open brackets are matched and there are no unmatched open brackets left, return true
    return not open_brackets
print(checkValidString("()"))
'''
Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.

The following rules define a valid string:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".
 

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "(*)"
Output: true
Example 3:

Input: s = "(*))"
Output: true
 

Constraints:

1 <= s.length <= 100
s[i] is '(', ')' or '*'.'''