import java.util.Scanner;

/**
 * This is a large singleton for handling input and output functions as they relate
 * to the game.
 */
class IoHandler {

    private static IoHandler ioHandler = null; // null instance needed for proper init
    private Scanner input;
    private String currentInput;

    /**
     * <h3>Constructor</h3>
     */
    private IoHandler() {
        input = new Scanner(System.in);
        currentInput = "";
    }

    /**
     * <h3>Singleton Getter</h3>
     * Creates a new instance if it doesn't exist
     * @return Reference to ioHandler
     */
    public static IoHandler getInstance() {
        if (ioHandler == null) ioHandler = new IoHandler();
        return ioHandler;
    }

    public void scanInput() { currentInput = input.nextLine().toLowerCase(); }

    /**
     * <h3>Get Current Input</h3>
     * @return value of String currentInput
     */
    public String getCurrentInput() {
        return currentInput;
    }

    /**
     * Translates the preferred method of typing in moves into an array
     * @param move - human readable coords (A1, B2, etc.)
     * @return coordinates for internal use
     */
    public int[] handleMove(String move) {
        int[] out = new int[2];

        switch (move.substring(0, 1)) {
            case "a":
                break; // already set to 0, no need for assignment
            case "b":
                out[0] = 1;
                break;
            case "c":
                out[0] = 2;

                break;
        }

        out[1] = Integer.parseInt(move.substring(1, 2));

        return out;
    }
}
