public class Passagier extends FlugPersonen {
    public int ticketPreis;

    public Passagier(int ticketPreis) {
        this.rolle = "Passagier";
        this.ticketPreis = ticketPreis;
    }

    @Override
    public String getRolle() {
        return this.rolle;
    }
    
}
