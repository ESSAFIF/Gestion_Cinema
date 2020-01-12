<%@ include file="/WEB-INF/views/includes/includes.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Gestion de Cinemas</title>

   <!-- Bootstrap Core CSS -->
    <link href="<%=request.getContextPath() %>/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->

   <!-- DataTables CSS -->
    <link href="<%=request.getContextPath() %>/resources/vendor/datatables-plugins/dataTables.bootstrap.css" rel="stylesheet">

    <!-- DataTables Responsive CSS -->
    <link href="<%=request.getContextPath() %>/resources/vendor/datatables-responsive/dataTables.responsive.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="<%=request.getContextPath() %>/resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
      <!-- Custom styles for this template-->
  <link href="<%=request.getContextPath() %>/resources/dist/css/sbp-admin.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
  
</head>
<body>

<div id="wrapper">
    
            <%@ include file="/WEB-INF/views/menu_top/topMenu.jsp" %>
			
            <%@ include file="/WEB-INF/views/menu_left/leftMenu.jsp" %>
            <!-- /.navbar-static-side -->
            
            
   <div id="page-wrapper">
          <div class="container-fluid">
				
                    <c:url value="/film/uploadExcelFile" var="uploadFileUrl" />
    <c:url value="/film/excelProcessing" var="resetUrl" />
    <c:url value="/film/readPOI" var="readPOIUrl" />

    <form method="post" enctype="multipart/form-data" action="${uploadFileUrl}">
        <input type="file" name="file" accept=".xls,.xlsx" /> 
        <input type="submit" value="Upload file" />
    </form>
        <br /> ${message }
    <br />
    <form method="GET" action="${readPOIUrl}">
        <input type="submit" value="view" />
    </form>

    <br />
    <br />

		<div">
		    <table id="myTableId">
		        <thead>
		            <tr>
		                <th>Id</th>
		                <th>LastName</th>
		                <th>FirstName</th>
		            </tr>
		        </thead>
		        <tbody>
		         <c:forEach items="${persons}" var = "person">
		            <tr>
		                <td >${person.getFirstname()}</td>
		                <td >${person.getLastName()}</td>
		                <td>${person.getId()}</td>
		            </tr>
		              </c:forEach>
		        </tbody>
		    </table>
		</div>

  </div>
    </div>
    
   </div>
</body>

</html>
