function displayNumber(param) {
    document.getElementById("result").value += param
}

function solveOperation() {
    let x = document.getElementById("result").value
    let y = eval(x)
    document.getElementById("result").value = y
}

function clr() {
    document.getElementById("result").value = ""
}