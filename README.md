# LocalStorage

**LocalStorage** es una aplicación web para la gestión de inventario, automatización de pedidos a proveedores y administración de pedidos de clientes. Está creada con arquitectura **hexagonal**, **Spring Boot** y **Spring Security**. El proyecto aún se encuentra en desarrollo y está pensado como una aplicación full stack.

---

## Endpoints

### Administración de productos

#### Categoría

| **Method** | **Path**            | **Descripción**                       | **Autenticación requerida** | **Disponible en UI** |
|------------|---------------------|---------------------------------------|-----------------------------|-----------------------|
| GET        | `/category`         | Obtener todas las categorías          |                             |                       |
| POST       | `/category`         | Crear nueva categoría                 | ✓                           |                      |
| PUT        | `/category/{id}`    | Actualizar categoría                  | ✓                           |                      |
| DELETE     | `/category/{id}`    | Eliminar categoría                    | ✓                           |                      |

#### Productos

| **Method** | **Path**                    | **Descripción**                          | **Autenticación requerida** | **Disponible en UI** |
|------------|-----------------------------|------------------------------------------|-----------------------------|-----------------------|
| GET        | `/product`                  | Obtener todos los productos              |                             |                       |
| GET        | `/product/{nameCategory}`   | Obtener productos por categoría          |                             |                       |
| POST       | `/product`                  | Crear nuevo producto                     | ✓                           |                      |
| PUT        | `/product/{id}`             | Actualizar producto                      | ✓                           |                      |
| DELETE     | `/product/{id}`             | Eliminar producto                        | ✓                           |                      |

---

### Administración de proveedores y pedidos


---
