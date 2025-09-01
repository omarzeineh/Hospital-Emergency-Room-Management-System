package Hospital_G7;

import java.util.ArrayList;
import java.util.Scanner;

public class MBTemplate {

    public static void main(String[] args) {
        HospitalSystem_G7 hospital = new HospitalSystem_G7(30);
        int userChoice;
        do {
            displayMenu();
            userChoice = userMenuChoice();
            switch (userChoice) {
                case 1:
                    logPatientCheckIn(hospital);
                    break;  // 1- Log a new patient check-in.
                case 2:
                    updatePatientInfo(hospital);
                    break;  // 2- Update patient information.
                case 3:
                    hireADoctor(hospital);
                    break;
                case 4:
                    assignADoctorAndBed(hospital);
                    break;
                case 5:
                    dischargePatient(hospital);
                    break;
                case 6:
                    viewPatients(hospital);
                    break;
                case 7:
                    viewPatientsBTreated(hospital);
                    break;
                case 8:
                    viewDoctors(hospital);
                    break;
                case 9:
                    viewAvBeds(hospital);
                    break;
                case 10:
                    viewUsedBeds(hospital);
                    break;
                case 11:
                    patientsFile(hospital);
                    break;
                case 12:
                    doctorsFile(hospital);
                    break;
                default:
                    System.out.println("Thank you for using the Hospital ER Management System. Goodbye!");
            }
        } while (userChoice != 0);
    }

    public static void displayMenu() {
        System.out.println("---------------------------------------------------------");
        System.out.println("Hospital Emergency Room Management System");
        System.out.println("---------------------------------------------------------");
        System.out.println("1- Log a new patient check-in.");
        System.out.println("2- Update patient information.");
        System.out.println("3- Hire a doctor");
        System.out.println("4- Assign a doctor and bed to a patient.");
        System.out.println("5- Discharge a patient and free the bed.");
        System.out.println("6- View all patients in the queue sorted by severity.");
        System.out.println("7- View patients being treated.");
        System.out.println("8- View all doctors.");
        System.out.println("9- View all available beds.");
        System.out.println("10- View all used beds.");
        System.out.println("11- Add patients from file.");
        System.out.println("12- Add doctors from file.");
        System.out.println("0- Quit");
        System.out.println("---------------------------------------------------------");
    }

