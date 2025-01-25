# Hotel Management System (Wotif)

## Overview
The **Hotel Management System (Wotif)** is a robust backend application designed and developed to streamline hotel operations. Built using modern Java technologies, it focuses on performance, scalability, and security, offering modules such as OTP-based user registration, room management, feedback collection, and automated PDF invoice generation. The system is secured with Spring Security and JWT for authentication and integrates third-party APIs for email/SMS notifications.

## Features
### Core Functionalities
- **User Registration with OTP Verification**: Secure and seamless user onboarding using OTP-based authentication.
- **Room Management**: Efficient handling of room availability, booking, and status updates.
- **Feedback Management**: Collect and manage guest feedback to improve services.
- **Room Search**: Quick and optimized room search functionality using JPQL with joins.
- **PDF Invoice Generation**: Automated generation of invoices using ITEXTPDF.

### Security Features
- **Spring Security and JWT**: Secure the application with token-based authentication, ensuring session safety.
- **Third-party API Integration**: Email and SMS notifications for user activities.

### Performance Enhancements
- Optimized database queries using JPQL with joins, reducing query execution time by 20%.
- Advanced Java 8 features (Stream API, Optional) to write efficient, maintainable code.
- Utilization of Lombok and ModelMapper to reduce boilerplate code and improve productivity.

### Deployment
The application is deployed on AWS, leveraging cloud scalability and reliability for production use.

## Tech Stack
- **Programming Language**: Java 8
- **Framework**: Spring Boot
- **Database**: MySQL
- **ORM**: Hibernate JPA
- **Security**: Spring Security, JWT
- **PDF Generation**: ITEXTPDF
- **Tools & Libraries**: Maven, Lombok, ModelMapper
- **Cloud Provider**: AWS

## Project Architecture
1. **Controller Layer**: Manages HTTP requests and routes them to the appropriate services.
2. **Service Layer**: Contains the business logic for the application.
3. **Repository Layer**: Handles database interactions using Hibernate JPA.
4. **Security Layer**: Configures Spring Security and JWT for authentication and authorization.
5. **Utility Classes**: Includes tools for PDF generation, email/SMS notifications, and model mapping.

## Installation and Setup
### Prerequisites
- Java 8
- Maven
- MySQL Server

### Steps to Run the Application
1. Clone the repository:
   ```bash
   https://github.com/harshsinghcs/Hotel-Management-System-HMS-Wotif-.git
   ```
2. Navigate to the project directory:
   ```bash
   cd hms
   ```
3. Configure the `application.properties` file with your MySQL and AWS credentials.
4. Build the project:
   ```bash
   mvn clean install
   ```
5. Run the application:
   ```bash
   mvn spring-boot:run
   ```

## API Endpoints
### User Management
- **POST** `/api/users/register` - Register a new user with OTP verification.
- **POST** `/api/users/login` - Authenticate and retrieve a JWT token.

### Room Management
- **GET** `/api/rooms` - Retrieve a list of available rooms.
- **POST** `/api/rooms/book` - Book a room.

### Feedback
- **POST** `/api/feedback` - Submit guest feedback.

### Invoice
- **GET** `/api/invoice/{bookingId}` - Generate and download a PDF invoice.

## Contributions
Contributions are welcome! If you'd like to improve this project, feel free to fork the repository and submit a pull request.

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.

## Contact
For any inquiries or support, please contact:
- **Author**: Harsh Singh Lohiya
- **Email**: share.harshsingh@gmail.com
- **LinkedIn**: [Harsh Singh Lohiya](https://linkedin.com/in/mrharshsingh)

---
**Note**: This project is part of a backend development portfolio showcasing expertise in Java, Spring Boot, and backend systems development.
