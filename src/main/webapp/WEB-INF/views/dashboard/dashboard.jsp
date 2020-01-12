<%@ include file="/WEB-INF/views/includes/includes.jsp" %>
 <%@ page import="java.util.*" %>
<html lang="en">
<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>SB Admin - Dashboard</title>
     <!-- Bootstrap Core CSS -->
    <link href="<%=request.getContextPath() %>/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  
    <!-- Custom Fonts -->
    <link href="<%=request.getContextPath() %>/resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

  <!-- Custom fonts for this template-->
  <link href="<%=request.getContextPath() %>/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <!-- Custom styles for this template-->
  <link href="<%=request.getContextPath() %>/resources/dist/css/sbp-admin.css" rel="stylesheet" type="text/css">


<script type="text/javascript">
var filmArray1 = new Array();
var filmArray2 = new Array();
<c:forEach items="${dataPointsList1}" var="dataPoints" >	
<c:forEach items="${dataPoints}" var="dataPoint">
	yValue = parseFloat("${dataPoint.y}");
	label = "${dataPoint.label}";
	filmArray1.push(label);
	filmArray2.push(yValue);
</c:forEach> 	
</c:forEach> 	
	

window.onload = function() {
	// Set new default font family and font color to mimic Bootstrap's default styling
	Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
	Chart.defaults.global.defaultFontColor = '#292b2c';
// Bar Chart Example
var ctx = document.getElementById("myBarChart");
var myLineChart = new Chart(ctx, {
	  type: 'bar',
	  data: {
	    labels: filmArray1,
	    datasets: [{
	      label: "Films",
	      backgroundColor: "rgba(2,117,216,1)",
	      borderColor: "rgba(2,117,216,1)",
	      data: filmArray2
	    }]
	  },
  options: {
    scales: {
      xAxes: [{
        time: {
          unit: 'month'
        },
        gridLines: {
          display: false
        },
        ticks: {
          maxTicksLimit: 6
        }
      }],
      yAxes: [{
        ticks: {
          min: 0,
       
          maxTicksLimit: 5
        },
        gridLines: {
          display: true
        }
      }],
    },
    legend: {
      display: false
    }
  }
});


var cineArray1 = new Array();
var cineArray2 = new Array();
<c:forEach items="${dataPointsList2}" var="dataPoints" >	
<c:forEach items="${dataPoints}" var="dataPoint">
	yValue = parseFloat("${dataPoint.y}");
	label = "${dataPoint.label}";
	cineArray1.push(label);
	cineArray2.push(yValue);
</c:forEach> 	
</c:forEach> 


	// Pie Chart Example
	var ctx = document.getElementById("myPieChart");
	var myPieChart = new Chart(ctx, {
	  type: 'pie',
	  data: {
	    labels:cineArray1 ,
	    datasets: [{
	      data: cineArray2,
	      backgroundColor: ['#007bff', '#dc3545', '#ffc107', '#28a745','#819FF7','#00FF80','#FF4000','#F8E6E0','#F4FA58']
	    }],
	  },
	});
							
		};		
		
		$('.multi-item-carousel').carousel({
			  interval: false
			})

			$('.multi-item-carousel .item').each(function(){
			  var next = $(this).next();
			  if (!next.length) {
			    next = $(this).siblings(':first');
			  }
			  next.children(':first-child').clone().appendTo($(this));
			  
			  if (next.next().length>0) {
			    next.next().children(':first-child').clone().appendTo($(this));
			  } else {
			  	$(this).siblings(':first').children(':first-child').clone().appendTo($(this));
			  }
			});	
		
		$(document).ready(function() {
		    // -----------------------------------------------------------------------
		    $.each($('#topheader').find('li'), function() {
		        $(this).toggleClass('active', 
		            window.location.pathname.indexOf($(this).find('a').attr('href')) > -1);
		    }); 
		    // -----------------------------------------------------------------------
		});
		
		
</script>

