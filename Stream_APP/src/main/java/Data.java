import java.util.*;
import java.util.Iterator;

public class Data implements Container{
    private static Data instance = null;
    private ArrayList<Stream> streams;
    private HashMap<Integer, Streamer> streamers;
    private HashMap<Integer, User> users;

    private Data() {

        this.streamers = new HashMap<>();
        this.streams = new ArrayList<>();
        this.users = new HashMap<>();
    }

    public static Data getInstance() {
        if (instance == null) {
            instance = new Data();
        }
        return instance;
    }

    public Stream findStream(Integer id)
    {
        Iterator1 iterator = this.getIterator(0);
        for (;iterator.hasNext();)
        {
            Stream stream = (Stream) iterator.next();
            if (stream.getId().equals(id))
                return stream;
        }
        return null;
    }


    public Iterator1 getIterator(Integer type) {
        return new streamIterator();
    }

    private class streamIterator implements Iterator1 {

        int index = 0;

        @Override
        public boolean hasNext() {

            if (index < streams.size()) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {

            if (this.hasNext()) {
                return streams.get(index++);
            }
            return null;
        }
    }

    public HashMap<Integer, Streamer> getStreamers() {
        return streamers;
    }

    public HashMap<Integer, User> getUsers() {
        return users;
    }

    public ArrayList<Stream> getStreams() {
        return streams;
    }
}
