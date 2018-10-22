package com.aaa.sigiep.authentication;

import java.util.ArrayList;
import java.util.List;
import com.aaa.sigiep.dao.basic.usuarioDao;
import com.aaa.sigiep.models.basic.usuario;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//@Service
//public class AuthenticationService implements UserDetailsService{
//    @Autowired
//    private usuarioDao user;
//    
//    @Override
//    public UserDetails loadUserByUsername(String nombre) throws UsernameNotFoundException {
//        usuario usuario = user.buscarUsuario(nombre);                                 
//        List<String> roles = user.obtenerRolesUsuario(nombre);         
//        List<GrantedAuthority> grantList= new ArrayList<>();
//        if(roles != null)  {
//            roles.stream().map((role) -> new SimpleGrantedAuthority("ROLE_" + role)).forEachOrdered((authority) -> {
//                grantList.add(authority);
//            });
//        }                 
//        UserDetails userDetails = (UserDetails) new User(usuario.getUsuario(), usuario.getContrasen(), grantList);        
//        return userDetails;
//    }         
//}
