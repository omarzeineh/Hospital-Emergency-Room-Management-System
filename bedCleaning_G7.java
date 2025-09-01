package Hospital_G7;


public class bedCleaning_G7 implements Runnable {
    Bed_G7 bed;

    public bedCleaning_G7(Bed_G7 bed) {
        this.bed = bed;
    }
    
    public static void clean(Bed_G7 bed) {
        Thread thr = new Thread(new bedCleaning_G7(bed));
        thr.start();
    }
    
    @Override
    public void run() {
        try{
            Thread.sleep(3000);
            System.out.println("Bed Has Been Cleaned");
            bed.clean = true;
        }
        catch(InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
