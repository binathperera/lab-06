# Library Management System

A RESTful API for managing a library's book collection, built with Spring Boot and MongoDB.

## Description

This is a Spring Boot application that provides a complete backend solution for managing a library's book inventory. It offers RESTful endpoints for performing CRUD (Create, Read, Update, Delete) operations on books, along with additional features like filtering books by publication year and retrieving genre information.

## Features

- **Book Management**: Add, update, retrieve, and delete books
- **Search Capabilities**: 
  - Get all books in the library
  - Find books by ID
  - Filter books by publication year
  - Get genre information for specific books
- **Bulk Operations**: Delete all books from a specific publication year
- **MongoDB Integration**: Persistent storage using MongoDB Atlas
- **RESTful API**: Clean and intuitive REST endpoints

## Technology Stack

- **Java**: Version 21
- **Spring Boot**: Version 3.5.7
- **Spring Data MongoDB**: For database operations
- **MongoDB**: Cloud database (MongoDB Atlas)
- **Lombok**: To reduce boilerplate code
- **Maven**: Build and dependency management

## Prerequisites

Before running this application, ensure you have the following installed:

- Java Development Kit (JDK) 21 or higher
- Maven 3.6 or higher
- MongoDB Atlas account (or local MongoDB instance)

## Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/binathperera/lab-06.git
   cd lab-06
   ```

2. **Configure MongoDB connection**:
   
   Edit `src/main/resources/application.properties` and update the MongoDB URI with your credentials:
   ```properties
   spring.application.name=library
   spring.data.mongodb.uri=mongodb+srv://<username>:<password>@<cluster-url>/<database-name>?retryWrites=true&w=majority
   ```

3. **Build the project**:
   ```bash
   ./mvnw clean install
   ```

4. **Run the application**:
   ```bash
   ./mvnw spring-boot:run
   ```

   The application will start on `http://localhost:8080`

## API Endpoints

### Book Operations

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/books/` | Get all books |
| GET | `/api/books/{id}` | Get a book by ID |
| GET | `/api/books/year/{year}` | Get all books by publication year |
| GET | `/api/books/genre/{id}` | Get genre of a specific book |
| POST | `/api/books/add` | Add a new book |
| PUT | `/api/books/update/{id}` | Update an existing book |
| DELETE | `/api/books/delete/{id}` | Delete a book by ID |
| DELETE | `/api/books/delete/year/{year}` | Delete all books from a specific year |

### Example Requests

#### Add a New Book
```bash
curl -X POST http://localhost:8080/api/books/add \
  -H "Content-Type: application/json" \
  -d '{
    "title": "The Great Gatsby",
    "author": "F. Scott Fitzgerald",
    "genre": "Classic Fiction",
    "publicationYear": 1925,
    "shelfLocation": "A-12"
  }'
```

#### Get All Books
```bash
curl -X GET http://localhost:8080/api/books/
```

#### Get Books by Year
```bash
curl -X GET http://localhost:8080/api/books/year/1925
```

#### Update a Book
```bash
curl -X PUT http://localhost:8080/api/books/update/{id} \
  -H "Content-Type: application/json" \
  -d '{
    "title": "The Great Gatsby - Updated Edition",
    "author": "F. Scott Fitzgerald",
    "genre": "Classic Fiction",
    "publicationYear": 1925,
    "shelfLocation": "A-15"
  }'
```

#### Delete a Book
```bash
curl -X DELETE http://localhost:8080/api/books/delete/{id}
```

## Data Model

### Book
```java
{
  "id": "string",              // Auto-generated MongoDB ID
  "title": "string",           // Book title
  "author": "string",          // Author name
  "genre": "string",           // Book genre
  "publicationYear": integer,  // Year of publication
  "shelfLocation": "string"    // Physical location in library
}
```

## Project Structure

```
lab-06/
├── src/
│   ├── main/
│   │   ├── java/com/example/library/
│   │   │   ├── controller/
│   │   │   │   └── BookController.java      # REST endpoints
│   │   │   ├── model/
│   │   │   │   └── Book.java                # Book entity
│   │   │   ├── repository/
│   │   │   │   └── BookRepository.java      # MongoDB repository
│   │   │   ├── service/
│   │   │   │   ├── BookService.java         # Service interface
│   │   │   │   └── impl/
│   │   │   │       └── BookServiceImpl.java # Service implementation
│   │   │   └── LibraryApplication.java      # Main application class
│   │   └── resources/
│   │       └── application.properties        # Configuration file
│   └── test/
│       └── java/com/example/library/
│           └── LibraryApplicationTests.java  # Test cases
├── pom.xml                                    # Maven configuration
└── README.md                                  # This file
```

## Running Tests

Execute the test suite using Maven:

```bash
./mvnw test
```

## Configuration

Key configuration properties in `application.properties`:

- `spring.application.name`: Application name
- `spring.data.mongodb.uri`: MongoDB connection string

For additional configuration options, refer to the [Spring Boot documentation](https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html).

## Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## License

This project is created as a lab exercise for educational purposes.

## Author

- **Binath Perera** - [binathperera](https://github.com/binathperera)

## Acknowledgments

- Spring Boot documentation
- MongoDB documentation
- Spring Data MongoDB reference guide
