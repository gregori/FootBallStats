/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.controller;

import br.org.catolicasc.action.Action;
import br.org.catolicasc.action.ActionFactory;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author u35444
 */
@SuppressWarnings("serial")
@WebServlet("/controller")
public class FrontController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
            
            Action action = ActionFactory.getAction(request, "ActionPaginaPrincipal");
            
            try {
                String view = action.execute(request, response);
                request.getRequestDispatcher(view).forward(request, response);
            } catch (ServletException | IOException e) {
                throw new ServletException("Falha na execução da action.", e);
            } catch (Exception ex) {
                Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
            }		
	}
}