import java.util.ArrayList;
import java.util.Collections;

public class Dictionary {
    public static ArrayList<Word> words = new ArrayList<Word>();

    public Dictionary() {
        words = new ArrayList<Word>();
    }
    
    public void sortDic() {
        Collections.sort(words);
    }
}
