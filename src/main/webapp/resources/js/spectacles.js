$(document).ready(function() {
	
	console.log('Hello World!');

	$('input[name=spectacle_nom]').on('input', function() {	
		
		var nomSpectacle = this.value;
		
		if(nomSpectacle.length > 0) {
			filter(nomSpectacle);					
		}
	});
});

function filter(nomSpectacle){
	
	console.log("filter");
	
	/*$.get( "/tp2/test", {spectacle_nom: nomSpectacle}).done( function( data ) {
	console.log(data);
	});*/			

	$.getJSON(contextPath + "/chercherSpectacle", { spectacle_nom: nomSpectacle }).done(function(json) {
	
		console.log(json.length);
		//Checker le length du json pour �viter les doublons
		
		$('.media').hide();
		
		if(json.length > 0) {
			
			$.each(json, function(i, spectacle) {
				console.log(spectacle);
				console.log(spectacle['description']);
				
				$('.form-group').after(	'<div class="media"><a class="pull-left" href="#">'+
		    			'<img class="media-object" src="'+contextPath+'/resources/img/'+spectacle['imagePath']+'" alt="img_spectacle">'+
	    				'</a><div class="media-body"><h4 class="media-heading"><a href="001.html">'+spectacle['nom']+'</a></h4>'+
	    				'<p>'+spectacle['description']+'</p>'+
		  				'</div></div>');
			});
		}				
	});	//Fin AJAX
}