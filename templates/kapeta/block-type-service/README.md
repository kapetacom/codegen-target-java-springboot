#FILENAME:README.md:create-only
{{ai-type 'documentation'}}
# {{lowercase data.metadata.name}}

Kapeta block implemented using Language Target "Java Spring Boot".

{{#if data.metadata.description}}
## Description
{{data.metadata.description}}
{{/if}}

See the [kapeta.md](kapeta.md) readme file for more information.

## Prerequisites
- Docker installed and running
- Kapeta Desktop installed and running
- Java 21+

## Setup

To prepare / setup the service, run the following command:
```bash
mvn compile
```

## Running
To run the service, use the following commands:
```bash
mvn spring-boot:run
```
