jQuery(document).on("change", "select", function() {
	console.log(this);
	
	element = jQuery(this);
	
	switch(element.attr('name')) {
		
		case "address":
			value = element.find(":selected").val();
			console.log(value);
			break;
		case "street":
			
			break;
		case "city":
			
			break;
		case "country":
			
			break;
		default:
			
			break;
	}
})