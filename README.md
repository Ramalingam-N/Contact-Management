# Contact Management
Contact Management is a web application built using Spring Boot that allows users to manage their personal contacts. Each user can log in to their account and add, update, view, delete, and search for their contacts.

## Features
- __User Authentication:__ Secure login system for individual users.
- __Add Contacts:__ Users can add new contacts with details such as name, phone number, email, and address.
- __Update Contacts:__ Modify existing contact information.
- __View Contacts:__ View a list of all contacts added by the user.
- __Delete Contacts:__ Remove contacts from the list.
- __Search Contacts:__ Easily search for specific contacts by name or other details.
  
## Technologies Used
- __Backend:__ Spring Boot
- __Frontend:__ Thymeleaf, HTML, CSS
- __Database:__ MySql
- __Security:__ Spring Security for user authentication and authorization

  
## Installation
### 1. Clone the repository:
  - git clone -b master --single-branch  https://github.com/Ramalingam-N/Contact-Management.git
  - cd contact-management
### 2. Configure the Database:
  - Update the application.properties file located in src/main/resources with your database configuration.
  - Replace your username and password in the your-username and your-passoword(MYSQL).
  - Example configuration for MySQL:
1. spring.datasource.url=jdbc:mysql://localhost:3306/contact_management?allowPublicKeyRetrieval=true&useSSL=false&createDatabaseIfNotExist=true
2. spring.datasource.username=your-username
3. spring.datasource.password=your-password
4. spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
5. spring.jpa.hibernate.ddl-auto=update
6. spring.jpa.properties.hibernate.show_sql=true
7. spring.jpa.properties.hibernate.format_sql=true
8. logging.level.org.springframework.security=DEBUG


### 3. Build the project:
- mvn clean install
### 4.Run the application:
- mvn spring-boot:run
### 5.Access the application:
- Open your browser and navigate to http://localhost:8080.

  
## Usage
### Register and Login:
- Register as a new user or log in with your existing credentials.
### Manage Contacts:
- Use the dashboard to add new contacts, update existing ones, view all contacts, delete contacts, and search through your contacts list.
  

## Contributing
__Contributions are welcome! Please follow these steps to contribute:__

1. Fork the repository.
2. Create a new branch (git checkout -b feature-branch).
3. Make your changes.
4. Commit your changes (git commit -m 'Add some feature').
5. Push to the branch (git push origin feature-branch).
6. Open a pull request.

## Contact
For any questions or feedback, please contact ramalingamn4977@gmail.com.
