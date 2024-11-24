// Call the dataTables jQuery plugin
$(document).ready(function() {

//alert(localStorage.token);
cargarProductos();
  $('#tablaProductos').DataTable();
});


async function cargarProductos(){
    //if (localStorage.dni === null && localStorage.dni.length=== 0){
    //window.location.href = 'login.html';
    //};



  const request = await fetch('api/productos', {
    method: 'GET',
    headers: getHeaders()
    //body: JSON.stringify({a: 1, b: 'Textual content'})
  });
  const productos = await request.json();
  //if (productos.length === 0) {
   //  alert("aa");

  //}

  //console.log(clientes);
let listadoHtml = '';
for (let pro of productos){
//let tel = cli.tel == null ? '-' : cli.tel;

let btnElim ='<a href="#" onclick="eliminarProducto('+pro.id+')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i>';
 let prodHtml = '<tr><td>'+pro.id+'</td><td></td><td>'+pro.nombre +'</td><td>'+pro.descripcion +'</td><td>'+pro.categoria +'</td><td>'+pro.cantidad +'</td><td>'+btnElim+'</a><a href="#" class="btn btn-warning btn-circle btn-sm"><i class="fas fa-exclamation-triangle"></i></a></tr>';
listadoHtml += prodHtml;
}

 document.querySelector('#tablaProductos tbody').outerHTML=listadoHtml;

}

function getHeaders(){
return {
             'Accept': 'application/json',
             'Content-Type': 'application/json',
             'Authorization':localStorage.token
           };
}


async function eliminarProducto(id){


if(!confirm('Desea eliminar el producto '+id+'?')){
return;
}
 const request = await fetch('api/productos/'+id, {
    method: 'DELETE',
    headers: getHeaders()
    //body: JSON.stringify({a: 1, b: 'Textual content'})
  });
location.reload();


}