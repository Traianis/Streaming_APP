import java.text.SimpleDateFormat;
import java.util.*;

public class UserDecorator extends UtilizatorDecorator {
    UserDecorator(Utilizator user) {
        super(user);
    }

    public void surprise(Data data, Integer type) {
        ArrayList<Stream> streamArrayList = new ArrayList<>();
        User user = (User) getUtilizator();
        for (Map.Entry<Integer, Streamer> entry : data.getStreamers().entrySet()) {
            Streamer streamer = entry.getValue();
            if (user.findStreamer(streamer.getId()) == null) {
                Iterator1 iterator = streamer.getIterator(0);
                for (; iterator.hasNext();) {
                    Stream stream = (Stream) iterator.next();
                    if (stream.getStreamType().equals(type))
                        streamArrayList.add(stream);
                }
            }
        }
        Collections.sort(streamArrayList, new StreamComparator2());
        Integer nr = 0;
        System.out.print("[");
        for (Stream stream : streamArrayList) {
            if (nr != 0)
                System.out.print(",");
            SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
            SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy");
            sdf2.setTimeZone(TimeZone.getTimeZone("GMT"));
            sdf1.setTimeZone(TimeZone.getTimeZone("GMT"));
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
                System.out.print(h + ":" + min + ":" + sec + "\",\"dateAdded\":\"" + sdf2.format(stream.getDateAdded() * 1000) + "\"}");
            else
                System.out.print(min + ":" + sec + "\",\"dateAdded\":\"" + sdf2.format(stream.getDateAdded() * 1000) + "\"}");
            nr++;
            if (nr == 3)
                break;
        }
        System.out.println("]");
    }


    public void recommand(Integer streamtype) {
        ArrayList<Stream> stream_recommend = new ArrayList<>();
        User user = (User) getUtilizator();
        for (Streamer streamer : user.getStreamers()) {
            Iterator1 iterator = streamer.getIterator(0);
            for (; iterator.hasNext();) {
                Stream stream = (Stream) iterator.next();
                if (stream.getStreamType().equals(streamtype)) {
                    if (user.getStreamHashMap().get(stream.getId()) == null) {
                        stream_recommend.add(stream);
                    }
                }
            }
        }
        Collections.sort(stream_recommend, new StreamComparator());
        Integer nr = 0;
        System.out.print("[");
        for (Stream stream : stream_recommend) {
            if (nr != 0)
                System.out.print(",");
            SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
            SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy");
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
            sdf2.setTimeZone(TimeZone.getTimeZone("GMT"));
            sdf1.setTimeZone(TimeZone.getTimeZone("GMT"));
            System.out.print("{\"id\":\"" + stream.getId() + "\",\"name\":\"" + stream.getName() +
                    "\",\"streamerName\":\"" + stream.getStreamerName() + "\",\"noOfListenings\":\"" + stream.getNoOfStreams() +
                    "\",\"length\":\"");
            if (hours != 0)
                System.out.print(h + ":" + min + ":" + sec + "\",\"dateAdded\":\"" + sdf2.format(stream.getDateAdded() * 1000) + "\"}");
            else
                System.out.print(min + ":" + sec + "\",\"dateAdded\":\"" + sdf2.format(stream.getDateAdded() * 1000) + "\"}");
            nr++;
            if (nr == 5)
                break;
        }
        System.out.println("]");
    }

    private class StreamComparator implements Comparator<Stream> {
        public int compare(Stream o1, Stream o2) {
            if (o1.getNoOfStreams() > o2.getNoOfStreams())
                return -1;
            if (o1.getNoOfStreams() < o2.getNoOfStreams())
                return 1;
            return 0;
        }
    }

    private class StreamComparator2 implements Comparator<Stream> {
        public int compare(Stream o1, Stream o2) {
            if (o1.getDateAdded() / 86400 > o2.getDateAdded() / 86400)
                return -1;
            if (o1.getDateAdded() / 86400 < o2.getDateAdded() / 86400)
                return 1;
            if (o1.getNoOfStreams() > o2.getNoOfStreams())
                return -1;
            if (o1.getNoOfStreams() < o2.getNoOfStreams())
                return 1;
            return 0;
        }
    }
}
