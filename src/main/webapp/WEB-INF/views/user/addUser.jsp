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
    <link href="<%=request.getContextPath() %>/resources/dist/css/sbp-admin.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="<%=request.getContextPath() %>/resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href="https://gitcdn.github.io/bootstrap-toggle/2.2.2/css/bootstrap-toggle.min.css" rel="stylesheet">
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
                    <div class="row">
	          
                  <div class="row">
	                <div class="col-lg-12">
	                    <div class="panel panel-primary">
	                        <div class="panel-heading">
	                            <spring:message code="user.new" />
	                        </div>
	     
	                <!-- /.row -->
	                <div class="panel-body">
							<!-- /.panel-heading -->
						    <c:url value="/user/save" var ="urlSave" />
							<f:form modelAttribute="user" action="${urlSave}" role="form" >
								<f:hidden path="idUser"/>
								<div class="form-group">
					                         <label><spring:message code="common.name" /></label>
					                         <f:input path="name" class="form-control" placeholder="name" />
					                           <f:errors path="name" cssClass="error"  />
								</div>
								<div class="form-group">
					                         <label><spring:message code="common.surname" /></label>
					                         <f:input path="surname" class="form-control" placeholder="surname" />
					                         <f:errors path="surname" cssClass="error"  />
								</div>
								
								<div class="form-group">
					                         <label><spring:message code="common.mail" /></label>
					                         <f:input path="mail" class="form-control" placeholder="mail" />
					                         <f:errors path="mail" cssClass="error" />
								</div>
								
								<div class="form-group">
					                         <label><spring:message code="common.login" /></label>
					                         <f:input path="login" class="form-control" placeholder="login" />
					                         <f:errors path="login" cssClass="error" />
								</div>
								
									<div class="form-group">
					                         <label><spring:message code="common.password" /></label>
					                         <f:input path="passW" class="form-control" placeholder="password" />
					                         <f:errors path="passW" cssClass="error" />
								</div>
											
									<div class="form-group">
					                         <label><spring:message code="common.role" /></label>
					                         <f:select class="form-control" path="roles.idRole" >
					                             <c:forEach var="role" items="${roles}" >
										       				 <option value="${role.idRole}" label="${role.roleName}"/>
										    	</c:forEach>
					                          </f:select>
								</div>
									<div class="form-group">
					                         <label><spring:message code="common.status" /></label>			
										<f:checkbox data-toggle="toggle" data-onstyle="warning" data-on="true" data-width="100" data-off="false" path="actived"/>	
									</div>	
						
					 			<div class="panel-footer">
					                   		<button type="submit" class="btn btn-primary"><i class="fa fa-save">&nbsp;<spring:message code="common.save" /></i></button>
					                   		
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
                
                 <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <spring:message code="user.list" />
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables1">
                            
                            <thead>
                                    <tr>
                                    	
                                        <th><spring:message code="common.id" /></th>
                                        <th><spring:message code="common.name" /></th>
                                        <th><spring:message code="common.surname" /></th>
                                        <th><spring:message code="common.mail" /></th>
                                        <th><spring:message code="common.login" /></th>
                                         <th><spring:message code="common.password" /></th>
                                         <th><spring:message code="common.role" /></th>
                                           <th><spring:message code="common.status" /></th>
                                       	<th><spring:message code="common.actions" /></th>
                                    </tr>
                                </thead>
               
                  <tbody> 
                  <c:forEach items="${users}" var = "user">
                   <tr class="odd gradeX">
	                        				 <td>${user.getIdUser() }</td>
	                                        <td>${user.getName() }</td>
	                                        <td>${user.getSurname() }</td>
	                                        <td>${user.getMail() }</td>
	                                        <td>${user.getLogin() }</td>
	                                        <td>${user.getPassW() }</td>
	                                        <td>${user.getRoles().getRoleName() }</td>
	                                         <td>${user.isActived()}</td>
	                                                <td>
	                                        	
	                                         	<c:url value="/user/update/${user.getIdUser()}" var="urlUpdate" />
	                                        	<a href="${urlUpdate}" class="btn btn-info"><i class="fa fa-edit"></i></a>
	                                        	&nbsp;|&nbsp;
	                                        	
	                                        	<a href="javascript:void(0);" data-toggle="modal" data-target="#modalUser${user.getIdUser() }" class="btn btn-danger"><i class="fa fa-trash-o"></i></a>
	                                        	<div class="modal fade" id="modalUser${user.getIdUser() }" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
													<div class="modal-dialog">
														<div class="modal-content">
															<div class="modal-header">
																<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
																<h4 class="modal-title" id="myModalLabel"><spring:message code="common.confirm.suppression" /></h4>
															</div>
															<div class="modal-body">
																<spring:message code="film.confirm.suppression.msg" />
															</div>
															<div class="modal-footer">
																<button type="button" class="btn btn-default" data-dismiss="modal"><spring:message code="common.close" /></button>
																<c:url value="/user/delete/${user.getIdUser()}" var="urlDelete" />
																<a href="${urlDelete }" class="btn btn-danger"><i class="fa fa-trash-o"></i>&nbsp;<spring:message code="common.confirm" /></a>
															</div>
														</div>
														<!-- /.modal-content -->
													</div>
													<!-- /.modal-dialog -->
					                               	</div>         	
	                                         </td>
                    </tr>
                    </c:forEach>
                    </tbody>
     			</table>
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
    <script src="https://gitcdn.github.io/bootstrap-toggle/2.2.2/js/bootstrap-toggle.min.js"></script>
    <script>
			    $(document).ready(function() {
			        $('#dataTables1').DataTable({
			            responsive: true,
			            "scrollY": "200px",
			      	  "scrollCollapse": true
			        });
			    });
	    
		    $('.btn-expand-collapse').click(function(e) {
				$('.navbar-primary').toggleClass('collapsed');
			});
		    
    </script>
</body>

</html>
