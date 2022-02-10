import java.io.Serializable;
import java.util.ArrayList;

public class Flug implements Serializable {
    public int flugnummer;
    public ArrayList<Crew> crew = new ArrayList<Crew>();
    public ArrayList<Passagier> passagiere= new ArrayList<Passagier>();
    public ArrayList<String> flugrollen = new ArrayList<String>();
    
    public Flug(int id) {
        this.flugnummer = id;
    }

    public void newPassagier(int ticketPreis) {
        Passagier passagier = new Passagier(ticketPreis);
        passagiere.add(passagier);
    }

    public void newCrew(String funktion) {
        //System.out.println(funktion);
        //System.out.println(flugrollen.contains(funktion));
        if (!flugrollen.contains(funktion)) {
            flugrollen.add(funktion);
        }
        Crew crewMitglied = new Crew(funktion);
        crew.add(crewMitglied);
    }

    public int crewSizeAufgabe(String funktion) {
        int size = 0;
        for (Crew crewMitglied : crew) {
            if (crewMitglied.getRolle().equals(funktion)) {
                size++;
            } else {
                continue;
            }
        }
        return size;
    }

    public int passagierSize() {
        return passagiere.size();
    }

    public int ticketUmsatz() {
        int umsatz = 0;
        for (Passagier passagier : passagiere) {
            umsatz += passagier.ticketPreis; 
        }

        return umsatz;
    }

    @Override
    public String toString() {
        String res = "Flug "+String.valueOf(flugnummer)+":\n\n";
        res += "Crew (nach Aufgabetyp): \n";
        for (String funktion : flugrollen) {
            int size = crewSizeAufgabe(funktion); 
            res += funktion + "\t" + String.valueOf(size) + "\n";
        }

        res += "\n";

        res += "Passagiere:\t"+String.valueOf(passagierSize())+"\n";

        res += "\n";

        res += "Ticketumsatz:\t"+String.valueOf(ticketUmsatz())+"\n";

        /*
        for (Crew crewm : crew) {
            res += crewm.getRolle(); 
        }

        res += String.valueOf(flugrollen.size());
        */

        return res;
    }
}
