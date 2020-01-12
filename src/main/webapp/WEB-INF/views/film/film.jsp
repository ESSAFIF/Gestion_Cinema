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
      <!-- Page-Level Demo Scripts - Tables - Use for reference -->
   
  
</head>
<body>

<div id="wrapper">
    
            <%@ include file="/WEB-INF/views/menu_top/topMenu.jsp" %>
			
            <%@ include file="/WEB-INF/views/menu_left/leftMenu.jsp" %>
            <!-- /.navbar-static-side -->
            
            
   <div id="page-wrapper">
          <div class="container-fluid">
				
                    <!-- /.col-lg-12 -->
                   <div class="row">
					<div class="col-lg-12">
						<ol class="breadcrumb">
						  <li><a href="<c:url value="/film/new" />" class="btn btn-success" ><i class="fa fa-plus">&nbsp;<spring:message code="common.add" /></i></a></li>
						  <li>
						  <c:url value="/film/export/" var="urlExport" />
						  <a href="${urlExport }"  class="btn btn-warning"><i class="fa fa-download">&nbsp;<spring:message code="common.exporter" /></i></a></li>
						</ol>					
					</div>                
                </div>  
           			 
		        <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <spring:message code="film.list" />
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body table-responsive">
		              <table class="table table-striped table-bordered table-hover" id="dataTables" width="100%" >
                            
                            <thead>
                                    <tr>
                                    	
                                        <th><spring:message code="common.id" /></th>
                                        <th><spring:message code="common.photo" /></th>
                                        <th><spring:message code="common.video" /></th>
                                        <th><spring:message code="common.title" /></th>
                                        <th><spring:message code="common.date_release" /></th>
                                     	<th><spring:message code="common.kind" /></th>
                                        <th><spring:message code="common.year" /></th>
                                        <th><spring:message code="common.synopsis" /></th>
                                        <th><spring:message code="common.duration" /></th>
                                         <th><spring:message code="common.country" /></th>
                                         <th><div style="width: 30px;"><spring:message code="common.note_imdb" /></div></th>
                                         <th><spring:message code="common.note_allocine" /></th>
                                        <th><spring:message code="individual.Ind" /></th> 
                                        <th><spring:message code="common.director" /></th>
                                        <th><div style="width: 120px;"><spring:message code="common.actions" /></div></th>
                                    </tr>
                                </thead>
               
                  <tbody> 
                  <c:forEach items="${films}" var = "film">
                   <tr >
	                        				 <td>${film.getNumFilm() }</td>
	                                        <td><img src="${film.getPhoto()}" width="90px" height="90px" /></td>
	                                        <td>${film.getVideo() }</td>
	                                        <td>${film.getTitle() }</td>	                                        
	                                         <td>${film.getDateStringOut() }</td>
	                                    	 <td>  ${film.getKind() } 	
	                                    	 
											    </td>
	                                        <td>${film.getFyear() }</td>
	                                        <td>${film.getSynopsis() }</td>
	                                        <td>${film.getDuration() }</td> 
	                                        <td>${film.getCountry() }</td>
	                                        <td>${film.getNote_imdb() }</td>
	                                        <td>${film.getNote_allocine() }</td>                                        
	                                        <td>${film.getIndividual().getNumInd() }</td>
	                                        <td>${film.getIndividual().getSurname()}  ${film.getIndividual().getName() }</td>
	                                        
	                                         <td>
	                                        	
	                                         	<c:url value="/film/update/${film.getNumFilm()}" var="urlUpdate" />
	                                        	<a href="${urlUpdate}" class="btn btn-info"><i class="fa fa-edit"></i></a>
	                                        	&nbsp;|&nbsp;
	                                        	
	                                        	<a href="javascript:void(0);" data-toggle="modal" data-target="#modalFilm${film.getNumFilm() }" class="btn btn-danger"><i class="fa fa-trash"></i></a>
	                                        	<div class="modal fade" id="modalFilm${film.getNumFilm() }" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
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
																<c:url value="/film/delete/${film.getNumFilm()}" var="urlDelete" />
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
        <script> 	
       $(document).ready(function() {
       
           $.each($('#topheader').find('li'), function() {
   	        $(this).toggleClass('active', 
   	            window.location.pathname.indexOf($(this).find('a').attr('href')) > -1);
   	    }); 
           
           $('#dataTables').DataTable({
        	   "sScrollX": '100%',
               "scrollY": "300px"
           	
           });
       });
	
    </script>


  

</body>

</html>
