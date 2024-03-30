/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany._10;

import java.io.*;

/**
 *
 * @author Варвара
 */
public class App {

    public static void main(String[] args) {
        System.out.println("Practical task 1.10, Kolotilina Varvara, RIBO-03-22, Var. 1");
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Enter the number of files to concatenate: ");
            int numFiles = Integer.parseInt(reader.readLine());

            System.out.println("Enter the path of the first file: ");
            String firstFilePath = reader.readLine();

            StringBuilder result = new StringBuilder();

            for (int i = 0; i < numFiles; i++) {
                System.out.println("Enter the path of file " + (i + 1) + ": ");
                String filePath = reader.readLine();

                File file = new File(filePath);
                BufferedReader fileReader = new BufferedReader(new FileReader(file));

                String line;
                while ((line = fileReader.readLine()) != null) {
                    result.append(line).append("\n");
                }

                fileReader.close();
            }

            File resultFile = new File(firstFilePath.replace(".txt", "_result.txt"));
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(resultFile));

            fileWriter.write(result.toString());
            fileWriter.close();

            System.out.println("Files concatenated successfully. Result saved as " + resultFile.getAbsolutePath());

        } catch (IOException e) {
            System.out.println("An error occurred while concatenating files.");
        } finally {
            try {
                if (reader != null) reader.close();
            } catch (IOException e) {
                System.out.println("Error closing BufferedReader.");
            }
        }
    }
}
