package encryptdecrypt;



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
        inputText = FileOperation.getInputText(data, fileInName);

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
        FileOperation.processOutputText(outputText, fileOutName);





    }






}
