var xhr = getXMLHttp();
	
function getXMLHttp() {
	var xmlhttp = null;
	if(window.ActiveXObject){
	      try{
	           xmlhttp=new ActiveXObject("MsXml2.XMLHTTP");
	        }catch(e){

	           try{
	            xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	            }catch(e){}
	        }
	  }else{
	      xmlhttp=new XMLHttpRequest();
	  }
	  return xmlhttp;
}	

function displayNumber(param) {
    document.getElementById("result").value += param
}

function solveOperation() 
{
	xhr.open("POST","calculate");
	var x = document.getElementById("result").value;
	console.log(x);
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status==200){
			var response = xhr.responseText;
			document.getElementById("result").value = response;
		}
	}
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send("expr="+(x));
}

function clr() {
    document.getElementById("result").value = "";
}
