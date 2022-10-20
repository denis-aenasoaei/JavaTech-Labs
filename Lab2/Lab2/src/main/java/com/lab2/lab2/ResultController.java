package com.lab2.lab2;

import com.lab2.lab2.BusinessLogic.PermutationService;
import com.lab2.lab2.Models.User;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



@WebServlet(name = "Result", urlPatterns = {"/result"})
public class ResultController extends HttpServlet {
    private PermutationService _permutationService;

    public void init()
    {
        _permutationService = new PermutationService
                ("C:\\Users\\Denis\\Proiecte\\Java\\Labs\\JavaTech-Labs\\Lab2\\Lab2\\src\\main\\resources\\validwords.txt",
                        0);
    }


    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        String word = request.getParameter("word");
        int number;
        try {
            number = Integer.parseInt(request.getParameter("number"));
        } catch (NumberFormatException e) {
            number = 0;
        }
        User user = new User(request.getParameter("username"), word);

        this._permutationService.initial_size = number;

        ArrayList<String> permutatedWords = new ArrayList<>();
        if(number == 0)
        {
            for(int i =0; i<word.length(); i++)
            {
                this._permutationService.initial_size = i;
                _permutationService.GetPermutations(word, "",true, permutatedWords);
            }
        }
        else {
            _permutationService.GetPermutations(word, "", true, permutatedWords);
        }
        user.permutatedWords = permutatedWords;
        request.setAttribute("user", user);
        String nextPage = "/result.jsp";
        getServletContext().getRequestDispatcher(nextPage)
                .forward(request, response);
    }
}