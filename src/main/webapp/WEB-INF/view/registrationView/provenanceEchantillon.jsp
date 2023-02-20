<div class="container part-provenance">
	<div class="row input-provenance">
	 		<h5>Transporteur</h5>
			 <form action="searchTransporteur" method="get">
			 	<div class="form-group col-lg-12">
				 	<label class="col-lg-12" for="numeroSearch">Verifier : </label>
			      	<input class="" type="search" name="numeroSearch" id="numeroSearch" placeholder="Telephone : 0011223344" aria-label="Search">
		            <br>
	            </div>
		     </form>
		     <c:if test="${checkTransporteur == false}">
		            <div>
			            <button type="button" class="btn-sm btn-secondary" data-toggle="modal" data-target="#modelId">Ajouter transporteur</button>
			            <em class="text-danger" style="font-weight: bold;">Numero de telephone pas present dans la base de donnée</em>
		            </div>
	         </c:if>
		     
		     <c:choose>
		     	<c:when test="${checkTransporteur == true }">
			     		<div class="row input-transporteur-hidden">
					     	<div class="form-group col-lg-6">
						      <label for="">Nom du transporteur</label>
						      <input type="text"
						        class="form-control form-control-sm" readonly="readonly" value="${transporteur.getNom_transporteur()}" name="nom_transporteur" id="" aria-describedby="helpId" placeholder="">
						    </div>
						    <div class="form-group col-lg-6">
						      <label for="">Prenom du transporteur</label>
						      <input type="text"
						        class="form-control form-control-sm" readonly="readonly" value="${transporteur.getPrenom_transporteur()}" name="prenom_transporteur" id="" aria-describedby="helpId" placeholder="">
						    </div>
						    <div class="form-group col-lg-12">
						      <label for="">Contact du transporteur</label>
						      <input type="text"
						        class="form-control form-control-sm" readonly="readonly" value="${transporteur.getContact_transporteur()}" name="contact_transporteur" id="contact_transporteur" aria-describedby="helpId" placeholder="">
						    </div>
					     </div>
		     	</c:when>
		     	
		     	<c:when test="${checkTransporteur == false }">
		     		
		     	</c:when>
		     </c:choose>
		     
	</div>

	<form action="searchTransporteur" method="post">
		<div class="row input-provenance">
		<h4>Origine de l'échantillon</h4>
				<div class="form-group col-lg-4" style="display:none;">
			      <label for="">Id transporteur : </label>
			      <input type="text"
			        class="form-control form-control-sm" name="id_transporteur" id="id_transporteur" value="${transporteur.getId_transporteur() }" aria-describedby="helpId" placeholder="">
			    </div>
				<div class="form-group col-lg-4">
			      <label for="">Provenance : </label>
			      <input type="text"
			        class="form-control form-control-sm" name="provenance" id="provenance" aria-describedby="helpId" placeholder="">
			    </div>
			    <div class="form-group col-lg-4">
			      <label for="">Nom glaciere : </label>
			      <input type="text"
			        class="form-control form-control-sm" name="nom_glaciere" id="nom_glaciere" aria-describedby="helpId" placeholder="">
			    </div>
			    <div class="form-group col-lg-4">
			      <label for="">Code glaciere : </label>
			      <input type="text"
			        class="form-control form-control-sm" name="code_glaciere" id="code_glaciere" aria-describedby="helpId" placeholder="">
			    </div>
			    <div class="form-group col-lg-6">
			      <label for="">Nombre d'échantillons : </label>
			      <input type="number"
			        class="form-control form-control-sm" name="nb_prelevement" id="nb_prelevement" aria-describedby="helpId" placeholder="">
			    </div>
			    <div class="form-group col-lg-6">
			      <label for="">Date de prelevement : </label>
			      <input type="date"
			        class="form-control form-control-sm" name="date_prelevement" id="date_prelevement" aria-describedby="helpId" placeholder="">
			    </div>
			    <div class="form-group col-lg-6">
			      <label for="">Temperature prelevement : </label>
			      <input type="number"
			        class="form-control form-control-sm" name="temperature_debut" id="temperature_debut" aria-describedby="helpId" placeholder="">
			    </div>
			    <div class="form-group col-lg-6">
			      <label for="">Temperature arrivée : </label>
			      <input type="number"
			        class="form-control form-control-sm" name="temperature_arrivee" id="temperature_arrivee" aria-describedby="helpId" placeholder="">
			    </div>
			    <div class="form-group col-lg-6" style="margin-top: 15px;">
					<button class="col-lg-6 btn btn-success">Enregistrer</button>
				</div>
		</div>
	</form>
	
	
</div>

<div class="modal fade" id="modelId" tabindex="-1" role="dialog" aria-labelledby="modelTitleId" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h3 class="modal-title">Ajouter un nouveau transporteur</h3>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                </div>
                <div class="modal-body">
                    <div class="container">
                        <h5>Renseignez les informations</h5>
                        <form action="registrationTransporteur" method="post">
                            <div class="form-group row">
                                <label for="nom_transporteur" class="col-sm-1-12 col-form-label">Nom du transporteur : </label>
                                <div class="col-sm-1-12">
                                    <input type="text" class="form-control" name="nom_transporteur" id="nom_transporteur" placeholder="">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="prenom_transporteur" class="col-sm-1-12 col-form-label">Prenom du transporteur : </label>
                                <div class="col-sm-1-12">
                                    <input type="text" class="form-control" name="prenom_transporteur" id="prenom_transporteur" placeholder="">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="contact_transporteur" class="col-sm-1-12 col-form-label">Numero de telephone : </label>
                                <div class="col-sm-1-12">
                                    <input type="text" class="form-control" name="contact_transporteur" id="contact_transporteur" placeholder="">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="sexe_transporteur" class="col-sm-1-12 col-form-label">Sexe : </label>
                                <div class="col-sm-1-12">
                                    <select class="form-control" name="sexe_transporteur">
                                        <option value="M">Masculin</option>
                                        <option value="F">Feminin</option>
                                    </select>
                                </div>
                            </div>
                            <div class="modal-footer">
			                    <button type="button" class="btn btn-danger" data-dismiss="modal">Fermer</button>
			                    <button type="submit" class="btn btn-primary">Enregistrer</button>
			                </div>
                        </form>
                    </div>
                </div>
                
            </div>
        </div>
    </div>