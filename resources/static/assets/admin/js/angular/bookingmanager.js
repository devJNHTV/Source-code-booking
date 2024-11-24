app.controller(
  "bookingController",
  function ($scope, $location, $http, $rootScope) {
    $scope.bookings = [];
    $scope.findAll = function () {
      $http
        .get("/admin/api/booking")
        .then(function (response) {
          $scope.bookings = response.data.data;
          console.log($scope.bookings)
        })
        .catch(function (error) {
            console.log(error)
        });
    };
    $scope.findAll();


    $scope.selectedUser = {};
    $scope.viewUserInfo = function(item) {
        $scope.selectedUser = item;
    };


  }
);
