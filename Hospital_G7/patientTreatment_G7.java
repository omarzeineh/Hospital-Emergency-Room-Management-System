package Hospital_G7;


public class patientTreatment_G7 implements Runnable {

    Doctor_G7 doctor;

    public patientTreatment_G7(Doctor_G7 doctor) {
        this.doctor = doctor;
    }

    
    public static void treat(Doctor_G7 doctor) {
        Thread thr = new Thread(new patientTreatment_G7(doctor));
        thr.start();
    }
    
    @Override
    public void run() {
        try{
            Thread.sleep(6000);
            System.out.println(doctor.patient + "Has Been Treated");
            doctor.patient.setTreated(true);
        }
        catch(InterruptedException e) {
            System.out.println(e.getMessage());
        } 
    }
}
