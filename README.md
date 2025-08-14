# Hotel Management System (Wotif) Clone

### Note: This project is a Wotif clone created solely for learning and educational purposes Only.

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

## 🚀 Tech Stack

- ![Java](https://img.shields.io/badge/Java%208-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)  
- ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)  
- ![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)  
- ![Hibernate](https://img.shields.io/badge/Hibernate%20JPA-59666C?style=for-the-badge&logo=hibernate&logoColor=white)  
- ![Spring Security](https://img.shields.io/badge/Spring%20Security-6DB33F?style=for-the-badge&logo=springsecurity&logoColor=white)  
- ![JWT](https://img.shields.io/badge/JWT-000000?style=for-the-badge&logo=jsonwebtokens&logoColor=white)  
- ![iTextPDF](https://img.shields.io/badge/iTextPDF-FF6F00?style=for-the-badge&logo=adobeacrobatreader&logoColor=white)  
- ![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)  
- ![Lombok](https://img.shields.io/badge/Lombok-CA4245?style=for-the-badge&logoColor=white)  
- ![ModelMapper](https://img.shields.io/badge/ModelMapper-007396?style=for-the-badge&logo=java&logoColor=white)  
- ![AWS](https://img.shields.io/badge/AWS-232F3E?style=for-the-badge&logo=amazonaws&logoColor=white)  

---

## 🏗 Project Architecture

1. **Controller Layer** → Manages HTTP requests and routes them to the appropriate services.  
2. **Service Layer** → Contains the business logic for the application.  
3. **Repository Layer** → Handles database interactions using Hibernate JPA.  
4. **Security Layer** → Configures Spring Security and JWT for authentication and authorization.  
5. **Utility Classes** → Includes tools for PDF generation, email/SMS notifications, and model mapping.  

---

## ⚙ Installation & Setup

### ✅ Prerequisites
- ![Java 8](https://img.shields.io/badge/Java%208-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
- ![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)
- ![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)


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

# Application Properties Configuration

To set up the application, create a file named `application.properties` in the `src/main/resources` directory with the following configuration:

```properties
spring.application.name=hms

# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/{your_database_name}
spring.datasource.username={your_mysql_username}
spring.datasource.password={your_mysql_password}
spring.jpa.hibernate.ddl-auto=update
#spring.jpa.show-sql=true

# JWT Configuration
jwt.algorithm.key={your_jwt_secret_key}
jwt.issuer={your_issuer_name}
jwt.expiry.duration={jwt_expiry_duration}
```

## Configuration Details

1. **Database Configuration**
   - Replace `{your_database_name}` with your MySQL database name
   - Replace `{your_mysql_username}` with your MySQL username
   - Replace `{your_mysql_password}` with your MySQL password
   - The `ddl-auto=update` setting automatically updates database schema

2. **JWT Configuration**
   - Replace `{your_jwt_secret_key}` with a secure secret key for JWT token signing
   - Replace `{your_issuer_name}` with your application's name or domain
   - Replace `{jwt_expiry_duration}` with the token expiry time (e.g., `86400000` for 24 hours)

## Example Configuration
```properties
spring.application.name=hms

spring.datasource.url=jdbc:mysql://localhost:3306/hotel_db
spring.datasource.username=root
spring.datasource.password=mypassword
spring.jpa.hibernate.ddl-auto=update
#spring.jpa.show-sql=true

jwt.algorithm.key=your-256-bit-secret
jwt.issuer=hotel-management-system
jwt.expiry.duration=86400000
```

> **Note**: Never commit your actual credentials to version control. Consider using environment variables or external configuration for sensitive data in production.

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
