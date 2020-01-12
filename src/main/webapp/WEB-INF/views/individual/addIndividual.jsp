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

        <!-- Custom styles for this template-->
  	<link href="<%=request.getContextPath() %>/resources/dist/css/sbp-admin.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="<%=request.getContextPath() %>/resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
      
            <%@ include file="/WEB-INF/views/menu_top/topMenu.jsp" %>
			
            <%@ include file="/WEB-INF/views/menu_left/leftMenu.jsp" %>
           

        <!-- Page Content -->
        <div id="page-wrapper">
            <div class="container-fluid">
             &nbsp;
    
                  <div class="row">
	                <div class="col-lg-12">
	                    <div class="panel panel-primary">
	                        <div class="panel-heading">
	                            <spring:message code="individual.new" />
	                        </div>
	     
	                <!-- /.row -->
	                <div class="panel-body">
							<!-- /.panel-heading -->
						    <c:url value="/individual/save" var ="urlSave" />
							<f:form modelAttribute="individual" action="${urlSave}" role="form" >
								<f:hidden path="numInd"/>
								<div class="form-group">
					                         <label><spring:message code="common.name" /></label>
					                         <f:input path="name" class="form-control" placeholder="Name" />
					                             <f:errors path="name" cssClass="error"  />
								</div>
								<div class="form-group">
					                         <label><spring:message code="common.surname" /></label>
					                         <f:input path="surname" class="form-control" placeholder="Surname" />
					                             <f:errors path="surname" cssClass="error"  />
								</div>
					
					 			<div class="panel-footer">
					                   		<button type="submit" class="btn btn-primary"><i class="fa fa-save">&nbsp;<spring:message code="common.save" /></i></button>
					                   		<a href="<c:url value="/individual/" />" class="btn btn-danger"> <i class="fa fa-arrow-left">&nbsp;<spring:message code="common.quit" /></i></a>
					                	</div>
								</f:form>	                        
	                   		</div>
	                        <!-- /.panel-body -->
	                    </div>
	                    <!-- /.panel -->
	                </div>
                <!-- /.col-lg-12 -->
            </div>
                <!-- /.row -->
               <div style="color:red;"><h1>${MsgInd}</h1></div> 
                 <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-success">
                        <div class="panel-heading">
                            <spring:message code="common.success" />
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables">
                            
                            <thead>
                                    <tr>
                                        <th><spring:message code="common.id" /></th>
                                        <th><spring:message code="common.name" /></th>
                                        <th><spring:message code="common.surname" /></th>
                                     
                                    </tr>
                                </thead>
               
                  <tbody> 
                  <c:forEach items="${individuals}" var = "ind">
                   <tr class="odd gradeX">
	                        
	                                        <td>${ind.getNumInd() }</td>
	                                        <td>${ind.getName() }</td>
	                                        <td>${ind.getSurname() }</td>
	                                       
                    </tr>
                    </c:forEach>
                    </tbody>
     			</table>
              </div>
            </div>
          </div>
         </div>
         </div>
        </div>
                
                
          </div>
            <!-- /.container-fluid -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="<%=request.getContextPath() %>/resources/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<%=request.getContextPath() %>/resources/vendor/bootstrap/js/bootstrap.min.js"></script>

  
    <script>
 

    $('.btn-expand-collapse').click(function(e) {
		$('.navbar-primary').toggleClass('collapsed');
	});
  
    </script>
</body>

</html>
