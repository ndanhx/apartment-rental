# Apartment Rental Website Project

## Overview

This project is a web application designed for apartment rental listings, developed by third-year university students. The platform facilitates connections between customers seeking rental properties and sellers who list their apartments. It features four distinct user roles—Customer, Seller, Moderator, and Admin—each with specific functionalities and responsibilities.

## Features

### User Roles

#### Customer
- Browse and search for available rental listings.
- Save favorite listings to a personal list. 

#### Seller
- Create and manage apartment listings efficiently.
- Update listing details and manage availability. 

#### Moderator
- Review and approve new listings to ensure quality.
- Monitor user activities and ensure compliance with community standards.
- Manage content and user interactions on the platform.

#### Admin
- Manage user accounts and define roles.
- Access and analyze statistics on revenue, views, and total listings.
- Oversee and optimize the overall functionality of the platform.

## Technology Stack

- **Frontend**: Angular 16
- **Backend**: Java with JDBC for database interactions
- **Payment Integration**: VNPAY Sandbox to simulate transaction scenarios

## Statistics & Analytics

The website provides comprehensive analytics to enhance decision-making and platform management, featuring:
- Revenue statistics to track financial performance.
- View counts for each listing to gauge interest and popularity.
- The total number of published listings to monitor growth and content volume.

## Project Setup and Installation

### Prerequisites

1. **Java Development Kit (JDK)**
   - Download and install **Java JDK 21** from [Oracle JDK](https://www.oracle.com/java/technologies/javase-downloads.html).

2. **Apache Tomcat**
   - Download and install **Tomcat 11.0.0** from [Tomcat Website](https://tomcat.apache.org/download-11.cgi).

3. **Node.js and NPM**
   - Download and install Node.js (which includes npm) from [Node.js Official Website](https://nodejs.org/).

### Backend Setup

1. **Clone the Backend Repository**
   - Clone or download the backend repository to your local machine.

2. **Build and Deploy**
   - Use Maven to package the project into a WAR file:
     ```bash
     mvn clean package
     ```
   - Deploy the WAR file to Tomcat by copying it to the `webapps` directory.

3. **Start Tomcat**
   - Start the Tomcat server and ensure it runs at:
     ```
     http://localhost:8080/apartment-backend-1.0-SNAPSHOT/
     ```

### Frontend Setup

1. **Clone the Frontend Repository**
   - Clone or download the frontend Angular project.

2. **Install Dependencies**
   - Navigate to the project directory and run:
     ```bash
     npm install
     ```

3. **Configure Backend API Link**
   - Update the backend API link in the Angular project to match:
     ```
     http://localhost:8080/apartment-backend-1.0-SNAPSHOT/
     ```

4. **Run the Angular Application**
   - Start the development server:
     ```bash
     npm start
     ```
   - Alternatively, use Angular CLI:
     ```bash
     ng serve
     ```
   - Access the application at:
     ```
     http://localhost:4200/
     ```

## Usage Instructions

- Access the frontend interface via `http://localhost:4200/`.
- Ensure the backend server is running and connected to a valid database.
- Use the platform to explore different user roles and features.

 
