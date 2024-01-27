public abstract class UtilizatorDecorator implements Utilizator {
    private Utilizator utilizator;

    UtilizatorDecorator(Utilizator utilizator) {
        this.utilizator = utilizator;
    }

    public void listeaza() {
        utilizator.listeaza();
    }

    public void add(Stream stream) {
        utilizator.add(stream);
    }

    public Utilizator getUtilizator() {
        return utilizator;
    }
}
