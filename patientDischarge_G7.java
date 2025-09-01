package Hospital_G7;



public class patientDischarge_G7 implements Runnable {
    HospitalSystem_G7 hospital;
    int patID;

    public patientDischarge_G7(HospitalSystem_G7 hospital, int patID) {
        this.hospital = hospital;
        this.patID = patID;
    }
    
    public static void discharge(HospitalSystem_G7 hospital, int patID) {
        Thread thr = new Thread(new patientDischarge_G7(hospital, patID));
        thr.start();
    }
    
    @Override
    public void run() {
        for (int i = 0; i < hospital.doctors.size(); i++) {
            if (hospital.doctors.get(i).getPatient() != null) {
                if (hospital.doctors.get(i).getPatient().getID() == patID) {
                    if (hospital.doctors.get(i).getPatient().isTreated()) {
                        Patient_G7 pat = hospital.doctors.get(i).removePatient();
                        System.out.println("Patient " + pat + " has been discharged");
                        for (int j = 0; j < hospital.usedBeds.size(); j++) {
                            if (hospital.usedBeds.get(j).getPatient().equals(pat)) {
                                hospital.usedBeds.get(j).unoccupy();
                                hospital.beds.push(hospital.usedBeds.get(j));
                                hospital.usedBeds.remove(j);
                                return;
                            }
                        }
                    }
                    else {
                    System.out.println("Patient has not been treated yet");
                    return;
                    }
                } 
            }
        }
        System.out.println("This patient does not exist");
    }
}
