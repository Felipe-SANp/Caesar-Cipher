import java.nio.file.Files;
import java.nio.file.Path;

public class Validator {
    public boolean isNotValidKey(int key, int sizeAlphabet) {
        return key >= sizeAlphabet;
    }
    public boolean isNotFileExists(String filePath) {
        Path path = Path.of(filePath);
        return !Files.exists(path);
    }
}
