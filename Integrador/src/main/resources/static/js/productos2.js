
$(document).ready(function() {

cargarProductos();
  $('#tablaProductos').DataTable();
});


async function cargarProductos(){


  const request = await fetch('api/productos', {
    method: 'GET',
    headers: getHeaders()
  });
     const productos = await request.json();
    let listadoHtml = '';
    for (let pro of productos){
        let btnElim ='<a href="#" onclick="eliminarProducto('+pro.id+')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i>';
        let prodHtml = '<tr><td>'+pro.id+'</td><td>'+pro.marca+'</td><td>'+pro.nombre +'</td><td>'+pro.descripcion +'</td><td>'+pro.categoria +'</td><td>'+pro.cantidad +'</td><td>'+btnElim+'</a><a href="#" class="btn btn-warning btn-circle btn-sm"><i class="fas fa-exclamation-triangle"></i></a></tr>';
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
  });
    location.reload();


}