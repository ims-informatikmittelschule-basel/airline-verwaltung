import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Main {
    public static Airline airline;
    public static final String AIRLINE_FILE = "airline.dat";

    public static void main(String[] args) {
        //System.out.println("Hello World");
        airline = addAirlineFromFile();
        airline.newFlug();
        airline.getFlug(0).newPassagier(69);
        airline.getFlug(0).newCrew("Pilot");
        //mobiliarverwaltung.getMobiliar("xDasFahrzeug").lineareAbschreibungRechnen();
        //airline.neueMobiliar("Jonas", 7000, 3, 0.4f);
        //mobiliarverwaltung.getMobiliar("Jonas").degressiveAbschreibungRechnen();
        menu();
        AddressenSpeichern();
    }
    
    public static void menu() {
        Menu menu = new Menu();

        menu.AddMenuItem('1', "Flug auflisten", LIST_FLUG);
        menu.AddMenuItem('2', "Flug hinzufügen", NEW_FLUG);
        menu.AddMenuItem('3', "Neuer Passagier", NEUER_PASSAGIER);
        menu.AddMenuItem('4', "Neues Crewmitglied", NEUES_CREWMITGLIED);
        menu.AddMenuItem('5', "Alle Flüge listen", LIST_FLUEGE);
        //menu.AddMenuItem('4', "Neues Crewmitglied", DEGRESSIVE_ABSCHREIBUNG);
        //menu.AddMenuItem('4', "Neues Crewmitglied", DEGRESSIVE_ABSCHREIBUNG);
 
        menu.Anzeigen();
    }

    public final static Menu.Funktion NEW_FLUG = new Menu.Funktion() {
        public void eval() {
            airline.newFlug(); 
            return;
        }
    };

    public final static Menu.Funktion LIST_FLUG = new Menu.Funktion() {
        public void eval() {
            Scanner sc = new Scanner(System.in);
            System.out.println("Flugnummer: ");
            int id = sc.nextInt();
            System.out.println(airline.getFlug(id));
            return;
        }
    };

    public final static Menu.Funktion LIST_FLUEGE = new Menu.Funktion() {
        public void eval() {
            System.out.println(airline);
            return;
        }
    };


    public final static Menu.Funktion NEUER_PASSAGIER = new Menu.Funktion() {
        public void eval() {
            Scanner sc = new Scanner(System.in);
            System.out.println("Flugnummer: ");
            int id = sc.nextInt();
            System.out.println("Ticketpreis: ");
            int ticketPreis = sc.nextInt();
            airline.getFlug(id).newPassagier(ticketPreis);
            //mobiliarverwaltung.getMobiliar(name).lineareAbschreibungRechnen();
            return;
        }
    };

    public static final Menu.Funktion NEUES_CREWMITGLIED = new Menu.Funktion() {
        public void eval() {
            Scanner sc = new Scanner(System.in);
            System.out.println("Flugnummer: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.println("Crewfunktion: ");
            String funktion = sc.nextLine().trim();
            airline.getFlug(id).newCrew(funktion);
            //mobiliarverwaltung.getMobiliar(name).degressiveAbschreibungRechnen();
            return;
        }
    };


    public static Airline addAirlineFromFile() {
        try {
            FileInputStream fin = new FileInputStream(AIRLINE_FILE);
            if (fin.available() == 0) {
                fin.close();
                return new Airline();
            }
            ObjectInputStream ois = new ObjectInputStream(fin);
            Airline readAirline = (Airline) ois.readObject();
            ois.close();
            return readAirline;
        } catch (IOException | ClassNotFoundException e) {
            //e.printStackTrace();
            return new Airline();
        }
    }

    public static void AddressenSpeichern() {
        try {
            FileOutputStream fos = new FileOutputStream(AIRLINE_FILE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(airline);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}