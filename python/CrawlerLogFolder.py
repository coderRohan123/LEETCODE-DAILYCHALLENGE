def minOperations(logs) -> int:
    folder_stack = []

    for current_operation in logs:
        if current_operation == "../":
            # Move up to parent directory if not already at main folder
            if folder_stack:
                folder_stack.pop()
        elif current_operation != "./":
            # Enter a new folder
            folder_stack.append(current_operation)
        # Ignore "./" operations as they don't change the current folder
    # The stack size represents the number of folders deep we are
    return len(folder_stack)
print(minOperations(["d1/","d2/","../","d21/","./"]))