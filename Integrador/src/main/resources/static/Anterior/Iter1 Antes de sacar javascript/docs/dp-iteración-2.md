# Trabajo en equipo



# Diseño OO



# Wireframe y caso de uso
## UC-11 - Registrar Pedido
**Descripción**: El cliente selecciona productos para realizar un pedido.  
**Actor(es)**: Cliente  

**Precondición**:  
- Ninguna.  

**Postcondición**:  
- Se registra el pedido en el sistema.  

**Flujo Principal**:  
1. El cliente accede a los productos.  
2. Selecciona uno o varios productos indicando la cantidad.  
3. Selecciona el método de pago.  
4. Confirma el pedido.  

**Extensiones**:  
- Se verifica el control de stock emitiendo un error en caso de inventario insuficiente.  
- Se redirige al método de pago.  

---



## UC-12 - Seleccionar Método de Pago
**Descripción**: El cliente selecciona el método de pago al confirmar el pedido.  
**Actor(es)**: Cliente  

**Precondición**:  
- Ninguna.  

**Postcondición**:  
- Se registra el pago en el sistema.  

**Flujo Principal**:  
1. El cliente selecciona el método de pago: efectivo, tarjeta o cheque.  
2. El sistema solicita los datos de la tarjeta o emite un volante de pago en caso de seleccionar efectivo o cheque.  
3. El sistema confirma el pago.  

**Extensiones**:  
- Se verifica si la tarjeta tiene fondos.  
- Se redirige a la descripción de la compra realizada.  

---



## UC-13 - Realizar Descuento
**Descripción**: Se realiza un descuento al total del pedido.  
**Actor(es)**: Cliente  

**Precondición**:  
- Ninguna.  

**Postcondición**:  
- Se actualiza el precio total.  

**Flujo Principal**:  
1. El cliente selecciona descuento.  
2. El cliente introduce el código de descuento.  
3. El sistema valida el código introducido.  
4. El sistema aplica el descuento y actualiza el precio total.  

**Extensiones**:  
- Ninguna.  

--- 