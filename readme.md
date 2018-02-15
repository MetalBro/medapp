### Web-app on ZK + Spring

Technologies:  
- Maven  
- Tomcat
- Spring, Spring DataJPA  
- ZK Framework (+ Authorization)  
- HSQLDB (may be changed to PostgreSQL)

#### Description

The application is designed to display data on paid procedures of a medical institution. Procedure can be taken once a week.

2 types of Users:
- Regular (visitor). This user can only watch procedures and do not need authorization
- Admin. This user can create, update and delete procedures, must be authorized (for test login/pass = admin@gmail.com/admin)