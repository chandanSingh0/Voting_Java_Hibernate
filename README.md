# Console-based Java Project using Hibernate and MySQL
This console-based Java project demonstrates the use of Hibernate with MySQL to manage a simple Online Voting System. The application allows administrators to manage candidate profiles and voters to participate in elections by casting their votes securely.

<h2 align="left">Features</h3>
<h5 align="left">Administrator Functionality:</h5>
- Login using predefined credentials. <br> 
- Create, update, and delete candidate profiles. <br> 
- View candidate information. <br> 
- Log out from the administrator account. <br> 

<h5 align="left">Voter Functionality:</h5>
- Register by providing personal information and verification.
- Log in using registered credentials.
- View upcoming elections and candidate profiles.
- Cast votes securely and anonymously.
- Receive confirmation and acknowledgment of the successfully cast vote.
- View personal voting history.

<h2 align="left">Database Schema</h2>
- The project uses Hibernate ORM for database interaction. 
- The entity classes in com.example.model are automatically mapped to the corresponding MySQL tables.

<h2 align="left">Security</h2>
- The application implements encryption and secure authentication for sensitive voter data.
- Measures are taken to prevent multiple voting or any fraudulent activities, such as checking for duplicate votes or suspicious voting patterns.

<h2 align="left">Technologies Used</h2>
- Back-end: (programming language, e.g., Python, Java, etc.), (framework Spring .)
- Database: (database management system, e.g., MySQL, PostgreSQL, etc.)
