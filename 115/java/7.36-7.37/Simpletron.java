import java.util.Scanner;

public class Simpletron {
    private static final int READ = 10;
    private static final int WRITE = 11;
    private static final int LOAD = 20;
    private static final int STORE = 21;
    private static final int ADD = 30;
    private static final int SUBTRACT = 31;
    private static final int DIVIDE = 32;
    private static final int MULTIPLY = 33;
    private static final int BRANCH = 40;
    private static final int BRANCHNEG = 41;
    private static final int BRANCHZERO = 42;
    private static final int HALT = 43;

    private int[] mem;
    private int acc;
    private int insCnt;
    private int ins;
    private int opCode;
    private int opr;

    private Scanner scn;

    public Simpletron() {
        mem = new int[100];
        acc = 0;
        opCode = 0;
        opr = 0;

        scn = new Scanner(System.in);
    }

    public static void main(String[] args) {
        Simpletron sim = new Simpletron();
        sim.load();
        sim.exe();
    }

    public void load() {
        System.out.println("*** Welcome to Simpletron! ***");
        System.out.println("*** Please enter your program one instruction    ***");
        System.out.println("*** (or data word) at a time. I will display     ***");
        System.out.println("*** the location number and a question mark (?). ***");
        System.out.println("*** You then type the word for that location     ***");
        System.out.println("*** Type -99999 to stop entering your program.   ***");

        int ins = 0, memPtr = 0;

        while (ins != -99999 && memPtr < 100) {
            System.out.printf("%02d ? ", memPtr);
            ins = scn.nextInt();

            mem[memPtr++] = ins;
        }

        System.out.println("*** Program loading completed ***");
    }

    private boolean isOf(int value) {
        if (value > 9999 || value < -9999) {
            System.out.println("*** Accumulator overflow ***");
            return true;
        }

        return false;
    }

    public void exe() {
        System.out.println("*** Program execution begins ***");
        boolean isHalt = false, isFat = false, isBranch;

        while (!isHalt && !isFat && insCnt < 100) {
            isBranch = false;

            ins = mem[insCnt];

            int opCode = ins / 100, opr = ins % 100;

            switch (opCode) {
                case READ:
                    System.out.print("Enter an integer: ");
                    int in = scn.nextInt();
                    if (in >= -9999 && in <= 9999) {
                        mem[opr] = in;
                    } else {
                        System.out.println("Fatal Error: Input out of bounds.");
                        isFat = true;
                    }
                    break;

                case LOAD:
                    acc = mem[opr];
                    break;

                case WRITE:
                    System.out.printf("Output: %+05d%n", mem[opr]);
                    break;

                case STORE:
                    mem[opr] = acc;
                    break;

                case ADD:
                    acc += mem[opr];
                    if (isOf(acc))
                        isFat = true;
                    break;

                case SUBTRACT:
                    acc -= mem[opr];
                    if (isOf(acc))
                        isFat = true;
                    break;

                case DIVIDE:
                    if (mem[opr] == 0) {
                        System.out.println("*** Attempt to divide by zero ***");
                        isFat = true;
                    } else
                        acc /= mem[opr];
                    break;

                case MULTIPLY:
                    acc *= mem[opr];
                    if (isOf(acc))
                        isFat = true;
                    break;

                case BRANCH:
                    insCnt = opr;
                    isBranch = true;
                    break;

                case BRANCHNEG:
                    if (acc < 0) {
                        insCnt = opr;
                        isBranch = true;
                    }
                    break;

                case BRANCHZERO:
                    if (acc == 0) {
                        insCnt = opr;
                        isBranch = true;
                    }
                    break;

                case HALT:
                    System.out.println("*** Simpletron execution terminated ***");
                    isHalt = true;
                    break;

                case 0:
                    break;

                default:
                    System.out.println("*** Invalid operation code detected ***");
                    isFat = true;
                    break;
            }

            if (isFat)
                System.out.println("*** Simpletron execution abnormally terminated ***");
            if (!isBranch && !isHalt && !isFat)
                insCnt++;
        }

        dump();
    }

    public void dump() {
        System.out.println("\nREGISTERS:");
        System.out.printf("accumulator          %+05d%n", acc);
        System.out.printf("instructionCounter      %02d%n", insCnt);
        System.out.printf("instructionRegister  %+05d%n", ins);
        System.out.printf("operationCode           %02d%n", opCode);
        System.out.printf("operand                 %02d%n", opr);

        System.out.println("\nMEMORY:");
        System.out.print("  ");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%6d", i);
        }
        System.out.println();

        for (int i = 0; i < 100; i += 10) {
            System.out.printf("%2d", i);
            for (int j = 0; j < 10; j++) {
                System.out.printf(" %+05d", mem[i + j]);
            }
            System.out.println();
        }
    }
}