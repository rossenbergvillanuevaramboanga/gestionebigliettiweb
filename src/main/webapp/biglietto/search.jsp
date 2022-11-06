<!doctype html>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="it.prova.gestionebigliettiweb.model.Biglietto"%>
<html lang="it" class="h-100" >
	 <head>
	 
	 	<!-- Common imports in pages -->
	 	<jsp:include page="../header.jsp" />
	   
	   <title>Ricerca Biglietto</title>
	 </head>
	   <body class="d-flex flex-column h-100">
	   
	   		<!-- Fixed navbar -->
	   		<jsp:include page="../navbar.jsp"></jsp:include>
	    
			
			<!-- Begin page content -->
			<main class="flex-shrink-0">
			  <div class="container">
			  
			  		<div class="alert alert-danger alert-dismissible fade show ${errorMessage==null?'d-none':'' }" role="alert">
					  ${errorMessage}
					  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
					</div>
					<div class="alert alert-danger alert-dismissible fade show d-none" role="alert">
					  Esempio di operazione fallita!
					  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
					</div>
					<div class="alert alert-info alert-dismissible fade show d-none" role="alert">
					  Aggiungere d-none nelle class per non far apparire
					   <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
					</div>
			  
			  <div class='card'>
				    <div class='card-header'>
				        <h5>Ricerca Biglietto</h5> 
				    </div>
				    <div class='card-body'>
		
		
							<form method="post" action="ExecuteSearchBigliettoServlet" class="row g-3" novalidate="novalidate">
							
								<div class="col-md-6">
									<label for="provenienza" class="form-label">Provenienza</label>
									<input type="text" name="provenienza" id="provenienza" class="form-control" placeholder="Inserire la provenienza"  >
								</div>
								
								<div class="col-md-6">
									<label for="destinazione" class="form-label">Destinazione</label>
									<input type="text" name="destinazione" id="destinazione" class="form-control" placeholder="Inserire la destinazione"  >
								</div>
							
								<div class="col-md-6">
									<label for="prezzo" class="form-label">Prezzo</label>
									<input type="number" class="form-control" name="prezzo" id="prezzo" placeholder="Inserire prezzo">
								</div>
								
								<div class="col-md-3">
									<label for="data" class="form-label">Data</label>
									<input class="form-control"  name="data" id="data" type="date" placeholder="dd/MM/yy" title="formato : gg/mm/aaaa">
								</div>
									
							<div class="col-12">
								<button type="submit" name="submit" value="submit" id="submit" class="btn btn-info">Conferma Ricerca</button>
								<a href="index.jsp" class='btn btn-outline-secondary' style='width:80px'>
					            	<i class='fa fa-chevron-left'></i> Back
					        	</a>
							</div>
		
						</form>
					<!-- end card-body -->			   
				    </div>
				<!-- end card -->
				</div>		
					  
			    
			  <!-- end container -->  
			  </div>
			  
			</main>
			
			<!-- Footer -->
			<jsp:include page="../footer.jsp" />
	  </body>
</html>