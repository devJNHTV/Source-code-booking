app.controller(
  "saveServiceController",
  function ($scope, $location, $http, $rootScope, $routeParams) {
    $scope.check = false;
    $scope.save = {};
    let review = document.getElementById("review");
    $scope.service = {};
    $scope.image =
      "https://s3.amazonaws.com/thumbnails.venngage.com/template/5456834b-ba95-41a9-85b2-4abd4d313c11.png";
    const id = document.getElementById("id_service").value;
    if (id) {
      $scope.findById = function () {
        $http
          .get("/admin/api/service/find/" + id)
          .then(function (response) {
            $scope.service = response.data.data;
            console.log($scope.service);
            review.src = $scope.service.photo;
            $scope.check = true;
          })
          .catch(function (error) {
            console.log(error);
          });
      };

      $scope.findById();
    } else {
      $scope.service = {};
      review.src = $scope.image;
    }

    $scope.submitForm = function () {
      if ($scope.check) {
        const data = {
          name: $scope.service.name,
          photo: review.src,
          price: $scope.service.price,
          description: $scope.service.description,
        };
        $http
          .put("/admin/api/service/update/"+id,  data)
          .then(function (response) {
            Swal.fire({
              icon: "success",
              title: "Cập nhật dịch vụ thành công",
              text: "Tuyệt vời!",
            });
              window.location.href ="/admin/service";
          })
          .catch(function (error) {
            Swal.fire({
              icon: "error",
              title: "Cập nhật dịch vụ thất bại",
              text: "kiểm tra lai dữ liệu",
            });
          });
      } else {
        const data = {
          ...$scope.service,
          photo: $scope.image,
        };

        console.log(data);
        $http
          .post("/admin/api/service/save", data)
          .then(function (response) {
            Swal.fire({
              icon: "success",
              title: "Thêm dịch thành công",
              text: "Tuyệt vời!",
            });
              window.location.href ="/admin/service";
          })
          .catch(function (error) {
            Swal.fire({
              icon: "error",
              title: "Thêm dịch thất bại",
              text: "kiểm tra lai dữ liệu",
            });
          });
      }
    };

    document.getElementById("fileInputfb").onchange = function (e) {
      if (e.target.files.length > 0) {
        let file = e.target.files[0];
        let fileType = file.type;

        if (
          fileType !== "image/png" &&
          fileType !== "image/jpeg" &&
          fileType !== "image/jpg"
        ) {
          alert("Chỉ chấp nhận file ảnh có định dạng .png hoặc .jpg");
          e.target.value = "";
          return;
        }

        let reader = new FileReader();
        reader.onload = function () {
          let base64String = reader.result;
          review.src = base64String;
          $scope.image = base64String;
        };

        reader.readAsDataURL(file);
      }
    };
  }
);
