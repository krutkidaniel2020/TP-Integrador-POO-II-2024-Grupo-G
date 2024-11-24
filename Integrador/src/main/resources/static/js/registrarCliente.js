// Call the dataTables jQuery plugin
$(document).ready(function() {
// on ready
});

async function agregarCliente(){
let datos ={};
//datos.id = '';
datos.dni = document.getElementById('dni').value;
datos.apellido = document.getElementById('apellido').value;
datos.nombre = document.getElementById('nombre').value;
datos.fecha = document.getElementById('fecha').value;
datos.direccion = document.getElementById('direccion').value;
datos.email = document.getElementById('email').value;
datos.tel = document.getElementById('tel').value;

let repDni = document.getElementById('repdni').value;
if(repDni!= datos.dni){
alert('Dni distintos');
return;
}
  const request = await fetch('api/clientes', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(datos)
  });
  const clientes = await request.json();
//location.reload();

}


