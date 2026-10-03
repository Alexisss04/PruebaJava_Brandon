# Prueba Técnica - Gestión de Lectores y Blogs 

Aplicación web desarrollada con **Java Spring Boot** para cumplir con los requerimientos de la prueba técnica. El sistema gestiona una relación de muchos a muchos entre Lectores y Blogs, incluyendo seguridad, interfaz gráfica personalizada y un servicio web REST.

![Java](https://img.shields.io/badge/Java-JDK_27-blue?logo=java)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-6DB33F?logo=springboot)
![Oracle](https://img.shields.io/badge/Oracle_DB-21c-F80000?logo=oracle)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-UI-005F0F?logo=thymeleaf)
![Spring Security](https://img.shields.io/badge/Spring_Security-Auth-6DB33F?logo=springsecurity)

---

##  Características Principales e Implementación

Se ha cumplido con el 100% de los requerimientos solicitados:

1. **Base de Datos y Tablas:** Uso de JPA/Hibernate para generar la estructura relacional (`READERS`, `BLOGS`, `BLOGS_READERS`).
2. **Listas de Valores:** Implementación de selectores múltiples en la interfaz para gestionar la relación muchos a muchos.
3. **Interfaz Gráfica:** Plantillas Thymeleaf aplicando el diseño base ("EMPRESA XYZ") con menú de navegación.
4. **Secuencias Automáticas:** Manejo de IDs autoincrementales delegados a la base de datos mediante secuencias.
5. **Autenticación:** Login de usuario personalizado protegido y gestionado por Spring Security.
6. **Mantenimientos (CRUD):** Módulos completos para consultar, crear, editar y eliminar registros de las 3 tablas.
7. **Validaciones:** Uso de *Bean Validation* (Jakarta) para garantizar la integridad de los datos, con manejo de errores en formularios.
8. **Servicio Web REST:** Endpoint expuesto para consultas de datos, protegido mediante **Autenticación Básica (HTTP Basic Auth)**.
9. **Servidor y DataSource:** Despliegue en Tomcat embebido y conexión a base de datos externa configurada.

---

##  Tecnologías Utilizadas

* **Backend:** Java, Spring Boot (Web, Data JPA, Security).
* **Frontend:** HTML5, CSS3, Thymeleaf.
* **Base de Datos:** Oracle Database XE (Docker) 
* **Gestor de Dependencias:** Maven.

---

##  Configuración y Ejecución

### Requisitos Previos
* JDK instalado (Versión 17 o superior).
* Maven instalado.
* (Opcional) Docker Desktop en ejecución si se desea usar Oracle.

### Pasos para ejecutar localmente

1. **Clonar el repositorio:**
   ```bash
   git clone [https://github.com/Alexisss04/PruebaJava_Brandon.git](https://github.com/Alexisss04/PruebaJava_Brandon.git)
   cd PruebaJava_Brandon
   
---
## Configuración de Base de Datos
* Para inicializar la base de datos tenemos que ejecutar el siguiente comando:

docker run -d --name mi-oracle -p 1521:1521 -e ORACLE_PASSWORD=12345 gvenzl/oracle-xe:21-slim-faststart

Nota: La aplicación está configurada en application.properties para conectarse a esta instancia automáticamente en el puerto 1521.

## Ejecutar la Aplicacion
mvn spring-boot:run

## Accesos al sistema

* URL: http://localhost:8080
* Usuario: admin
* Contraseña: (la contraseña configurada en tu SecurityConfig)
---
## API Rest

* Endpoint: GET /api/blogs
* Autenticación: HTTP Basic Auth requerida.
* Ejemplo de petición (cURL): curl -u admin:password http://localhost:8080/api/blogs

Hecho por Brandon Cerritos