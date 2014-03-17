/**
 * prevent a custommer to checkout an empty cart
 */
$(document).ready(function() {
	check_panier(line_count);
});

function check_panier(line_count) {
	if(line_count <= 0) {
		$("#checkout").addClass("disabled");
	}
}