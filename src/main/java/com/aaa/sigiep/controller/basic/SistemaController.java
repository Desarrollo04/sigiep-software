package com.aaa.sigiep.controller.basic;

import com.aaa.sigiep.dao.basic.paramDao;
import com.aaa.sigiep.dao.basic.terceroDao;
import com.aaa.sigiep.dao.basic.usuarioDao;
import com.aaa.sigiep.dao.gadmn.menuDao;
import com.aaa.sigiep.models.basic.param;
import com.aaa.sigiep.models.basic.tercero;
import org.springframework.beans.factory.annotation.Autowired;
import java.security.Principal;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpSession;

@Controller
public class SistemaController {
    @Autowired
    private terceroDao terceroDao;
    @Autowired
    private usuarioDao usuarioDao;               
    @Autowired
    private paramDao paramDao;
    @Autowired
    private menuDao menuDao;
    
    @RequestMapping(value = "/sistema", method = RequestMethod.GET)
    public String gestionAdmin(Model model, HttpSession session, HttpServletRequest request){
        if(session.getAttribute("compania") != null){
            String compania = session.getAttribute("compania").toString();
            String paramId  = session.getAttribute("param").toString();
            String RolId    = session.getAttribute("rol").toString();
            tercero ter   = terceroDao.obtenerCompania(compania);
            param   par   = paramDao.obtenerParamActual(paramId);
            List    menus = menuDao.obtenerMenuRol(RolId);
            String  url   = request.getRequestURI();
            String  ruta  = url.substring(8, url.length());
            List    SCapa = menuDao.obtenerHijosPrimeraCapa(RolId, ruta);                      
            
            model.addAttribute("logo", "./"+ter.getRutaLogo());
            model.addAttribute("anno", par.getAnno());
            model.addAttribute("nomUsuario", session.getAttribute("usuario").toString().toUpperCase());            
            model.addAttribute("menus", menus);
            model.addAttribute("titulo", "Sistema");
            model.addAttribute("xHijos", SCapa);
            return "layout";
        }else{
            return "redirect:Logout?error=true";
        }
    }
    
    @RequestMapping(value = "/Dropdown", method = RequestMethod.POST)
    @ResponseBody
    public String generarSubmenu(@RequestParam("padre") String padre){
        List<Map<String, Object>> params = menuDao.obtenerHijos(padre);
        String html = "";
        for (Iterator<Map<String, Object>> it = params.iterator(); it.hasNext();) {
            Map<String, Object> next = it.next();            
            html += "<a class=\"dropdown-item\" href='javascript:void(0)' onclick=\"llamarCuerpo('"+next.get("ruta")+"')\" >"+next.get("nombre")+"</a>";
        }        
        return html;
    }
}
