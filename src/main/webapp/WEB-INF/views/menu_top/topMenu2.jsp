
  <nav class="navbar navbar-expand navbar-dark  bg-dark static-top">

    	<c:url value="/film/" var = "filmUrl" />
             <a href="${filmUrl }" class="d-none d-sm-inline-block btn btn-sm btn-dark shadow-sm"><i class="fas fa-home fa-sm text-white-50"></i>&nbsp;Home</a>
 
    <!-- Navbar -->
    <ul class="navbar-nav ml-auto mr-0 mr-md-3 my-2 my-md-0">
      
      <li class="nav-item dropdown no-arrow">
        <a class="nav-link dropdown-toggle text-white " href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          <i class="fas fa-users-cog"></i> ${userDetails.username} </a>
        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
        	<c:url value="/user/new" var="user" />
          <a class="dropdown-item" href="${user}"><i class="fas fa-cog"></i>Settings</a>
          <div class="dropdown-divider"></div>
          <c:url value="/j_spring_security_logout" var = "logout" />  
          <a class="dropdown-item" href="${logout }" ><i class="fas fa-sign-out-alt"></i>Logout</a>
        </div>
      </li>

    </ul>

  </nav>