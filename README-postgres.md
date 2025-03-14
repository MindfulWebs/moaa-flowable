# Despliegue de PostgreSQL para MOAA Platform

Este repositorio contiene los archivos necesarios para desplegar PostgreSQL en el proyecto MOAA Platform.

## Arquitectura del Sistema

El sistema Flowable consiste en tres componentes principales:

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

- `docker-compose-postgres.yml`: Configuración de los servicios Docker para PostgreSQL

## Requisitos previos

- Docker y Docker Compose instalados
- Acceso al repositorio Git

## Instrucciones de despliegue

### 1. Clonar el repositorio

```bash
git clone [URL_DEL_REPOSITORIO]
cd flowable
```

### 2. Iniciar los servicios

```bash
docker compose up -d
```

Este comando iniciará:
- **PostgreSQL Database** (puerto 5432)

### 3. Verificar la instalación

Conectar mediante un cliente SQL (pgAdmin, DBeaver) a la base de datos PostgreSQL:
- Host: localhost
- Puerto: 5432
- Usuario: flowable
- Contraseña: flowable
- Base de datos: flowable

- **Errores de conexión a la base de datos**: Verifica que PostgreSQL esté funcionando correctamente
  ```bash
  docker-compose logs postgres
  ```