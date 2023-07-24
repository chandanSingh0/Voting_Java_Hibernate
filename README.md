# Console-based Java Project using Hibernate and MySQL
This console-based Java project demonstrates the use of Hibernate with MySQL to manage a simple Online Voting System. The application allows administrators to manage candidate profiles and voters to participate in elections by casting their votes securely.

<h3 align="center">Features</h3>
**Administrator Functionality:**
Login using predefined credentials.
Create, update, and delete candidate profiles.
View candidate information.
Log out from the administrator account.

**Voter Functionality:**
Register by providing personal information and verification.
Log in using registered credentials.
View upcoming elections and candidate profiles.
Cast votes securely and anonymously.
Receive confirmation and acknowledgment of the successfully cast vote.
View personal voting history.

<h3 align="center">Database Schema</h3>
The project uses Hibernate ORM for database interaction. The entity classes in com.example.model are automatically mapped to the corresponding MySQL tables.

<h3 align="center">Security</h3>
The application implements encryption and secure authentication for sensitive voter data.
Measures are taken to prevent multiple voting or any fraudulent activities, such as checking for duplicate votes or suspicious voting patterns.
