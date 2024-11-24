// Call the dataTables jQuery plugin
$(document).ready(function() {
cargarClientes();
  $('#tablaClientes').DataTable();
});

async function cargarClientes(){

  const request = await fetch('api/clientes', {
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
let tel = cli.tel == null ? '-' : cli.tel;

let btnElim ='<a href="#" onclick="eliminarCliente('+cli.id+')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i>';
 let clienteHtml = '<tr><td>'+cli.dni+'</td><td>'+cli.apellido +' '+cli.nombre +'</td><td>'+cli.fecha +'</td><td>'+cli.direccion +'</td><td>'+cli.email +'</td><td>'+tel +'</td><td>'+btnElim+'</a><a href="#" class="btn btn-warning btn-circle btn-sm"><i class="fas fa-exclamation-triangle"></i></a></tr>';
listadoHtml += clienteHtml;
}

 document.querySelector('#tablaClientes tbody').outerHTML=listadoHtml;

}

async function eliminarCliente(id){
alert("Eliminando usuario "+id);

if(!confirm('Desea eliminar el usuari0?')){
return;
}
 const request = await fetch('api/clientes/'+id, {
    method: 'DELETE',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    //body: JSON.stringify({a: 1, b: 'Textual content'})
  });
location.reload();


}