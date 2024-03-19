# **Docker**

## Why do we need Docker?
- A complex microservice system will require diverse libraries, databases, OS, hardware infrastructure and these will have different version compatibilities, also overtime there will be version upgrades for these. This creates matrix hell.

## What can it do?
- Containerize applications.
- Run each service with its own dependencies in separate containers.

## Containers
- Isolated environments.

## Containers v/s Virtual Machines

## Containers v/s Image

## Docker commands
### `docker run`
### `docker ps`
- list containers
### `docker ps -a`
### `docker stop`
### `docker rm`
- Remove a container
### `docker images`
- List images.
### `docker rmi`
- Remove Images.
### `docker pull`
- Download an image.
### `docker images`
### `docker exec`
- Execute a command.
### `docker run -d`
- Run container in the background in detach mode.

## Docker environment variables

## How to create Docker image

## Dockerfile
- `FROM`
- `RUN`
- `COPY`
- `ENTRYPOINT` 

## Docker CMD v/s Entrypoint

## Docker Networking
- Bridge
- none
- host

## Docker Storage
- `var/lib/docker`
    - `images`
    - `containers`
- Layered architecture

## docker-compose

## Docker Registry

## Docker Engine

## Container Orchestration

## Docker swarm

### Kubernetes