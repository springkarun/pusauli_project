<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Spring Boot Example</title>
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
		<h1>pusauli School Registation Form</h1>

		<div class="row">
			<div ng-controller="postController" class="col-md-3">
				<form name="customerForm" ng-submit="submitForm()">


					<label>Roll No : </label>
					<input type="text" name="rollNo"	class="form-control" ng-model="rollNo" />

					<label>Full Name :</label>
					<input type="text" name="name" class="form-control" ng-model="name" />

			    	<label>Email :</label>
					<input type="text" name="email"	class="form-control" ng-model="email" />

					<label>Mobile :</label>
					<input type="text" name="mobile" class="form-control" ng-model="mobile" />

					<label>Password :</label>
					<input type="text" name="passwords" class="form-control" ng-model="passwords" />


					<label>Course :</label>
					<input type="text" name="course" class="form-control" ng-model="course" />


					<label>Age :</label>
					<input type="text" name="age" class="form-control" ng-model="age" />

	                <label>Gender :</label>
					<input type="text" name="gender" class="form-control" ng-model="gender" />


			     	<label>Address :</label>
					<input type="text" name="addess"	class="form-control" ng-model="addess" />


					<br>
					<button type="submit" class="btn btn-primary">Submit</button>

				</form>
				<p>{{postResultMessage}}</p>

			</div>
		</div>


		<div class="row">
			<div ng-controller="getallcustomersController" class="col-md-3">
				<h3>All Students</h3>

				<button ng-click="getAllCustomers()">Get All Customers</button>

				<div ng-show="showAllCustomers">
					<ul class="list-group">
						<li ng-repeat="s in allcustomers.data"><h4 class="list-group-item">
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

			<div ng-controller="getcustomerControllerrollNo" class="col-md-3">
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

		</div>
	</div>
</body>
</html>