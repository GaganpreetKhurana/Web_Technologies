function validate_parenthesis() {
    let string = prompt("Enter string:") // Input

    let stack = [] // Stack
    let dictionary = {
        "(": ")",
        "[": "]",
        "{": "}"
    } // Dictionary for opposite pairs

    for (let i = 0; i < string.length; i++) {
        if (string[i] === "(" || string[i] === "[" || string[i] === "{") {
            // Opening bracket
            stack.push(string[i])
        } else if (string[i] === ")" || string[i] === "]" || string[i] === "}") {
            // Closing bracket

            if (stack.length === 0) {
                // Stack empty
                alert("Invalid")
                return
            }
            let last = stack[stack.length - 1]
            if (string[i].localeCompare(dictionary[last]) === 0) {
                // Pair matched
                stack.pop()
            } else {
                alert("Invalid")
                return
            }
        } else {
            // Invalid characters
            alert("Invalid Input!")
            return
        }

    }
    if (stack.length === 0) {
        // Valid Parenthesis as Stack is empty
        alert("Valid")
    } else {
        alert("Invalid")
    }
}