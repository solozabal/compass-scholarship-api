# Compass Scholarship API

## Descrição
Este projeto é uma API RESTful desenvolvida com Spring Boot para gerenciar o registro de aulas do Compass Scholarship Program. A API permite a manipulação de dados relacionados a organizadores, alunos, aulas e squads.

## Estrutura do Projeto
A estrutura do projeto é organizada da seguinte forma:

```
compass-scholarship-api
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── compass
│   │   │           └── scholarship
│   │   │               ├── CompassScholarshipApiApplication.java
│   │   │               ├── controller
│   │   │               │   ├── OrganizerController.java
│   │   │               │   ├── StudentController.java
│   │   │               │   ├── LessonController.java
│   │   │               │   └── SquadController.java
│   │   │               ├── model
│   │   │               │   ├── Organizer.java
│   │   │               │   ├── Student.java
│   │   │               │   ├── Lesson.java
│   │   │               │   └── Squad.java
│   │   │               ├── repository
│   │   │               │   ├── OrganizerRepository.java
│   │   │               │   ├── StudentRepository.java
│   │   │               │   ├── LessonRepository.java
│   │   │               │   └── SquadRepository.java
│   │   │               ├── service
│   │   │               │   ├── OrganizerService.java
│   │   │               │   ├── StudentService.java
│   │   │               │   ├── LessonService.java
│   │   │               │   └── SquadService.java
│   │   │               └── exception
│   │   │                   └── ResourceNotFoundException.java
│   │   ├── resources
│   │   │   ├── application.properties
│   │   │   └── data.sql
│   ├── test
│       ├── java
│       │   └── com
│       │       └── compass
│       │           └── scholarship
│       │               ├── controller
│       │               │   ├── OrganizerControllerTest.java
│       │               │   ├── StudentControllerTest.java
│       │               │   ├── LessonControllerTest.java
│       │               │   └── SquadControllerTest.java
│       │               ├── service
│       │               │   ├── OrganizerServiceTest.java
│       │               │   ├── StudentServiceTest.java
│       │               │   ├── LessonServiceTest.java
│       │               │   └── SquadServiceTest.java
│       │               └── CompassScholarshipApiApplicationTests.java
├── pom.xml
└── README.md
```

## Tecnologias Utilizadas
- Java
- Spring Boot
- MySQL ou MongoDB (dependendo da configuração)
- Maven

## Instruções de Configuração
1. Clone o repositório.
2. Navegue até o diretório do projeto.
3. Configure o banco de dados no arquivo `src/main/resources/application.properties`.
4. Execute o comando `mvn spring-boot:run` para iniciar a aplicação.

## Endpoints
A API disponibiliza os seguintes endpoints:

- **Organizadores**
  - `GET /api/organizers`
  - `POST /api/organizers`
  - `PUT /api/organizers/{id}`
  - `DELETE /api/organizers/{id}`

- **Alunos**
  - `GET /api/students`
  - `POST /api/students`
  - `PUT /api/students/{id}`
  - `DELETE /api/students/{id}`

- **Aulas**
  - `GET /api/lessons`
  - `POST /api/lessons`
  - `PUT /api/lessons/{id}`
  - `DELETE /api/lessons/{id}`

- **Squads**
  - `GET /api/squads`
  - `POST /api/squads`
  - `PUT /api/squads/{id}`
  - `DELETE /api/squads/{id}`

## Testes
Os testes de unidade e integração estão localizados na pasta `src/test/java/com/compass/scholarship`. Execute os testes com o comando `mvn test`.

## Contribuição
Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou pull requests.