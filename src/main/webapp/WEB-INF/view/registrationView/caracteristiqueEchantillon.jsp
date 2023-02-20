<form action="searchPatient" method="post">
	<div class="part-pathologie">
		<div class="row input-pathologie">
			<h4 style="text-decoration: underline;">Caractérisation de l'echantillon : </h4>
			
				<div class="col-lg-6">
					<h6>Pathologie</h6>
					<select class="form-select" name="id_pathologie">
						<c:forEach items="${listPathologie }" var="pathologie">
							<option value="${pathologie.getId_pathologie() }">${pathologie.getNom_pathologie() }</option>
						</c:forEach>
					</select>
				</div>
			
				<div class="col-lg-6 type-echantillon" id="type-echantillon">
					<h6>Type d'échantillon</h6>
					<select class="form-select" name="id_type_echantillon">
						
						<optgroup label="ULCERE DE BURILI">
							<c:forEach items="${listTypeEchantillonUlcereBuruli}" var="typeEchantillonUlcereBuruli">
								<option value="${typeEchantillonUlcereBuruli.getId_type_echantillon() }"> ${typeEchantillonUlcereBuruli.getNom_type_echantillon() } </option>
							</c:forEach>
						</optgroup>
						<optgroup label="MENINGITE ">
							<c:forEach items="${listTypeEchantillonMenin}" var="typeEchantillonMenin">
								<option value="${typeEchantillonMenin.getId_type_echantillon() }"> ${typeEchantillonMenin.getNom_type_echantillon() } </option>
							</c:forEach>
						</optgroup>
						<optgroup label="LEGIONELLA">
							<c:forEach items="${listTypeEchantillonLegio}" var="typeEchantillonLegio">
								<option value="${typeEchantillonLegio.getId_type_echantillon() }"> ${typeEchantillonLegio.getNom_type_echantillon() } </option>
							</c:forEach>
						</optgroup>
						<optgroup label="CHLAMYDIA">
							<c:forEach items="${listTypeEchantillonChla}" var="typeEchantillonChla">
								<option value="${typeEchantillonChla.getId_type_echantillon() }"> ${typeEchantillonChla.getNom_type_echantillon() } </option>
							</c:forEach>
						</optgroup>
					</select>
				</div>
				<c:choose>
				   	<c:when test="${checkPatient == true }">
						<div class="form-group col-lg-12" style="display:none;">
							<label for="id_patient">Identifiant du patient : </label>
							<input type="text"
								 class="form-control form-control-sm" name="id_patient" id="id_patient" readonly="readonly" value="${patient.getId_patient()}" aria-describedby="helpId" required="required" placeholder="">
						</div>
					</c:when>
					<c:otherwise>
						<div class="form-group col-lg-12" style="display:none;">
							<label for="id_patient">Identifiant du patient : </label>
							<input type="text"
								 class="form-control form-control-sm" name="id_patient" id="id_patient" aria-describedby="helpId" required="required" placeholder="">
						</div>
					</c:otherwise>
				</c:choose>
				
				<div class="form-group col-lg-6" style="display:none;">
					<label for="">Reception : </label>
					<input type="text"
						 class="form-control form-control-sm" name="id_reception" id="id_reception" readonly="readonly" value="${id_reception}" aria-describedby="helpId" placeholder="">
				</div>
				<!-- 
				<div class="form-group col-lg-6" style="display:none;">
					<label for="">Status : </label>
					<input type="text"
						 class="form-control form-control-sm" name="status_echantillon" id="status_echantillon" readonly="readonly" value="Receptionné" aria-describedby="helpId" placeholder="">
				</div>  -->
				<div class="form-group col-lg-6">
					<label for="volume_echantillon">Volume de l'echantillon (en ml) : </label>
			        <input type="number"
					        class="form-control form-control-sm" name="volume_echantillon" id="volume_echantillon" aria-describedby="helpId" placeholder="">
				</div>
				<div class="form-group col-lg-6">
					<label for="date_prelevement">Date de prelevement : </label>
			        <input type="date"
					        class="form-control form-control-sm" name="date_prelevement" id="date_prelevement"  aria-describedby="helpId" placeholder="">
				</div>
				
				<div class="form-group col-lg-6" style="margin-top: 15px;">
					<button type="submit" class="btn btn-success col-lg-6">Enregistrer</button>
				</div>
		</div>
		
	</div>
	
</form>

