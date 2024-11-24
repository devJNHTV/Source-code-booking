app.config(function ($routeProvider) {
  $routeProvider
      .when("/main", {
        templateUrl: "/admin/main.html"
      })
      .when("/booking", {
        templateUrl: "/admin/BookingManager.html"
      })
      .when("/service", {
        templateUrl: "/admin/ServiceManager.html"
      })
      .when("/save-service", {
        templateUrl: "/admin/SaveService.html"
      })
      .when("/save-service/:id", {
        templateUrl: "/admin/SaveService.html"
      })
      .otherwise({
        redirectTo: "/main"
      });
});

app.run(function ($rootScope) {
  $rootScope.$on("$routeChangeStart", function () {
    $rootScope.loading = true;
  });
  $rootScope.$on("$routeChangeSuccess", function () {
    $rootScope.loading = false;
  });
  $rootScope.$on("$routeChangeError", function () {
    $rootScope.loading = false;
    alert("loading Templet Errors");
  });
});
