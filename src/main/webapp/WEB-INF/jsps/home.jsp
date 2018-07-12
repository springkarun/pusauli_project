<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>DIGITAL PUSAULI REGISTER</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<script
	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.6.0/angular.min.js"></script>
<script src="/js/angular.js"></script>
<link rel="stylesheet"
	href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css" />
</head>
<body>
	<div class="container" ng-app="app">
		<h1>DIGITAL PUSAULI REGISTER </h1>

		<%--<div class="row">

			<div ng-controller="shopRegisterController" class="col-md-3">


				<form name="customerForm" ng-submit="submitForm()">

					<label>Select Shop Category : </label>
						<select name="cateSelect" ng-model="cateSelect" class="form-control" >
							<option value="">--Select Category--</option>
							<option ng-repeat="option in arrlists" value="{{option.categoryId}}">{{option.categoryName}}</option>
						</select>


					</br></br>

					<label>Upload Shop Images :</label>
					<input type = "file" file-model = "shopAvatar"  class="form-control" />



					<label>Shop Name: </label>
					<input type="text" name="shopName"	class="form-control" ng-model="shopName" />


					<label>Shop Registaion No :</label>
					<input type="text" name="shopReg" class="form-control" ng-model="shopReg" />

			    	<label>Shop Email :</label>
					<input type="text" name="shopEmail"	class="form-control" ng-model="shopEmail" />

					<label>Shop Mobile :</label>
					<input type="text" name="shopMobile" class="form-control" ng-model="shopMobile" />

					<label>Shop Address :</label>
					<input type="text" name="shopAddress" class="form-control" ng-model="shopAddress" />


					<label>Shop Nearst :</label>
					<input type="text" name="shopNearst" class="form-control" ng-model="shopNearst" />


					<label>Shop Open Time :</label>
					<input type="text" name="shopTime" class="form-control" ng-model="shopTime" />



					<label>Shop Rating :</label>
					<input type="text" name="shopRating" class="form-control" ng-model="shopRating" />



					<label>Owner Name :</label>
					<input type="text" name="ownerName" class="form-control" ng-model="ownerName" />



					<label>Upload Owner Images :</label>
					<input type = "file" file-model = "ownerAvatar"  class="form-control" />


					<label>Owner Email :</label>
					<input type="text" name="ownerEmail" class="form-control" ng-model="ownerEmail" />


					<label>Owner Contact :</label>
					<input type="text" name="ownerContact" class="form-control" ng-model="ownerContact" />

	                <label>Shop Color Code :</label>
					<input type="text" name="colorCode" class="form-control" ng-model="colorCode" />


					<br>
					<button type="submit" class="btn btn-primary" ng-click="checkselection()">Submit</button>

				</form>
			     <br />
			     <span style="color:red">{{getResultMessage}}</span><br />

			</div>
		</div>--%>


		<div class="row">
			<div ng-controller="getAllShopController" class="col-md-3">
				<h3>All SHOP</h3>

				<button ng-click="getAllCustomers()">Get All Customers</button>

				<div ng-show="showAllCustomers">
					<ul class="list-group">
						<li ng-repeat="s in allcustomers.data"><h4 class="list-group-item">
								<strong>Stop {{$index+1}}</strong><br />

							<div>
								<img alt="" ng-src="http://localhost:8080/api/images/{{s.shopAvatar}}" />
								<img alt="" ng-src="http://localhost:8080/api/images/{{s.ownerContact}}" />

							</div>

							Category Id : {{s.categoryId}}<br />
							Shop Id : {{s.shopId}}<br />
							Shop Name: {{s.shopName}}<br />
							Shop Reg : {{s.shopReg}}<br />
							Shop Email : {{s.shopEmail}}<br />
							Shop Mobile: {{s.shopMobile}}<br />
							Shop Address: {{s.shopAddress}}<br />
							Shop Nearst: {{s.shopNearst}}<br />
							Shop Open Time: {{s.shopTime}}<br />
							Shop Rating: {{s.shopRating}}<br />


							Owner Name: {{s.ownerName}}<br />
							Owner Contact: {{s.ownerContact}}<br />
							Owner Email: {{s.ownerEmail}}<br />
							Reg Date: {{s.reg_date}}<br />

						</h4> </li>
					</ul>
				</div>
				<p>{{getResultMessage}}</p>

			</div>

		<%--	<div ng-controller="getcustomerControllerrollNo" class="col-md-3">
				<h3>Student by Roll No</h3>

				<input type="text" class="form-control" style="width: 100px;"
					ng-model="rollNo" /> <br />
				<button ng-click="getCustomer()">Get Customer</button>

				<div ng-show="showCustomer">

					<ul class="list-group">
						<li ng-repeat="s in allData.data"><h4 class="list-group-item">
							<strong>Students {{$index+1}}</strong><br />

							Roll No: {{s.rollNo}}<br />
							Full Name: {{s.name}}<br />
							Email : {{s.email}}<br />
							Mobile: {{s.mobile}}<br />
							Course: {{s.course}}<br />
							Age: {{s.age}}<br />
							Gender: {{s.gender}}<br />
							Address: {{s.addess}}<br />
						</h4> </li>
					</ul>
				</div>
				<p>{{getResultMessage}}</p>
			</div>

			<div ng-controller="getcustomersbylastnameController" class="col-md-4">
				<h3>Student by ID</h3>

				<input type="text" class="form-control" style="width: 100px;" ng-model="rollNo" /><br />
				<button ng-click="getCustomersByLastName()">Get Customers</button>

				<div ng-show="showCustomersByLastName">

					<ul class="list-group">
						<li ng-repeat="s in allcustomersbylastname.data"><h4	class="list-group-item">
								<strong>Student {{$index+1}}</strong><br />

							ID : {{s.id}}<br />
							Roll No: {{s.rollNo}}<br />
							Full Name: {{s.name}}<br />
							Email : {{s.email}}<br />
							Mobile: {{s.mobile}}<br />
							Address: {{s.addess}}<br />


						</h4></li>
					</ul>
				</div>
				<p>{{getResultMessage}}</p>
			</div>
--%>
		</div>
	</div>
</body>
</html>