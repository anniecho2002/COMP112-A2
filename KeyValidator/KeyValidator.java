/* Code for COMP-102-112 - 2021T1, Assignment 2
 * Name: Annie Cho
 * Username: choanni
 * ID: 300575457
 */

import ecs100.*;
import java.awt.Color;
import java.util.regex.*;
import java.util.ArrayList;

/**
 * Key:
 * Core:       Method must report whether the key is valid, or
 *             report that it is invalid and give one reason why it is invalid.
 *             To be valid, the key must
 *             - be at least 8 characters and at most 16 characters long,
 *             - not end with the special characters '#' or '$',
 *             - not have a hyphen ('-') character anywhere
 *            
 * Completion: Method should either report that the key is valid, or
 *             report that it is invalid and list ALL the reasons that it is invalid.
 *             To be valid, the key must
 *             - satisfy all of the conditions above AND
 *             - have at least one Upper case character and at least one Lower case character,
 *             - not start with the same character as the first character of the user's name
 *             - contain either a '#' or a '$', but not both.
 * Challenge:  Same as completion, except that to be valid, the key must
 *             - satisfy all of the conditions above AND
 *             - have a mix of numbers and letters
 *             - not contain any "suffix" of the user's name of 2 characters or more in any case.
 *               (eg if name is Peter, it does not contain "er", or "eR" or "ter", or "eTer" or "ETER", or...)
 *
 * Hint.  Look at the documentation in the String class.
 * You will definitely find the length(), endsWith(...), and contains(...) methods to be helpful
 */

public class KeyValidator {

    /**
     * Asks user for key word and then checks if it is a valid key word.
     */
    public void doCore() {
        UI.clearText();
        String key = UI.askString("Key:   ");
        UI.println();
        this.validateKeyCore(key);
    }

    /** CORE
     * Report "Valid" or "Invalid: ...reason...."
     */
    public void validateKeyCore(String key) {
        if (key.length() > 16) {
            UI.println("Not valid - too long");
        } else if (key.length() < 8) {
            UI.println("Not valid - too short");
        } else if (key.endsWith("#")) {
            UI.println("Not valid - cannot end with #");
        } else if (key.endsWith("$")) {
            UI.println("Not valid - cannot end with $");
        } else if (key.contains("-")) {
            UI.println("Not valid - cannot contain hyphens '-'");
        } else {
            UI.println("Valid!");
        }

    }

    /**
     * Asks user for key word and the name and then checks if it is a valid key word.
     */
    public void doCompletion() {
        UI.clearText();
        String key = UI.askString("Key:   ");
        String name = UI.askString("Your name:   ");
        UI.println();
        this.validateKeyCompletion(key, name);
    }

    /** COMPLETION
     * Report that the key is valid or report ALL the rules that the key failed.
     */

    public static boolean areAllTrue(boolean[] array) {
        for (boolean b: array)
            if (!b) return false;
        UI.println("Valid");
        return true;
    }

    public void validateKeyCompletion(String key, String name) {
        boolean[] conditions = {true,true,true,true,true,true};
        String[] reasons = {
            "Invalid. Key must be at least 8 and at most 16 characters long",
            "Invalid. Cannot end with # or $",
            "Invalid. Cannot contain hyphens",
            "Invalid. Key cannot start with same letter as name",
            "Invalid. MUST contain # or $, but NOT both",
            "Invalid. Must contain uppercase and lowercase letters."
        };

        if (key.length() < 8 || key.length() > 16) {
            conditions[0] = false;
            UI.println(reasons[0]);
        }

        if (key.endsWith("#") || key.endsWith("$")) {
            conditions[1] = false;
            UI.println(reasons[1]);
        }

        if (key.contains("-")) {
            conditions[2] = false;
            UI.println(reasons[2]);
        }

        char key_first = key.charAt(0);
        char name_first = name.charAt(0);
        if (key_first == name_first) {
            conditions[3] = false;
            UI.println(reasons[3]);
        }

        if ((key.contains("#") == false && key.contains("$") == false) || (key.contains("#") == true && key.contains("$") == true)) {
            conditions[4] = false;
            UI.println(reasons[4]);
        }

        boolean no_uppercase = !key.equals(key.toUpperCase());
        boolean no_lowercase = !key.equals(key.toLowerCase());
        if ((no_uppercase == true && no_lowercase == false) || (no_uppercase == false && no_lowercase == true)) {
            // if there is no uppercase and there is uppercase OR if there is uppercase and no lowercase then
            conditions[5] = false;
            UI.println(reasons[5]);
        }

        areAllTrue(conditions);

    }

