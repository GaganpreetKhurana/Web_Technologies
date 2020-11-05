function triangle_pattern() {
    let rows = prompt("Enter Number of rows: ") // Input rows
    if (rows <= 0) {
        // Non positive number of rows
        alert("Invalid Input!")
        return
    }
    let triangle = "" // Output

    for (let i = 0; i < rows; i++) {
        for (let space = 0; space < rows - 1 - i; space++) {
            // Spaces before triangle starts
            triangle += " "
        }
        let odd = true
        for (let j = 0; j < 2 * i + 1; j++) {
            // Alternate character and space
            if (odd) {
                if (i === 0) {
                    // First row
                    triangle += "*"
                } else {
                    triangle += "0"
                }
                odd = false
            } else {
                triangle += " "
                odd = true
            }
        }
        triangle += "\n";
    }
    alert(triangle)
}