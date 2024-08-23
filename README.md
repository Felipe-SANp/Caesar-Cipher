# Proyecto: Cifrado de Cesar

## Descripción

Este proyecto implementa el cifrado de Cesar, un método de cifrado por sustitución en el que cada letra del texto 
se desplaza un número fijo de posiciones en el alfabeto. El proyecto incluye funcionalidades para 
encriptar y desencriptar archivos de texto utilizando este método.

## Estructura del Proyecto

- `Main.java`: Punto de entrada del programa. Muestra un menú para que el usuario elija entre encriptar o desencriptar un archivo.
- `Menu.java`: Clase que maneja la interacción con el usuario a través de un menú en la consola.
- `CaesarCipher.java`: Clase principal que contiene la lógica para encriptar y desencriptar utilizando el cifrado de Cesar.
- `Validator.java`: Clase que valida las entradas del usuario, como la existencia del archivo y la validez de la llave de cifrado.
- `FileManager.java`: Clase que maneja la lectura y escritura de archivos.

## Clases y Métodos Relevantes

### CaesarCipher

Esta clase contiene los métodos principales para encriptar y desencriptar archivos utilizando el cifrado de Cesar.

#### Métodos

- **CaesarCipher()**: Constructor que inicializa los alfabetos en minúsculas y mayúsculas.
- **encrypt(String filePath, int key)**: Encripta el archivo especificado utilizando la llave proporcionada.
- **decrypt(String filePath, int key)**: Desencripta el archivo especificado utilizando la llave proporcionada.
- **indexAlphabet(char letter)**: Devuelve el índice de una letra en el alfabeto.
- **shiftLetter(char c, int n)**: Desplaza una letra un número `n` de posiciones en el alfabeto.
- **alternatedLetters(String line, int n)**: Aplica el desplazamiento de letras a una línea completa de texto.

### Ejemplo de Uso

Para encriptar un archivo:

1. Ejecuta el programa.
2. Selecciona la opción "1. Encriptar archivo".
3. Ingresa el directorio del archivo y la llave de encriptación.
4. El archivo encriptado se guardará en el mismo directorio con el sufijo `_encrypted`.

Para desencriptar un archivo:

1. Ejecuta el programa.
2. Selecciona la opción "2. Desencriptar archivo con llave".
3. Ingresa el directorio del archivo y la llave de desencriptación.
4. El archivo desencriptado se guardará en el mismo directorio con el sufijo `_decrypted`.

## Requisitos

- Java 11 o superior.
- IntelliJ IDEA 2024.1.3 (opcional, pero recomendado para desarrollo).

## Ejecución

Para ejecutar el proyecto, compila y ejecuta la clase `Main.java`. Sigue las instrucciones en pantalla para encriptar o desencriptar archivos.

## Contribuciones

Por favor, abre un issue o un pull request para discutir cualquier cambio que desees realizar.
