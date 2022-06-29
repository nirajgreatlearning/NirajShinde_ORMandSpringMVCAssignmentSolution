<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<h4>Save Customer</h4>
	<br>
	<form:form method="post" action="save" modelAttribute="customerInfo">
		<div class="mb-3 row">
			<c:set var="firstNameHasBindError">
				<form:errors path="firstName" />
			</c:set>
			<label for="firstName" class="col-sm-2 col-form-label">First
				Name:</label>
			<div class="col-sm-4">
				<form:input
					class="form-control ${not empty firstNameHasBindError?'is-invalid':''}"
					path="firstName" />
				<div id="firstName" class="invalid-feedback">
					${firstNameHasBindError}</div>
			</div>
		</div>
		<div class="mb-3 row">
			<c:set var="lastNameHasBindError">
				<form:errors path="lastName" />
			</c:set>
			<label for="lastName" class="col-sm-2 col-form-label">Last
				Name:</label>
			<div class="col-sm-4">
				<form:input
					class="form-control ${not empty lastNameHasBindError?'is-invalid':''}"
					path="lastName" />
				<div id="firstName" class="invalid-feedback">
					${lastNameHasBindError}</div>
			</div>
		</div>
		<div class="mb-3 row">
			<c:set var="emailHasBindError">
				<form:errors path="email" />
			</c:set>
			<label for="email" class="col-sm-2 col-form-label">Email:</label>
			<div class="col-sm-4">
				<form:input
					class="form-control ${not empty emailHasBindError?'is-invalid':''}"
					path="email" />
				<div id="email" class="invalid-feedback">${emailHasBindError}</div>
			</div>
		</div>
		<div class="mb-3 row">
			<label class="col-sm-2 col-form-label"></label>
			<div class="col-sm-4">
				<input type="submit" class="btn btn-sm btn-primary" value="Save" />
			</div>
		</div>

	</form:form>
	<br> <a href="customer" class="btn btn-link">Back to List</a>
</div>
<%@ include file="common/footer.jspf"%>