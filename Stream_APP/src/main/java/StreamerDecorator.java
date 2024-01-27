import java.util.Iterator;

public class StreamerDecorator extends UtilizatorDecorator {
    StreamerDecorator(Utilizator utilizator) {
        super(utilizator);
    }

    public void delete(Data data, Integer streamId) {
        Iterator1 iterator = ((Streamer) this.getUtilizator()).getIterator(0);
        for (; iterator.hasNext(); ) {
            Stream stream = (Stream) iterator.next();
            if (stream.getId().equals(streamId)) {
                ((Streamer) this.getUtilizator()).getStreams().remove(stream);
                data.getStreams().remove(stream);
                return;
            }
        }
    }
}
