<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.84.0">
    <title>Création nouveau type utilisateur</title>

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
    
<%@ include file="header.jsp" %> 

<div class="container-fluid">
  <div class="row">
    
    <%@ include file="navsidebar.jsp" %>  

    <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
      <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
        <h1 class="h2" style="border:solid 4px black;font-family: consolas">Ajouter un nouvel utilisateur de PFBM</h1>
      </div>
      
      <c:choose>
      	<c:when test="${checkUserBD == false }">
      		<div class="col-md-7 col-lg-8">
	        <h4 class="mb-3">Renseignez les informations</h4>
	        <form action="adduser" method="post" id="formUser">
	          <div class="row">
	          
	            <div class="col-md-8">
	              <label for="nom_user" class="form-label">Nom utilisateur :</label>
	              <input type="text" class="form-control" id="nom_user" name="nom_user" value="${nom_user }" required>
	            </div>
	            
	            <div class="col-md-8">
	              <label for="prenom_user" class="form-label">Prenom utilisateur :</label>
	              <input type="text" class="form-control" id="prenom_user" name="prenom_user" value="${prenom_user }" required>
	            </div>
	            
	            <div class="col-md-8">
	              <label for="login_user" class="form-label">Login :</label>
	              <input type="text" class="form-control" id="login_user" name="login_user" value="${login_user }" required>
	              <span class="bg-dark text-danger">Ce login est deja utilisé</span>
	            </div>
	            
	            <div class="col-md-8">
	              <label for="mdp_user" class="form-label">Mot de passe :</label>
	              <input type="password" class="form-control" id="mdp_user" name="mdp_user" required>
	            </div>
	            
	            <div class="col-md-8">
	              <label for="id_type_user" class="form-label">Type d'utilisateur :</label>
	              <select class="form-select" name="id_type_user">
			      	<c:forEach items="${listTypeUser }" var="typeUser">
			      		<option value="${typeUser.getId_type_user() }">
			      			<c:out value="${typeUser.getNom_type_user() }"></c:out>
			      		</option>
			      	</c:forEach>
			      </select>
	            </div>
	            
	          </div>
	          <hr class="col-md-8">
	
	         <button class="btn btn-success btn-lg-12" type="submit">Enregistrer</button>
	         </form>
	         
	        </div>
      	</c:when>
      
      	<c:otherwise>
	      <div class="col-md-7 col-lg-8">
	        <h4 class="mb-3">Renseignez les informations</h4>
	        <form action="adduser" method="post" id="formUser">
	          <div class="row">
	          
	            <div class="col-md-8">
	              <label for="nom_user" class="form-label">Nom utilisateur :</label>
	              <input type="text" class="form-control" id="nom_user" name="nom_user" required>
	            </div>
	            
	            <div class="col-md-8">
	              <label for="prenom_user" class="form-label">Prenom utilisateur :</label>
	              <input type="text" class="form-control" id="prenom_user" name="prenom_user" required>
	            </div>
	            
	            <div class="col-md-8">
	              <label for="login_user" class="form-label">Login :</label>
	              <input type="text" class="form-control" id="login_user" name="login_user" required>
	            </div>
	            
	            <div class="col-md-8">
	              <label for="mdp_user" class="form-label">Mot de passe :</label>
	              <input type="password" class="form-control" id="mdp_user" name="mdp_user" required>
	            </div>
	            
	            <div class="col-md-8">
	              <label for="id_type_user" class="form-label">Type d'utilisateur :</label>
	              <select class="form-select" name="id_type_user">
			      	<c:forEach items="${listTypeUser }" var="typeUser">
			      		<option value="${typeUser.getId_type_user() }">
			      			<c:out value="${typeUser.getNom_type_user() }"></c:out>
			      		</option>
			      	</c:forEach>
			      </select>
	            </div>
	            
	          </div>
	
	          <hr class="col-md-8">
	
	          <button class="btn btn-success btn-lg-12" type="submit">Enregistrer</button>
	        </form>
	      </div>
     	</c:otherwise>
     	
     </c:choose>
      
    </main>
  </div>
</div>
	
	

    <script src="public/js/bootstrap.bundle.min.js"></script>
    <script src="public/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="public/js/js-template/sidebars.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/feather-icons@4.28.0/dist/feather.min.js" integrity="sha384-uO3SXW5IuS1ZpFPKugNNWqTZRRglnUJK6UAZ/gxOX80nxEkN9NcGZTftn6RzhGWE" crossorigin="anonymous"></script><script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js" integrity="sha384-zNy6FEbO50N+Cg5wap8IKA4M/ZnLJgzc6w2NqACZaK0u0FXfOWRRJOnQtpZun8ha" crossorigin="anonymous"></script><script src="public/js/js-template/dashboard.js"></script>
  	
  	<script type="text/javascript">
  	
  		const formUser = document.getElementById("formUser");
  		
  		formUser.onsubmit = function(){
  			alert("Utilisateur enregistré !!");
  		}
  	
  	</script>
  
  </body>
</html>
