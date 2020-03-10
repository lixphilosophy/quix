<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<div class="register-container m-auto d-flex">
	<form id="register-form" class="m-auto px-md-0 px-3">

		<div class="form-group d-flex pb-1">
			<h4 class="login-title m-auto">Sign in</h4>
		</div>
		
    <div class="form-row">
      <span class="col-md-1"></span>
      <div class="form-group col-md-5">
        <label for="username">Username</label> <input type="text" name="username"
          class="form-control quix-label" id="username">
      </div>
      <div class="form-group col-md-5">
        <label for="password">Password</label> <input type="password" name="password"
          class="form-control quix-label" id="password">
      </div>
      <span class="col-md-1"></span>
    </div>

		<div class="form-row">
			<span class="col-md-1"></span>
			<div class="form-group col-md-5">
				<label for="firstname">First Name</label> <input type="text" name="firstname"
					class="form-control quix-label" id="firstname">
			</div>
			<div class="form-group col-md-5">
				<label for="lastname">Last Name</label> <input type="text" name="lastname"
					class="form-control quix-label" id="lastname">
			</div>
			<span class="col-md-1"></span>
		</div>

    <div class="form-row">
      <span class="col-md-1"></span>
      <div class="form-group col-md-5">
        <label for="birthdate">Birth Date</label> <input type="text" name="birthdate"
          class="form-control quix-label" id="birthdate">
      </div>
      <div class="form-group col-md-5">
        <label for="email">Email</label> <input type="text" name="email"
          class="form-control quix-label" id="email">
      </div>
      <span class="col-md-1"></span>
    </div>

		<div class="form-group row m-0">
      <span class="col-md-1"></span>
      <p id="error" class="col-md-10 color-red mb-0 mb-md-2 p-0" style="display:none"></p>
      <span class="col-md-1"></span>
    </div>

		<div class="form-group row pt-2">
			<span class="col-md-1"></span>
			<div class="col-md-10">
				<button type="submit" class="btn btn-primary btn-block">Sign
					in</button>
			</div>
			<span class="col-md-1"></span>
		</div>

		<div class="form-group row">
			<span class="col-1"></span>
			<div class="col-10">
				<div class="row">
					<span class="col-8 text-right pr-1 register-link">Already
						have an account?</span> <span class="col-4 pl-1 register-link"><a
						href="${pageContext.request.contextPath}/login">Login</a></span>
				</div>

			</div>
			<span class="col-1"></span>
		</div>

	</form>
</div>
