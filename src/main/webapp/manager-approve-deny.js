async function viewPendingRequests(e) {

    e.preventDefault();

    const status = {
        "reimbStatus" : "pending"
    }

    try {
        let res = await fetch("http://localhost:8080/ersApp/controller/manager/view-pending-requests", {
            method: "POST",
            body: JSON.stringify(status),
            headers: {
                "Content-Type": "application/json"
            }
        })

        let pastTickets = await res.json();
        console.log(pastTickets)
        
        secs = pastTickets[0].reimbSubmitted; //testing
        
        var d1  = new Date(secs); //testing

        console.log(d1.toLocaleString()); //testing

        var table = document.getElementById("pending-requests");

        for (let i = 0; i < pastTickets.length; i++) {

            var tr = table.insertRow(-1);

            var td0 = tr.insertCell(-1);
            td0.innerHTML = pastTickets[i].reimbID;

            var td1 = tr.insertCell(-1);
            td1.innerHTML = pastTickets[i].reimbAmount;

            var td2 = tr.insertCell(-1);
            td2.innerHTML = pastTickets[i].reimbDescription;

            var td3 = tr.insertCell(-1);
            td3.innerHTML = pastTickets[i].reimbReceipt;

            var td4 = tr.insertCell(-1);
            td4.innerHTML = pastTickets[i].reimbType;

            var td5 = tr.insertCell(-1);
            td5.innerHTML = pastTickets[i].reimbAuthor;

            var td6 = tr.insertCell(-1);
            secs = pastTickets[i].reimbSubmitted;
            var d1  = new Date(secs);
            td6.innerHTML = d1.toLocaleString();

            var td7 = tr.insertCell(-1);
            td7.innerHTML = pastTickets[i].reimbStatus;

            // var td7 = tr.insertCell(-1);
            // if (pastTickets[i].reimbStatus == "pending" || pastTickets[i].reimbStatus == "rejected"){
            //     td7.innerHTML = "Not Applicable";
            // } else {
            //     secs = pastTickets[i].reimbSubmitted;
            //     var d1  = new Date(secs);
            //     td7.innerHTML = d1.toLocaleString();
            // }
            
            table.appendChild(tr);

        }

    } catch (e) {
        console.log(e);
    }

}

async function approveReq(e){

    e.preventDefault();

    let reimbID = document.getElementById("reimb-id").value

    const id = {
        reimbID
    };

    try{
        let res = await fetch("http://localhost:8080/ersApp/controller/manager/approve-request", {
            method:"POST",
            body: JSON.stringify(id),
            headers:{
                "Content-Type" : "application/json"
                
            }
        })

    } catch (e) {
        console.log(e);
        alert("Invalid Entry")
    }

}

async function denyReq(e){

    e.preventDefault();

    let reimbID = document.getElementById("reimb-id").value

    const id = {
        reimbID
    };

    try{
        let res = await fetch("http://localhost:8080/ersApp/controller/manager/deny-request", {
            method:"POST",
            body: JSON.stringify(id),
            headers:{
                "Content-Type" : "application/json"
                
            }
        })

    } catch (e) {
        console.log(e);
        alert("Invalid Entry")
    }

}


window.addEventListener("load", viewPendingRequests);
document.getElementById("approve-btn").addEventListener("click", approveReq);
document.getElementById("deny-btn").addEventListener("click", denyReq);