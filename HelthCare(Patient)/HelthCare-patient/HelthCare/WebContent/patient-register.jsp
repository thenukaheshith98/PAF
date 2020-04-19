<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Patient Registration</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" 
integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="container">
        <fieldset>
            <h3>
                <span>Patient Registration</span>
            </h3>

            <form action="patient_register_process.jsp">
                <div class="form-group row">
                    <label for="nic" class="col-sm-2 col-form-label">NIC</label>
                    <div class="col-sm-10">
                        <input type="text" name="nic" class="form-control">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="nic" class="col-sm-2 col-form-label">First Name</label>
                    <div class="col-sm-10">
                        <input type="text" name="firstName" class="form-control">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="nic" class="col-sm-2 col-form-label">Last Name</label>
                    <div class="col-sm-10">
                        <input type="text" name="lastName" class="form-control">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="nic" class="col-sm-2 col-form-label">Date of Birth</label>
                    <div class="col-sm-10">
                        <input type="date" name="dob" class="form-control">
                    </div>
                </div>
                <fieldset class="form-group">
                    <div class="row">
                      <legend class="col-form-label col-sm-2 pt-0">Gender</legend>
                      <div class="col-sm-10">
                        <div class="form-check">
                          <input class="form-check-input" type="radio" name="gender" value="male" checked>
                          <label class="form-check-label" for="male">
                            Male
                          </label>
                        </div>
                        <div class="form-check">
                          <input class="form-check-input" type="radio" name="gender" value="female">
                          <label class="form-check-label" for="female">
                            Female
                          </label>
                        </div>
                      </div>
                    </div>
                </fieldset>
                <div class="form-group row">
                    <label for="nic" class="col-sm-2 col-form-label">Email</label>
                    <div class="col-sm-10">
                        <input type="email" name="email"  class="form-control">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="nic" class="col-sm-2 col-form-label">Password</label>
                    <div class="col-sm-10">
                        <input type="password" name="password" class="form-control">
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-sm-10">
                      <button type="submit" class="btn btn-success">Register</button>
                    </div>
                </div>
            </form>
            
            <div class="alert alert-success">
            	<%
            		if(session.getAttribute("patient_registraton_status") != null) {
            			out.print(session.getAttribute("patient_registraton_status"));
            		}
            	%>
            </div>
             
        </fieldset>
    </div>
</body>
</html>