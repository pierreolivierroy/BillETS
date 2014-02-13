$(document).ready(function() {

	console.log('Hello World!');
	
	$('input[name=spectacle_nom]').keyup(function() {	

		var nomSpectacle = this.value;
		
		if(nomSpectacle.length > 0){
			
			/*$.get( "/tp2/test", {spectacle_nom: nomSpectacle}).done( function( data ) {
				console.log(data);
			});*/			

			$.getJSON("/tp2/chercherSpectacle", { spectacle_nom: nomSpectacle }).done(function(json) {
				console.log(json);
				console.log(json.length);
				//Checker le length du json pour éviter les doublons
				
		    });		
		}
	});
});