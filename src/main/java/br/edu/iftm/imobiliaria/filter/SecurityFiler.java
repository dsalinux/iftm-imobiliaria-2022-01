package br.edu.iftm.imobiliaria.filter;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.faces.context.FacesContext;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author danilo
 */
@WebFilter(filterName = "SecurityFiler", urlPatterns = {"/admin/*"})
public class SecurityFiler implements Filter {
    
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        
        Throwable problem = null;
        try {
            HttpServletResponse resp = (HttpServletResponse) response;
//            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
//            resp.sendRedirect(request.getServletContext().getContextPath()+"/login.xhtml");
            chain.doFilter(request, resp);
        } catch (Throwable t) {
            problem = t;
            t.printStackTrace();
        }
        
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }

   
    
}