</head>
<body>
<div id="wrapper">
    
            <%@ include file="/WEB-INF/views/menu_top/topMenu.jsp" %>
			
            <%@ include file="/WEB-INF/views/menu_left/leftMenu.jsp" %>
            <!-- /.navbar-static-side -->

    <div id="page-wrapper">
   
      <div class="container-fluid">
      	&nbsp;	
      	
      <div class=" justify-content-right mb-4">
      		<c:url value="/dashboard/export/" var="urlPdf" />
            <a href="${urlPdf}" class="-block btn btn-sm btn-primary shadow-sm "><i class="fas fa-download fa-sm text-white-50 "></i> Generate Report</a>
       </div>
  
         <div >
				<ol class="breadcrumb">
		          <li class="breadcrumb-item">
		            <a href="#">Dashboard</a>
		          </li>
		          <li class="breadcrumb-item active">Actually</li>
		        </ol>
		    </div>
  
        <!-- Icon Cards-->
	<div class="row">
        <c:forEach var = "cines"  items="${distinctElements}"  varStatus="status">
        
			<div class="col-xl-3 col-md-6 mb-4">
			              <div class="card border-left-primary shadow h-100 py-2">
			                <div class="card-body">
			                  <div class="row no-gutters align-items-center">
			                    <div class="col mr-2">
			                      <div class="text-lg font-weight-bold text-primary text-uppercase mb-1">${cines.cine}</div>
			                      <div class="h5 mb-1 font-weight-bold text-gray-800">${cines.nb_film}</div>
			                    </div>
			                    <div class="col-auto">
			                      <i class="fas fa-calendar fa-2x text-gray-300"></i>
			                    </div>
			                  </div>
			                       <div class="show">
					           <a class="bg-info clearfix " href="#">
					                <span class="float-left"><i class="fa fa-eye" aria-hidden="true"></i>View Details</span>
					                <span class="float-right">
					                
					                    	<c:forEach items="${films}" var="films"  >
											   	<c:if test="${films.name eq cines.cine }">
											   	  <c:set var="titles" value="${films.title}" />
					                    			<c:forEach var="listValue" items="${titles}">
					                    			<ul class="list-categories">
								            			<li>${listValue}</li>
								            		</ul> 
								            		
								       			 	 </c:forEach>
									      		</c:if>	
									      	 </c:forEach>								
					                </span>
					              </a>
					          </div>
			                  
			                </div>
			              </div>    		
            </div>
       	 </c:forEach>
           </div>
           
        <!--/.Active slide-->

                   
          &nbsp;  
         <div>
		    <ol class="breadcrumb">
		          <li class="breadcrumb-item">
		            <a href="#">Dashboard</a>
		          </li>
		          <li class="breadcrumb-item active">Statistic</li>
		    </ol>
		 </div>  
	
    <div class="row justify-content-center">
          <div class="col-lg-6">
            <div class="card mb-3">
              <div class="card-header bg-info">
                <i class="fas fa-chart-bar"></i>
               Films by category</div>
              <div class="card-body"><div class="chartjs-size-monitor"><div class="chartjs-size-monitor-expand"><div class=""></div></div><div class="chartjs-size-monitor-shrink"><div class=""></div></div></div>
                <canvas id="myBarChart" width="435" height="217" class="chartjs-render-monitor" style="display: block; width: 435px; height: 217px;"></canvas>
              </div>
              <div class="card-footer small text-muted">Updated on  <%= (new java.util.Date()).toLocaleString()%></div>
            </div>
          </div>
          <div class="col-lg-6">
            <div class="card mb-3">
              <div class="card-header bg-info">
                <i class="fas fa-chart-pie"></i>
                Films by cinema</div>
              <div class="card-body"><div class="chartjs-size-monitor"><div class="chartjs-size-monitor-expand"><div class=""></div></div><div class="chartjs-size-monitor-shrink"><div class=""></div></div></div>
                <canvas id="myPieChart" width="435" height="217" class="chartjs-render-monitor" style="display: block; width: 435px; height: 217px;"></canvas>
              </div>
              <div class="card-footer small text-muted">Updated on  <%= (new java.util.Date()).toLocaleString()%></div>
            </div>
          </div>
        </div>     
    </div>
      <!-- /.container-fluid -->
		
    </div>
    <!-- /.content-wrapper -->
  </div>
    <!-- /#wrapper -->

  <!-- Page level plugin JavaScript-->
  <script src="<%=request.getContextPath() %>/resources/vendor/chart.js/Chart.min.js"></script>



</body>

</html>
