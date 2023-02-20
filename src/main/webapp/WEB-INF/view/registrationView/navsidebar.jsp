<c:choose>
   <c:when test="${type_user eq 'TU-2022-1' }">
        	
   
	<nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse"> <!-- NAVBAR for TypeUser = 'TU-2022-1' = 'Admin' -->
	      <div class="position-sticky pt-3">
	        <ul class="nav flex-column">
	        
	        
	          <li class="nav-item" style="font-size: 20px;">
	            <a class="nav-link active" aria-current="page" href="statistiquespathologies">
	              <i style="font-size: 27px;" class="bi bi-graph-up"></i>
	              <span style="font-size: 25px;">Tableau de bord</span>
	            </a>
	          </li>
	          
	          <!-- 
	          <li class="mb-1">
	          	<li><a href="tablereception" class="link-dark rounded">Liste des receptions</a></li>
	          </li>
	            -->
	          
	          <li class="mb-1">
		        <button style="display: none;" class="btn btn-toggle align-items-center rounded collapsed" data-bs-toggle="collapse" data-bs-target="#dashboard-collapse" aria-expanded="true">
		          Faire la reception
		        </button>
		        <div class="collapse show" id="dashboard-collapse" style="font-size:17px;">
		          <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
		          	<li><a href="tablereception" class="link-dark rounded">Liste des receptions</a></li>
		          	 
		          	<li><a href="tableechantillon" class="link-dark rounded">Liste de tous les échantillons</a></li>
		          	<!-- 
		            <li><a href="registrationechantillon" class="link-dark rounded">Receptionner un échantillon</a></li>
		            -->
		          </ul>
		        </div>
		      </li>
	          <li class="mb-1">
		        <button  style="display: none;" class="btn btn-toggle align-items-center rounded collapsed" data-bs-toggle="collapse" data-bs-target="#orders-collapse" aria-expanded="false">
		          Faire l'analyse
		        </button>
		        <div class="collapse show" id="orders-collapse" style="font-size:17px;">
		          <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
		           <!-- <li><a href="makeanalyse" class="link-dark rounded">Effectuer une analyse (A enlever) </a></li>  --> 
		            <li><a href="listeanalyse" class="link-dark rounded">Liste totale des analyses</a></li>
		            <!-- 
		            <li><a href="updateanalyse" class="link-dark rounded">Modifier une analyse</a></li>
		             -->
		          </ul>
		        </div>
		      </li>
		      
		       <li class="mb-1">
		        <button  style="display: none;" class="btn btn-toggle align-items-center rounded collapsed" data-bs-toggle="collapse" data-bs-target="#conservation-collapse" aria-expanded="false">
		          Faire la conservation
		        </button>
		        <div class="collapse show" id="conservation-collapse" style="font-size:17px;">
		          <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
		            <!-- <li><a href="makeemplacement" class="link-dark rounded">Ajouter un emplacement biobanque (A enlever) </a></li>  -->
		            <li><a href="listeEchantillonConservation" class="link-dark rounded">Liste des échantillons conservés ou non</a></li>
		            <!-- 
		            <li><a href="updateemplacement" class="link-dark rounded">Modifier un emplacement biobanque</a></li>
		             -->
		          </ul>
		        </div>
		      </li>
		      
		     </ul>
	<!-- 
	        <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
	          <span>Saved reports</span>
	          <a class="link-secondary" href="#" aria-label="Add a new report">
	            <span data-feather="plus-circle"></span>
	          </a>
	        </h6>
	        <ul class="nav flex-column mb-2">
	          <li class="mb-1">
		        <button class="btn btn-toggle align-items-center rounded collapsed" data-bs-toggle="collapse" data-bs-target="#account-collapse" aria-expanded="false">
		          Statistiques
		        </button>
		        <div class="collapse show" id="account-collapse">
		          <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
		            <li><a href="statistiquesreceptions" class="link-dark rounded">Statistiques des receptions</a></li>
		            <li><a href="statistiquespathologies" class="link-dark rounded">Statistiques des pathologies</a></li>
		            <li><a href="statistiquesechantillons" class="link-dark rounded">Statistiques sur les échantillons</a></li>
		          </ul>
		        </div>
		      </li>
	        </ul>
	         -->
	      </div>
	      
	    </nav>
    </c:when>
    
    
    <c:otherwise>
    
    	<nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">  <!-- NAVBAR for TypeUser = 'TU-2022-2' = 'Laborantin' -->
	      <div class="position-sticky pt-3">
	        <ul class="nav flex-column">
	        
	        
	          
	          
	          
	          <li class="mb-1">
		        <button class="btn btn-toggle align-items-center rounded collapsed" data-bs-toggle="collapse" data-bs-target="#dashboard-collapse" aria-expanded="true">
		          Faire la reception
		        </button>
		        <div class="collapse show" id="dashboard-collapse">
		          <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
		          	<li><a href="tablereception" class="link-dark rounded">Effectuer une reception</a></li>
		          	 
		          	<!--  <li><a href="tableechantillon" class="link-dark rounded">Liste de tous les échantillons</a></li> -->
		          	<!-- 
		            <li><a href="registrationechantillon" class="link-dark rounded">Receptionner un échantillon</a></li>
		            -->
		          </ul>
		        </div>
		      </li>
	          <li class="mb-1">
		        <button class="btn btn-toggle align-items-center rounded collapsed" data-bs-toggle="collapse" data-bs-target="#orders-collapse" aria-expanded="false">
		          Faire l'analyse
		        </button>
		        <div class="collapse show" id="orders-collapse">
		          <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
		            <li><a href="makeanalyse" class="link-dark rounded">Effectuer une analyse</a></li>
		            <!-- 
		            <li><a href="updateanalyse" class="link-dark rounded">Modifier une analyse</a></li>
		             -->
		          </ul>
		        </div>
		      </li>
		      
		       <li class="mb-1">
		        <button class="btn btn-toggle align-items-center rounded collapsed" data-bs-toggle="collapse" data-bs-target="#conservation-collapse" aria-expanded="false">
		          Faire la conservation
		        </button>
		        <div class="collapse show" id="conservation-collapse">
		          <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
		            <li><a href="makeemplacement" class="link-dark rounded">Ajouter un emplacement biobanque</a></li>
		            <!-- 
		            <li><a href="updateemplacement" class="link-dark rounded">Modifier un emplacement biobanque</a></li>
		             -->
		          </ul>
		        </div>
		      </li>
		      
		     </ul>
	<!-- 
	        <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
	          <span>Saved reports</span>
	          <a class="link-secondary" href="#" aria-label="Add a new report">
	            <span data-feather="plus-circle"></span>
	          </a>
	        </h6>
	        <ul class="nav flex-column mb-2">
	          <li class="mb-1">
		        <button class="btn btn-toggle align-items-center rounded collapsed" data-bs-toggle="collapse" data-bs-target="#account-collapse" aria-expanded="false">
		          Statistiques
		        </button>
		        <div class="collapse show" id="account-collapse">
		          <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
		            <li><a href="statistiquesreceptions" class="link-dark rounded">Statistiques des receptions</a></li>
		            <li><a href="statistiquespathologies" class="link-dark rounded">Statistiques des pathologies</a></li>
		            <li><a href="statistiquesechantillons" class="link-dark rounded">Statistiques sur les échantillons</a></li>
		          </ul>
		        </div>
		      </li>
	        </ul>
	         -->
	      </div>
	      
	    </nav>
    
    </c:otherwise>
    
</c:choose>