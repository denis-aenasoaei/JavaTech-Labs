package com.lab2.lab2.Filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName = "LoggingFilter", urlPatterns = {"/input.jsp"})
public class LogRequestsFilter implements Filter {

    private PrintWriter logFile;
    public void init(FilterConfig config) throws ServletException {
        try {
            logFile = new PrintWriter(new BufferedWriter(new FileWriter("C:\\Users\\Denis\\Proiecte\\Java\\Labs\\JavaTech-Labs\\Lab2\\Lab2\\src\\main\\java\\com\\lab2\\lab2\\logs.txt", true)));
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }
    }

    public void destroy() {
        logFile.close();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(java.time.Instant.now().toString());
        sb.append("; ");
        sb.append(request.getRemoteAddr());
        sb.append("; ");
        sb.append(request.getProtocol());
        sb.append("; ");
        logFile.println(sb.toString());
        logFile.flush();
        chain.doFilter(request, response);
    }
}
