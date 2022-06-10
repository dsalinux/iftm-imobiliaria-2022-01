/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.edu.iftm.imobiliaria.servlet;

import br.edu.iftm.imobiliaria.logic.ImagemLogic;
import br.edu.iftm.imobiliaria.util.Assert;
import br.edu.iftm.imobiliaria.util.FileUtil;
import br.edu.iftm.imobiliaria.util.MimeTypes;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author danilo
 */
@WebServlet(name = "ImagemServlet", urlPatterns = {"/imagem"}, initParams = {
    @WebInitParam(name = "codigo", value = "")})
public class ImagemServlet extends HttpServlet {

    @Inject
    private ImagemLogic logic;
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String codigo  = request.getParameter("codigo");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println(codigo);
        System.out.println("");
        System.out.println("");
        if(Assert.isStringEmpty(codigo)) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;     
        }
        try {
            File imagem = this.logic.getImagemPorCodigo(codigo);
            String ext = codigo.substring(codigo.lastIndexOf(".")+1);
            byte[] bytesImagem = FileUtil.fileToByteArray(imagem);
            response.setContentType(MimeTypes.getMimeType(ext)+";charset=UTF-8");
            response.setContentLength(Double.valueOf(imagem.length()).intValue());
            response.getOutputStream().write(bytesImagem);
        } catch (Exception ex) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
