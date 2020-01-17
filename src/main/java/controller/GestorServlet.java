/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Gestor;
import model.bean.Mensagem;
import model.dao.GestorDAO;

/**
 *
 * @author nando
 */
public class GestorServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try{
            //tenta escolher, caso não conresponda as opções é redirecionado para index
            switch (request.getParameter("action")){
                case "cadastrar":
                    Gestor gestorCriar = new Gestor();
                    //daoc abreviação de daoCreate
                    GestorDAO daoc = new GestorDAO();
                    SimpleDateFormat sdfc = new SimpleDateFormat("dd/MM/yyyy");
                    
                    //setta valores no objeto gestor
                    gestorCriar.setNome(request.getParameter("nome"));
                    gestorCriar.setMatricula(request.getParameter("matricula"));
                    gestorCriar.setData_nascimento(sdfc.parse(request.getParameter("data_nascimento")));
                    gestorCriar.setSetor(request.getParameter("setor"));
                    
                    if(daoc.create(gestorCriar)){
                        try (PrintWriter out = response.getWriter()) {
                            /* exibir mensagem de sucesso */
                            out.println(Mensagem.success());
                        }catch(Exception ex){//caso ocorra erro na exibição da mensagem
                            response.sendRedirect("/");//redireciona para index
                        }                        
                    }else{//se não for verdade que o gestor foi criado com sucesso:
                        try (PrintWriter out = response.getWriter()) {
                            /* exibir mensagem de sucesso */
                            out.println(Mensagem.error());
                        }catch(Exception ex){//caso ocorra erro na exibição da mensagem
                            response.sendRedirect("/");//redireciona para index
                        }
                    }
                    break;
                case "editar":
                    Gestor gestorEditar = new Gestor();
                    GestorDAO daoe = new GestorDAO();
                    SimpleDateFormat sdfe = new SimpleDateFormat("dd/MM/yyyy");
                    
                    //setta valores no objeto gestor
                    gestorEditar.setId(Integer.parseInt(request.getParameter("id")));
                    gestorEditar.setNome(request.getParameter("nome"));
                    gestorEditar.setMatricula(request.getParameter("matricula"));
                    gestorEditar.setData_nascimento(sdfe.parse(request.getParameter("data_nascimento")));
                    gestorEditar.setSetor(request.getParameter("setor"));
                    
                    if(daoe.update(gestorEditar)){
                        try (PrintWriter out = response.getWriter()) {
                            /* exibir mensagem de sucesso */
                            out.println(Mensagem.success());
                        }catch(Exception ex){//caso ocorra erro na exibição da mensagem
                            response.sendRedirect("/");//redireciona para index
                        }
                    }else{//se não for verdade que o gestor foi criado com sucesso:
                        try (PrintWriter out = response.getWriter()) {
                            /* exibir mensagem de sucesso */
                            out.println(Mensagem.error());
                        }catch(Exception ex){//caso ocorra erro na exibição da mensagem
                            response.sendRedirect("/");//redireciona para index
                        }
                    }
                    break;
                case "deletar":
                    //daod abreviação de daoDelete
                    GestorDAO daod = new GestorDAO();
                                        
                    if(daod.delete(Integer.parseInt(request.getParameter("id")))){
                        try (PrintWriter out = response.getWriter()) {
                            /* exibir mensagem de sucesso */
                            out.println(Mensagem.success());
                        }catch(Exception ex){//caso ocorra erro na exibição da mensagem
                            response.sendRedirect("/");//redireciona para index
                        }                        
                    }else{//se não for verdade que o gestor foi criado com sucesso:
                        try (PrintWriter out = response.getWriter()) {
                            /* exibir mensagem de sucesso */
                            out.println(Mensagem.error());
                        }catch(Exception ex){//caso ocorra erro na exibição da mensagem
                            response.sendRedirect("/");//redireciona para index
                        } 
                    }
                    break;
                default:
                    response.sendRedirect("/");//redireciona para index
                    break;
            }
        }catch(NullPointerException | ParseException | IllegalStateException | NumberFormatException ex){//caso o parametro action venha nulo é redirecionado para index
            try (PrintWriter out = response.getWriter()) {
                /* exibir mensagem de sucesso */
                System.out.println(ex);
                out.println(Mensagem.error());
            }catch(Exception ex1){//caso ocorra erro na exibição da mensagem
                System.out.println(ex1);
                response.sendRedirect("/");//redireciona para index
            }
        }
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
