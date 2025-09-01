# Hospital Emergency Room Management System

## Overview
This project is a **Hospital Emergency Room Management System** implemented in Java as part of the CSC301 Data Structures and Algorithms course assignment.  
It applies Object-Oriented Programming (OOP) principles and uses **queues** and **stacks** to efficiently manage patients, doctors, and hospital beds.

The system simulates real-world ER operations by prioritizing patients, dynamically assigning doctors, and allocating beds using a LIFO strategy.

---

## Features
- **Patient Management**  
  - Log new patient check-ins (ID, name, age, severity).  
  - Update patient information (severity changes trigger reordering in the queue).  
  - View patients sorted by severity (Critical > Severe > Moderate > Mild).  

- **Doctor Management**  
  - Doctors have IDs, names, and specializations.  
  - Patients are assigned doctors based on specialization and availability.  
  - Doctors switch between busy and available states dynamically.  

- **Bed Management**  
  - Beds are allocated using a **stack (LIFO)** strategy.  
  - Recently cleaned/vacated beds are prioritized for assignment.  
  - Beds return to the available stack only after a "cleaning period".  

- **Discharge Workflow**  
  - Patients are discharged once treatment is completed.  
  - Beds are freed and re-added to the stack after cleaning.  

- **Error Handling**  
  - Predefined and custom exceptions (e.g., no available beds, invalid inputs).  

- **Extra Functionality**  
  - Flexible structure to add innovative features such as patient history tracking or waitlist systems.

---

## Technologies Used
- **Language:** Java  
- **Concepts:** OOP (Inheritance, Encapsulation, Abstraction)  
- **Data Structures:** Priority Queue, Stack, FIFO Queue  
- **Exception Handling:** Predefined and Custom Exceptions

---

## File Descriptions
- `HospitalSystem_G7.java` → Main driver program with menu-driven system.  
- `Patient_G7.java` → Defines patient details and severity.  
- `Doctor_G7.java` → Defines doctor details and specialization.  
- `Bed_G7.java` → Handles bed allocation and cleaning logic.  
- `PatientComparator_G7.java` → Custom comparator to sort patients by severity and arrival order.  
- `patientTreatment_G7.java` → Manages patient treatment workflow.  
- `patientDischarge_G7.java` → Handles patient discharge process.  
- `bedCleaning_G7.java` → Manages bed cleaning cycle before reallocation.  
- `MBTemplate.java` → Template base for menu-driven interface.  

---

## How to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/HospitalERSystem.git
   cd HospitalERSystem
   ```

2. Compile the Java files:
   ```bash
   javac *.java
   ```

3. Run the system:
   ```bash
   java HospitalSystem_G7
   ```

---

## Contributors
- Group 7 — CSC301 (Fall 2024)  
- Developed as part of **Assignment 2: Hospital Emergency Room Management System**.

---

## License
This project is for academic purposes only.
