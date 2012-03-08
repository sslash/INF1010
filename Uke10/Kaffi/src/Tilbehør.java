
public abstract class Tilbeh¿r extends Drikke {
    
    /*
     * Alle underklasser av Tilbehør MÅ implementere
     * denne metoden. Merk at den allerede er implementert
     * i Drikke klassen. Vi tvinger underklasser til å 
     * implementere denne. Det er derfor vi har tilbehør klassen,
     * slik at underklasser av tilbehør må implementere denne,
     * mens underklasser av drikke ikke MÅ det (slik som 
     * Espresso, HusetsKaffe, Mørkbrent.
     */
    public abstract String getBeskrivelse();

}