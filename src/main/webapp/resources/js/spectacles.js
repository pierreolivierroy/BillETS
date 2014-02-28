$(document).ready(function() {
	
	console.log('Hello World!');

	$('input[name=spectacle_nom]').on('input', function() {	
		
		var nomSpectacle = this.value;
		
		recherche(nomSpectacle);					
	});
});

function recherche(nomSpectacle){
		
	$.getJSON(contextPath + "/chercherSpectacle", { spectacle_nom: nomSpectacle }).done(function(json) {			

		$('.media').hide();
		
		if(json.length > 0) {
						
			$.each(json, function(i, spectacle) {
				console.log(spectacle['artistes']);
				$('.form-group').after(	'<div class="media"><a class="pull-left" href="'+contextPath+'/spectacles/'+spectacle['id']+'">'+
    			'<img class="media-object" src="'+contextPath+'/resources/img/'+spectacle['thumbnailPath']+'" alt="img_spectacle">'+
				'</a><div class="media-body"><h4 class="media-heading"><a href="'+contextPath+'/spectacles/'+spectacle['id']+'">'+spectacle['nom']+'</a></h4>'+
				'<h5>'+spectacle['artistes']+'</h5>'+
				'<p>'+spectacle['description']+'</p>'+
  				'</div></div>');
			});
		}				
	});	//Fin AJAX
}