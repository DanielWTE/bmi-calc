import java.util.Scanner;

/**
 * @author Daniel Wagner
 * @version 0.0.1
 */

public class bmi {
    public static void main(String[] args ) {
        try {
            // Setze Scanner sObj
            Scanner sObj = new Scanner(System.in);

            // Eingabe von Werten
            System.out.println("Ihre Groesse in cm:");
            String bodySize = sObj.nextLine();
            System.out.println("Ihr Koerpergewicht in KG:");
            String bodyWeight = sObj.nextLine();

            // Setze String in float und rufe Funktion
            float bmi = calcBmi(Float.valueOf(bodySize), Float.valueOf(bodyWeight));

            // Gibt nach aufruf der Funktion Wert aus
            System.out.println(getMassIndex(bmi) + "\n" + "Ihr genauer BMI Wert ist: " + bmi);
        } catch (NumberFormatException e) {
            System.out.println("Bitte geben Sie nur Zahlen ein!");
            // Fehler wenn ein String eingegeben wird
                System.out.println("[Fehler] Bitte geben Sie nur Zahlen ein! " + e.getMessage());
            }
        finally {
                System.out.println("Danke fuer die Nutzung!");
            }
    }

    public static float calcBmi(float size, float weight){
        try {
            if (size == 0 || weight == 0) {
                throw new Exception("Unlogische Werte");
            }
            size = size / 100;
            return (weight / (size * size));
            // Gibt BMI Wert zurück
        } catch (Exception e) {
            System.out.println("[Fehler] " + e);
            System.exit(0);
            return 0;
        }
    }

    public static String getMassIndex(float bmi){

        // Initialisiere Result
        String result = "";

        //IF Statement um Typ zu bestimmen
        if(bmi <= 16.0){
            result = "Kritisches Untergewicht";
        } else if (bmi <= 19.9) {
            result = "Untergewicht";
        } else if (bmi <= 24.9) {
            result = "Normalgewicht";
        } else if (bmi <= 29.9) {
            result = "Uebergewicht";
        } else if (bmi <= 34.9) {
            result = "Adipositas Grad I";
        } else if (bmi <= 39.9) {
            result = "Adipositas Grad II";
        } else if (bmi <= 40.0) {
            result = "Adipositas Grad III";
        } else {
            result = "Nicht identifizierbar";
        }

        //Return das durch IF aktualisierte result
        return result;
    }
}
