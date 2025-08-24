# LocalStorage

**LocalStorage** es una aplicación web para la gestión de inventario, automatización de pedidos a proveedores y administración de pedidos de clientes. Está creada con arquitectura **hexagonal**, **Spring Boot** y **Spring Security**. El proyecto aún se encuentra en desarrollo y está pensado como una aplicación full stack.

---

## Diagrama UML

![Diagrama UML de LocalStorage](https://porfolio-dev-git-main-rignus-projects.vercel.app/projects/localStorageDB.png)

---

## Endpoints

### Administración de productos

#### Categoría

| **Method** | **Path**          | **Descripción**             | **Autenticación requerida** | **Disponible en UI** |
|------------|-------------------|-----------------------------|-----------------------------|-----------------------|
| GET        | `/category`       | Obtener todas las categorías |                             |✓                      |
| POST       | `/category`       | Crear nueva categoría        | ✓                           |✓                         |
| PUT        | `/category/{id}`  | Actualizar categoría         | ✓                           |                       |
| DELETE     | `/category/{id}`  | Eliminar categoría           | ✓                           |✓                          |

#### Productos

| **Method** | **Path**                   | **Descripción**               | **Autenticación requerida** | **Disponible en UI** |
|------------|----------------------------|-------------------------------|-----------------------------|-----------------------|
| GET        | `/product`                 | Obtener todos los productos   |                             |✓                          |
| GET        | `/product/{nameCategory}`  | Obtener productos por categoría |                             |                          |
| POST       | `/product`                 | Crear nuevo producto          | ✓                           |✓                          |
| PUT        | `/product/{id}`            | Actualizar producto           | ✓                           |                          |
| DELETE     | `/product/{id}`            | Eliminar producto             | ✓                           |✓                          |

---

### Administración de proveedores y pedidos

#### Proveedores (Suppliers)

| **Method** | **Path**        | **Descripción**         | **Autenticación requerida** | **Disponible en UI** |
|------------|-----------------|-------------------------|-----------------------------|-----------------------|
| GET        | `/supplier`     | Obtener todos los proveedores | ✓                            |✓                          |
| POST       | `/supplier`     | Crear nuevo proveedor   | ✓                           |✓                          |
| PUT        | `/supplier/{id}`| Actualizar proveedor    | ✓                           |                       |
| DELETE     | `/supplier/{id}`| Eliminar proveedor      | ✓                           |✓                          |

#### Órdenes de compra (Purchase Orders)

| **Method** | **Path**              | **Descripción**                       | **Autenticación requerida** | **Disponible en UI** |
|------------|-----------------------|---------------------------------------|-----------------------------|-----------------------|
| GET        | `/purchaseOrder`      | Obtener todas las órdenes de compra   | ✓                            |                       |
| POST       | `/purchaseOrder`      | Crear orden de compra                 | ✓                           |                       |
| PATCH      | `/purchaseOrder/{id}` | Actualizar estado de la orden de compra | ✓                           |                       |

---

### Administración de clientes y ventas

#### Clientes (Clients)

| **Method** | **Path**         | **Descripción**             | **Autenticación requerida** | **Disponible en UI** |
|------------|------------------|-----------------------------|-----------------------------|-----------------------|
| GET        | `/client`        | Obtener todos los clientes  | ✓                            |                       |
| POST       | `/client`        | Crear nuevo cliente         | ✓                           |                       |
| PUT        | `/client/{id}`   | Actualizar cliente          | ✓                           |                       |
| DELETE     | `/client/{id}`   | Eliminar cliente            | ✓                           |                       |

#### Ventas (Sales)

| **Method** | **Path**         | **Descripción**             | **Autenticación requerida** | **Disponible en UI** |
|------------|------------------|-----------------------------|-----------------------------|-----------------------|
| GET        | `/sales`         | Obtener todas las ventas    | ✓                            |                       |
| POST       | `/sales`         | Crear nueva venta           | ✓                           |                       |

---

### Usuarios

#### Usuarios (Users)

| **Method** | **Path**         | **Descripción**             | **Autenticación requerida** | **Disponible en UI** |
|------------|------------------|-----------------------------|-----------------------------|-----------------------|
| GET        | `/user`          | Obtener todos los usuarios  | ✓                            |                       |
| POST       | `/user`          | Crear nuevo usuario         | ✓                           |                       |
| PUT        | `/user/{id}`     | Actualizar usuario          | ✓                           |                       |
| DELETE     | `/user/{id}`     | Eliminar usuario            | ✓                           |                       |
