package Hospital_G7;

import java.util.Comparator;

public class PatientComparator_G7 implements Comparator<Patient_G7> {
    @Override
    public int compare(Patient_G7 p1, Patient_G7 p2) {
        if(p1.getSeverityLevel() > p2.getSeverityLevel()) {
            return -1;
        }
        else if (p1.getSeverityLevel() < p2.getSeverityLevel()) {
            return 1;
        }
        else {
            return 0;
        }
    }
}