    /** CHALLENGE */

    public void doChallenge() {
        UI.clearText();
        String key = UI.askString("Key:   ");
        String name = UI.askString("Your name:   ");
        UI.println();
        this.validateKeyChallenge(key, name);
    }

    public static Boolean checkSuffix(String name, String key) {

        String suffix = name.substring(1); // removes first letter in name
        ArrayList < String > possibleSuffix = new ArrayList < String > (); // makes an arraylist which can change size/be added onto
        for (int i = 0; i < suffix.length(); i++) {
            possibleSuffix.add(suffix.substring(i)); //goes through and makes more suffixes of the name, stores into arraylist
        }

        int index = possibleSuffix.size() - 1;
        possibleSuffix.remove(index); // removes last possible suffix which is the one letter option
        String[] allSuffix = possibleSuffix.toArray(new String[0]); //makes arraylist into an array
        /* UI.println(allSuffix); */

        boolean match = false;
        for (int i = 0; i < possibleSuffix.size(); i++) {
            Pattern pattern = Pattern.compile(allSuffix[i], Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(key);
            match = matcher.find();
        }
        return match;
    }

    public void validateKeyChallenge(String key, String name) {
        String numRegex = ".*[0-9].*";
        String alphaRegex = ".*[A-Z].*";
        boolean[] conditions = {true,true,true,true,true,true,true,true};
        String[] reasons = {
            "Invalid. Key must be at least 8 and at most 16 characters long",
            "Invalid. Cannot end with # or $",
            "Invalid. Cannot contain hyphens",
            "Invalid. Key cannot start with same letter as name",
            "Invalid. MUST contain # or $, but NOT both",
            "Invalid. Must contain uppercase and lowercase letters.",
            "Invalid. Must contain a mix of letters and numbers.",
            "Invalid. Must not include suffix of name."
        };

        if (key.length() < 8 || key.length() > 16) {
            conditions[0] = false;
            UI.println(reasons[0]);
        }

        if (key.endsWith("#") || key.endsWith("$")) {
            conditions[1] = false;
            UI.println(reasons[1]);
        }

        if (key.contains("-")) {
            conditions[2] = false;
            UI.println(reasons[2]);
        }

        if (key.charAt(0) == name.charAt(0)) {
            conditions[3] = false;
            UI.println(reasons[3]);
        }

        if ((key.contains("#") == false && key.contains("$") == false) || (key.contains("#") == true && key.contains("$") == true)) {
            conditions[4] = false;
            UI.println(reasons[4]);
        }

        boolean noUppercase = !key.equals(key.toUpperCase());
        boolean noLowercase = !key.equals(key.toLowerCase());
        if ((noUppercase == true && noLowercase == false) || (noUppercase == false && noLowercase == true)) {
            // if there is no uppercase and there is uppercase OR if there is uppercase and no lowercase then
            conditions[5] = false;
            UI.println(reasons[5]);
        }

        if ((key.matches(alphaRegex) == false) || (key.matches(numRegex) == false)) {
            //if key does not have letters OR if key does not have numbers then:
            conditions[6] = false;
            UI.println(reasons[6]);
        }

        Boolean match = checkSuffix(name, key);
        if (match == true) {
            conditions[7] = false;
            UI.println(reasons[7]);
        }

        areAllTrue(conditions); // checks if all conditions are true; if so, says valid!

    }


    public void setupGUI() {
        UI.initialise();
        UI.addButton("Clear", UI::clearText);
        UI.addButton("Validate Key Core", this::doCore);
        UI.addButton("Validate Key Completion", this::doCompletion);
        UI.addButton("Validate Key Challenge", this::doChallenge);
        UI.addButton("Quit", UI::quit);
        UI.setDivider(1); // Expand the text area
    }

    public static void main(String[] args) {
        KeyValidator kv = new KeyValidator();
        kv.setupGUI();
    }
}