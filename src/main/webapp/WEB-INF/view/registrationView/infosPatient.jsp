<div>
	<div class="row">
	
		<div class="form-group col-lg-4">
				<label for="">Numero reception : </label>
				<input type="text"
				class="form-control form-control-sm" name="" id="" readonly="readonly" value="${id_reception}" aria-describedby="helpId" placeholder="">
		</div>
		
		<form action="searchPatient" method="get">
			<h5 style="text-decoration: underline;">Patient : </h5>
			
			<div class="form-group col-lg-12">
				<label class="col-lg-12" for="">Verifier : </label>  
			   	<input class="" type="search" name="numeroSearch" placeholder="Telephone du patient" aria-label="Search">
		    </div>
		    
		    <c:if test="${checkPatient == false }">
			     <button class="btn-sm btn-secondary" type="button" data-toggle="modal" data-target="#modelI">Ajouter patient</button>
			     <em class="text-danger" style="font-weight: bold;">Ce numero n'est pas present dans la base de données</em>
	 	    </c:if>
		  </form>
	   
	   <c:choose>
		   	<c:when test="${checkPatient == true }">
		   		<div class="row input-patient-hidden">
			   		
			     	<div class="form-group col-lg-4">
				      <label for="">Identifiant du patient : </label>
				      <input type="text"
				        	 class="form-control form-control-sm" name="" id="" readonly="readonly" value="${patient.getId_patient()}" aria-describedby="helpId" placeholder="">
				    </div>
			     	<div class="form-group col-lg-4">
				      <label for="">Nom du patient : </label>
				      <input type="text"
				        class="form-control form-control-sm" name="" id="" readonly="readonly" value="${patient.getNom_patient() }" aria-describedby="helpId" placeholder="">
				    </div>
				    <div class="form-group col-lg-4">
				      <label for="">Prenom du patient : </label>
				      <input type="text"
				        class="form-control form-control-sm" name="" id="" readonly="readonly" value="${patient.getPrenom_patient() }" aria-describedby="helpId" placeholder="">
				    </div>
				    <div class="form-group col-lg-4">
				      <label for="">Contact du patient : </label>
				      <input type="text"
				        class="form-control form-control-sm" name="" id="" readonly="readonly" value="${patient.getContact_patient() }" aria-describedby="helpId" placeholder="">
				    </div>
				    <div class="form-group col-lg-4">
				      <label for="">Age du patient : </label>
				      <input type="text"
				        class="form-control form-control-sm" name="" id="" readonly="readonly" value="${patient.getAge_patient() }" aria-describedby="helpId" placeholder="">
				    </div>
				    <div class="form-group col-lg-4">
				      <label for="">Sexe : </label>
				      <input type="text"
				        class="form-control form-control-sm" readonly="readonly" name="" id="" value="${patient.getSexe_patient() }" aria-describedby="helpId" placeholder="">
				    </div>
			     </div>
		   	</c:when>
		   	
		   	<c:when test="${checkPatient == false }">
		   	</c:when>
	   </c:choose>
	</div>
</div>

<!-- Fentre modal pour afficher un formulaire d'ajout d'un nouveau patient -->

 <div class="modal fade" id="modelI" tabindex="-1" role="dialog" aria-labelledby="modelTitleId" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    	<h3 class="modal-title">Ajouter un nouveau patient</h3>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                </div>
                <div class="modal-body">
                    <div class="container">
                        <h5>Renseignez les informations</h5>
                        <form action="registrationPatient" method="post">
	                        <div class="form-group col-lg-4" style="display: none;">
								<label for="">Numero reception : </label>
								<input type="text"
								class="form-control form-control-sm" name="id_reception" id="id_reception" readonly="readonly" value="${id_reception}" aria-describedby="helpId" placeholder="">
							</div>
                            <div class="form-group row">
                                <label for="nom_patient" class="col-sm-1-12 col-form-label">Nom du patient : </label>
                                <div class="col-sm-1-12">
                                    <input type="text" class="form-control" name="nom_patient" id="nom_patient" placeholder="" required="required">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="prenom_patient" class="col-sm-1-12 col-form-label">Prenom du patient : </label>
                                <div class="col-sm-1-12">
                                    <input type="text" class="form-control" name="prenom_patient" id="prenom_patient" placeholder="" required="required">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="age_patient" class="col-sm-1-12 col-form-label">Age du patient : </label>
                                <div class="col-sm-1-12">
                                    <input type="number" class="form-control" name="age_patient" id="age_patient" placeholder="" required="required">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="contact_patient" class="col-sm-1-12 col-form-label">Numero de telephone du patient : </label>
                                <div class="col-sm-1-6">
                                    <input type="text" class="form-control" name="contact_patient" id="contact_patient" placeholder="" required="required">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="sexe_patient" class="col-sm-1-12 col-form-label">Sexe : </label>
                                <div class="col-sm-1-6">
                                    <select class="form-control" name="sexe_patient" required="required">
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