$(document).ready(function() 
{
	$('#operation').click(function() {
		$.ajax({
			url : 'calculate',
			type : 'POST',
			data : {
				expr : $('#result').val()
			},
			success : function(response) {
				$('#result').val(response);
			},
			error : function(status) {
				$('#result').val(status);
			}
		});
	});
});

function clr() {
    $('#result').val("");
}

function displayNumber(param) {
	$('#result').val($('#result').val()+param);
}