    public static int userMenuChoice() {
        Scanner input = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Your choice (0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11):");
            choice = input.nextInt();
        } while (choice > 12 || choice < 0);
        return choice;
    }

    public static void logPatientCheckIn(HospitalSystem_G7 hospital) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the patients name");
        String name = input.nextLine();
        System.out.println("Please enter the patients age");
        String age = input.next();
        int severity = 0;
        do {
            System.out.println("Please choose the patients severity: ");
            System.out.println("1 - Mild");
            System.out.println("2 - Moderate");
            System.out.println("3 - Severe");
            System.out.println("4 - Critical");
            severity = input.nextInt();
        } while (severity < 1 || severity > 4);
        int prob = 0;
        String problem = "";
        do {
            System.out.println("Please choose the patients problem: ");
            System.out.println("1 - Heart");
            System.out.println("2 - Muscle");
            System.out.println("3 - Bone");
            System.out.println("4 - Brain");
            System.out.println("5 - Skin");
            prob = input.nextInt();
        } while (prob < 1 || prob > 5);
        switch (prob) {
            case 1:
                problem = "Heart";
                break;
            case 2:
                problem = "Muscle";
                break;
            case 3:
                problem = "Bone";
                break;
            case 4:
                problem = "Brain";
                break;
            case 5:
                problem = "Skin";
                break;
            default:
                break;
        }
        hospital.logPatient(new Patient_G7(0, name, age, severity - 1, problem));
    }

    public static void updatePatientInfo(HospitalSystem_G7 hospital) {
        Scanner input = new Scanner(System.in);
        int updateOption = 0;
        do {
            System.out.println("Update Options:");
            System.out.println("1. Update ID");
            System.out.println("2. Update Name");
            System.out.println("3. Update Age");
            System.out.println("4. Update Problem");
            System.out.println("5. Update Severity Level");
            System.out.print("Choose an update option: ");
            updateOption = input.nextInt();
        } while (updateOption > 5 && updateOption < 1);
        hospital.viewPatients();
        System.out.print("Choose a patient to update: ");
        int patientID = input.nextInt();
        switch (updateOption) {
            case 1:
                System.out.print("Enter new ID: ");
                int newID = input.nextInt();
                hospital.updateID(patientID, newID);
                break;

            case 2:
                System.out.print("Enter new Name: ");
                String newName = input.nextLine();
                hospital.updateName(patientID, newName);
                break;

            case 3:
                System.out.print("Enter new Age: ");
                String newAge = input.nextLine();
                hospital.updateAge(patientID, newAge);
                break;

            case 4:
                int prob = 0;
                String problem = "";
                do {
                    System.out.println("choose the new problem: ");
                    System.out.println("1 - Heart");
                    System.out.println("2 - Muscle");
                    System.out.println("3 - Bone");
                    System.out.println("4 - Brain");
                    System.out.println("5 - Skin");
                    prob = input.nextInt();
                    if (prob < 1 || prob >= 5) {
                        System.out.println("Invalid problem.");
                    }
                } while (prob < 1 && prob >= 5);
                switch (prob) {
                    case 1:
                        problem = "Heart";
                        break;
                    case 2:
                        problem = "Muscle";
                        break;
                    case 3:
                        problem = "Bone";
                        break;
                    case 4:
                        problem = "Brain";
                        break;
                    case 5:
                        problem = "Skin";
                        break;
                    default:
                        break;
                }
                hospital.updateProblem(patientID, problem);
                break;

            case 5:
                int sev = 0;
                String severity = "";
                do {
                    System.out.println("Please choose the patients severity: ");
                    System.out.println("1 - Mild");
                    System.out.println("2 - Moderate");
                    System.out.println("3 - Severe");
                    System.out.println("4 - Critical");
                    sev = input.nextInt();
                    if (sev < 1 || sev > 4) {
                        System.out.println("Invalid Severity.");
                    }
                } while (sev < 1 && sev > 4);
                switch (sev) {
                    case 1:
                        severity = "Mild";
                        break;
                    case 2:
                        severity = "Moderate";
                        break;
                    case 3:
                        severity = "Severe";
                        break;
                    case 4:
                        severity = "Critical";
                        break;
                    default:
                        break;
                }
                hospital.updateSeverityLevel(patientID, severity);
                break;

            default:
                System.out.println("Invalid update option.");
                break;
        }

    }

    public static void hireADoctor(HospitalSystem_G7 hospital) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the Doctors name");
        String name = input.nextLine();
        System.out.println("Please enter the Doctors ID");
        int ID = input.nextInt();
        int prob = 0;
        String problem = "";
        do {
            System.out.println("Please choose the doctors specialiazation: ");
            System.out.println("1 - Heart");
            System.out.println("2 - Muscle");
            System.out.println("3 - Bone");
            System.out.println("4 - Brain");
            System.out.println("5 - Skin");
            prob = input.nextInt();
        } while (prob < 1 || prob > 5);
        switch (prob) {
            case 1:
                problem = "Heart";
                break;
            case 2:
                problem = "Muscle";
                break;
            case 3:
                problem = "Bone";
                break;
            case 4:
                problem = "Brain";
                break;
            case 5:
                problem = "Skin";
                break;
            default:
                break;
        }
        hospital.hireDoctor(new Doctor_G7(ID, name, problem, true));
    }

    public static void assignADoctorAndBed(HospitalSystem_G7 hospital) {
        ArrayList<Doctor_G7> av = hospital.getAvDoctors();

        System.out.println("Available Doctors: ");
        hospital.getAvDoctors();
        Patient_G7 pat = hospital.getPatients().peek();

        ArrayList<Doctor_G7> s = new ArrayList<>();
        for (int i = 0; i < av.size(); i++) {
            if (av.get(i).getSpecialization().equals(pat.getProblem())) {
                s.add(av.get(i));
            }
        }
        if (!s.isEmpty()) {
            System.out.println("---------------------------------------------------------");
            for (int i = 0; i < s.size(); i++) {
                System.out.println("Doctor #" + (i + 1) + ": ");
                System.out.println("---------------------------------------------------------");
                System.out.println("ID: " + s.get(i).getID());
                System.out.println("Name: " + s.get(i).getName());
                System.out.println("Specialization: " + s.get(i).getSpecialization());
                System.out.println("Available: " + s.get(i).isAvailable());
                System.out.println("Patient: " + s.get(i).getPatient());
                System.out.println("---------------------------------------------------------");
            }
            System.out.println("Enter the ID of the doctor you want for patient: " + pat);
            Scanner input = new Scanner(System.in);
            int ID = input.nextInt();
            hospital.assignDoctorAndBed(ID);
        } else {
            System.out.println("There are no doctors that can treat the patient " + pat + " right now");
        }
    }

    public static void dischargePatient(HospitalSystem_G7 hospital) {
        if (!hospital.getPatientsBeingTreated().isEmpty()) {
            hospital.viewPatientsBeingTreated();
            System.out.println("Enter ID of patient to be discharged: ");
            Scanner input = new Scanner(System.in);
            int ID = input.nextInt();
            hospital.dischargePatient(ID);
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            System.out.println("There are no patients to be discharge");
        }
    }

    public static void viewPatients(HospitalSystem_G7 hospital) {
        hospital.viewPatients();
    }
    
    public static void viewPatientsBTreated(HospitalSystem_G7 hospital) {
        hospital.viewPatientsBeingTreated();
    }

    public static void viewDoctors(HospitalSystem_G7 hospital) {
        hospital.viewDoctors();
    }

    public static void viewAvBeds(HospitalSystem_G7 hospital) {
        hospital.viewBeds();
    }

    public static void viewUsedBeds(HospitalSystem_G7 hospital) {
        hospital.viewUsedBeds();
    }

    public static void patientsFile(HospitalSystem_G7 hospital) {
        hospital.addPatientsFromFile();
    }

    public static void doctorsFile(HospitalSystem_G7 hospital) {
        hospital.addDoctorsFromFile();
    }
}
