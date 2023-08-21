package encryptdecrypt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileOperation {
    /**
     *
     * Retrieves the input text from
     * either the provided data or a file,
     * based on the given parameters.
     *
     * @param data        The input text as a string.
     * @param fileInName  The name of the input file.
     *                    If provided, the method attempts
     *                    to read the text from the file.
     * @return The input text retrieved from either the data or the file.
     */
    public static String getInputText(String data, String fileInName) {
        String inputText = "";

        if (!"".equals(data) && !"".equals(fileInName)) {
            inputText = data;
        } else if ("".equals(data) && !"".equals(fileInName)) {
            try (BufferedReader reader =
                         new BufferedReader(
                                 Files.newBufferedReader(Path.of(fileInName)))
            ) {
                String line = "";
                line = reader.readLine();
                if (line != null) {
                    inputText = line;
                }
                System.out.println(
                        "Data has been successfully read from " + fileInName
                );

            } catch (IOException e) {
                System.out.println(e.getMessage());
                //throw new IOException("An error occurred while trying to read from the specified file", e);
            }
        } else if (!"".equals(data)) {
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
    public static void processOutputText(String outputText, String fileOutName) {
        if ("".equals(fileOutName)) {
            System.out.print(outputText);
        } else {
            if (!"".equals(outputText)) {

                try (BufferedWriter writer = new BufferedWriter(Files.newBufferedWriter(Path.of(fileOutName)))) {
                    writer.write(outputText);
                    System.out.println("Data has been successfully written to " + fileOutName);
                } catch (IOException e) {
                    System.out.println("An error occurred while trying to write to the specified file");
                }
            }
        }
    }
}
