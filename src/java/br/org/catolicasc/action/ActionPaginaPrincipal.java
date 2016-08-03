/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.action;

import eu.dataaccess.footballpool.ArrayOftTeamInfo;
import eu.dataaccess.footballpool.Info;
import eu.dataaccess.footballpool.InfoSoapType;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author u35444
 */
public class ActionPaginaPrincipal implements Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        InfoSoapType fs = new Info().getInfoSoap();
        
        ArrayOftTeamInfo teams =  fs.teams();
        
        request.setAttribute("teams", teams);
        
        return "/WEB-INF/jsp/principal.jsp";
        
   }
    
}