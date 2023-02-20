<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.84.0">
    <title>Ajouter un type d'echantillon</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/dashboard/">

    

    <!-- Bootstrap core CSS -->
<link href="public/css/bootstrap.min.css" rel="stylesheet">
<link href="public/css/bootstrap-icons-1.3.0/bootstrap-icons.css" rel="stylesheet">

    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>

    
    <!-- Custom styles for this template -->
    <link href="public/css/css-template/sidebars.css" rel="stylesheet">
    <link href="public/css/css-template/dashboard.css" rel="stylesheet">
  </head>
  <body>
    
<%@ include file="/WEB-INF/view/registrationView/header.jsp" %>

<div class="container-fluid">
  <div class="row">
    
    <%@ include file="navsidebar.jsp" %>

    <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
      <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
        <h1 class="h2" style="border:solid 4px black;font-family: consolas">Ajouter un type d'echantillon</h1>
      </div>
      
      
      <div class="col-md-7 col-lg-8">
        <h4 class="mb-3">Renseignez les informations ici</h4>
        	<form action="registrationTypeEchantillon" method="post">
	          <div class="row">
	          
	            <div class="col-md-8">
	              <label for="nom_type_echantillon" class="form-label">Nom type echantillon :</label>
	              <input type="text" class="form-control" id="nom_type_echantillon" name="nom_type_echantillon" required>
	            </div>
	            
	            <div class="col-md-8">
	              <label for="id_pathologie" class="form-label">Pathologie concern�e :</label>
	              <select class="form-select" name="id_pathologie">
			      	<c:forEach items="${listPathologie }" var="pathologie">
			      		<option value="${pathologie.getId_pathologie() }">
			      			<c:out value="${pathologie.getNom_pathologie() }"></c:out>
			      		</option>
			      	</c:forEach>
			      </select>
	            </div>
	            
	           
	          </div>
	
	          <hr class="col-md-8">
	
	          <button class="btn btn-success btn-lg-12" type="submit">Enregistrer</button>
	        </form>
      </div>
      
    </main>
  </div>
</div>
	
	

    <script src="public/js/bootstrap.min.js"></script>
	
	<script type="text/javascript" src="public/js/js-template/sidebars.js"></script>
      <script src="https://cdn.jsdelivr.net/npm/feather-icons@4.28.0/dist/feather.min.js" integrity="sha384-uO3SXW5IuS1ZpFPKugNNWqTZRRglnUJK6UAZ/gxOX80nxEkN9NcGZTftn6RzhGWE" crossorigin="anonymous"></script><script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js" integrity="sha384-zNy6FEbO50N+Cg5wap8IKA4M/ZnLJgzc6w2NqACZaK0u0FXfOWRRJOnQtpZun8ha" crossorigin="anonymous"></script><script src="public/js/js-template/dashboard.js"></script>
  </body>
</html>
