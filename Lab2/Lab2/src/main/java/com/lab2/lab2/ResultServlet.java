package com.lab2.lab2;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ResultServlet extends HttpServlet {

    private int initial_size;
    private List<String> validWords = new ArrayList<>();
    public List<String> toDisplayWords = new ArrayList<>();

    public void init() {
        File file = new File("C:\\Users\\Denis\\Proiecte\\Java\\Labs\\JavaTech-Labs\\Lab2\\Lab2\\src\\main\\resources\\validwords.txt");
        Scanner input = null;
        try {
            input = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (input.hasNextLine()) {
            validWords.add(input.nextLine());
        }
    }
    void printPermutn(String str, String ans,boolean only_valid)
    {
        if (str.length() == 0 || (ans.length() == initial_size  && initial_size != 0)) {
            if(!only_valid || validWords.contains(ans))
                toDisplayWords.add(ans);
            return;
        }

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            // Rest of the string after excluding
            // the ith character
            String ros = str.substring(0, i) +
                    str.substring(i + 1);

            // Recursive call
            printPermutn(ros, ans + ch, only_valid);
        }
    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String url = "";
        StringBuilder sb = new StringBuilder();
        int number;
        String word = request.getParameter("word");try {
            number = Integer.parseInt(request.getParameter("number"));
        } catch (NumberFormatException e) {
            number = 0;
        }
        initial_size = number;
        if(number == 0)
        {
            for(int i =0; i<word.length(); i++)
            {
                initial_size = i;
                printPermutn(word, "", true);
            }
        }
        else {
            printPermutn(word, "", true);
        }
        PrintWriter out = response.getWriter();

    }

    public void destroy() {
    }
}
