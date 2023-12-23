# Educational_Institute_Management
## Database Design and API Development for Educational Institution
### 1. Database Design:
- Created entities: Routine, Teacher, and Group.
- Along with necessary fields for each entity and establish relationships between the tables.
### 2. REST API for Routine Creation:
- Developed a REST API endpoint to save routine information in the database which accepts the following data in the request body:
- StartTime (LocalTime)
- EndTime (LocalTime)
- RoutineDate (LocalDate)
- TeacherID (Numeric)
- GroupID (Numeric)
- Ensuring data validation and error handling to store the routine record in the database.
### 3. REST API for Teacher Workload:
- Created a REST API endpoint that accepts a date range and a teacher's name as input parameters.
- Calculated the total allocated work hours for the specified teacher within the given date range.
- And the API responds with the total work hours as a numeric value.
- Implementing error handling for invalid inputs or data not found.
### 4. REST API for Group Workload:
- Developing another REST API endpoint to calculate the total work load of a specific group which accepts the GroupID as an input parameter.
- Calculated the total work hours for all routines associated with the specified group.
- And the API responds with the total work hours as a numeric value.
- Implementing appropriate error handling for invalid inputs or data not found.
#### Implemented unit tests
