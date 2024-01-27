import java.util.StringTokenizer;

public class FactoryCommand {
    private static FactoryCommand instance = null;

    public static FactoryCommand getInstance() {
        if (instance == null) {
            instance = new FactoryCommand();
        }
        return instance;
    }
    public Command createCommand(String line) throws IllegalArgumentException {
        if (line == null || line.isEmpty())
            return null;
        if (line.contains(" ADD")) {
            return createAddCommand(line);
        }
        if (line.contains(" LISTEN")) {
            return createListenCommand(line);
        }
        if (line.contains(" DELETE")) {
            return createDeleteCommand(line);
        }
        if (line.contains(" LIST")) {
            return createListCommand(line);
        }
        if (line.contains(" RECOMMEND")) {
            return createRecommendCommand(line);
        }
        if (line.contains(" SURPRISE")) {
            return createSurpriseCommand(line);
        }
        throw new IllegalArgumentException("Unknown Command");
    }

    private AddCommand createAddCommand(String line) {
        StringTokenizer st = new StringTokenizer(line);
        Integer streamerId = Integer.valueOf(st.nextToken(" "));
        st.nextToken(" ");
        Integer streamType = Integer.valueOf(st.nextToken(" "));
        Integer id = Integer.valueOf(st.nextToken(" "));
        Integer streamGenre = Integer.valueOf(st.nextToken(" "));
        Long lenght = Long.valueOf(st.nextToken(" "));
        String name = st.nextToken(" ");
        while (st.hasMoreTokens()) {
            name = name.concat(" ");
            name = name.concat(st.nextToken(" "));
        }
        return new AddCommand(streamerId, streamType, id, streamGenre, lenght, name);
    }

    private ListCommand createListCommand(String line) {
        StringTokenizer st = new StringTokenizer(line);
        Integer id = Integer.valueOf(st.nextToken(" "));
        return new ListCommand(id);
    }

    private DeleteCommand createDeleteCommand(String line) {
        StringTokenizer st = new StringTokenizer(line);
        Integer streamerId = Integer.valueOf(st.nextToken(" "));
        st.nextToken(" ");
        Integer streamId = Integer.valueOf(st.nextToken(" "));
        return new DeleteCommand(streamerId, streamId);
    }

    private ListenCommand createListenCommand(String line) {
        StringTokenizer st = new StringTokenizer(line);
        Integer userId = Integer.valueOf(st.nextToken(" "));
        st.nextToken(" ");
        Integer streamId = Integer.valueOf(st.nextToken(" "));
        return new ListenCommand(userId, streamId);
    }

    private RecommendCommand createRecommendCommand(String line) {
        StringTokenizer st = new StringTokenizer(line);
        Integer userId = Integer.valueOf(st.nextToken(" "));
        st.nextToken(" ");
        String type = st.nextToken(" ");
        Integer streamGenre;
        switch (type) {
            case "SONG": {
                streamGenre = 1;
                break;
            }
            case "PODCAST": {
                streamGenre = 2;
                break;
            }
            case "AUDIOBOOK": {
                streamGenre = 3;
                break;
            }
            default:
                streamGenre = -1;
        }
        return new RecommendCommand(userId, streamGenre);
    }
    private SurpriseCommand createSurpriseCommand(String line) {
        StringTokenizer st = new StringTokenizer(line);
        Integer userId = Integer.valueOf(st.nextToken(" "));
        st.nextToken(" ");
        String type = st.nextToken(" ");
        Integer streamGenre;
        switch (type) {
            case "SONG": {
                streamGenre = 1;
                break;
            }
            case "PODCAST": {
                streamGenre = 2;
                break;
            }
            case "AUDIOBOOK": {
                streamGenre = 3;
                break;
            }
            default:
                streamGenre = -1;
        }
        return new SurpriseCommand(userId, streamGenre);
    }
}
