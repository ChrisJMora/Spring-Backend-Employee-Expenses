# Backend para Cálculo de Gastos por Departamento

Este proyecto es una API RESTful creada con **Spring Boot** para gestionar y calcular los gastos de los departamentos de una organización. Utiliza **PostgreSQL** como base de datos y **Vue.js** para la interfaz de usuario.

## Descripción

La API permite realizar las siguientes operaciones:

### Gestión de Gastos por Departamento
- Obtener el total de gastos por departamento en un rango de fechas.

## Arquitectura

El sistema sigue el patrón **Modelo-Vista-Controlador (MVC)**, con:
- **Backend**: Implementado en **Spring Boot** con controladores y modelos.
- **Base de Datos**: PostgreSQL.
- **Frontend**: Desarrollado en **Vue.js**.

## Instalación

### Prerrequisitos
- **Java 17+**
- **Maven**
- **PostgreSQL**

### Pasos de Instalación
1. Clona este repositorio:
    ```bash
    git clone <URL_DEL_REPOSITORIO>
    ```
2. Navega al directorio del proyecto:
    ```bash
    cd <NOMBRE_DEL_PROYECTO>
    ```
3. Configura la base de datos en el archivo `application.properties`:
    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/employee_expenses_db
    spring.datasource.username=<TU_USUARIO>
    spring.datasource.password=<TU_CONTRASEÑA>
    ```
4. Construye el proyecto con Maven:
    ```bash
    mvn clean install
    ```
5. Ejecuta la aplicación:
    ```bash
    mvn spring-boot:run
    ```

## Base de Datos

El sistema usa dos esquemas en PostgreSQL:
- **business** (gestiona los departamentos)
- **human_resources** (gestiona empleados y gastos)

### Estructura de Tablas

#### `business.departments`
| Campo             | Tipo           | Restricciones         |
|-------------------|---------------|-----------------------|
| department_id     | BIGSERIAL      | PRIMARY KEY          |
| department_name   | VARCHAR(100)   | NOT NULL, UNIQUE     |
| department_phone  | VARCHAR(15)    | Opcional             |
| department_email  | VARCHAR(100)   | Opcional, UNIQUE     |
| department_created_at | TIMESTAMP  | DEFAULT CURRENT_TIMESTAMP |

#### `human_resources.employees`
| Campo              | Tipo         | Restricciones               |
|--------------------|-------------|-----------------------------|
| employee_id        | BIGSERIAL    | PRIMARY KEY                 |
| department_id      | BIGSERIAL    | FOREIGN KEY (departments)   |
| employee_first_name | VARCHAR(255) | NOT NULL                    |
| employee_last_name  | VARCHAR(255) | NOT NULL                    |
| employee_email     | VARCHAR(100) | UNIQUE, Opcional            |
| employee_created_at | TIMESTAMP   | DEFAULT CURRENT_TIMESTAMP   |

#### `human_resources.expenses`
| Campo          | Tipo         | Restricciones                  |
|---------------|-------------|--------------------------------|
| expense_id    | BIGSERIAL    | PRIMARY KEY                    |
| employee_id   | BIGSERIAL    | FOREIGN KEY (employees)        |
| expense_amount | REAL       | NOT NULL, > 0                   |
| expense_type  | ENUM        | ('Alimentación', 'Alojamiento', 'Suministros') |
| expense_date  | DATE        | NOT NULL, ≤ CURRENT_DATE       |
| expense_created_at | TIMESTAMP | DEFAULT CURRENT_TIMESTAMP |

## Endpoints de la API

### Gastos por Departamento

| Método HTTP | Endpoint        | Descripción                                |
|--------------|----------------|--------------------------------------------|
| POST        | `/department/expenses` | Obtiene los gastos de los departamentos en un rango de fechas |

#### Ejemplo de Petición (JSON)
```json
{
    "startDate": "2025-01-01",
    "endDate": "2025-01-31"
}
```

## Seguridad

Este proyecto implementa **CORS** para permitir peticiones desde `https://demo-business-site.netlify.app/`. Para mayor seguridad, se recomienda autenticar las peticiones en un futuro.

