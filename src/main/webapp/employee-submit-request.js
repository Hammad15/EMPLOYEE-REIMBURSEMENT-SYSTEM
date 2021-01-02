async function requestSubmit(e){

    e.preventDefault();

    let reimbAmount = document.getElementById("amount").value
    let reimbDescription = document.getElementById("description").value
    let reimbReceipt = document.getElementById("receipt").value
    let reimbType = document.getElementById("reimb-type").value

    const reimbDetails = {
        reimbAmount,
        reimbDescription,
        reimbReceipt,
        reimbType
    }

    try{
        let res = await fetch("http://localhost:8080/ersApp/controller/employee/submit-request", {
            method:"POST",
            body: JSON.stringify(reimbDetails),
            headers:{
                "Content-Type" : "application/json"
            }
        })

        alert("The request has been submitted")

    } catch (e) {
        console.log(e);
    }

}

document.getElementsByTagName("form")[0].addEventListener('submit', requestSubmit);