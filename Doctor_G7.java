package Hospital_G7;

public class Doctor_G7 {
    
    int ID;
    String name;
    String specialization;
    boolean available;
    Patient_G7 patient;

    public Doctor_G7(int ID, String name, String specialization, boolean available) {
        this.ID = ID;
        this.name = name;
        this.specialization = specialization;
        this.available = available;
    }
    
    public Doctor_G7() {
    }
    
    public void takePatient(Patient_G7 patient) {
        if(this.available == true) {
            this.patient = patient;
            this.available = false;
            treatPatient();
            return;
        }
        System.out.println("Dr is not avialable");
    }
    
    public void treatPatient() {
        patientTreatment_G7.treat(this);
    }
    
    public Patient_G7 removePatient() {
            Patient_G7 temp = this.patient;
            this.patient = null;
            return temp;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public boolean isAvailable() {
        return available;
    }

    public Patient_G7 getPatient() {
        return patient;
    }

    
    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
    

    @Override
    public String toString() {
        return "[" + ID + "," + name + "," + specialization + "," + available + "," + patient + ']';
    }

}
