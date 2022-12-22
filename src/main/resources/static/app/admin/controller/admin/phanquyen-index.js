app.controller('phanquyenController',function($scope, $http){
	$scope.roles = [];
	$scope.admin=[];
	$scope.author = [];
	
	$scope.init = function(){
		  $http.get("/rest/auth").then(function(response){
				$scope.auths=response.data;
            }).catch(function(error){
			console.log(error);

            })

		  $http.get("/rest/role").then(function(response){
					$scope.roles= response.data;
            }).catch(function(error){
			console.log(error)

            })



 			$http.get("/rest/authoritiesAdmin?admin=true").then(function(response){
						$scope.author= response.data;
					console.log($scope.author);
            }).catch(function(error){
			console.log(error)

            })

		
	}
	
	$scope.init();
	$scope.authorityOf=function(acc , role){

			if($scope.author){
				return $scope.author.find(ur => ur.account.username == acc.username && ur.role.id == role.id)
			}	
	}
	
	$scope.authorityChange=function(acc,role){
		var author = $scope.authorityOf(acc,role);
		if(author){
			$http.get(`/rest/countRole/${acc.userid}`).then(function(response){
				if(response.data == 1){
					alert("Ít nhất 1 quyền")
				}else{
				
						$scope.deleteAuthor(author);
				}
            }).catch(function(error){

			console.log(error)
            })
		}else{
			author = {account : acc , role :role}
			alert("Cấp Quyền")
				$scope.createAuthor(author);
		}
			
	}
	
	$scope.createAuthor = function(authorities){
		  $http.post("/rest/auth/insertAuthor",authorities).then(function(response){
					$scope.author.push(response.data);
					alert("Cấp Quyền Thành Công")
            }).catch(function(error){
			alert("Cấp Quyền Không Thành Công")
			console.log(error)
            })
	}
	
	$scope.deleteAuthor  = function(authorities){
			  $http.delete(`/rest/auth/deleteAuthor/${authorities.id}`).then(function(response){
					var index = $scope.author.findIndex(a => a.id == authorities.id);
					$scope.author.splice(index,1);
					alert("Thu Hồi Quyền Thành Công")
            }).catch(function(error){
alert("Thu Hồi Quyền Không Thành Công")

            })
		
	}
	
	
	
})