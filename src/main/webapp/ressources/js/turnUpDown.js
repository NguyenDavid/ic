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

function turnUpDownInformations(cpt){
	var elements = document.getElementsByTagName('div');
	for (i = 0; i < elements.length; i++) {
		if(elements[i].className == 'informationsEvent' && elements[i].id == cpt){
			if(elements[i].style.display == 'none'){
				elements[i].style.display = 'block';
			}
			else {
				elements[i].style.display = 'none';
			}
		}
	}	
}