// Call the dataTables jQuery plugin
$(document).ready(function() {
cargarClientes();
  $('#tablaClientes').DataTable();
});

async function cargarClientes(){

  const request = await fetch('clientes', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    //body: JSON.stringify({a: 1, b: 'Textual content'})
  });
  const clientes = await request.json();

  //console.log(clientes);
let listadoHtml = '';
for (let cli of clientes){

 let clienteHtml = '<tr><td>'+cli.dni+'</td><td>'+cli.apellido +' '+cli.nombre +'</td><td>'+cli.fecha +'</td><td>'+cli.direccion +'</td><td>'+cli.email +'</td><td>'+cli.tel +'</td><td><a href="#" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a><a href="#" class="btn btn-warning btn-circle btn-sm"><i class="fas fa-exclamation-triangle"></i></a></tr>';
listadoHtml += clienteHtml;
}

 document.querySelector('#tablaClientes tbody').outerHTML=listadoHtml;

}