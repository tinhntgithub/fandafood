
function getCurrentUser() {
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
      if (role == 'ROLE_ADMIN') {
        document.getElementById('adminTab').style.visibility = "visible";
      }
      else{
        document.getElementById('adminTab').style.visibility = "hidden";
      }
    }
    )
  fetch('/rest/user/current', {
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
      if (data) {
        console.log(data.authorities)
        document.getElementById("mainImage").src = '/user/img/user/' + data.avatar;
      } else {
        document.getElementById("mainImage").src = '/user/img/user/noImage.jpg'
      }
    }
    )
}

getCurrentUser();