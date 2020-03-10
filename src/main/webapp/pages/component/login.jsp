<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<div class="login-container m-auto d-flex">
	<form id="login-form" class="m-auto px-md-0 px-3">

		<div class="form-group d-flex pb-1">
			<h4 class="login-title m-auto">Login</h4>
		</div>

		<div class="form-group row">
			<span class="col-md-1"></span> <label for="username"
				class="col-md-3 col-form-label quix-label">USERNAME:</label>
			<div class="col-md-7">
				<input class="form-control" name="username" id="username">
			</div>
			<span class="col-md-1"></span>
		</div>

		<div class="form-group row">
			<span class="col-md-1"></span> <label for="password"
				class="col-md-3 col-form-label quix-label">PASSWORD:</label>
			<div class="col-md-7">
				<input type="password" class="form-control" name="password"
					id="password">
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
				<button type="submit" class="btn btn-primary btn-block">Login</button>
			</div>
			<span class="col-md-1"></span>
		</div>
		
		<div class="form-group row">
			<span class="col-md-1"></span>
			<div class="col-md-10">
				<div class="row">
					<span class="col-7 text-right pr-1 register-link">Need an
						account?</span> <span class="col-5 pl-1 register-link"><a
						href="${pageContext.request.contextPath}/register">Sign up</a></span>
				</div>

			</div>
			<span class="col-md-1"></span>
		</div>

	</form>
</div>
