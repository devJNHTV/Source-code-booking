const app = angular.module("shopping-cart-app",[]);

app.controller("shopping-cart-ctrl",function($scope,$http){
	   
	$scope.updateDates = function() {
	    console.log("Check-in Date:", $scope.checkinDate);
	    console.log("Check-out Date:", $scope.checkoutDate);
	};
	const today = new Date();
	   $scope.checkinDate = today; // Gán trực tiếp kiểu Date

	   // Thiết lập ngày checkout là ngày kế tiếp
	   const tomorrow = new Date();
	   tomorrow.setDate(today.getDate() + 1);
	   $scope.checkoutDate = tomorrow; // Gán trực tiếp kiểu Date
	$scope.formatDate = function(date) {
	    if (!date) return ''; // Kiểm tra nếu không có ngày
	    const d = new Date(date);
	    const year = d.getFullYear();
	    const month = String(d.getMonth() + 1).padStart(2, '0'); // Tháng bắt đầu từ 0
	    const day = String(d.getDate()).padStart(2, '0');
	    return `${year}-${month}-${day}`; // Trả về định dạng "YYYY-MM-DD"
	};	
	$scope.cart={
		items:[],
		// them san pham vao gio hang
		add(item,checkinDate,checkoutDate){
			console.log(checkinDate)
			console.log(checkoutDate)
			

			// Lưu số ngày lưu trú
			 // Làm tròn lên
			 var exitItem = this.items.find(cartItem => cartItem.id == item.id && cartItem.type == item.type);
			if(exitItem){	
				console.log('if 1')
				exitItem.qty++;
				this.saveToLocalStorage();
			}
			else{
				if(item.type === 'room') {
				             $http.get(`/rest/rooms/${item.id}`).then(resp => {
				                 resp.data.qty = 1;
				                 resp.data.type = 'room'; // Đặt loại là room
								 var formattedCheckinDate = $scope.formatDate($scope.checkinDate);
								 var formattedCheckoutDate = $scope.formatDate($scope.checkoutDate);
								 resp.data.checkinDate = formattedCheckinDate;  // Lưu ngày check-in
								 resp.data.checkoutDate =  formattedCheckoutDate; 
								 const timeDifference = checkoutDate.getTime() - checkinDate.getTime();
								 console.log(timeDifference) // Tính hiệu số thời gian
								const nightStay =Math.ceil(timeDifference / (1000 * 3600 * 24));
								 resp.data.nightStay = Math.ceil(nightStay);
				                 this.items.push(resp.data);
				                 this.saveToLocalStorage();
				             });
				         } else if(item.type === 'service') {
				             $http.get(`/rest/services/${item.id}`).then(resp => {
				                 resp.data.qty = 1;
								 resp.data.svday=1;
				                 resp.data.type = 'service'; 
								 							
				                 this.items.push(resp.data);
				                 this.saveToLocalStorage();
				             }).catch(error => {
							     console.error("Error fetching service data:", error);
							 });;
				         }
				     }
				 },
		remove(id){ 
				var index = this.items.findIndex(room => room.id==id);
				this.items.splice(index,1);
				this.saveToLocalStorage();
			},
			clear(){
				this.items=[];
				this.saveToLocalStorage();
			},
			clearRoom() {
			    this.items = this.items.filter(item => item.type !== 'room'); // Giữ lại các mục không phải là 'room'
			    this.saveToLocalStorage();
			},
			clearService() {
						    this.items = this.items.filter(item => item.type !== 'service'); // Giữ lại các mục không phải là 'room'
						    this.saveToLocalStorage();
						},
		get count(){
			return this.items
			.map(room=>room.qty)
			.reduce((total,qty)=>total+=qty, 0);
		},
		get amountRoom(){
			  		return this.items.filter(item => item.type === 'room')
					.map(item=>item.qty*item.price*item.nightStay)
			  				.reduce((total,qty) => total+=qty,0)
		},
		get amountService(){
					  		return this.items.filter(item => item.type === 'service')
							.map(item=>item.qty*item.svday*item.price)
					  				.reduce((total,qty) => total+=qty,0)
				},
		saveToLocalStorage(){
			var json = JSON.stringify(angular.copy(this.items));
			localStorage.setItem("cart",json);
		},
		loadFromLocalStorage(){
			var json = localStorage.getItem("cart");
			this.items=json ? JSON.parse(json):[];
		},
		get rooms() {
		  return this.items.filter(item => item.type === 'room');
		},

		get services() {
		  return this.items.filter(item => item.type === 'service');
		},
		get amount()
		{
			return $scope.cart.amountRoom +$scope.cart.amountService;
		}
	}                                                                                                                                                                                                                                                                                                                                                                                                                  
	$scope.cart.loadFromLocalStorage();
	
	

		$scope.order={
			
			createDate: new  Date(),
			checkinDate: new Date($scope.cart.items.find(item => item.type === 'room')?.checkinDate ) || new Date(),
			checkoutDate:new Date($scope.cart.items.find(item => item.type === 'room')?.checkoutDate ) || new Date(),
			account:{username:$("#username").text()
			},
			price: $scope.cart.amount,
			
			get bookingDetails(){
						return $scope.cart.items.map(item=>{
							return {
								room: item.type === 'room' ? { id: item.id } : null,
								            service: item.type === 'service' ? { id: item.id } : null,
								            price: item.price,
								            quantity: item.qty
							}
						}).filter(detail => detail.room || detail.service);
					},
			purchase(){
				
				var order=angular.copy(this);
				console.log(order)
				$http.post("/rest/bookings",order).then(resp=>{
					alert("Successfully")
					console.log(order)
					console.log(resp.data)
					$scope.cart.items.forEach(item => {
					        if (item.type === 'room') {
					            $http.put(`/rest/rooms/${item.id}/status`, { status: false })
					                .then(() => {
					                    console.log(`Room ${item.id} status updated to false`);
					                })
					                .catch(error => {
					                    console.error(`Failed to update status for room ${item.id}`, error);
					                });
					        }
					    });
					$scope.cart.clear();
				}).catch(error=>{
					alert("invalid")
					console.log(error)
				})
				
				
				
			}
		  }
})