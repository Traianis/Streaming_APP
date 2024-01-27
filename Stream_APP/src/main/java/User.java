import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Iterator;

public class User implements Utilizator, Container {
    private Integer id;
    private String name;
    private HashMap<Integer, Stream> streamHashMap;
    private ArrayList<Integer> streamArrayListID;
    private ArrayList<Streamer> streamers;

    User() {
        this(-1, "Unknown");
    }

    User(Integer id, String name) {
        this.id = id;
        this.name = name;
        this.streamHashMap = new HashMap<>();
        this.streamers = new ArrayList<>();
        this.streamArrayListID = new ArrayList<>();
    }

    public ArrayList<Integer> getStreamArrayList() {
        return streamArrayListID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<Integer, Stream> getStreamHashMap() {
        return streamHashMap;
    }

    public void setStreams(HashMap<Integer, Stream> streams) {
        this.streamHashMap = streams;
    }

    public ArrayList<Streamer> getStreamers() {
        return streamers;
    }


    @Override
    public void add(Stream stream) {
        this.streamHashMap.put(stream.getId(), stream);
        this.streamArrayListID.add(stream.getId());
    }

    Streamer findStreamer(Integer id) {
        Iterator1 iterator = getIterator(0);
        for (; iterator.hasNext(); ) {
            Streamer streamer = (Streamer) iterator.next();
            if (streamer.getId().equals(id))
                return streamer;
        }
        return null;
    }

    public Iterator1 getIterator(Integer type) {
        if (type == 0)
            return new streamerIterator();
        return new streamIDIterator();
    }


    private class streamerIterator implements Iterator1 {

        int index = 0;

        @Override
        public boolean hasNext() {

            if (index < streamers.size()) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {

            if (this.hasNext()) {
                return streamers.get(index++);
            }
            return null;
        }
    }

    private class streamIDIterator implements Iterator1 {

        int index = 0;

        @Override
        public boolean hasNext() {

            if (index < streamArrayListID.size()) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {

            if (this.hasNext()) {
                return streamArrayListID.get(index++);
            }
            return null;
        }
    }

    @Override
    public void listeaza() {
        System.out.print("[");
        int nr = 0;
        Iterator1 iterator = getIterator(1);
        for (; iterator.hasNext(); ) {
            Integer id = (Integer) iterator.next();
            Stream stream = this.streamHashMap.get(id);
            SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy");
            sdf2.setTimeZone(TimeZone.getTimeZone("GMT"));
            Long hours = stream.length / 3600;
            String h = "", min = "", sec = "";
            if (hours < 10)
                h = "0" + hours.toString();
            else h = hours.toString();
            Long minutes = (stream.length % 3600) / 60;
            if (minutes < 10)
                min = "0" + minutes.toString();
            else min = minutes.toString();
            Long seconds = (stream.length % 3600) % 60;
            if (seconds < 10)
                sec = "0" + seconds.toString();
            else sec = seconds.toString();
            System.out.print("{\"id\":\"" + stream.getId() + "\",\"name\":\"" + stream.getName() +
                    "\",\"streamerName\":\"" + stream.getStreamerName() + "\",\"noOfListenings\":\"" + stream.getNoOfStreams() +
                    "\",\"length\":\"");
            if (hours != 0)
                System.out.print(h + ":" + min + ":" + sec + "\",\"dateAdded\":\"" + sdf2.format((stream.getDateAdded()) * 1000) + "\"}");
            else
                System.out.print(min + ":" + sec + "\",\"dateAdded\":\"" + sdf2.format((stream.getDateAdded()) * 1000) + "\"}");
            nr++;
            if (nr < this.streamArrayListID.size())
                System.out.print(",");
        }
        System.out.println("]");
    }
}
