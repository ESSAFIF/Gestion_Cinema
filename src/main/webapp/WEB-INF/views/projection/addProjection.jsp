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

    <!-- MetisMenu CSS -->
    <link href="<%=request.getContextPath() %>/resources/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

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
	                            <spring:message code="projection.new" />
	                        </div>
	     
	                <!-- /.row -->
	                <div class="panel-body">
							<!-- /.panel-heading -->
						    <c:url value="/projection/save" var ="urlSave" />
							<f:form modelAttribute="projection" action="${urlSave}" role="form"  >

										<div class="form-group">
                                          <label><spring:message code="common.cinema" /></label>
					                         <f:select path="projectionPK.numCine" class="form-control">
					                             <c:forEach var="cine" items="${cinemas}" >
										       				
										       				    <c:choose>
											                                <c:when test="${cine.numCine eq idCine }">
											                                    <option value= "${cine.numCine}" selected="selected" >${cine.name}</option>
											                                </c:when>
											                                <c:otherwise>
											                                    <option value="${cine.numCine}" >${cine.name}</option>
											                                </c:otherwise>
											                   </c:choose>
										    	</c:forEach>
										    	
					                          </f:select>
					                          
                                    </div>
								
									<div class="form-group">
					                         <label><spring:message code="common.film" /></label>
					                          <f:select path="projectionPK.numFilm"  class="form-control">
					                             <c:forEach var="film" items="${films}" >
			
										       				 <c:choose>
											                                <c:when test="${film.numFilm eq idFilm }">
											                                    <option value= "${film.numFilm}" selected="selected" >${film.title} </option>
											                                </c:when>
											                                <c:otherwise>
											                                    <option value="${film.numFilm}">${film.title} </option>
											                                </c:otherwise>
											                   </c:choose>
										    	</c:forEach>
					                          </f:select>
					                     	</div>
					
							
								            <div class="form-group">
								            <label><spring:message code="common.date" /></label>
								                <div class='input-group date' id='datepicker1'>
								                    <f:input path="projectionPK.DateStringIn" type="text"  class="form-control" />
								         
								                    <span class="input-group-addon">
								                        <span class="glyphicon glyphicon-calendar"></span>
								                    </span>
								                </div>
								                 <f:errors path="projectionPK.DateStringIn" cssClass="error"  />
								            </div>
							  
							   
					 					<div class="panel-footer">
					 			
					                   		<button type="submit" class="btn btn-primary">
					                   		
					                   		<i class="fa fa-save">&nbsp;<spring:message code="common.save" />
					                   		
					                   		</i></button>
					                   		<a href="<c:url value="/projection/" />" class="btn btn-danger"> <i class="fa fa-arrow-left">&nbsp;<spring:message code="common.quit" /></i></a>
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
                    <div class="panel panel-success">
                        <div class="panel-heading">
                            <spring:message code="common.success" />
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables">
                            
                            <thead>
                                    <tr>
                                    	
                                     
                                        <th><spring:message code="common.idCinema" /></th>
                                        <th><spring:message code="common.cinema" /></th>
                                           <th><spring:message code="common.idFilm" /></th>
                                        <th><spring:message code="common.title" /></th>
                                        <th><spring:message code="common.date" /></th>
                                    </tr>
                                </thead>
               
                  <tbody> 
                  <c:forEach items="${proj}" var = "proj">
                   <tr class="odd gradeX">	                        				
	                                    
	                                        <td>${proj.getCinema().getNumCine()}</td>
	                                        <td>${proj.getCinema().getName()}</td>
	                                        <td>${proj.getFilm().getNumFilm()}</td>
	                                        <td>${proj.getFilm().getTitle()}</td>
	                                         <td>${proj.getProjectionPK().getDateStringOut() }</td>

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


   <!-- Include Bootstrap Datepicker -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.8.0/css/bootstrap-datepicker.min.css" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.8.0/js/bootstrap-datepicker.min.js"></script>
 <script>
 $('.input-group.date').datepicker({
     todayBtn: "linked",
     autoclose: true,
     todayHighlight: true,
     format: 'dd-mm-yyyy'
    
 	});
 $( "#datepicker1" ).datepicker({ 
     changeYear: true,
     minDate: '-3M',
     maxDate: '+28D',
 });
	
    $('.btn-expand-collapse').click(function(e) {
		$('.navbar-primary').toggleClass('collapsed');
	});
   
    </script>
</body>

</html>
