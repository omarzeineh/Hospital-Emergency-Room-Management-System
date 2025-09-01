package Hospital_G7;

import java.util.Date;

public class Patient_G7 {
    
    int ID;
    String name;
    String age;
    int severityLevel;
    String problem;
    boolean treated;
    Date date;

    public Patient_G7(int ID, String name, String age, int severityLevel, String problem) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.severityLevel = severityLevel;
        this.problem = problem;
        this.treated = false;
        this.date = new Date();
    }

    public int getID() {
        return ID;
    }
    
    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public int getSeverityLevel() {
        return this.severityLevel;
    }

    public String getProblem() {
        return problem;
    }
    
    public String getSeverity() {
        switch(this.severityLevel) {
            case 0: return "Mild"; 
            case 1: return "Moderate";
            case 2: return "Severe";
            case 3: return "Critical";
            default: return "";
        }
    }

    public boolean isTreated() {
        return treated;
    }

    public Date getDate() {
        return date;
    }
    
    
    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public void setSeverityLevel(String severityLevel) {
        switch(severityLevel) {
            case "Mild": this.severityLevel = 0; break;
            case "Moderate": this.severityLevel = 1; break;
            case "Severe": this.severityLevel = 2; break;
            case "Critical": this.severityLevel = 3; break;
            default: System.out.println("Please Enter a Valid Severity Level");break;
        }
    }

    public void setTreated(boolean treated) {
        this.treated = treated;
    }
    
    
    
    @Override
    public String toString() {
        return "[" + ID + "," + name + "," + age + "," + getSeverity() + "," + getProblem() + "," + treated + "," + date + "]";
    }
    
}
