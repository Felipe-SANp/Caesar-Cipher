import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.io.FileWriter;

public class FileManager {

    public String[] readFile(String filePath){
        ArrayList<String> lines = new ArrayList<>();
        try(FileInputStream file = new FileInputStream(filePath);
             BufferedReader reader = new BufferedReader(new InputStreamReader(file))){
            String line;
            while((line = reader.readLine()) != null){
                lines.add(line);
            }
        }catch (IOException e){
            System.out.println("Error reading file");
        }
        return lines.toArray(new String[0]);
    }

    public void writeFile(String[] content ,String filePath){
        try(FileWriter write = new FileWriter(filePath)){
            for(String line: content){
                write.write(line + "\n");
            }
        }catch (IOException e){
            System.out.println("Error writing file");
        }
    }

    public Path getNewPathFileName(String pathFileName, String plusName) {
        int dotIndex = pathFileName.lastIndexOf(".");
        return Path.of(pathFileName.substring(0, dotIndex) + plusName + pathFileName.substring(dotIndex));
    }

    public boolean createNewFile(Path filePath){
        try{
            return filePath.toFile().createNewFile();
        }
        catch (IOException e){
            System.out.println("Error creating file");
        }
        return false;
    }
    public String cleanPath(String path){
        if(path.contains("\\")){
            return path.replace('\\', '/');
        }
        return path;
    }
}
