<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href='<spring:url value="/resources/css/bootstrap.min.css"></spring:url>'>
<link rel="stylesheet" type="text/css"
	href='<spring:url value="/resources/css/dataTables.bootstrap.min.css"></spring:url>'>
<link rel="stylesheet" type="text/css"
	href='<spring:url value="/resources/css/responsive.bootstrap.min.css"></spring:url>'>

<script type="text/javascript"
	src='<spring:url value="resources/js/jquery-3.2.1.min.js"></spring:url>'></script>
<script type="text/javascript"
	src='<spring:url value="resources/js/bootstrap.min.js"></spring:url>'></script>
<script type="text/javascript"
	src='<spring:url value="resources/js/jquery.dataTables.js"></spring:url>'></script>
<script type="text/javascript"
	src='<spring:url value="resources/js/dataTables.bootstrap.min.js"></spring:url>'></script>
<script type="text/javascript"
	src='<spring:url value="resources/js/dataTables.responsive.min.js"></spring:url>'></script>
<script type="text/javascript"
	src='<spring:url value="resources/js/responsive.bootstrap.min.js"></spring:url>'></script>

</head>
<body>

	
	
	 <!-- Fixed navbar -->
    <nav class="navbar navbar-default navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Project name</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
            <li><a href="#about">About</a></li>
            <li><a href="#contact">Contact</a></li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li><a href="#">Action</a></li>
                <li><a href="#">Another action</a></li>
                <li><a href="#">Something else here</a></li>
                <li role="separator" class="divider"></li>
                <li class="dropdown-header">Nav header</li>
                <li><a href="#">Separated link</a></li>
                <li><a href="#">One more separated link</a></li>
              </ul>
            </li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li><a href="../navbar/">Default</a></li>
            <li><a href="../navbar-static-top/">Static top</a></li>
            <li class="active"><a href="./">Fixed top <span class="sr-only">(current)</span></a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>

    <div class="container">

      <a href="">New Invoice</a>

		<!-- 	<a href="/getSteamingFile/1">download</a> -->

		<table id="invoiceTable"
			class="table table-striped table-bordered dt-responsive nowrap"
			cellspacing="0" width="100%">
			<thead>
				<tr>
					<th>Invoice No.</th>
					<th>Customer Name</th>
					<th>Customer Mobile Number</th>
					<th>Invoice Amount</th>
					<th>Invoice Date</th>
					<th>Action</th>
				</tr>
			</thead>
			<tfoot>
				<c:forEach items="${invoices }" var="invoice">
					<tr>
						<td><c:out value="${invoice.id}" /></td>
						<td>${invoice.customer.firstName}${invoice.customer.lastName}</td>
						<td>${invoice.customer.mobile}</td>
						<td>${invoice.total}</td>
						<td>${invoice.invoiceDate}</td>
						<td><a href="/getSteamingFile/${invoice.id }">PDF
								DOWNLOAD</a></td>
					</tr>
				</c:forEach>
			</tfoot>
		</table>

    </div> <!-- /container -->
    
    


	<script type="text/javascript">
	$(document).ready(function() {
	    $('#invoiceTable').DataTable();
	} );
	</script>




</body>
</html>