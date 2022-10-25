import java.util.HashMap;
import java.util.Set;
public class HashMatique{
public static void main(String[] args){
HashMap<String, String> trackList = new HashMap<String, String>();
trackList.put("firstSong", "I'm the lyrics of the first song");
trackList.put("secondSong", "I'm the lyrics of the second song");
trackList.put("thirdSong", "I'm the lyrics of the third song");
trackList.put("fourthSong", "I'm the lyrics of the fourth song");

String oneSong = trackList.get("firstSong");

Set<String> songs = trackList.keySet();
        for(String song : songs) {
            System.out.println(song + ":" + trackList.get(song));    
        }
}
}