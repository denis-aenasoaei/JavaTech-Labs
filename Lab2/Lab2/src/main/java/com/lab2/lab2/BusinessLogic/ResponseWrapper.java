package com.lab2.lab2.BusinessLogic;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletResponseWrapper;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ResponseWrapper
        extends HttpServletResponseWrapper {
    private final StringWriter output;
    public ResponseWrapper(HttpServletResponse response) {
        super(response);
        output = new StringWriter();
    }
    @Override
    public PrintWriter getWriter() {
        return new PrintWriter(output);
    }
    @Override
    public String toString() {
        return output.toString();
    }
}