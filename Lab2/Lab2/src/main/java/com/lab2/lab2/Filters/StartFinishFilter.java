package com.lab2.lab2.Filters;

import com.lab2.lab2.BusinessLogic.ResponseWrapper;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName = "StartFinishFilter", urlPatterns = {"/*"})
public class StartFinishFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        ResponseWrapper wrapper
                = new ResponseWrapper((HttpServletResponse) response);
        chain.doFilter(request, wrapper);

        StringBuilder sb = new StringBuilder();
        String content = wrapper.toString();
        String antet = "<h1>This is at the start of every page</h1>";
        int bodyIndex = content.indexOf("<body>") + 6;

        sb.append(content.substring(0, bodyIndex));
        sb.append(antet);
        int endBodyIndex = content.indexOf("</body>");
        sb.append(content.substring(bodyIndex, endBodyIndex));
        String subText = "<h1>This is at the end of every page</h1>";

        sb.append(subText);
        sb.append(content.substring(endBodyIndex));

        PrintWriter out = response.getWriter();
        out.write(sb.toString());

    }
}
