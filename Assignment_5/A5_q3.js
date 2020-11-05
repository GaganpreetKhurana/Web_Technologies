function validate_parenthesis() {
    let string = prompt("Enter string:")
    console.log(string)
    let stack = []
    let dictionary = {
        "(": ")",
        "[": "]",
        "{": "}"
    }
    for (let i = 0; i < string.length; i++) {
        if (string[i] === "(" || string[i] === "[" || string[i] === "{") {
            stack.push(string[i])
        } else if (string[i] === ")" || string[i] === "]" || string[i] === "}") {
            if (stack.length === 0) {
                alert("Invalid")
                return
            }
            let last = stack[stack.length - 1]
            if (string[i].localeCompare(dictionary[last]) === 0) {
                stack.pop()
            } else {
                alert("Invalid")
                return
            }
        } else {
            alert("Invalid Input!")
            return
        }

    }
    if (stack.length === 0) {
        alert("Valid")
    } else {
        alert("Invalid")
    }
}