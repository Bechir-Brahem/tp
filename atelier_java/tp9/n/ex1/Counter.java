class Counter extends Thread {

    private boolean needToPause = false;

    public synchronized void pausePoint() {
        try {
            while (needToPause) {
                wait();
            }
        } catch (InterruptedException e) {
            System.out.println(         "killing thread" + id);
        }
    }

    public synchronized void pause() {
        needToPause = true;
    }

    public synchronized void unpause() {
        needToPause = false;
        this.notifyAll();
    }
    public   int rem = 0;
    int id = 0;
    public Counter(int time, int i) {
        rem = time;
        id = i;
    }
    public void run() {
        try {
            while (rem != 0) {
                pausePoint();
                System.out.println("thread" + id + ": temps restant " + rem);
                rem--;
                this.sleep(1000);

            }
        } catch (InterruptedException e) {
            System.out.println("killing thread" + id);
        }
    }
}
