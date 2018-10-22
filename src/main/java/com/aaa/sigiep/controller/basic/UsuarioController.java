package com.aaa.sigiep.controller.basic;

import com.aaa.sigiep.dao.basic.paramDao;
import com.aaa.sigiep.dao.basic.terceroDao;
import com.aaa.sigiep.dao.basic.usuarioDao;
import com.aaa.sigiep.dao.gadmn.menuDao;
import com.aaa.sigiep.models.basic.usuario;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsuarioController {
    @Autowired
    private terceroDao terceroDao;
    @Autowired
    private usuarioDao usuarioDao;               
    @Autowired
    private paramDao paramDao;
    @Autowired
    private menuDao menuDao;
    
    @ResponseBody
    @RequestMapping(value = "Usuarios", method = RequestMethod.GET)
    public ModelAndView vistaUsuarios(Model model, HttpSession session, HttpServletRequest request){
        String compania = session.getAttribute("compania").toString();
        List<String> usuarios = usuarioDao.ListadoUsuario();
        List<String> estados  = usuarioDao.ListadoEstado();
        List<String> terceros = usuarioDao.ListadoTerceros();
        List<String> roles    = usuarioDao.ListadoRoles(compania);
        ModelAndView vista = new ModelAndView("/basicos/usuarios");  
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("estados", estados);
        model.addAttribute("terceros", terceros);
        model.addAttribute("roles", roles);
        return vista;
    }
    
    @ResponseBody
    @RequestMapping(value = "NuevoUsuario", method = RequestMethod.POST)    
    public String crearUsuario(HttpServletResponse response, 
            @ModelAttribute usuario user, HttpSession session){        
        Integer res =  usuarioDao.Registrar(user);        
        return res.toString();
    }
    
    @ResponseBody
    @RequestMapping(value = "EliminarUsuario", method = RequestMethod.POST)
    public String eliminarUsuario(@RequestParam int id){
        Integer res = usuarioDao.Eliminar(id);
        return res.toString();
    }
    
    @RequestMapping(value = "ObtenerUsuario/{id}", method = RequestMethod.POST)
    public @ResponseBody String obtenerUsuario(@PathVariable Integer id, Model model) throws IOException{
        usuario usr = usuarioDao.obtenerUsuario(id);                                
        ObjectMapper mapper = new ObjectMapper();  
        String json = mapper.writerWithDefaultPrettyPrinter()
                    .writeValueAsString(usr);        
        return json;
    }
    
    @ResponseBody
    @RequestMapping(value = "EditarUsuario", method = RequestMethod.POST)
    public String EditarUsuario(HttpServletResponse response, 
            @ModelAttribute usuario user, HttpSession session){        
        Integer res = usuarioDao.Modificar(user);
        return res.toString();        
    }
}
