package com.lab2.lab2.BusinessLogic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileService {

    public ArrayList<String> GetWordListFromFile(String filePath)
    {
        ArrayList<String> output = new ArrayList<>();
        File file = new File(filePath);
        Scanner input = null;
        try {
            input = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (input.hasNextLine()) {
            output.add(input.nextLine());
        }
        return output;
    }
}
