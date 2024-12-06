# Trabajo en equipo
- Dp-Iteracion 2: Schiaffino Alejandro Thiago


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



# Backlog de iteraciones
| **ID**       | [HU01]                 |
|--------------|-------------------------|
| **Título**   | Metodo de envio           |
| **Como**     | Cliente                 |
| **Quiero**   | Seleccionar un metodo de envio |
| **Para**     | el producto que deseo comprar |

| **ID**       | [HU02]                 |
|--------------|-------------------------|
| **Título**   | Integración con metodos de pago           |
| **Como**     | Cliente                 |
| **Quiero**   | realizar pagos a través de plataformas en línea como PayPal o tarjetas de crédito |
| **Para**     | facilitar las transacciones |

| **ID**       | [HU03]                 |
|--------------|-------------------------|
| **Título**   | Hacer un pedido           |
| **Como**     | Cliente                 |
| **Quiero**   | Hacer un pedido |
| **Para**     | un producto que deseo comprar |

| **ID**       | [HU04]                 |
|--------------|-------------------------|
| **Título**   | Metodo de pago           |
| **Como**     | Usuario                 |
| **Quiero**   | Seleccionar un metodo de pago |
| **Para**     | el producto que deseo comprar |

| **ID**       | [HU05]                 |
|--------------|-------------------------|
| **Título**   | Reporte de ventas           |
| **Como**     | Administrador                 |
| **Quiero**   | generar reportes de ventas |
| **Para**     | analizar el desempeño del negocio |

| **ID**       | [HU06]                 |
|--------------|-------------------------|
| **Título**   | Gestión avanzada de usuarios           |
| **Como**     | Administrador                 |
| **Quiero**   | asignar roles a los usuarios |
| **Para**     | definir sus permisos en el sistema |