/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author u35444
 */
public class ActionFactory {
    public static Action getAction(HttpServletRequest request, String defaultAction) 
                throws ServletException {

        String parameter = request.getParameter("action") != null ? request.getParameter("action") : defaultAction;
        String className = "br.org.catolicasc.action." + parameter;

        try {

            Class<?> clazz = Class.forName(className);
            Action action = (Action) clazz.newInstance();

            return action;
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new ServletException("A ActionFactory causou uma exceção", e);
        }
    } 
}
