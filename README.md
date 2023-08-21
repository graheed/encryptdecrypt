# Encryption and Decryption Utility
This Java program offers encryption and decryption functionalities using the Shift and Unicode algorithms. It's a simple utility that allows you to secure your text-based information using different algorithms.


# Features
* Encrypt and decrypt text using Shift or Unicode algorithm.
* Choose the operation mode (encryption or decryption).
* Provide encryption/decryption key and input data via command-line options.
* Read input data from files and write output to files.
* Easily switch between encryption algorithms using the -alg option.


# Options
-mode: Specify the operation mode (enc for encryption or dec for decryption).
-key: Provide the encryption/decryption key (an integer).
-data: Specify the input data for encryption/decryption (enclosed in double quotes).
-in: Provide an input file name (input text will be read from this file).
-out: Specify an output file name (output will be written to this file).
-alg: Choose the encryption algorithm (shift for Shift algorithm or unicode for Unicode algorithm).

Examples
Encrypt using Shift algorithm and key 3:


java Main -mode enc -key 3 -data "Hello" -alg shift
Decrypt using Unicode algorithm with input from a file:


java Main -mode dec -key 5 -in input.txt -alg unicode

Disclaimer
This program is intended for educational purposes and may not provide the level of security required for sensitive information. It's recommended to use established and secure encryption libraries for real-world applications. The authors of this program are not responsible for any misuse or consequences resulting from its usage.
