public interface Utilizator {
    void listeaza();
    void add(Stream stream);
    //conectare(), schimbare parola(), scrieMesaj(), etc..
    //intr-o aplicatie reala utilizatorii pot avea mai multe actiuni comune si acest
    // lucru ar putea fi implementat mai usor prin aceasta interfata
}
