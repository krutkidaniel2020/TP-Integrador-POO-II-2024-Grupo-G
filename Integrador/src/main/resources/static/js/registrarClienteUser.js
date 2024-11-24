// Call the dataTables jQuery plugin
$(document).ready(function() {
// on ready
});

async function agregarCliente(){
alert("Entro cliente");
let datos ={};
datos.dni = document.getElementById('dni').value;
datos.apellido = document.getElementById('apellido').value;
datos.nombre = document.getElementById('nombre').value;
datos.fecha = document.getElementById('fecha').value;
datos.direccion = document.getElementById('direccion').value;
datos.email = document.getElementById('email').value;
datos.tel = document.getElementById('tel').value;

 const request = await fetch('api/clientes', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(datos)
  });

  const clientes = await request.json();




}
async function agregarUsuario(){
alert("Entro Usuario");
let datosUser ={};
datosUser.dni = document.getElementById('dni').value;
datosUser.pass = document.getElementById('pass').value;
datosUser.categoria = 'Cliente';
//let repPas = document.getElementById('pass1').value;
//if(repPas!= datosUser.pass){
//alert('Contraseñas distintas!');
//return;
//}

    const request1 = await fetch('api/usuarios', {
      method: 'POST',
     headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(datosUser)
    });
    const usuarios = await request1.json();
//location.reload();

}


