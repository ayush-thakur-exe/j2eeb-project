# Bienvenu - Event Management System

"Bienvenu" is a comprehensive Event Management System (EMS) designed to streamline the process of organising and attending events within educational institutions and local communities. This platform addresses the challenges of manual coordination, which often result in missed schedules and low engagement, by providing a centralised solution for event creation, registration, and management.

***

## Business Case

In many educational and community settings, the management of workshops, webinars, and hackathons is handled manually or with unstructured tools. This project, "Bienvenu," aims to address these coordination problems by providing a robust platform for both event organisers and attendees, ultimately enhancing efficiency and engagement.

***

## Target Audience

This system is designed for:
* Students and professionals who want to attend events.
* Event organisers who need a platform to manage registrations and details.
* Venue property managers who want to advertise their venues.
* Event organisations need a management tool.

***

## Proposed Solution

The proposed solution is a responsive web application with the following key features:
* User registration and authentication for secure access.
* Full CRUD (Create, Read, Update, Delete) functionality for events available to organizers.
* A user-friendly interface for viewing, searching, and registering for events.
* Automated notifications sent to users upon successful event registration.
* A REST API with Swagger documentation for seamless integration.

***

## Scope

### Core Functionalities (MVP)
* Secure user login and registration utilizing Spring Security.
* CRUD operations for managing events.
* Functionality for users to register for events.
* RESTful APIs complete with Swagger documentation.

### Optional Features (Phase 2 and 3)
* Email notifications powered by JavaMail.
* Advanced search and filtering capabilities by category or date.
* Direct links to join events sent via email.

***

## Project Justification

This project provides a practical solution to real-world event coordination challenges. It also offers valuable hands-on experience for the development team in backend and frontend development, API creation, implementing Spring Security, and utilizing containerized deployment and testing methodologies.

***

## Team & Task Distribution

| Team Member | Assigned Task |
| :--- | :--- |
| Ayush Thakur | EJB Container |
| Manas Pandya | Web Component |
| Vivek Chalodiya | Database connection |

***

## System Architecture

### Class Diagram
The system is composed of four main entities:
* **User:** Contains user details such as userId, name, email, password, and role, along with methods for registration and login.
* **Event:** Holds all event-specific information including eventId, title, description, date, and capacity, with methods to create, edit, and delete events.
* **Registration:** Links users to events and contains registrationId, userId, and eventId. It includes a method for registering a user to an event.
* **Venue:** Stores information about the event location, including venueId, name, and location, with a method to list venues.

### Sequence Diagram: User Registration
The sequence for a user registering for an event is as follows:
1.  The **User** selects and views an event through the **EventService**.
2.  The user initiates the registration for a specific event by calling `registerUser(userId, eventId)` through the **EventService** to the **RegistrationService**.
3.  The **RegistrationService** processes this request and calls the **Database** to insert the new registration record.
4.  The **Database** confirms the successful insertion of data.
5.  The system sends a notification back to the user to confirm their successful registration.

***

## Testing

A comprehensive testing strategy is planned to ensure application stability and reliability.

### Functional Test Cases
* **TC-F01:** A user can successfully register for an event.
* **TC-F02:** An admin can create a new event, and it appears in the event listings.
* **TC-F03:** The system prevents registration for events that are in the past.
* **TC-F04:** Only authenticated (logged-in) users are permitted to register for events.
* **TC-F05:** The REST API correctly fetches and returns all events in JSON format.

### Integration Test Cases
* **TC-101:** An end-to-end test confirms that a user registration is successfully saved in the database.
* **TC-102:** When an admin deletes an event, it is no longer visible to users.

### Boundary and Error Handling
* **TC-B01:** The system shows a "full" error when a user attempts to register for an event that has reached its capacity.
* **TC-E01:** In case of a database failure during registration, the system handles the error gracefully.
