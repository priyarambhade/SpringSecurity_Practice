function validayion(){
	let email = $('#email').val();
	let mobileNumber = $('#email').val();
	var isValid = false;
	if(email != ''){
		$.ajax({
			url: ""+email,
			type:'GET',
			success: function(data){
				isValid = data;
				console.log("Is Valid-->"+isValid);
			},
			error:function(data){}
		});
	}else if(mobileNumber != ''){
		$.ajax({
			url: ""+email,
			type:'GET',
			success: function(data){
				isValid = data;
				console.log("Is Valid-->"+isValid);
			},
			error:function(data){}
		});
		return isValid;
	}
}