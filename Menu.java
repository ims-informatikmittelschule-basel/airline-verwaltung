import java.util.*;

public class Menu {

    protected HashMap<Character, MenuItem> items = new HashMap<Character, MenuItem>();

    public void AddMenuItem(char key, String text, Menu.Funktion funct) {
        MenuItem item = new MenuItem(key, text, funct);
        items.put(item.key, item);
    }

    public Menu.Funktion getMenuItemFunktion(char key) {
        MenuItem item = items.get(key);
        return item.getFunktion();
    }

    public void Anzeigen() {
        char auswahl = ' ';

        System.out.println("\nAirline");

        items.forEach((key, value) -> System.out.println(value));

        System.out.println("\n0   Beenden\n");
        System.out.print("> ");

        Scanner reader = new Scanner(System.in);
        auswahl = reader.next(".").charAt(0);

        if (auswahl == '0') {
            return;
        } else {
            this.getMenuItemFunktion(auswahl).eval();

            // System.out.println("...bitte Taste drücken...");
            new java.util.Scanner(System.in).nextLine();

            this.Anzeigen();
        }

    }

    public interface Funktion {
        void eval();
    }

    private class MenuItem {
        protected char key;
        protected String text;
        protected Menu.Funktion funct;

        MenuItem() {
            this.key = '0';
            this.text = "";
            this.funct = null;
        }

        MenuItem(char key, String text, Menu.Funktion funct) {
            this.key = key;
            this.text = text;
            this.funct = funct;
        }

        public Menu.Funktion getFunktion() {
            return this.funct;
        }

        @Override
        public String toString() {
            return this.key + "   " + this.text;
        }
    }

}