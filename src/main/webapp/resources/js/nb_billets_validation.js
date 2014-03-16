/**
 * Valide le nombre de billets en vente pour le <select> (0 à 6)
 */
$(document).ready(function() {
		
	validerQuantiteBillets(quantite);	
});

function validerQuantiteBillets(billets) {
	
	var max = 6;
	
	$('.panel-body').empty();
	
	if(billets == 0) {
		$('.panel-body').append('<div class="alert alert-danger"><strong>Désolé!</strong> Il ne reste plus de billets pour cette représentation.</div>');
	}
	else {
		
		$('.panel-body').append('<p>Choisissez une quantité</p>');
		$('.panel-body').append('<select id="num_tickets_list" class="form-control spacer-bottom"></select>');
		
		if(billets >= max) {
			for(var i = 1; i <= max; i++) {
				$('#num_tickets_list').append(new Option(i, i));
			}
		}
		else if(0 < billets && billets < max){
			for(var i = 1; i <= billets; i++) {
				$('#num_tickets_list').append(new Option(i, i));
			}
		}
		$('.panel-body').append('<button data-toggle="modal" data-target="#myModal" type="button" class="btn btn-success btn-block"><span class="glyphicon glyphicon glyphicon-shopping-cart"></span> Ajouter au panier</button>');
	}		
}