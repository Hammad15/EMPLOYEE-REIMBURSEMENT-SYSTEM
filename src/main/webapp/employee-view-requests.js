async function viewRequests(e) {

    e.preventDefault();

    try {
        let res = await fetch("http://localhost:8080/ersApp/controller/employee/view-requests", {
            method: "POST",
            // body: JSON.stringify(reimbDetails),
            headers: {
                "Content-Type": "application/json"
            }
        })

        let pastTickets = await res.json();
        console.log(pastTickets)
        
        secs = pastTickets[0].reimbSubmitted;
        
        var d1  = new Date(secs);

        console.log(d1.toLocaleString());

        var table = document.getElementById("reimb-requests");

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
            secs = pastTickets[i].reimbSubmitted;
            var d1  = new Date(secs);
            td5.innerHTML = d1.toLocaleString();

            var td6 = tr.insertCell(-1);
            td6.innerHTML = pastTickets[i].reimbStatus;

            var td7 = tr.insertCell(-1);
            if (pastTickets[i].reimbStatus == "pending" || pastTickets[i].reimbStatus == "denied"){
                td7.innerHTML = "Not Applicable";
            } else {
                secs = pastTickets[i].reimbSubmitted;
                var d1  = new Date(secs);
                td7.innerHTML = d1.toLocaleString();
            }
            
            table.appendChild(tr);

        }


    } catch (e) {
        console.log(e);
    }

}

window.addEventListener("load", viewRequests);