import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AirlineTest {
    public Airline airline = new Airline();

    @Test
    void add_Flug() {
        airline.newFlug();
        assertEquals(1, airline.fluege.size(), "adding single flight works");
        airline.newFlug();
        airline.newFlug();
        airline.newFlug();
        assertEquals(4, airline.fluege.size(), "adding multiple flight works");
    }

    @Test
    void get_Flug() {
        airline.newFlug();
        assertEquals(0, airline.getFlug(0).flugnummer, "getting flight works");
    }

    @Test 
    void add_get_Crew() {
        airline.newFlug();
        airline.getFlug(0).newCrew("Pilot");
        assertEquals(1, airline.getFlug(0).crewSizeAufgabe("Pilot"), "adding & getting crew works");
    }

    @Test 
    void add_get_Passenger() {
        airline.newFlug();
        airline.getFlug(0).newPassagier(50);
        assertEquals(1, airline.getFlug(0).passagierSize(), "adding & getting passenger works");
    }

    void calc_Umsatz() {
        airline.newFlug();
        airline.getFlug(0).newPassagier(123);
        assertEquals(173, airline.getFlug(0).ticketUmsatz(), "calculating profits works");
       
    }


}
