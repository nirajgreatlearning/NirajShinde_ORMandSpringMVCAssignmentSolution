<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<div class="row">
		<div class="col">
			<a href="showFormForAdd" class="btn btn-info">Add Customer</a>
		</div>
	</div>
	<br>
	<div class="row">
		<div class="col">
			<c:if test="${customers.size() > 0}">
				<table class="table table-striped table-hover">
					<thead class="table bg-primary">
						<tr>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Email</th>
							<th>Action</th>
						</tr>
					</thead>
					<c:forEach items="${customers}" var="customer">
						<tr>
							<td><c:out value="${customer.firstName}" /></td>
							<td><c:out value="${customer.lastName}" /></td>
							<td><c:out value="${customer.email}" /></td>
							<td><a class="btn btn-sm btn-primary"
								href="showFormForUpdate?customerId=${customer.id}">Update</a> |
								<a class="btn btn-sm btn-danger" onclick="return confirm('Are you sure you want to Delete?');"
								href="deleteCustomer?customerId=${customer.id}">Delete</a></td>
						</tr>
					</c:forEach>
				</table>


			</c:if>
		</div>
	</div>
</div>
<%@ include file="common/footer.jspf"%>