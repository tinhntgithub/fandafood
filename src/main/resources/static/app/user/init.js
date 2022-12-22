
function getCurrentUser(){

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
            if(data){
                document.getElementById("mainImage").src= '/user/img/user/'+data.avatar;
            }else{
              document.getElementById("mainImage").src= '/user/img/user/noImage.jpg'
            }
        }
            )
}

getCurrentUser();