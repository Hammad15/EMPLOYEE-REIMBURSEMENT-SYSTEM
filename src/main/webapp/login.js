

async function loginSubmit(e){

    e.preventDefault();

    let username = document.getElementById("username-input").value
    let password = document.getElementById("password-input").value

    const credentials = {
        username,
        password
    };

    try{
        let res = await fetch("http://localhost:8080/ersApp/controller/login", {
            method:"POST",
            body: JSON.stringify(credentials),
            headers:{
                "Content-Type" : "application/json"
                
            }
        })
        
        let user = await res.json();

        console.log(user);

        let h = res.headers;

        console.log(h);

        // let storage = window.sessionStorage

        // storage.setItem("username",user.username)
        // storage.setItem("firstName",user.firstName)
        // storage.setItem("lastName",user.lastName)
        // storage.setItem("userID",user.userID)
        // storage.setItem("userRole",user.userRole)

        if (user.userRole == "employee") {
            window.location.href = "http://localhost:8080/ersApp/employee-main.html"
        } else if (user.userRole == "manager") {
            window.location.href = "http://localhost:8080/ersApp/manager-main.html"
        } else {
            console.log("error")
        }

    } catch (e) {
        console.log(e);
    }

}

document.getElementsByTagName("form")[0].addEventListener('submit', loginSubmit);