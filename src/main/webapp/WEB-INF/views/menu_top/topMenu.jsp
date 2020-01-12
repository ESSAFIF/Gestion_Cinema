<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<nav class="navbar navbar-inverse navbar-global  mb-3 navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
        <li>
          <a class="nav  navbar-left "  href="#"><img src="http://kris.agentfire2.com/wp-content/mu-plugins/agentfire-shared-library/img/agentfire.svg"  width="20" height="40" class="d-inline-block align-left" alt="">
         TopFilm
          
       </a></li>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <c:set var = "role1" value = "[ROLE_ADMIN]" />
          <c:set var = "role2" value = "[ROLE_USER]" />
           <c:set var = "string1" value = "${userDetails.authorities}" />
          
	       <c:if test="${userDetails.authorities eq role1}">
	        	<c:set var = "string2" value = "${fn:replace(role1, 'ROLE_ADMIN', 'admin')}" />
           </c:if>
        
	       <c:if test="${userDetails.authorities eq role2}">
	        	<c:set var = "string2" value = "${fn:replace(role2, 'ROLE_USER', 'user')}" />
           </c:if>
         
          <ul class="nav navbar-nav  navbar-right">
          		<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#"> <i class="fa fa-user fa-fw"></i> <span>${userDetails.username} </span> <span> ${string2}</span>
					
			</a>
		<ul class="dropdown-menu dropdown-user">
			<li>
			 <c:url value="/user/new" var="user" />
      			<a href="${user}">
			<i class="fa fa-user fa-fw"></i> User Profile</a></li>
			<li class="divider"></li>
				<c:url value="/changelocale/fr" var = "frUrl" />
			<c:url value="/changelocale/en" var = "enUrl" />
			<li><a href="${frUrl }"><i class="fa fa-globe fa-fw"></i> <spring:message code="locale.fr"/></a></li>
			<li><a href="${enUrl }"><i class="fa fa-globe fa-fw"></i> <spring:message code="locale.en"/></a></li>
			<li class="divider"></li>
		
		</ul> <!-- /.dropdown-user --></li>
    
         
            <li>     <c:url value="/j_spring_security_logout" var = "logout" />   
            		<a href="${logout }"><span class="glyphicon glyphicon-log-out"></span> Logout</a>
            </li>
            
            
          </ul>
        </div><!--/.nav-collapse -->
      </div>

	
    </nav>