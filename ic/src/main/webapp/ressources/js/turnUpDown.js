function turnUpDown(){
		if(document.getElementById('createEvent').style.display == 'none'){
    		document.getElementById('createEvent').style.display = 'block';
    		document.getElementById('newEvent').style.display = 'none';
  		}
  		else {
    		document.getElementById('createEvent').style.display = 'none';
    		document.getElementById('newEvent').style.display = 'block';
		}
}

function turnUpDownInformations(){
	if(document.getElementById('informationsEvent').style.display == 'none'){
		document.getElementById('informationsEvent').style.display = 'block';
	}
	else {
		document.getElementById('informationsEvent').style.display = 'none';
	}
	
}