async function viewAllRequests(e) {

    e.preventDefault();

    try {
        let res = await fetch("http://localhost:8080/ersApp/controller/manager/view-all-requests", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            }
        })

        let pastTickets = await res.json();
        console.log(pastTickets)

        var table = document.getElementById("reimbursements");

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

            var td8 = tr.insertCell(-1);
            if (pastTickets[i].reimbStatus == "pending" || pastTickets[i].reimbStatus == "rejected"){
                td8.innerHTML = "Not Applicable";
            } else {
                secs = pastTickets[i].reimbSubmitted;
                var d1  = new Date(secs);
                td8.innerHTML = d1.toLocaleString();
            }

            var td9 = tr.insertCell(-1);
            td9.innerHTML = pastTickets[i].reimbResolver; 
            
            table.appendChild(tr);

        }

    } catch (e) {
        console.log(e);
    }

}

window.addEventListener("load", viewAllRequests);
// document.getElementById("approve-btn").addEventListener("click", approveReq);
// document.getElementById("deny-btn").addEventListener("click", denyReq);