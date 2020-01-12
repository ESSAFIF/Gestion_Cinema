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

    <!-- Custom Fonts -->
    <link href="<%=request.getContextPath() %>/resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

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
	                            <spring:message code="play.new" />
	                        </div>
	     
	                <!-- /.row -->
	                <div class="panel-body">
							<!-- /.panel-heading -->
						    <c:url value="/play/save" var ="urlSave" />
							<f:form modelAttribute="play" action="${urlSave}" role="form"  >

										<div class="form-group">
                                          <label><spring:message code="common.actor" /></label>
					                         <f:select class="form-control" path="playPK.numInd" itemValue="playPK.numInd" >
					                             <c:forEach var="ind" items="${individuals}" >
										       			
										       				     <c:choose>
											                                <c:when test="${ind.numInd eq idActor }">
											                                    <option value= "${ind.numInd}"  selected="selected">${ind.surname} ${ind.name} </option>
											                                </c:when>
											                                <c:otherwise>
											                                    <option value="${ind.numInd}">${ind.surname} ${ind.name}</option>
											                                </c:otherwise>
											                            </c:choose>
										    	</c:forEach>
										    	
					                          </f:select>
					                          
                                    </div>
								
									<div class="form-group">
					                         <label><spring:message code="common.title" /></label>
					                         <f:select class="form-control" path="playPK.numFilm" itemValue="playPK.numFilm" >
					                             <c:forEach var="film" items="${films}" >
										       			
										       				 <c:choose>
											                                <c:when test="${film.numFilm eq idFilm }">
											                                    <option value= "${film.numFilm}" selected="selected" label="${film.title} "/>
											                                </c:when>
											                                <c:otherwise>
											                                    <option value="${film.numFilm}" label="${film.title} "/>
											                                </c:otherwise>
											                   </c:choose>
										    	</c:forEach>
					                          </f:select>
					               	</div>
								<div class="form-group">
					                         <label><spring:message code="common.role" /></label>
					                         <f:input path="role"  class="form-control" placeholder="role" />
					                             <f:errors path="role" cssClass="error"  />
					                      
								</div>
					
					 			<div class="panel-footer">
					 			
					                   		<button type="submit" class="btn btn-primary">
					                   		
					                   		<i class="fa fa-save">&nbsp;<spring:message code="common.save" />
					                   		
					                   		</i></button>
					                   		<a href="<c:url value="/play/" />" class="btn btn-danger"> <i class="fa fa-arrow-left">&nbsp;<spring:message code="common.quit" /></i></a>
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
                                    	
                                        <th><spring:message code="common.idAct" /></th>
                                        <th><spring:message code="common.actor" /></th>
                                        <th><spring:message code="common.idFilm" /></th>
                                        <th><spring:message code="common.title" /></th>
                                        <th><spring:message code="common.role" /></th>
                                     
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

    <script>
   
    $('.btn-expand-collapse').click(function(e) {
		$('.navbar-primary').toggleClass('collapsed');
	});
   
    </script>
</body>

</html>
