# Spring Boot Web Tutorial

## Description
The **Spring Boot Web Tutorial** project is a simple web application demonstrating how to build a web-based project using **Spring Boot**. It includes essential concepts like controllers, views, and request handling, making it a great learning resource for beginners.

## Features
- **Spring MVC Architecture**: Uses controllers to handle web requests.
- **Thymeleaf Integration**: Provides dynamic HTML rendering.
- **Form Handling**: Demonstrates handling user input and form submissions.
- **RESTful APIs**: Exposes endpoints for basic CRUD operations.
- **Embedded Server**: Runs using an embedded **Tomcat server**.

## Tech Stack
- **Backend**: Spring Boot, Spring MVC
- **Template Engine**: Thymeleaf
- **Build Tool**: Maven
- **IDE**: IntelliJ IDEA
- **Version Control**: GitHub

## Project Structure
```
springbootwebtutorial/
│── src/
│   ├── main/java/com/example/webtutorial/
│   │   ├── controller/    # Controllers for handling requests
│   │   ├── service/       # Business logic layer
│   │   ├── repository/    # Data access layer (if applicable)
│   ├── main/resources/
│   │   ├── templates/     # Thymeleaf HTML templates
│   │   ├── static/        # CSS, JS, and image files
│   │   ├── application.properties  # Configuration settings
│── pom.xml  # Maven dependencies
│── README.md  # Project documentation
```

## Installation & Setup
1. **Clone the repository:**
   ```sh
   git clone https://github.com/VaishnaviRSawant/springbootwebtutorial.git
   ```
2. **Navigate to the project directory:**
   ```sh
   cd springbootwebtutorial
   ```
3. **Run the application:**
   ```sh
   mvn spring-boot:run
   ```
4. **Access the application in your browser:**
   ```
   http://localhost:8080
   ```

## API Endpoints (if applicable)
| Endpoint | Method | Description |
|----------|--------|-------------|
| `/` | GET | Home page |
| `/form` | GET | Display a form |
| `/submit` | POST | Handle form submission |

## Contributions
Feel free to contribute by creating issues or submitting pull requests!

## License
This project is **MIT Licensed**.

## Author
[Vaishnavi R Sawant](https://github.com/VaishnaviRSawant)

