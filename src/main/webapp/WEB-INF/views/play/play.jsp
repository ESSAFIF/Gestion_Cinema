<%@ include file="/WEB-INF/views/includes/includes.jsp" %>
<!DOCTYPE html>
<html lang="fr">
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

   <!-- DataTables CSS -->
    <link href="<%=request.getContextPath() %>/resources/vendor/datatables-plugins/dataTables.bootstrap.css" rel="stylesheet">

    <!-- DataTables Responsive CSS -->
    <link href="<%=request.getContextPath() %>/resources/vendor/datatables-responsive/dataTables.responsive.css" rel="stylesheet">

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

            
            <%@ include file="/WEB-INF/views/menu_top/topMenu.jsp" %>
			
            <%@ include file="/WEB-INF/views/menu_left/leftMenu.jsp" %>
      
      <!-- Page Content -->
        <div id="page-wrapper">
            <div class="container-fluid">
                
                <div class="row">
					<div class="col-lg-12">
						<ol class="breadcrumb">
						  <li><a href="<c:url value="/play/new" />" class="btn btn-success" ><i class="fa fa-plus">&nbsp;<spring:message code="common.add" /></i></a></li>
						</ol>					
					</div>                
                </div>  
               <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <spring:message code="play.list" />
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables">
                            
                            <thead>
                                    <tr>
                                    	
                                        <th><spring:message code="common.idAct" /></th>
                                        <th><spring:message code="common.actor" /></th>
                                        <th><spring:message code="common.idFilm" /></th>
                                        <th><spring:message code="common.title" /></th>
                                        <th><spring:message code="common.role" /></th>
                                        <th><spring:message code="common.actions" /></th>
                                    </tr>
                                </thead>
               
                  <tbody> 
                  <c:forEach items="${plays}" var = "play">
                   <tr class="odd gradeX">
	                        				
	                                    
	                                        <td>${play.getIndividual().getNumInd()}</td>
	                                        <td>${play.getIndividual().getSurname()} ${play.getIndividual().getName()}</td>
	                                        <td>${play.getFilm().getNumFilm()}</td>
	                                        <td>${play.getFilm().getTitle()}</td>
	                                        <td>${play.getRole() }</td>
	                         	                                        
	                                         <td>
	                                        
	                                         	<c:url value="/play/update/${play.getPlayPK().getNumInd()},${play.getPlayPK().getNumFilm()}" var="urlUpdate" />
	                                        	<a href="${urlUpdate}" class="btn btn-info"><i class="fa fa-edit"></i></a>
	                                        	&nbsp;|&nbsp;
	                                        	
	                                        	<a href="javascript:void(0);" data-toggle="modal" data-target="#modalPlay${play.getPlayPK().getNumInd() }" class="btn btn-danger"><i class="fa fa-trash-o"></i></a>
	                                        	<div class="modal fade" id="modalPlay${play.getPlayPK().getNumInd() }" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
													<div class="modal-dialog">
														<div class="modal-content">
															<div class="modal-header">
																<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
																<h4 class="modal-title" id="myModalLabel"><spring:message code="common.confirm.suppression" /></h4>
															</div>
															<div class="modal-body">
																<spring:message code="play.confirm.suppression.msg" />
															</div>
															<div class="modal-footer">
																<button type="button" class="btn btn-default" data-dismiss="modal"><spring:message code="common.close" /></button>
																<c:url value="/play/delete/${play.getPlayPK().getNumInd()},${play.getPlayPK().getNumFilm()}" var="urlDelete" />
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
        </div>
                      
                <!-- /.row -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="<%=request.getContextPath() %>/resources/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<%=request.getContextPath() %>/resources/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- DataTables JavaScript -->
    <script src="<%=request.getContextPath() %>/resources/vendor/datatables/js/jquery.dataTables.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/vendor/datatables-responsive/dataTables.responsive.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="<%=request.getContextPath() %>/resources/dist/js/sb-admin-2.js"></script>
    
    <!-- Custom Theme JavaScript -->
    <script src="../dist/js/sb-admin-2.js"></script>

    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
      <script>
    $(document).ready(function() {
    	
        $.each($('#topheader').find('li'), function() {
   	        $(this).toggleClass('active', 
   	            window.location.pathname.indexOf($(this).find('a').attr('href')) > -1);
   	    }); 
        
        $('#dataTables').DataTable({
            responsive: true,
            "scrollY": "300px",
        	  "scrollCollapse": true
        });
    });
	
    </script>

</body>

</html>
