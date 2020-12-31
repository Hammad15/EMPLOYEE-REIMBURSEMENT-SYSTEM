

async function loginSubmit(e){

    e.preventDefault();

    let username = document.getElementById("username-input").value
    let password = document.getElementById("password-input").value

    const credentials = {
        username,
        password
    }

    try{
        let res = await fetch("http://localhost:8080/ersApp/login", {
            method:"POST",
            body: JSON.stringify(credentials),
            headers:{
                "Content-Type" : "application/json"
            }
        })
    
        let user = await res.json()
        console.log(user);

    } catch (e) {
        console.log(e);
    }

}

document.getElementsByTagName("form")[0].addEventListener('submit', loginSubmit);