public class Clock {
    private int[] clock = {0, 0, 0};
    
    public void time() {
        for (int t = 0; t < 61; t++) {
             try {
                Thread.sleep(499);                 //1000 milliseconds is one second.
            }  catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            if (clock[0] + 1 == 60) {
                clock[0] = 0;
                clock[1] += 1;
                t = 0;
            }
            else if (clock[1] + 1 == 60) {
                clock[1] = 0;
                clock[2] += 1;
            }
            else {
                clock[0] = t;
            }
            System.out.format("\f%d:%d:%d", clock[2], clock[1], clock[0]);
        }
    }
}