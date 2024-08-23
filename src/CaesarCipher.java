import java.nio.file.Path;

public class CaesarCipher {
    private final char[] lowerAlphabet;
    private final char[] upperAlphabet;
    private final int sizeAlphabet;

    Validator validator = new Validator();
    FileManager fileManager = new FileManager();

    public CaesarCipher(char[] alphabet){
        lowerAlphabet = new String(alphabet).toLowerCase().toCharArray();
        upperAlphabet = new String(alphabet).toUpperCase().toCharArray();
        sizeAlphabet = alphabet.length;
    }
    public CaesarCipher(){
        lowerAlphabet = "abcdefghijklmnñopqrstuvwxyz".toCharArray();
        upperAlphabet = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ".toCharArray();
        sizeAlphabet = lowerAlphabet.length;
    }

    public Path encrypt(String filePath, int key) {
        filePath = fileManager.cleanPath(filePath);
        if(validator.isNotValidKey(key, sizeAlphabet) || validator.isNotFileExists(filePath)){
            return null;
        }

        Path pathFileEncrypt = fileManager.getNewPathFileName(filePath, "_encrypted");
        fileManager.createNewFile(pathFileEncrypt);

        String[] lines = fileManager.readFile(filePath);
        for(int a = 0; a < lines.length; a++){
            lines[a] = alternatedLetters(lines[a], key);
        }
        fileManager.writeFile(lines, pathFileEncrypt.toString());
        return pathFileEncrypt;
    }

    public Path decrypt(String filePath, int key) {
        filePath = fileManager.cleanPath(filePath);
        if(validator.isNotValidKey(key, sizeAlphabet) || validator.isNotFileExists(filePath)){
            return null;
        }

        Path pathFileDecrypt = fileManager.getNewPathFileName(filePath, "_decrypted");
        fileManager.createNewFile(pathFileDecrypt);

        String[] lines = fileManager.readFile(filePath);
        for(int a = 0; a < lines.length; a++){
            lines[a] = alternatedLetters(lines[a], - key);
        }
        fileManager.writeFile(lines, pathFileDecrypt.toString());
        return pathFileDecrypt;
    }

    private int indexAlphabet(char letter){
        for (int i = 0; i < sizeAlphabet; i++) {
            if (lowerAlphabet[i] == letter) {
                return i;
            }
            if (upperAlphabet[i] == letter) {
                return i;
            }
        }
        return -1;
    }

    private char shiftLetter(char c, int n) {
        int index = indexAlphabet(c);
        if (index == -1) {
            return c;
        }
        char[] alphabet = Character.isLowerCase(c) ? lowerAlphabet : upperAlphabet;
        int newIndex = (index + n) % alphabet.length;
        if (newIndex < 0) {
            newIndex += alphabet.length;
        }
        return alphabet[newIndex];
    }

    private String alternatedLetters(String line, int n){
        char[] lineChars = line.toCharArray();
        for (int i = 0; i < lineChars.length; i++) {
            lineChars[i] = shiftLetter(lineChars[i], n);
        }
        return new String(lineChars);
    }
}
