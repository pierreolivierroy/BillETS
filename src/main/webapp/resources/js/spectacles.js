$(document).ready(function() {

	console.log('Hello World!');

	$('input[name=spectacle_nom]').keyup(function() {	

		var nomSpectacle = this.value;
		
		if(nomSpectacle.length > 0){
			
			/*$.get( "/tp2/test", {spectacle_nom: nomSpectacle}).done( function( data ) {
				console.log(data);
			});*/
			
			//Retourne rien
			$.getJSON("/tp2/test", { spectacle_nom: nomSpectacle }).done(function(json) {
				console.log(json);
		    });		
		}
	});
});