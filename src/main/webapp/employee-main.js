let storage = window.sessionStorage

let fName = storage.getItem("firstName")

console.log(fName)

let lName = storage.getItem("lastName")

let userID = storage.getItem("userID")

document.getElementById("user-name").innerHTML = `Thanks for logging in, ${fName} ${lName}!`

document.getElementById("user-id").innerHTML = `User ID: ${userID}`

document.getElementById("submit-request").onclick = () => {window.location = "employee-submit-request.html"}

document.getElementById("view-requests").onclick = () => {window.location = "employee-view-requests.html"}