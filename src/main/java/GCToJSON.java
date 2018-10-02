import com.google.gson.Gson;

public class GCToJSON {

    String GCType;
    int GCTime; // In milliseconds

    public void GCToJson(String gctype, int time) {
        GCType = gctype;
        GCTime = time;
    }
}
