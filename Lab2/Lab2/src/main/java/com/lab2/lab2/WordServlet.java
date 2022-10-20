package com.lab2.lab2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "wordServlet", value = "/word-servlet")
public class WordServlet extends HttpServlet {
    private int initial_size;
    private List<String> validWords = new ArrayList<>();

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
    void printPermutn(String str, String ans, StringBuilder writer, boolean only_valid)
    {
        if (str.length() == 0 || (ans.length() == initial_size  && initial_size != 0)) {
            if(!only_valid || validWords.contains(ans))
                writer.append(ans).append(" ");
            return;
        }

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            // Rest of the string after excluding
            // the ith character
            String ros = str.substring(0, i) +
                    str.substring(i + 1);

            // Recursive call
            printPermutn(ros, ans + ch, writer, only_valid);
        }
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        StringBuilder sb = new StringBuilder();
        int number;
        String word = request.getParameter("word");
        try {
            number = Integer.parseInt(request.getParameter("number"));
        } catch (NumberFormatException e) {
            number = 0;
        }
        initial_size = number;
        sb.append("<ol>");
        for(char letter : word.toCharArray())
        {
            sb.append("<li>").append(letter).append("</li>");
        }
        sb.append("</ol>");
        sb.append("<h2> All sequences</h2><br>");
        if(number == 0)
        {
            for(int i =0; i<word.length(); i++)
            {
                initial_size = i;
                printPermutn(word, "", sb, false);
                sb.append("</p><p>");
            }
        }
        else {
            printPermutn(word, "", sb, false);
        }sb.append("<h2> Valid sequences</h2><br>");

        if(number == 0)
        {
            for(int i =0; i<word.length(); i++)
            {
                initial_size = i;
                printPermutn(word, "", sb, true);
                sb.append("</p><p>");
            }
        }
        else {
            printPermutn(word, "", sb, true);
        }
        PrintWriter out = response.getWriter();
        out.print(sb.toString());
    }

    public void destroy() {
    }
}