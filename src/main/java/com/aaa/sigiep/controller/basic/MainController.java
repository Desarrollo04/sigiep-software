package com.aaa.sigiep.controller.basic;
import com.aaa.sigiep.dao.gadmn.menuDao;
import com.aaa.sigiep.dao.basic.paramDao;
import com.aaa.sigiep.dao.basic.terceroDao;
import com.aaa.sigiep.dao.basic.usuarioDao;
import com.aaa.sigiep.models.basic.login;
import com.aaa.sigiep.models.basic.param;
import com.aaa.sigiep.models.basic.tercero;
import com.aaa.sigiep.models.basic.usuario;
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
import org.springframework.web.servlet.mvc.SimpleFormController;
import javax.servlet.http.HttpSession;

@Controller
public class MainController extends SimpleFormController {   
    
    @Autowired
    private terceroDao terceroDao;
    @Autowired
    private usuarioDao usuarioDao;               
    @Autowired
    private paramDao paramDao;
    @Autowired
    private menuDao menuDao;
    
    @RequestMapping(value = "/params", method = RequestMethod.POST)    
    @ResponseBody
    public String porCompania(@RequestParam("Compania") String Compania){            
        List<Map<String, Object>> params = terceroDao.obtenerParams(Compania);        
        String html = "";
        for (Iterator<Map<String, Object>> it = params.iterator(); it.hasNext();) {            
            Map<String, Object> next = it.next();
            html += "<option value='"+next.get("id_unico")+"'>"+next.get("anno")+"</option>";
        }
        return html;
    }
    
    @RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
    public String loginPage(Model model){  
        List companias = terceroDao.Companias();                    
        model.addAttribute("companias", companias);        
        return "login";
    }
    
    @RequestMapping(value = "ingresar", method = RequestMethod.POST)
    public String loginProcess(Model model, HttpServletRequest request, 
            HttpServletResponse response, @ModelAttribute("login") login Login, 
            BindingResult result, HttpSession session){        
        usuario user = usuarioDao.validarUsuario(Login);
        if(result.hasErrors()){
            return "redirect:/login?error=true";
        }
        
        if(null != user){            
            session.setAttribute("usuario", user.getUsuario());
            session.setAttribute("compania", Login.getSltCompania());
            session.setAttribute("param", Login.getSltAnno());
            session.setAttribute("TerceroUsuario", user.getTercero());
            session.setAttribute("rol", user.getRol());
            return "redirect:/Inicio";
        }else{
            return "redirect:/login?error=true";
        }                        
    }
    
    @RequestMapping(value = "Inicio", method = RequestMethod.GET)
    public String inicio(Model model, HttpSession session){               
        if(session.getAttribute("compania") != null){
            String compania = session.getAttribute("compania").toString();
            String paramId  = session.getAttribute("param").toString();
            String RolId    = session.getAttribute("rol").toString();
            tercero ter   = terceroDao.obtenerCompania(compania);
            param   par   = paramDao.obtenerParamActual(paramId);
            List    menus = menuDao.obtenerMenuRol(RolId);
            model.addAttribute("logo", "./"+ter.getRutaLogo());
            model.addAttribute("anno", par.getAnno());
            model.addAttribute("nomUsuario", session.getAttribute("usuario").toString().toUpperCase());            
            model.addAttribute("menus", menus);
            return "home";
        }else{
            return "redirect:Logout?error=true";
        }     
    } 
    
    @RequestMapping(value = "Logout", method = RequestMethod.GET)
    public String salir(Model model, HttpSession session){
        session.removeAttribute("usuario");
        session.removeAttribute("compania");
        session.removeAttribute("param");
        session.removeAttribute("TerceroUsuario");
        session.removeAttribute("rol");
        return "Cierre";
    }
       
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {

        if (principal != null) {
            model.addAttribute("message", "Hi " + principal.getName()
                    + "<br> You do not have permission to access this page!");
        } else {
            model.addAttribute("msg",
                    "You do not have permission to access this page!");
        }
        return "403Page";
    }       
}
