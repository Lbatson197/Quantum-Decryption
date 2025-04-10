package cmis202honors;

/*
 * This requires JRE v.22 because I'm new to building projects in java.
 * For some reason this doesn't have compatibility with ANY other version, so screw me I guess.
 */

// Program starts here because vscode was being lame.
// why would it not work if I just started from Main???
// "Error: JavaFX runtime components are missing, and are required to run this application"... uh huh.
public class App {

    public static void main(String[] args) {

        // Might as well initialize stuff here.

        // Using a hash map makes choosing which encryption algorithm to break easier by comparing integers instead of strings.
        for (int id = 0; id < Main.encryptionTypes.length; id++) {
            Main.encryptionTypesMap.put(Main.encryptionTypes[id], id); // Ex. "RSA" = 0.
        }

        // Run javafx application
        Main.main(args);
    }

}
