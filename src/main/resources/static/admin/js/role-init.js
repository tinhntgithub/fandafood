
function getCurrentUser(){

    fetch('/rest/auth/principal', {
        method: 'GET',
        headers: {
          'Content-Type': 'application/json',
        },
        mode: 'cors',
        cache: 'default'
      })
        .then(response => response.json())
        .then(data => {
            console.log(data)
            var role = data.authorities[0].authority
            if(role == 'ROLE_ADMIN') {
                document.getElementById('admin').style.visibility = "visible";
                document.getElementById('seller').style.visibility = "hidden";
            }
            else if(role == 'ROLE_SELLER'){
                document.getElementById('admin').style.visibility = "hidden";
                document.getElementById('seller').style.visibility = "visible";
            }
            else {
                window.location = "/home/index"
            }
        }
            )
}

getCurrentUser();