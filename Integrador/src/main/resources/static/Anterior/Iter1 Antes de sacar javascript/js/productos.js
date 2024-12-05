$(document).ready(function() {
cargarProductos();
//window.location.href="http://localhost:8080/TEMPLATEVIEJO";
});

async function cargarProductos(){

  const request = await fetch('api/productos', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    //body: JSON.stringify({a: 1, b: 'Textual content'})
  });
  const productos = await request.json();

  //console.log(clientes);
let listadoHtml = '';
//alert(23);
for (let prod of productos){

 //let productoHtml = '<tr><td>'+cli.dni+'</td><td>'+cli.apellido +' '+cli.nombre +'</td><td>'+cli.fecha +'</td><td>'+cli.direccion +'</td><td>'+cli.email +'</td><td>'+cli.tel +'</td><td><a href="#" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a><a href="#" class="btn btn-warning btn-circle btn-sm"><i class="fas fa-exclamation-triangle"></i></a></tr>';
//let productoHtml = '<div class="product" ><div class="product-img"><img src="./img/product01.png" alt=""><div class="product-label"><span class="sale">-40%</span><span class="new">+15u</span></div></div><div class="product-body"><p class="product-category">Category</p><h3 class="product-name"><a href="#">product name goes here</a></h3><h4 class="product-price">$220.00 <del class="product-old-price">$110.00</del></h4><div class="product-rating"><!--<i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i>--></div><div class="product-btns"><button class="add-to-wishlist"><i class="fa fa-heart-o"></i><span class="tooltipp">add to wishlist</span></button><button class="add-to-compare"><i class="fa fa-exchange"></i><span class="tooltipp">add to compare</span></button><button class="quick-view"><i class="fa fa-eye"></i><span class="tooltipp">quick view</span></button></div><div class="add-to-cart"><button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i> add to cart</button></div>';
//let productoHtml ='<div class="product" ><div class="product-img"><img src="./img/product01.png" alt=""><div class="product-label"><span class="sale">-30%</span><span class="new">+10u</span></div></div><div class="product-body"><p class="product-category">Category</p><h3 class="product-name"><a href="#">product name goes here</a></h3><div class="product-btns"><button class="add-to-wishlist"><i class="fa fa-heart-o"></i><span class="tooltipp">add to wishlist</span></button><button class="add-to-compare"><i class="fa fa-exchange"></i><span class="tooltipp">add to compare</span></button> <button class="quick-view"><i class="fa fa-eye"></i><span class="tooltipp">quick view</span></button></div></div><div class="add-to-cart"><button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i> add to cart</button></div>';
//alert(prod.id);
let productoHtml ='<div class="product" ><div class="product-img"><img src="./img/product01.png" alt=""></div><div class="product-body"><p class="product-category">Alimentacion</p><h3 class="product-name"><a href="#">Arroz</a></h3><h4 class="product-price">$980.00 </h4></div><div class="add-to-cart"><button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i> Agregar carrito</button></div></div>';
listadoHtml += productoHtml;
}
//alert(111);
 //document.querySelector('#listaProductos').outerHTML=listadoHtml;

}