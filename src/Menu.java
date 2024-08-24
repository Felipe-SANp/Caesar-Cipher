import java.nio.file.Path;
import java.util.InputMismatchException;
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
        try {
            do {
                String menu = """
                                           \s
                        Caesar Cipher
                        1. Encriptar archivo
                        2. Desencriptar archivo con llave
                        3. Imprimir informacion de archivo en consola
                        0. Salir
                        Ingresa tu opcion:\s""";
                println(menu);
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
                        println("Saliendo...");
                        break;
                    default:
                        println("Opcion invalida, intente de nuevo.");
                }
            } while (choice != 0);
        } catch (InputMismatchException e){
            println("Tipo de dato incorrecto ingresado.\nReinicie el programa.");
        }
    }

    private void encryptFile() {
        print("Ingrese el directorio del archivo: ");
        String filePath = scanner.nextLine();
        print("Ingrese su llave de encriptacion: ");

        int keyInt = testInputKey(scanner.nextLine());

        if(keyInt == 0){
            println("Llave invalida. Por favor ingrese un numero entero.");
            return;
        }

        Path encryptedPath = caesarCipher.encrypt(filePath, keyInt);
        if (encryptedPath != null) {
            println("Archivo encriptado. Directorio del archivo: " + encryptedPath);
        } else {
            println("Encriptacion fallida. Por favor revise la llave y/o directorio del archivo.");
        }
    }

    private void decryptFile() {
        print("Ingrese el directorio del archivo a desencriptar: ");
        String filePath = scanner.nextLine();
        print("Ingrese la llave de desencriptacion: ");

        int keyInt = testInputKey(scanner.nextLine());

        if(keyInt == 0){
            println("Llave invalida. Por favor ingrese un numero entero.");
            return;
        }
        Path decryptedPath = caesarCipher.decrypt(filePath, keyInt);
        if (decryptedPath != null) {
            println("Archivo desencriptado. Directorio del archivo: " + decryptedPath);
        } else {
            println("Desencriptacion fallida. Por favor revise la llave y/o directorio del archivo.");
        }
    }

    private void printInfoFile() {
        print("Ingrese el directorio del archivo: ");
        String filePath = scanner.nextLine();
        println("");
        fileManager.printInfoFile(filePath);
    }

    private int testInputKey(String input){
        String regex = "^[0-9]+$";
        if(!input.matches(regex)){
            return  0;
        } else {
            return Integer.parseInt(input);
        }
    }

    public void print(String message){
        System.out.print(message);
    }
    public void println(String message){
        System.out.println(message);
    }
}