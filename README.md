<p align='center'>
  <img width='250px' src='https://github.com/devicons/devicon/blob/master/icons/spring/spring-original.svg' alt='Spring Boot Logo'>
<p>
<h1 align="center"> Spring Boot API Rest Project </h1>

# Description
<p>
  This is a REST API project developed with Spring Boot that implements CRUD (Create, Read, Update, Delete) operations using Spring Data JPA for data persistence and MySQL as the database.
</p>

### The application provides a base structure for building RESTful web services with the following key features:
- Complete CRUD operations
- MySQL database connection
- REST controller implementation
- Entity management through JPA
- Dependency management with Maven

### Tecnhologies used:
- Spring Boot
- Spring Data JPA
- Spring Web
- MySQL
- Java 21+

# Project Setup
## Steps
### Clone the repository
```bash
git clone https://github.com/paulomantilla04/springboot-api-rest.git
cd springboot-api-rest
```
### Database configuration
1. Create a database in MySQL:
```sql
CREATE DATABASE football_api_db;
```
2. Configure credentials in `application.properties`
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/football_api_db
spring.datasource.username=your_username
spring.datasource.password=your_password
```

### Build and Run the Application
```bash
./mvnw clean install
./mvnw spring-boot:run
```

### API Endpoints
- `GET api/player/find/{id}` - List Player by ID 
- `GET api/club/findAll` - List all Players
- `POST api/player/save` - Create a new Player
- `PUT api/player/update/{id}` Update Player by ID
- `DELETE api/player/delete/{id}` Delete Player by ID

### POST Request Example
```json
{
	"name": "Jude Bellingham",
	"age": 21,
	"number": 5,
	"goals": 47,
	"assists": 57,
	"status": true,
	"club": {
		"id": 2
	}	
}
```

