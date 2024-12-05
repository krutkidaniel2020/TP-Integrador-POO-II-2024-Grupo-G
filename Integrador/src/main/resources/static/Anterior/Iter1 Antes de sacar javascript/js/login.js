// Call the dataTables jQuery plugin
$(document).ready(function() {
// on ready
});

async function iniciarSesion(){
//if(document.getElementById('pass').value!= document.getElementById('pass1').value){
//alert('Contraseñas distintas!');
//return;
//}
let datos ={};
datos.dni = document.getElementById('dni').value;
datos.pass = document.getElementById('pass').value;


 const request = await fetch('api/login', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(datos)
  });
const respuesta = await request.text();
if (respuesta !='FAIL'){
localStorage.token = respuesta; //cargando valores al usuario
localStorage.dni = datos.dni;

window.location.href = 'index.html';
}else{
alert("Usuario o contraseña incorrectos! Intente de nuevo.");
}

  //const respuesta = await request.json();
//window.location.href = 'index.html';



}

