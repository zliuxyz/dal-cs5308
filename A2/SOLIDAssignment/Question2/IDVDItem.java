import java.time.Duration;
import java.util.ArrayList;

public interface IDVDItem extends ILibraryItem {
    public Duration getPlayTime();
    public ArrayList<String> getCastList();
}
