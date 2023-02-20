<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.84.0">
    <title>Connexion - Plateforme Biologie Moléculaire</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/sign-in/">

    

    <!-- Bootstrap core CSS -->
<link href="public/css/bootstrap.min.css" rel="stylesheet">

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
    <link href="public/css/css-template/signin.css" rel="stylesheet">
  </head>
  <body class="text-center" style="">
    
	<main class="form-signin">
	  <form action="connexionUser" method="post">
	    <img class="mb-4" src="public/img/logo.jpg" alt="" width="202" height="207" style="border:solid 1px black;">
	    <h3 class="text-light" style="text-decoration: underline;">Connexion Utilisateur</h3>
		
		<c:choose>
			<c:when test="${checkUser == false }">
				<div class="form-floating">
			      <input type="text" class="form-control" id="floatingInput" name="login_user" value="${login_user }" placeholder="name@example.com">
			      <label for="login_user">Login</label>
			    </div>
			</c:when>
			<c:otherwise>
				<div class="form-floating">
			      <input type="text" class="form-control" id="floatingInput" name="login_user" placeholder="name@example.com">
			      <label for="login_user">Login</label>
			    </div>
			</c:otherwise>
		</c:choose>
		
	    <div class="form-floating">
	      
	      <select class="form-select" name="id_type_user">
	      	<c:forEach items="${listTypeUser }" var="typeUser">
	      		<option value="${typeUser.getId_type_user() }">
	      			<c:out value="${typeUser.getNom_type_user() }"></c:out>
	      		</option>
	      	</c:forEach>
	      </select>
	      <label for="id_type_user">Type utilisateur</label>
	    </div>
	    
	    
	    <div class="form-floating">
	      <input type="password" class="form-control" id="floatingPassword" name="mdp_user" placeholder="Password">
	      <label for="mdp_user">Mot de passe</label>
	    </div>
	
	    
	    <button class="w-100 btn btn-lg btn-secondary" type="submit">Connexion</button>
	    <c:if test="${checkUser == false }">
	    	<span class="text-danger bg-dark">Le login ou le mot de passe est incorrect</span>
	    </c:if>
	  </form>
	</main>


    
  </body>
</html>
