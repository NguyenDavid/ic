$(document).ready(function () {    
    $('#datepicker').datepicker({
        format: "MM/dd/yyyy"
    });  
});

function updateNbMaxPlayers(cpt){
//	var game = document.getElementById("idGame0");
//	alert(game.value);
	
	//Hearthstone, Starcraft 2, Fifa 15, Dota 2
	if(cpt == '2' || cpt == '3' || cpt == '5' || cpt == '6'){
		document.getElementById('twoPlayers').style.display = 'block';
		document.getElementById('sixPlayers').style.display = 'none';
		document.getElementById('tenPlayers').style.display = 'none';
	}
	
	//League of Legends (3vs3)
	else if(cpt == '0'){
		document.getElementById('twoPlayers').style.display = 'none';
		document.getElementById('sixPlayers').style.display = 'block';
		document.getElementById('tenPlayers').style.display = 'none';
	}
			
	//League of Legends (5vs5), Counter Strike
	else if(cpt == '1' || cpt == '4'){
		document.getElementById('twoPlayers').style.display = 'none';
		document.getElementById('sixPlayers').style.display = 'none';
		document.getElementById('tenPlayers').style.display = 'block';
	}
};

function updateEventGame(){
	var select = document.getElementById('selectGame');
	var gameName = select.options[select.selectedIndex].value;
	var hidden = document.getElementById('hiddenGameName');
	hidden.value = gameName;
	alert(hidden.value);
};