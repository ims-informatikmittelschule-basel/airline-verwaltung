import java.io.Serializable;
import java.util.HashMap;

public class Airline implements Serializable {
    public HashMap<Integer, Flug> fluege;
    public int lastid;
    private String flugString = "";

    public Airline() {
        //FIXME: Aus Datei lesen
        fluege = new HashMap<Integer, Flug>();
    }


    public void newFlug() {
        Flug flug = new Flug(this.lastid);
        fluege.put(lastid, flug);
        lastid++;
    }

    public Flug getFlug(int id) {
        return fluege.get(id);
    }

    public void deleteFlug(int id) {
        fluege.remove(id);
        return;
    }

    @Override
    public String toString() {
        fluege.forEach((key, flug) -> {
            if (key == flug.flugnummer) {
                flugString += flug.toString();
            }
        });
        return flugString;
    }
}
