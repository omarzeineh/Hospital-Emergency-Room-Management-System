package Hospital_G7;


public class Bed_G7 {
    
    int bedID;
    Patient_G7 patient;
    boolean occupied;
    boolean clean;

    public Bed_G7(int bedID) {
        this.bedID = bedID;
        this.occupied = false;
        this.clean = true;
    }
    
    public void cleanBed() {
        try{
            Thread.sleep(3000);
            System.out.println("Bed Has Been Cleaned");
            this.clean = true;
        }
        catch(InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void occupy(Patient_G7 patient) {
        this.patient = patient;
        this.occupied = true;
        this.clean = false;
    }
    
    public Patient_G7 unoccupy() {
        Patient_G7 temp = this.patient;
        this.patient = null;
        cleanBed();
        return temp;
    }

    public int getBedID() {
        return bedID;
    }

    public Patient_G7 getPatient() {
        return patient;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public boolean isClean() {
        return clean;
    }

    @Override
    public String toString() {
        return "[" + bedID + "," + patient + "," + occupied + "," + clean + ']';
    }
    
}
