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


</head>

<body >

    <div id="wrapper">
		     <!-- Navigation -->
        
       		<%@ include file="/WEB-INF/views/menu_top/topMenu.jsp" %>
            <%@ include file="/WEB-INF/views/menu_left/leftMenu.jsp" %>
        

 		 <div id="page-wrapper">
            <div class="container-fluid">
      				&nbsp;
                  <div class="row">
                  
	                <div class="col-lg-12">
	                    <div class="panel panel-primary">
	                        <div class="panel-heading">
	                            <spring:message code="film.new" />
	                        </div>
	     
	                <!-- /.row -->
	                <div class="panel-body">
							<!-- /.panel-heading -->
						    <c:url value="/film/save" var ="urlSave" />
							<f:form modelAttribute="film" action="${urlSave}" role="form" enctype="multipart/form-data" >
								<f:hidden path="numFilm"/>
								<f:hidden path="photo"/>
								<div class="form-group">
					                         <label><spring:message code="common.title" /></label>
					                         <f:input path="title" class="form-control" placeholder="Title" />
					                         <f:errors path="title" cssClass="error"  />
								</div>
								<div class="form-group">
					                <label><spring:message code="common.kind" /></label><br>
					            	   <f:checkbox path="kind" value="Action" /> Action 
					            	   <f:checkbox path="kind" value="Aventure" /> Aventure 
					            	   <f:checkbox path="kind" value="Animation" /> Animation 
					            	   <f:checkbox path="kind" value="Comedie" /> Comedie 
                                       <f:checkbox path="kind" value="Drame" /> Drame
                                       <f:checkbox path="kind" value="Epouvante" /> Epouvante 
                                       <f:checkbox path="kind" value="Famille" /> Famille
                                       <f:checkbox path="kind" value="Histoire" /> Histoire 
                                       <f:checkbox path="kind" value="Policier" /> Policier 
                                       <f:checkbox path="kind" value="Romance" /> Romance 
                                       <f:checkbox path="kind" value="Sport" /> Sport 
                                       <f:checkbox path="kind" value="Western" /> Western 
                        				<f:errors path="kind" cssClass="error"  />	                          
								</div>
								
								<div class="form-group">
					                         <label><spring:message code="common.year" /></label>
					                         <f:input path="fyear" class="form-control" placeholder="Year" />
					                 		<f:errors path="fyear" cssClass="error"  />
								</div>
								 <div class="form-group">
								            <label><spring:message code="common.date" /></label>
								                <div class='input-group date' id='datepicker1'>
								                    <f:input path="DateStringIn" type="text"  class="form-control" />
								         
								                    <span class="input-group-addon">
								                        <span class="glyphicon glyphicon-calendar"></span>
								                    </span>
								                     <f:errors path="DateStringIn" cssClass="error"  />
								                </div>
								              
								  </div>
  
								<div class="form-group">
					               <label><spring:message code="common.director" /></label>					                					                          
						           <spring:bind path="individual.numInd">
						           			
											<select name="individual.numInd" class="form-control">
											                        <c:forEach items="${individuals}" var="ind">
											                            <c:choose>
											                                <c:when test="${ind.numInd eq idDirector }">
											                                    <option value= "${ind.numInd}"  selected="selected">${ind.surname} ${ind.name} </option>
											                                </c:when>
											                                <c:otherwise>
											                                    <option value="${ind.numInd}">${ind.surname} ${ind.name}</option>
											                                </c:otherwise>
											                            </c:choose>
											                        </c:forEach>
											                    </select>
											</spring:bind>
								</div>
								
									<div class="form-group">
					                         <label><spring:message code="common.photo" /></label>
					                         <input type="file" name="file">
					                        
					                         
								</div>
									<div class="form-group">
					                         <label><spring:message code="common.video" /></label>
					                         <f:input path="video" class="form-control" placeholder="video" />
					                        
									</div>					 			
					                	
					               	<div class="form-group">
					                         <label><spring:message code="common.synopsis" /></label>
					                         <f:input path="synopsis" class="form-control" placeholder="synopsis" />
					                         <f:errors path="synopsis" cssClass="error"  />
									</div>
									 	<div class="form-group">
					                         <label><spring:message code="common.duration" /></label>
					                         <f:input path="duration" class="form-control" placeholder="duration" />
					                         <f:errors path="duration" cssClass="error"  />
									</div>
									
									 	<div class="form-group">
					                         <label><spring:message code="common.country" /></label>
					                         <f:input path="country" class="form-control" placeholder="country" />
					                        
									</div>
									
									 	<div class="form-group">
					                         <label><spring:message code="common.note_imdb" /></label>
					                         <f:input path="note_imdb" class="form-control" placeholder="note imdb" />
					                    
									</div>
								
									<div class="form-group">
					                         <label><spring:message code="common.note_allocine" /></label>
					                         <f:input path="note_allocine" class="form-control" placeholder="note allocine" />
					                         
									</div>
									<div class="panel-footer">
					                   		<button type="submit" class="btn btn-primary"><i class="fa fa-save">&nbsp;<spring:message code="common.save" /></i></button>
					                   		<a href="<c:url value="/film/" />" class="btn btn-danger"> <i class="fa fa-arrow-left">&nbsp;<spring:message code="common.quit" /></i></a>
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
 			<div style="color:red;"><h1>${MsgFilm}</h1></div> 
                     &nbsp;
                              
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
                                        <th><spring:message code="common.photo" /></th>
                                          <th><spring:message code="common.video" /></th>
                                        <th><spring:message code="common.title" /></th>
                                         <th><spring:message code="common.date_release" /></th>
                                        <th><spring:message code="common.kind" /></th>
                                        <th><spring:message code="common.year" /></th>
                                        <th><spring:message code="common.synopsis" /></th>
                                        <th><spring:message code="common.duration" /></th>
                                        <th><spring:message code="common.country" /></th>
                                        <th><spring:message code="common.note_imdb" /></th>
                                        <th><spring:message code="common.note_allocine" /></th>
                                        <th><spring:message code="individual.Ind" /></th> 
                                        <th><spring:message code="common.director" /></th>
                                    </tr>
                                </thead>
               
                  <tbody> 
                  <c:forEach items="${films}" var = "film">
                   <tr class="odd gradeX">
	                        				 <td>${film.getNumFilm() }</td>
	                                        <td><img src="${film.getPhoto()}" width="90px" height="90px" /></td>
	                                          <td>${film.getVideo() }</td>
	                                        <td>${film.getTitle() }</td>
	                                         <td>${film.getDateStringOut() }</td>
	                                        <td>${film.getKind() }</td>
	                                        <td>${film.getFyear() }</td>
	                                          <td>${film.getSynopsis() }</td>
	                                            <td>${film.getDuration() }</td>
	                                              <td>${film.getCountry() }</td>
	                                                <td>${film.getNote_imdb() }</td>
	                                                  <td>${film.getNote_allocine() }</td>
	                                                  
	                                        <td>${film.getIndividual().getNumInd() }</td>
	                                        <td>${film.getIndividual().getSurname()}  ${film.getIndividual().getName() }</td>	                                  	
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

	
    $('.btn-expand-collapse').click(function(e) {
		$('.navbar-primary').toggleClass('collapsed');
	});
   
    </script>
</body>

</html>
