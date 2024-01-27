import static java.lang.System.exit;

public class FactoryUtilizator {
    private static FactoryUtilizator instance = null;

    public static FactoryUtilizator getInstance() {
        if (instance == null) {
            instance = new FactoryUtilizator();
        }
        return instance;
    }
    public Utilizator createUtilizator(String type, Integer id, String name, Integer maybe_streamerType) throws IllegalArgumentException {
        if (type == null || type.isEmpty())
            return null;
        switch (type) {
            case "user":
                return new User(id, name);
            case "streamer":
                return new Streamer(maybe_streamerType, id, name);
            // poate sa mai apara alte tipuri de utilizatori, cum ar fi Subscriber
            default: {
                throw new IllegalArgumentException("Unknown type" + type);
            }
        }
    }
}
