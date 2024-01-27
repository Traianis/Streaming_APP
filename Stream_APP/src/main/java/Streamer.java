import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Streamer implements Utilizator,Container {
    private Integer streamerType, id;
    private String name;

    private ArrayList<Stream> streams;


    public Streamer() {
        this(-1, -1, "Unknown");
    }

    Streamer(Integer streamerType, Integer id, String name) {
        this.id = id;
        this.name = name;
        this.streamerType = streamerType;
        this.streams = new ArrayList<>();
    }

    public Integer getStreamerType() {
        return streamerType;
    }

    public void setStreamerType(Integer streamerType) {
        this.streamerType = streamerType;
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

    @Override
    public void listeaza() {
        System.out.print("[");
        Iterator1 iterator = getIterator(1);
        int nr=0;
        for (; iterator.hasNext(); ) {
            Stream stream = (Stream) iterator.next();
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
                    "\",\"streamerName\":\"" + this.getName() + "\",\"noOfListenings\":\"" + stream.getNoOfStreams() +
                    "\",\"length\":\"");
            if (hours != 0)
                System.out.print(h + ":" + min + ":" + sec + "\",\"dateAdded\":\"" + sdf2.format((stream.getDateAdded()) * 1000) + "\"}");
            else
                System.out.print(min + ":" + sec + "\",\"dateAdded\":\"" + sdf2.format((stream.getDateAdded()) * 1000) + "\"}");
            if (nr < this.streams.size() - 1)
                System.out.print(",");
            nr++;
        }
        System.out.println("]");
    }
    @Override
    public void add(Stream stream) {
        this.streams.add(stream);
    }

    public Iterator1 getIterator(Integer type) {
        return new streamIterator1();
    }

    private class streamIterator1 implements Iterator1 {

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

    public ArrayList<Stream> getStreams() {
        return streams;
    }
}
