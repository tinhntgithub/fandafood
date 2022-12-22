var app = angular.module('myMcR', []);
app.controller('McRegisCtrl', function ($scope, $http, $document) {
    var log = console.log;
    //lấy danh sách các tỉnh
    $http.get("https://raw.githubusercontent.com/ThanhLMPC02344/apimientay/main/.github/workflows/jekyll.yml").then(function (response) {
        $scope.loca = response.data;
        log($scope.loca)
    }).catch(function (error) {
        console.log(error);
    });

    $scope.currentUser = {};

    $http.get( `/rest/user/current`).then(function (response) {
        $scope.currentUser = response.data;
        log($scope.currentUser)
    }).catch(function (error) {
        console.log(error);
    });

    $scope.form = {};
    $scope.pre = {};
    $scope.loca = [];
    $scope.locaform = {};
    $document.ready(function () {
        //khởi tạo wizard stepper
        $('#smartwizard').smartWizard();
       



        //hiển thị premium bundle
        $http.get("/rest/pre").then(function (response) {
            $scope.pre = response.data;
            if ($scope.pre.date = 0) { $scope.pre.date = "Vĩnh viễn" }
            log($scope.pre)
        }).catch(function (error) {
            console.log(error);
        })


    });


    $('.clockpicker').clockpicker({
        donetext: 'Done',
    }).find('#close-time').change(function () {
        $scope.form.closeTime = this.value
        console.log(this.value);
    })

    $('.clockpicker').clockpicker({
        donetext: 'Done',
    }).find('#open-time').change(function () {
        $scope.form.openTime = this.value
        console.log(this.value);
    })

    function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function (e) {
                $('#imagePreview').css('background-image', 'url(' + e.target.result + ')');
                $('#imagePreview').hide();
                $('#imagePreview').fadeIn(650);
            }
            reader.readAsDataURL(input.files[0]);
            // $scope.location = input.files[0].name
        }
    }
    $("#imageUpload").change(function () {
        readURL(this);
    });

    $('.remove-img').on('click', function () {
        var imageUrl = "images/no-img-avatar.png";
        $('.avatar-preview, #imagePreview').removeAttr('style');
        $('#imagePreview').css('background-image', 'url(' + imageUrl + ')');
    });





    $scope.mcregist = function () {
        var mcItem = angular.copy($scope.form)
            mcItem.account = $scope.currentUser
            //tạo mới nhà hàng
            $http.post("/rest/restaurant", mcItem).then(function (response) {
                log(response)

                //tạo mới prioritized
                let prie = $scope.pre.find(o => o.Id === $scope.preid);
                var dataPrior = {
                    'start_date': new Date(),
                    'active': true,
                    'pre': prie,
                    'restaurant' : response.data
                };
        
                log(prie)
                $http.post("/rest/prior", dataPrior).then(function (response) {
                    log(response)
                    
                    // thêm role SELLSER với người dùng | đồng thời xóa role USER
                    $http.post("/rest/auth/seller", {
                        'account': $scope.currentUser
                    }).then(function (response) {
                        log(response)
            
                    }).catch(function (error) {
                        console.log(error);
                    })
                    
        
                }).catch(function (error) {
                    console.log(error);
                })

                

            }).catch(function (error) {
                console.log(error);
            })


            log(mcItem)



       






    };


})