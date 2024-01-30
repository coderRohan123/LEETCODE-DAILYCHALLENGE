def evalRPN(tokens):
    stack = []
    for token in tokens:
        if token == '+':
            x = stack.pop()
            y = stack.pop()
            stack.append(y + x)

        elif token == '/':
            x = stack.pop()
            y = stack.pop()
            stack.append(int(y / x))

        elif token == '*':
            x = stack.pop()
            y = stack.pop()
            stack.append(y * x)

        elif token == '-':
            x = stack.pop()
            y = stack.pop()
            stack.append(y - x)

        else:
            stack.append(int(token))

    return stack[0]
print(evalRPN(["2","1","+","3","*"]))
