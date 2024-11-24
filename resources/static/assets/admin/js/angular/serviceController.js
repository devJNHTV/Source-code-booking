app.controller(
  "serviceController",
  function ($scope, $location, $http, $rootScope, $rootScope) {
    $scope.services = [];

    $scope.findAll = function () {
      $http
        .get("/admin/api/service")
        .then(function (response) {
          $scope.services = response.data.data;
          console.log($scope.services);
        })
        .catch(function (error) {
          console.log(error);
        });
    };
    $scope.findAll();

    $scope.deleteid = function (id) {
      Swal.fire({
        title: "Bạn có muốn xóa dịch vụ này?",
        text: "Sẽ không thể phục hồi lại được!",
        icon: "warning",
        showCancelButton: true,
        confirmButtonColor: "#3085d6",
        cancelButtonColor: "#d33",
        confirmButtonText: "Xóa nó",
      }).then((result) => {
        if (result.isConfirmed) {
          // Gọi API bằng fetch
          fetch(`/admin/api/service/delete/${id}`, {
            method: "DELETE", // Phương thức DELETE
          })
            .then((response) => {
              if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
              }
              return response.json(); // Chuyển đổi response thành JSON
            })
            .then((data) => {
              Swal.fire({
                title: "Deleted!",
                text: "Dịch vụ đã được xóa thành công.",
                icon: "success",
              });
              // Xóa phần tử khỏi danh sách
              $scope.services = $scope.services.filter(
                (service) => service.id !== id
              );
              $scope.$apply(); // Cập nhật lại giao diện
            })
            .catch((error) => {
              console.error("Error:", error);
              Swal.fire({
                icon: "error",
                title: "Xóa thất bại",
                text: "Đã tồn tại khóa ngoại không thể xóa.",
              });
            });
        }
      });
    };

    $scope.update = function (id) {
        window.location.href = "/admin/save-service/" + id;
    }
  }
);
