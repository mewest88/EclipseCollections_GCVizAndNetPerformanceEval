import com.google.gson.Gson;

/**
 * Used to convert data collected from the GC tool into a JSON/GSON compatible class.
 * To implement -> create GCToJSON object by calling constructor -> make a new GSON object -> call gsonObject.toJson(GCToJSONObject)
 * Helpful link - https://futurestud.io/tutorials/gson-getting-started-with-java-json-serialization-deserialization
 * Helpful link - https://www.mkyong.com/java/how-do-convert-java-object-to-from-json-format-gson-api/
 */
public class GCToJSON {

    String GCType;
    int GCTime; // In milliseconds
    // Get the GC overhead
    float GCOverhead;

    public void GCToJson(String gctype, int time) {
        GCType = gctype;
        GCTime = time;
    }
}
