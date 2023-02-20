<header class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
  <a class="navbar-brand col-md-3 col-lg-2 me-0 px-3" href="#" style="font-size: 22px;font-family: stencil">PFBM - IPCI</a>
  <button class="navbar-toggler position-absolute d-md-none collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#sidebarMenu" aria-controls="sidebarMenu" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  
  <div class="navbar-nav" style="display:none;">
    <div class="nav-item" style="display: flex;">
    	<a class="nav-link px-3"> ${nom_user } ${prenom_user }</a>
      <a class="nav-link px-3 text-danger" href="#">Déconnexion</a>
    </div>
  </div>
  
  <ul class="nav nav-pills">
  <li class="nav-item" style="display:none;">
    <a class="nav-link active" href="#">Active</a>
  </li>
  <li class="nav-item dropdown">
    <a class="nav-link dropdown-toggle text-light" data-toggle="dropdown" data-bs-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false" style="font-size: 19px;">Parametres <i style="font-size: 19px;" class="bi bi-gear"></i> </a>
    <div class="dropdown-menu" style="font-size: 15px;">
    
    <c:choose>
    	<c:when test="${type_user eq 'TU-2022-1' }">
    		<a class="dropdown-item" href="parametrepage">Modifier les parametres de PFBM</a>
    		<a class="dropdown-item" href="adduser">Ajouter un utilisateur</a>
		      <a class="dropdown-item" href="listepatients">Voir la liste des patients</a>
		      <a class="dropdown-item" href="listetransporteurs">Voir la liste des transporteurs</a>
		      <a class="dropdown-item" href="updateprofil">Modifier son profil</a>
		      <a class="dropdown-item" href="updatemdp">Changer son mot de passe</a>
		      <div class="dropdown-divider"></div>
		      <a class="dropdown-item text-primary" href="aboutpfbm">A propos de la Plateforme de Biologie Moléculaire</a>
    	</c:when>
    	<c:otherwise>
		      <a class="dropdown-item" href="updateprofil">Modifier son profil</a>
		      <a class="dropdown-item" href="updatemdp">Changer son mot de passe</a>
		      <div class="dropdown-divider"></div>
		      <a class="dropdown-item text-primary" href="aboutpfbm">A propos de la Plateforme de Biologie Moléculaire</a>
    	</c:otherwise>
    </c:choose>
    <!-- 
      <a class="dropdown-item" href="parametrepage">Modifier les parametres de PFBM</a>
      <a class="dropdown-item" href="listepatients">Voir la liste des patients</a>
      <a class="dropdown-item" href="listetransporteurs">Voir la liste des transporteurs</a>
      <a class="dropdown-item" href="updateprofil">Modifier son profil</a>
      <a class="dropdown-item" href="updatemdp">Changer son mot de passe</a>
      <div class="dropdown-divider"></div>
      <a class="dropdown-item text-primary" href="aboutpfbm">A propos de la Plateforme de Biologie Moléculaire</a>
       -->
    </div>
  </li>
  <li class="nav-item">
    <a class="nav-link text-light" href="#"><i class="bi bi-person" style="font-size:20px;"></i> <span style="font-size: 19px;">${nom_user } ${prenom_user }</span> </a>
  </li>
  <li class="nav-item">
    <a class="nav-link text-danger" href="deconnexion" style="font-size: 16px;font-weight: bold;">Deconnexion</a>
  </li>
</ul>
</header>