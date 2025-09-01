package Hospital_G7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class HospitalSystem_G7 {
    
    PriorityQueue<Patient_G7> patients;
    ArrayList<Doctor_G7> doctors;
    Stack<Bed_G7> beds;
    ArrayList<Bed_G7> usedBeds;
    int currentID;

    public HospitalSystem_G7(int nBeds) {
        patients = new PriorityQueue<>(new PatientComparator_G7());
        doctors = new ArrayList<>();
        usedBeds = new ArrayList<>();
        currentID = 1;
        beds = new Stack<>();
       
        if (nBeds < 50) {
            for(int i = 0; i <= nBeds; i++) {
            beds.push(new Bed_G7(i));
            }
        }
        else {
            for(int i = 0; i <= 50; i++) {
            beds.push(new Bed_G7(i));
            }
        }
    }

    public PriorityQueue<Patient_G7> getPatients() {
        return patients;
    }

    public void viewPatients() {
        ArrayList<Patient_G7> pat = new ArrayList<>(patients);
        System.out.println("\n---------------------------------------------------------");
        for (int i = 0; i < pat.size(); i++) {
            System.out.println("Patient #" + (i + 1) + ": ");
            System.out.println("---------------------------------------------------------");
            System.out.println("ID: " + pat.get(i).getID());
            System.out.println("Name: " + pat.get(i).getName());
            System.out.println("Severity: " + pat.get(i).getSeverity());
            System.out.println("Problem: " + pat.get(i).getProblem());
            System.out.println("Is the patient treated: " + pat.get(i).isTreated());
            System.out.println("Time logged: " + pat.get(i).getDate());
            System.out.println("---------------------------------------------------------");
        }
        System.out.println("");
    }

    public ArrayList<Doctor_G7> getDoctors() {
        return doctors;
    }

    public void viewDoctors() {
        System.out.println("\n---------------------------------------------------------");
        for (int i = 0; i < doctors.size(); i++) {
            System.out.println("Doctor #" + (i + 1) + ": ");
            System.out.println("---------------------------------------------------------");
            System.out.println("ID: " + doctors.get(i).getID());
            System.out.println("Name: " + doctors.get(i).getName());
            System.out.println("Specialization: " + doctors.get(i).getSpecialization());
            System.out.println("Available: " + doctors.get(i).isAvailable());
            System.out.println("Patient: " + doctors.get(i).getPatient());
            System.out.println("---------------------------------------------------------");
        }
        System.out.println("");
    }

    public ArrayList<Doctor_G7> getAvDoctors() {
        ArrayList<Doctor_G7> av = new ArrayList<>();
        for (int i = 0; i < doctors.size(); i++) {
            if (doctors.get(i).isAvailable()) {
                av.add(doctors.get(i));
            }
        }
        return av;
    }

    public void viewAvDoctors() {
        ArrayList<Doctor_G7> av = new ArrayList<>();
        for (int i = 0; i < doctors.size(); i++) {
            if (doctors.get(i).isAvailable()) {
                av.add(doctors.get(i));
            }
        }
        System.out.println("\n---------------------------------------------------------");
        for (int i = 0; i < av.size(); i++) {
            System.out.println("Doctor #" + (i + 1) + ": ");
            System.out.println("---------------------------------------------------------");
            System.out.println("ID: " + av.get(i).getID());
            System.out.println("Name: " + av.get(i).getName());
            System.out.println("Specialization: " + av.get(i).getSpecialization());
            System.out.println("Available: " + av.get(i).isAvailable());
            System.out.println("Patient: " + av.get(i).getPatient());
            System.out.println("---------------------------------------------------------");
        }
        System.out.println("");
    }

    public Stack<Bed_G7> getBeds() {
        return beds;
    }

    public void viewBeds() {
        System.out.println("\n---------------------------------------------------------");
        for (int i = 0; i < beds.size(); i++) {
            System.out.println("Available Bed #" + (i + 1) + ": ");
            System.out.println("ID: " + beds.get(i).getBedID());
        }
        System.out.println("---------------------------------------------------------\n");
    }

    public ArrayList<Bed_G7> getUsedBeds() {
        return usedBeds;
    }

    public void viewUsedBeds() {
        System.out.println("");
        for (int i = 0; i < usedBeds.size(); i++) {
            System.out.println("Occupied Bed #" + (i + 1) + ": ");
            System.out.println("---------------------------------------------------------");
            System.out.println("ID: " + usedBeds.get(i).getBedID());
            System.out.println("Patient: " + usedBeds.get(i).getPatient());
            System.out.println("---------------------------------------------------------");
        }
        System.out.println("");
    }
    
    public ArrayList<Patient_G7> getPatientsBeingTreated() {
        ArrayList<Patient_G7> pat = new ArrayList<>();
        for (int i = 0; i < usedBeds.size(); i++) {
            pat.add(usedBeds.get(i).getPatient());
        }
        return pat;
    }
    
    public void viewPatientsBeingTreated() {
        ArrayList<Patient_G7> pat = getPatientsBeingTreated();
        
        if(!pat.isEmpty()) {
        System.out.println("\n---------------------------------------------------------");
        for (int i = 0; i < pat.size(); i++) {
            System.out.println("Patient #" + (i + 1) + ": ");
            System.out.println("---------------------------------------------------------");
            System.out.println("ID: " + pat.get(i).getID());
            System.out.println("Name: " + pat.get(i).getName());
            System.out.println("Severity: " + pat.get(i).getSeverity());
            System.out.println("Problem: " + pat.get(i).getProblem());
            System.out.println("Is the patient treated: " + pat.get(i).isTreated());
            System.out.println("Time logged: " + pat.get(i).getDate());
            System.out.println("---------------------------------------------------------");
        }
        System.out.println("");
        }
    }

    public int getCurrentID() {
        return currentID;
    }
    
    
    public void logPatient(Patient_G7 patient) {
        ArrayList<Patient_G7> pat = new ArrayList<>(patients);
        patient.setID(this.currentID);
        pat.add(patient);
        Collections.sort(pat, new PatientComparator_G7());
        this.patients.clear();
        this.patients.addAll(pat);
        this.currentID++;
    }

    public void hireDoctor(Doctor_G7 doctor) {
        if (this.doctors.size() < 10) {
            if (this.doctors.size() < 10) {
                this.doctors.add(doctor);
            } else {
                System.out.println("Max number of doctors reached");
            }
        } else {
            System.out.println("There are already 10 doctors");
        }
    }

    public void updateID(int patID, int newID) {
        ArrayList<Patient_G7> pat = new ArrayList<>(this.patients);
        
        for(int i = 0; i < this.patients.size(); i++) {
            if(pat.get(i).getID() == newID) {
                if(pat.get(i).getID() == patID) {
                    System.out.println("Patient Already Has This ID");
                    return;
                }
                else {
                    System.out.println("Another Patient Is Using This ID");
                    return;
                }
            }
        }
        
        for(int i = 0; i < this.patients.size(); i++) {
            if(pat.get(i).getID() == patID) {
                pat.get(i).setID(newID);
                return;
            }
        }
        
        System.out.println("Patient Does Not Exist");
        
    }

    public void updateName(int patID, String newName) {
        ArrayList<Patient_G7> pat = new ArrayList<>(this.patients);
        for(int i = 0; i < this.patients.size(); i++) {
            if(pat.get(i).getID() == patID) {
                pat.get(i).setName(newName);
                return;
            }
        }
        System.out.println("Patient Does Not Exist");
    }

    public void updateAge(int patID, String newAge) {
        ArrayList<Patient_G7> pat = new ArrayList<>(this.patients);
        for(int i = 0; i < this.patients.size(); i++) {
            if(pat.get(i).getID() == patID) {
                pat.get(i).setAge(newAge);
                return;
            }
        }
        System.out.println("Patient Does Not Exist");
    }

    public void updateProblem(int patID, String newProblem) {
        ArrayList<Patient_G7> pat = new ArrayList<>(this.patients);
        for(int i = 0; i < this.patients.size(); i++) {
            if(pat.get(i).getID() == patID) {
                pat.get(i).setProblem(newProblem);
                return;
            }
        }
        System.out.println("Patient Does Not Exist");
    }

    public void updateSeverityLevel(int patID, String newSeverityLevel) {
        ArrayList<Patient_G7> pat = new ArrayList<>(this.patients);
        System.out.println(pat);
        for(int i = 0; i < this.patients.size(); i++) {
            if(pat.get(i).getID() == patID) {
                pat.get(i).setSeverityLevel(newSeverityLevel);
                Collections.sort(pat, new PatientComparator_G7());
                this.patients.clear();
                this.patients.addAll(pat);
                return;
            }
        }
        System.out.println("Patient Does Not Exist");
    }

    public void assignDoctorAndBed(int docID) {
        for(int i = 0; i < this.doctors.size(); i++) {
            if(doctors.get(i).getID() == docID) {
                if(doctors.get(i).isAvailable()) {
                    if(doctors.get(i).getSpecialization().equals(patients.peek().getProblem())) {
                        if(!beds.isEmpty()) {
                            Patient_G7 patient = patients.remove();
                            Bed_G7 bed = beds.pop();
                            bed.occupy(patient);
                            doctors.get(i).takePatient(patient);
                            usedBeds.add(bed);
                            System.out.println("Doctor and bed were assigned to " + patient + " sucessfuly");
                            return;
                        }
                        else {
                            System.out.println("There Are No Availbe Beds");
                            return;
                        }
                    }
                    else {
                        System.out.println("his Doctor does not have the specialization to treat the patient");
                        return;
                    }
                }
                else{
                    System.out.println("This Doctor Is Not Available");
                    return;
                }
            }
        }
        System.out.println("Doctor Does Not Exist");
    }
    
    public void dischargePatient(int patID) {
        patientDischarge_G7.discharge(this, patID);
        }
    
    public void addDoctorsFromFile() {
        File file = new File("DOCTORS.txt");
 
        try{
            Scanner input = new Scanner(file);
 
            while (input.hasNextLine() && this.doctors.size() < 10) {
                int id = input.nextInt();
                String name = input.next();
                String specialization = input.next();
                boolean available = input.nextBoolean();
                doctors.add(new Doctor_G7(id, name, specialization, available));
            }
            input.close();
        }
        catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void addPatientsFromFile() {
        File file = new File("PATIENTS.txt");
 
        try {
            Scanner input = new Scanner(file);
            while (input.hasNextLine()) {
                
                String name = input.next();
                String age = input.next();
                int severity= findSeverity(input.next());
                String problem = input.next();
                
                if(severity >= 0 && severity <= 4) {
                    patients.add(new Patient_G7(this.currentID, name, age, severity, problem));
                    this.currentID++;
                    ArrayList<Patient_G7> pat = new ArrayList<>(patients);
                    Collections.sort(pat, new PatientComparator_G7());
                    this.patients.clear();
                    this.patients.addAll(pat);
                }
            }
            input.close();
        }
        catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public int findSeverity(String severity) {
        if(severity.equals("Mild")) { return 0; }
        else if(severity.equals("Moderate")) { return 1; }
        else if(severity.equals("Severe")) { return 2; }
        else if(severity.equals("Critical")) { return 3; }
        else{ return 0; }
    }
    
    @Override
    public String toString() {
        return "[patients=" + patients + ", doctors=" + doctors + ", beds=" + beds + ", used beds=" + usedBeds + ", currentID=" + currentID + ']';
    }
}
    
