  <div id="topheader">
  <nav class="navbar navbar-primary">
  <ul class="navbar-primary-menu">
    <li class="active" >
    <c:url value="/dashboard/" var="home" />
      <a href="${home}">
      <span class="glyphicon glyphicon-list-alt"></span><span class="nav-label"><spring:message code="common.dashboard" /></span><span class="sr-only">(current)</span></a></li>
         <li >
      <c:url value="/film/" var="film" />
      <a href="${film }">
      <span class="glyphicon glyphicon-film"></span><span class="nav-label"><spring:message code="common.film" /></span></a></li>
         <li>
      <c:url value="/individual/" var="individual" />
      <a href="${individual }">
      <span class="glyphicon glyphicon-user"></span><span class="nav-label"><spring:message code="common.individual" /></span></a></li>
         <li>
      <c:url value="/play/" var="play" />	
      <a href="${play }">
      <span class="glyphicon glyphicon-play"></span><span class="nav-label"> <spring:message code="common.play" /></span></a></li>
      <li>
      <c:url value="/cinema/" var="cinema" />
      <a href="${cinema }">
      <span class="glyphicon glyphicon-blackboard"></span><span class="nav-label"><spring:message code="common.cinema" /></span></a></li>
      
         <li>
      <c:url value="/projection/" var="projection" />	
        <a href="${projection}">
      <span class="glyphicon glyphicon-facetime-video"></span><span class="nav-label"><spring:message code="common.projection" /></span></a>
    </li>
     
    
   
  </ul>
</nav>

</div>