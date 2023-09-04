import java.math.BigDecimal;

public class Biglietto {
    private int km;
    private int eta;

    // Costanti
    private static final BigDecimal costoKm = new BigDecimal("0.21");
    private static final BigDecimal scontoOver = new BigDecimal("0.40");
    private static final BigDecimal scontoMinori = new BigDecimal("0.20");

    public Biglietto(int km, int eta) throws IllegalArgumentException {
        if (!isValidKm(km) || !isValidEta(eta)) {
            throw new IllegalArgumentException("Valori non validi per km o età");
        }
        this.km = km;
        this.eta = eta;
    }

    public boolean isValidKm(int km) {
        return km > 0;
    }

    public boolean isValidEta(int eta) {
        return eta > 0;
    }

    public BigDecimal calcolaPrezzo() {
        BigDecimal prezzoTotale = calcolaSconto().multiply(costoKm.multiply(new BigDecimal(km)));
        return prezzoTotale.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    private BigDecimal calcolaSconto() {
        if (eta >= 65) {
            return BigDecimal.ONE.subtract(scontoOver);
        } else if (eta < 18) {
            return BigDecimal.ONE.subtract(scontoMinori);
        } else {
            return BigDecimal.ONE;
        }
    }
}


