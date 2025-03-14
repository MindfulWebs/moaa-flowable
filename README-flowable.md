# Despliegue de Flowable para MOAA Platform

Este repositorio contiene los archivos necesarios para desplegar Flowable 7.1.0 en el proyecto MOAA Platform.

## Arquitectura del Sistema

El despliegue consiste en tres componentes principales:

1. **PostgreSQL Database**: Base de datos relacional que almacena todos los datos de procesos, tareas, históricos y configuración de Flowable.

2. **Flowable Engine**: Motor de procesos que ejecuta la lógica BPM, gestiona el ciclo de vida de los procesos y aplica las reglas de negocio.

3. **Flowable REST API**: Interfaz RESTful que permite interactuar con Flowable Engine, proporcionando endpoints para gestionar procesos, tareas, despliegues y más.

```
┌─────────────────┐     ┌───────────────────┐     ┌─────────────────┐
│                 │     │                   │     │                 │
│  Cliente HTTP   │───▶ │  Flowable REST    │───▶ │  Flowable       │
│  (Aplicación)   │     │  API (8080)       │     │  Engine         │
│                 │◀─── │                   │◀─── │                 │
└─────────────────┘     └───────────────────┘     └───────┬─────────┘
                                                          │
                                                          │
                                                  ┌───────▼────────┐
                                                  │                │
                                                  │  PostgreSQL    │
                                                  │  Database      │
                                                  │  (5432)        │
                                                  │                │
                                                  └────────────────┘
```

## Contenido

- `docker-compose.yml`: Configuración de los servicios Docker para Flowable y PostgreSQL
- `flowable-7.1.0/`: Contiene las librerías y WAR de Flowable

## Requisitos previos

- Docker y Docker Compose instalados
- Acceso al repositorio Git
- Java 17 o superior (para desarrollo local)

## Instrucciones de despliegue

### 1. Clonar el repositorio

```bash
git clone [URL_DEL_REPOSITORIO]
cd moaa-platform/flowable
```

### 2. Iniciar los servicios

```bash
docker-compose up -d
```

Este comando iniciará:
- **PostgreSQL Database** (puerto 5432)
- **Flowable Engine** + **Flowable REST API** (puerto 8080)

### 3. Verificar la instalación

Accede a la interfaz de Flowable REST API:
- URL: http://localhost:8080/flowable-rest/
- Credenciales por defecto: admin/test

### 4. Acceder a la documentación Swagger

Para explorar y probar los endpoints de la API REST de Flowable:
- URL: http://localhost:8080/flowable-rest/docs
- Esta interfaz permite visualizar todos los endpoints disponibles, sus parámetros y realizar pruebas directas.

## Componentes en detalle

### PostgreSQL Database
- Puerto: 5432
- Usuario: flowable
- Contraseña: flowable
- Base de datos: flowable
- Volumen persistente: postgres-data

### Flowable Engine
- Versión: 7.1.0
- Incluye soporte para BPMN, CMMN, DMN y Form Management
- Incorpora motores para Process, Case, Content y Decision Management

### Flowable REST API
- Puerto: 8080
- Acceso: http://localhost:8080/flowable-rest/
- Documentación Swagger: http://localhost:8080/flowable-rest/docs
- Autenticación Basic: admin/test

## Configuración personalizada

Si necesitas modificar la configuración:

1. Edita el archivo `docker-compose.yml` para cambiar puertos o variables de entorno
2. Las credenciales de base de datos están configuradas en el docker-compose.yml

## Solución de problemas

- **Error de conexión a la base de datos**: Verifica que PostgreSQL esté funcionando correctamente
  ```bash
  docker-compose logs postgres
  ```
  
- **Error al iniciar Flowable**: Consulta los logs con 
  ```bash
  docker-compose logs flowable-app
  ```

## Desarrollo local

Para desarrollo local sin Docker:
1. Configura una base de datos PostgreSQL
2. Despliega el WAR desde `flowable-7.1.0/wars/` en tu servidor Tomcat o similar

## APIs principales de Flowable

- **Process API**: Gestión de procesos de negocio
- **Task API**: Gestión de tareas y asignaciones
- **History API**: Consulta de históricos de procesos
- **Form API**: Gestión de formularios
- **DMN API**: Gestión de reglas de negocio

---

Para más información, consulta la [documentación oficial de Flowable](https://www.flowable.org/docs/).