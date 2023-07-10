package encryptdecrypt;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        String operation = "enc";
        String inputText = "";
        String data = "";
        String fileInName = "";
        String fileOutName = "";
        String algo = "shift";
        int key = 0;
        String outputText = "";

        // Parse command-line arguments and set encryption/decryption options
        if (args.length > 0) {
            for (int i = 0; i < args.length; i += 2) {
                if ((i + 1) > (args.length - 1)) {
                    break;
                }

                switch (args[i]) {
                    case "-mode":
                        operation = args[i + 1];
                        break;
                    case "-key":
                        key = Integer.parseInt(args[i + 1]);
                        break;
                    case "-data":
                        data = args[i + 1];
                        break;
                    case "-in":
                        fileInName = args[i + 1];
                        break;
                    case "-out":
                        fileOutName = args[i + 1];
                        break;
                    case "-alg":
                        algo = args[i + 1];
                        break;
                    default:
                        break;
                }
            }
        }

// Retrieve input text from data or file
        inputText = getInputText(data, fileInName);

// Create an instance of the EncryptionDecryptionContext
        EncryptionDecryptionContext encDecContext = new EncryptionDecryptionContext();

// Set the appropriate algorithm based on the provided option
        if ("unicode".equals(algo)) {
            encDecContext.setAlgo(new UnicodeAlgo());
        } else {
            encDecContext.setAlgo(new ShiftAlgo());
        }

// Process the input text using the chosen algorithm and options
        outputText = encDecContext.process(inputText, key, operation);
        processOutputText(outputText, fileOutName);





    }

    /**
     * Retrieves the input text from either the provided data or a file, based on the given parameters.
     *
     * @param data        The input text as a string.
     * @param fileInName  The name of the input file. If provided, the method attempts to read the text from the file.
     * @return The input text retrieved from either the data or the file.
     */
    private static String getInputText(String data, String fileInName) {
        String inputText = "";

        if ((!data.equals("")) && (!fileInName.equals(""))) {
            inputText = data;
        } else if ((data.equals("")) && (!fileInName.equals(""))) {
            try (BufferedReader reader = new BufferedReader(new FileReader(fileInName))) {
                String line = "";
                line = reader.readLine();
                if (line != null) {
                    inputText = line;
                }
                System.out.println("Data has been successfully read from " + fileInName);
            } catch (IOException e) {
                System.out.println("An error occurred while trying to read from the specified file");
            }
        } else if ((!data.equals("")) && (fileInName.equals(""))) {
            inputText = data;
        }

        return inputText;
    }


    /**
     * Processes the output text by either printing it to the console or writing it to a file.
     *
     * @param outputText   The text to be processed.
     * @param fileOutName  The name of the output file. If empty, the text will be printed to the console.
     */
    private static void processOutputText(String outputText, String fileOutName) {
        if (fileOutName.equals("")) {
            System.out.print(outputText);
        } else {
            if (!outputText.equals("")) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileOutName))) {
                    writer.write(outputText);
                    System.out.println("Data has been successfully written to " + fileOutName);
                } catch (IOException e) {
                    System.out.println("An error occurred while trying to write to the specified file");
                }
            }
        }
    }




}
