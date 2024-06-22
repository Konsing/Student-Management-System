# Java Student Management System

A Java application to manage different types of students and compute their fees based on their specific criteria.

## Overview

This project defines various student types and calculates their respective fees. The system includes regular degree-seeking students, certificate students, and senior citizen students. Each student type has its own fee computation logic.

## Classes and Interfaces

1. **Student Interface**
   - `Student.java`
   - Defines the basic methods every student type must implement.
     - `int computeFees()`
     - `String getFullName()`
     - `void printData()`

2. **CertificateStudent Class**
   - `CertificateStudent.java`
   - Implements the `Student` interface for certificate students.
     - Fee calculation: Base fee of 700 plus 300 per credit.

3. **DegreeSeekingStudent Class**
   - `DegreeSeekingStudent.java`
   - Implements the `Student` interface for degree-seeking students.
     - Fee calculation: Base fee of 150 plus 275 per credit (up to 12 credits), with optional financial assistance deduction.

4. **SeniorCitizenStudent Class**
   - `SeniorCitizenStudent.java`
   - Implements the `Student` interface for senior citizen students.
     - Fee calculation: 100 for up to 6 credits, and 50 for each additional credit beyond 6.

5. **StudentFactory Class**
   - `StudentFactory.java`
   - Factory class to create different types of students based on input data.

6. **Report Class**
   - `Report.java`
   - Handles the generation of reports for the students.

## How to Use

1. **Clone the Repository**:
   ```sh
   git clone https://github.com/yourusername/Java-Student-Management-System.git
   cd Java-Student-Management-System
   ```

2. **Compile the Code**:
   ```sh
   javac -d bin src/hw2/*.java
   ```

3. **Run the Application**:
   ```sh
   java -cp bin hw2.Report
   ```

## Examples

### Creating a Certificate Student
```java
CertificateStudent student = new CertificateStudent("123", "John", "Doe", 3);
student.printData(); // Outputs: John Doe (Certificate student): 1600 fees assessed.
```

### Creating a Degree-Seeking Student
```java
DegreeSeekingStudent student = new DegreeSeekingStudent("456", "Jane", "Smith", 12, true, 500);
student.printData(); // Outputs: Jane Smith (Degree seeking student): 3300 fees assessed.
```

### Creating a Senior Citizen Student
```java
SeniorCitizenStudent student = new SeniorCitizenStudent("789", "Alice", "Brown", 8);
student.printData(); // Outputs: Alice Brown (Senior citizen): 200 fees assessed.
```

### Using the Student Factory
```java
String dataLine = "123;John;Doe;25;3;N;C";
Student student = StudentFactory.createStudent(dataLine);
student.printData(); // Outputs: John Doe (Certificate student): 1600 fees assessed.
```