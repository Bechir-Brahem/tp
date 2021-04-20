class InitP {
    InitP(int x) {
        System.out.println("P1-arg const");
    } InitP() {
        System.out.println("Pno-arg const");
    } static {
        System.out.println("P1st static init");
    }{
        System.out.println("P1st instance init");
    }{
        System.out.println("PP2nd instance init");
    } static {
        System.out.println("P2nd static init");
    }
}
class Init extends InitP {
    Init(int x) {
        System.out.println("1-arg const");
    } Init() {
        System.out.println("no-arg const");
    } static {
        System.out.println("1st static init");
    }{
        System.out.println("1st instance init");
    }{
        System.out.println("2nd instance init");
    } static {
        System.out.println("2nd static init");
    } public static void main(String [] args) {
        System.out.println();
        new Init();
        System.out.println();
        new Init(7);
        System.out.println();
        new InitP();
        System.out.println();
        new InitP(7);

    }
}
