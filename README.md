# Bienvenu - Event Management System

[cite_start]"Bienvenu" is a comprehensive Event Management System (EMS) designed to streamline the process of organizing and attending events within educational institutions and local communities. [cite: 8, 10] [cite_start]This platform addresses the challenges of manual coordination, which often leads to missed schedules and low engagement, by providing a centralized solution for event creation, registration, and management. [cite: 9, 10]

## Business Case

[cite_start]In many educational and community settings, the management of workshops, webinars, and hackathons is handled manually or with inadequate tools. [cite: 8] [cite_start]This project, "Bienvenu," aims to solve these coordination problems by offering a robust platform for both event organizers and attendees, ultimately improving efficiency and engagement. [cite: 9, 10, 33]

## Target Audience

This system is designed for:
* [cite_start]**Students and Professionals:** Individuals looking to discover and sign up for events. [cite: 13]
* [cite_start]**Event Organizers:** Those who require a tool to manage event details and registrations. [cite: 14, 16]
* [cite_start]**Venue Property Managers:** Individuals who wish to promote their venues for events. [cite: 15]

## Proposed Solution

[cite_start]The proposed solution is a responsive web application with the following key features: [cite: 18]
* [cite_start]User registration and authentication for secure access. [cite: 19]
* [cite_start]Full CRUD (Create, Read, Update, Delete) functionality for events available to organizers. [cite: 20]
* [cite_start]A user-friendly interface for viewing, searching, and registering for events. [cite: 20]
* [cite_start]Automated notifications sent to users upon successful event registration. [cite: 20]
* [cite_start]A REST API with Swagger documentation for seamless integration. [cite: 21]

## Scope

### Core Functionalities (MVP)
* [cite_start]Secure user login and registration utilizing Spring Security. [cite: 24]
* [cite_start]CRUD operations for managing events. [cite: 25]
* [cite_start]Functionality for users to register for events. [cite: 26]
* [cite_start]RESTful APIs complete with Swagger documentation. [cite: 27]

### Optional Features (Post-MVP)
* [cite_start]Email notifications powered by JavaMail. [cite: 29]
* [cite_start]Advanced search and filtering capabilities by category or date. [cite: 30]
* [cite_start]Direct links to join events sent via email. [cite: 31]

## Project Justification

[cite_start]This project provides a practical solution to real-world event coordination challenges. [cite: 33] [cite_start]It also offers valuable hands-on experience for the development team in backend and frontend development, API creation, implementing Spring Security, and utilizing containerized deployment and testing methodologies. [cite: 34]

## Team & Task Distribution

* [cite_start]**Ayush Thakur:** EJB Container [cite: 36]
* [cite_start]**Manas Pandya:** Web Component [cite: 37]
* [cite_start]**Vivek Chalodiya:** Database Connection [cite: 38]

## System Architecture

### Class Diagram
The system is composed of four main entities:
* [cite_start]**User:** Contains user details such as ID, name, email, password, and role, along with methods for registration and login. [cite: 54, 55, 56, 57]
* [cite_start]**Event:** Holds all event-specific information including title, description, date, and capacity, with methods to create, edit, and delete events. [cite: 65, 67, 68, 69]
* **Registration:** Links users to events and contains registration details. [cite_start]It includes a method for registering a user to an event. [cite: 58, 59, 60]
* [cite_start]**Venue:** Stores information about the event location, including name and location, with a method to list venues. [cite: 70, 71, 72, 73]

### Sequence Diagram: User Registration
The sequence for a user registering for an event is as follows:
1.  [cite_start]The **User** selects and views an event through the **EventService**. [cite: 62, 63, 64]
2.  The user initiates the registration for a specific event. [cite_start]The request is sent to the **RegistrationService**. [cite: 77]
3.  [cite_start]The **RegistrationService** processes this request and calls the **Database** to insert the new registration record. [cite: 78]
4.  [cite_start]The **Database** confirms the successful insertion of data. [cite: 80]
5.  [cite_start]The system sends a notification back to the user to confirm their successful registration. [cite: 79]

## Testing

A comprehensive testing strategy is planned to ensure application stability and reliability.

### Functional Test Cases
* [cite_start]**TC-F01:** A user can successfully register for an event. [cite: 41]
* [cite_start]**TC-F02:** An admin can create a new event, and it appears in the event listings. [cite: 42]
* [cite_start]**TC-F03:** The system prevents registration for events that are in the past. [cite: 43]
* [cite_start]**TC-F04:** Only authenticated users are permitted to register for events. [cite: 44]
* [cite_start]**TC-F05:** The REST API correctly fetches and returns all events in JSON format. [cite: 45]

### Integration Test Cases
* [cite_start]**TC-101:** An end-to-end test confirms that a user registration is successfully saved in the database. [cite: 47]
* [cite_start]**TC-102:** When an admin deletes an event, it is no longer visible to users. [cite: 48]

### Boundary and Error Handling
* [cite_start]**TC-B01:** The system shows a "full" error when a user attempts to register for an event that has reached its capacity. [cite: 50]
* [cite_start]**TC-E01:** In case of a database failure during registration, the system handles the error gracefully. [cite: 52]
