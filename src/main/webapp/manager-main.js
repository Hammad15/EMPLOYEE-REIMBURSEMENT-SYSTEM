let storage = window.sessionStorage

let fName = storage.getItem("firstName")

console.log(fName)

let lName = storage.getItem("lastName")

let userID = storage.getItem("userID")

document.getElementById("user-name").innerHTML = `Thanks for logging in, ${fName} ${lName}!`

document.getElementById("user-id").innerHTML = `User ID: ${userID}`

document.getElementById("approve-deny").onclick = () => {window.location = "manager-approve-deny.html"}

document.getElementById("view-all").onclick = () => {window.location = "manager-view-all.html"}