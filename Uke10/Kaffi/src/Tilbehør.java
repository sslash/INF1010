
public abstract class Tilbeh�r extends Drikke {
    
    /*
     * Alle underklasser av Tilbeh�r M� implementere
     * denne metoden. Merk at den allerede er implementert
     * i Drikke klassen. Vi tvinger underklasser til � 
     * implementere denne. Det er derfor vi har tilbeh�r klassen,
     * slik at underklasser av tilbeh�r m� implementere denne,
     * mens underklasser av drikke ikke M� det (slik som 
     * Espresso, HusetsKaffe, M�rkbrent.
     */
    public abstract String getBeskrivelse();

}