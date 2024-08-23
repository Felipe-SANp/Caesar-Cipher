import java.nio.file.Path;
import java.util.Scanner;

public class Menu {
    private final CaesarCipher caesarCipher;
    private final Scanner scanner;
    private final FileManager fileManager;

    public Menu() {
        this.caesarCipher = new CaesarCipher();
        this.scanner = new Scanner(System.in);
        this.fileManager = new FileManager();
    }

    public void displayMenu() {
        int choice;
        do {
            String menu = """
                    
                    Caesar Cipher
                    1. Encriptar archivo
                    2. Desencriptar archivo con llave
                    3. Imprimir informacion de archivo en consola
                    0. Salir
                    Ingresa tu opcion:\s""";
            System.out.println(menu);
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    encryptFile();
                    break;
                case 2:
                    decryptFile();
                    break;
                case 3:
                    printInfoFile();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion invalida, intente de nuevo.");
            }
        } while (choice != 0);
    }

    private void encryptFile() {
        System.out.print("Ingrese el directorio del archivo: ");
        String filePath = scanner.nextLine();
        System.out.print("Ingrese su llave de encriptacion: ");
        int key = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Path encryptedPath = caesarCipher.encrypt(filePath, key);
        if (encryptedPath != null) {
            System.out.println("Archivo encriptado. Directorio del archivo: " + encryptedPath);
        } else {
            System.out.println("Encriptacion fallida. Por favor revise la llave y directorio del archivo.");
        }
    }

    private void decryptFile() {
        System.out.print("Ingrese el directorio del archivo a desencriptar: ");
        String filePath = scanner.nextLine();
        System.out.print("Ingrese la llave de desencriptacion: ");
        int key = scanner.nextInt();
        scanner.nextLine();

        Path decryptedPath = caesarCipher.decrypt(filePath, key);
        if (decryptedPath != null) {
            System.out.println("Archivo desencriptado. Directorio del archivo: " + decryptedPath);
        } else {
            System.out.println("Desencriptacion fallida. Por favor revise la llave y directorio del archivo.");
        }
    }

    private void printInfoFile() {
        System.out.print("Ingrese el directorio del archivo: ");
        String filePath = scanner.nextLine();
        System.out.println();
        fileManager.printInfoFile(filePath);
    }
}